package Vagas;

public class VagaOcupada implements EstadoVaga{

    @Override
    public void ocupar(Vaga vaga) {
        System.out.println("A vaga ja esta ocupada");
    }

    @Override
    public void desocupar(Vaga vaga) {
        vaga.estado(new VagaDesocupada());
        System.out.println("A vaga foi desocupada.");
    }

    @Override
    public void interditar(Vaga vaga) {
        vaga.estado(new VagaInterditada());
        System.out.println("A vaga foi interditada.");
    }
    
}
