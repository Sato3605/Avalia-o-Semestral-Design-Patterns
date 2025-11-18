import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerSistema {

    private static volatile LoggerSistema instancia; // garante visibilidade entre threads
    private FileWriter arquivo;

    // Construtor privado — impede múltiplas instâncias
    private LoggerSistema() {
        try {
            arquivo = new FileWriter("logs.txt", true); // append
        } catch (IOException e) {
            throw new RuntimeException("Erro ao abrir arquivo de log.", e);
        }
    }

    // Singleton com Double-Checked Locking (padrão moderno, eficiente e seguro)
    public static LoggerSistema getInstancia() {
        if (instancia == null) {               // primeira checagem (rápida)
            synchronized (LoggerSistema.class) {
                if (instancia == null) {       // segunda checagem (garante thread-safety)
                    instancia = new LoggerSistema();
                }
            }
        }
        return instancia;
    }

    // Método principal de logging
    public synchronized void registrar(String tipo, String mensagem) {
        String log = "[" + LocalDateTime.now() + "] [" + tipo + "] " + mensagem;

        try {
            arquivo.write(log + "\n");
            arquivo.flush();
        } catch (IOException e) {
            System.err.println("Falha ao registrar no arquivo: " + e.getMessage());
        }

        enviarParaServidor(log);
    }

    // Simulação de envio remoto
    private void enviarParaServidor(String log) {
        System.out.println("Enviando para servidor remoto: " + log);
        // Aqui poderia estar uma chamada HTTP real
    }
}
