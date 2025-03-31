package Vagas;
import Observers.*;

public class Vaga {
    private EstadoVaga disponibilidade;
    private Observer veiculo;
    private Observer veiculoNulo = new VeiculoNulo();
    public Vaga(){
        this.disponibilidade = new VagaDesocupada();
        this.veiculo = veiculoNulo;
    }
    public Vaga(EstadoVaga disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public String nomeEstado(){
        return disponibilidade.getClass().getSimpleName();
    }
    public EstadoVaga estado(){
        return disponibilidade;
    }
    public void estado(EstadoVaga estado){
        this.disponibilidade = estado;
    }

    public void ocupar(Observer veiculo){
        if (disponibilidade instanceof VagaDesocupada) {
            this.veiculo = veiculo;
            disponibilidade.ocupar(this);
        }else{
            System.out.println("A vaga não pode ser ocupada no momento.");
        }
    }
    public void desocupar(){
        this.veiculo = veiculoNulo;
        disponibilidade.desocupar(this);
    }
    public void interditar(){
        disponibilidade.interditar(this);
    }

    public Observer veiculo(){
        return veiculo;
    }
}
