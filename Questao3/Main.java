import java.util.ArrayList;
import java.util.List;

// OBSERVER
interface SensorObserver {
    void update(String tipo, double valor);
}

// SUBJECT (Sensor)
class Sensor {
    private String tipo;
    private double valor;
    private List<SensorObserver> observers = new ArrayList<>();

    public Sensor(String tipo) {
        this.tipo = tipo;
    }

    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    public void setValor(double novoValor) {
        this.valor = novoValor;
        notifyObservers();
    }

    private void notifyObservers() {
        for (SensorObserver obs : observers) {
            obs.update(tipo, valor);
        }
    }
}

class PainelControle implements SensorObserver {
    public void update(String tipo, double valor) {
        System.out.println("[PAINEL] " + tipo + " atualizado: " + valor);
    }
}

class ModuloAlerta implements SensorObserver {
    public void update(String tipo, double valor) {
        if (valor > 70) {
            System.out.println("[ALERTA] Valor alto de " + tipo + ": " + valor);
        }
    }
}

class RegistroHistorico implements SensorObserver {
    public void update(String tipo, double valor) {
        System.out.println("[HISTORICO] Registrado " + tipo + ": " + valor);
    }
}

public class Main {
    public static void main(String[] args) {
        Sensor temperatura = new Sensor("Temperatura");

        temperatura.addObserver(new PainelControle());
        temperatura.addObserver(new ModuloAlerta());
        temperatura.addObserver(new RegistroHistorico());

        temperatura.setValor(25.3);
        temperatura.setValor(80.1);
    }
}
