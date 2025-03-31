package Observers;
import Tarifas.*;

public class Veiculo implements Observer {
    private String placa;
    private Tarifa tarifa;
    private int vagasDisponiveis;

    public Veiculo(String placa, Tarifa tarifa){
        this.placa = placa;
        this.tarifa = tarifa;
    }

    public String placa(){
        return placa;
    }

    @Override
    public void atualizar(int disponiveis) {
        System.out.println("Notificação para veículo de placa: "+placa+"\n  Total de vagas disponiveis: "+disponiveis);
        vagasDisponiveis = disponiveis;
    }    
    public double calcularTarifa(){
        return tarifa.calcularTarifa();
    }
}
