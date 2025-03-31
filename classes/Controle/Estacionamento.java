package Controle;
import Observers.Observer;
import Vagas.*;

import java.util.ArrayList;


public class Estacionamento implements Observable {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private ArrayList<Vaga> vagas = new ArrayList<Vaga>();
    
    public Estacionamento(){
        vagas.add(new Vaga(new VagaIndisponivel()));//adiciona uma vaga nula para o index 0
    }
    public Estacionamento(int qntVagas){
        vagas.add(new Vaga(new VagaIndisponivel()));//adiciona uma vaga nula para o index 0
        criarVagas(qntVagas);
    }

    @Override
    public void adicionar(Observer Veiculo) {
        observers.add(Veiculo);
    }
    @Override
    public void remover(Observer Veiculo) {
        observers.remove(Veiculo);
    }

    public void ocuparVaga(int numero, Observer veiculo){
        try{
            vagas.get(numero).ocupar(veiculo);
            atualizar();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("A vaga " +numero+ " não existe!");
        }
    }
    public void desocuparVaga(int numero){
        try{
            vagas.get(numero).desocupar();
            atualizar();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("A vaga " +numero+ " não existe!");
        }
    }
    public void interditarVaga(int numero){
        try{
            vagas.get(numero).interditar();
            atualizar();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("A vaga " +numero+ " não existe!");
        }
    }

    @Override
    public void atualizar() {
        int vagasDisponiveis = (int) vagas.stream().filter(vaga -> vaga.estado() instanceof VagaDesocupada).count();
        System.out.println("Notificação para veículos{");
        for (Observer o : observers) {
            o.atualizar(vagasDisponiveis);
        }
        System.out.println("}");
    }
    
    public void criarVagas(int qntVagas){
        for (int i = 1; i <= qntVagas; i++) {
            vagas.add(new Vaga());//adiciona as vagas
        }
    }
    public void removerVagas(int qntVagas){
        try {
            for (int i = 0; i < qntVagas; i++) {
                vagas.remove(vagas.size() - 1); // Tenta remover a última vaga
            }
            System.out.println(qntVagas + " vagas removidas. Novo total de vagas: " + vagas.size());
            atualizar();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não é possível remover " + qntVagas + " vagas. Apenas " + vagas.size() + " vagas disponíveis.");
        }
    }

    public int buscarVagaPorVeiculo(Observer veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.veiculo() == veiculo) {
                return vagas.indexOf(vaga); // Retorna o numero da vaga onde o veículo está estacionado
            }
        }
        return 0;
    }
    public Observer buscarVeiculoPorVaga(Vaga vaga){
        return vaga.veiculo();
    }
}

