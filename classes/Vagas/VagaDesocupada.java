package Vagas;

public class VagaDesocupada implements EstadoVaga {

    @Override
    public void ocupar(Vaga vaga) {
        vaga.estado(new VagaOcupada());
        System.out.println("A vaga foi ocupada");
    }

    @Override
    public void desocupar(Vaga vaga) {
        System.out.println("A vaga ja esta desocupada.");
    }

    @Override
    public void interditar(Vaga vaga) {
        System.out.println("A vaga foi interditada.");
        vaga.estado(new VagaInterditada());
    }
    
}
