import Controle.*;
import Observers.*;
import Tarifas.*;

public class Main {
    public static void main(String[] args) {
        
        Estacionamento estacionamento = new Estacionamento(25);
        
        Observer carro = new Veiculo("ABC-1234", new TarifaCarro());
        Observer moto = new Veiculo("DEF-5678", new TarifaMoto());
        Observer quadriciculo = new Veiculo("GHI-9101", new TarifaMoto());
        Observer bicicleta = new Veiculo("---", new TarifaNula());
        Observer skate = new VeiculoNulo();
        
        estacionamento.adicionar(carro);
        estacionamento.ocuparVaga(1, carro);
        estacionamento.adicionar(moto);
        estacionamento.ocuparVaga(2, moto);
        estacionamento.adicionar(quadriciculo);
        estacionamento.ocuparVaga(3, bicicleta);
        estacionamento.adicionar(skate);
        
        estacionamento.desocuparVaga(1);
        
        estacionamento.interditarVaga(4);
        estacionamento.ocuparVaga(4, skate);
        estacionamento.remover(skate);

        estacionamento.ocuparVaga(27, quadriciculo);
        estacionamento.removerVagas(20);
    }
}

