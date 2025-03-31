package Vagas;

import java.util.Scanner;

public class VagaInterditada implements EstadoVaga {
    Scanner input = new Scanner(System.in);

    @Override
    public void ocupar(Vaga vaga) {
        System.out.println("A vaga esta em manutenção e não pode ser ocupada.");
    }

    @Override
    public void desocupar(Vaga vaga) {
        System.out.println("A vaga esta em manutenção, tem certeza que deseja disponibilizá-la?(true/false)");
        if (input.nextBoolean()) {
            vaga.estado(new VagaDesocupada());
            System.out.println("A Vaga foi desocupada e não está mais interditada.");
        }else{
            System.out.println("Desocupação negada ou valor inserido inválido, a vaga segue interditada.");
        }
    }

    @Override
    public void interditar(Vaga vaga) {
        System.out.println("A Vaga ja esta interditada.");
    }
    
}
