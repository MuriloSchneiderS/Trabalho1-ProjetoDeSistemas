package Observers;
public class VeiculoNulo implements Observer{

    @Override
    public void atualizar(int disponiveis) {
        System.out.println("Veículo não notificável.");
    }
    
}
