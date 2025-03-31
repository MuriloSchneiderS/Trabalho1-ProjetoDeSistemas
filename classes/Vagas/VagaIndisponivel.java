package Vagas;

public class VagaIndisponivel implements EstadoVaga{

    @Override
    public void ocupar(Vaga vaga) {
        System.out.println("Vaga não encontrada ou indisponível.");
    }

    @Override
    public void desocupar(Vaga vaga) {
        System.out.println("Vaga não encontrada ou indisponível.");
    }

    @Override
    public void interditar(Vaga vaga) {
        System.out.println("Vaga não encontrada ou indisponível.");
    }
    
}
