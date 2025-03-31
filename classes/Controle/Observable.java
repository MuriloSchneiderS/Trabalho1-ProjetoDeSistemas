package Controle;
import java.util.ArrayList;

import Observers.Observer;

public interface Observable {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    public void adicionar(Observer Veiculo);
    public void remover(Observer Veiculo);
    public void atualizar();
}
