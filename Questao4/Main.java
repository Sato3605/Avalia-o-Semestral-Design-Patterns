import java.util.Scanner;

class Transacao {
    public double valor;
    public String localizacao;
    public boolean historicoLimpo;
    public boolean dispositivoComum;

    public Transacao(double valor, String localizacao, boolean historicoLimpo, boolean dispositivoComum) {
        this.valor = valor;
        this.localizacao = localizacao;
        this.historicoLimpo = historicoLimpo;
        this.dispositivoComum = dispositivoComum;
    }
}

abstract class Verificacao {
    protected Verificacao proximo;

    public Verificacao definirProximo(Verificacao proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public boolean verificar(Transacao t) {
        if (!executar(t)) {
            System.out.println("Cadeia interrompida: falha detectada.");
            return false;
        }

        if (proximo == null) {
            return true;
        }

        return proximo.verificar(t);
    }

    protected abstract boolean executar(Transacao t);
}

class VerificacaoValor extends Verificacao {
    @Override
    protected boolean executar(Transacao t) {
        System.out.println("Checando valor...");
        if (t.valor > 5000) {
            System.out.println("Valor acima do limite permitido.");
            return false;
        }
        return true;
    }
}

class VerificacaoLocalizacao extends Verificacao {
    @Override
    protected boolean executar(Transacao t) {
        System.out.println("Checando localizaçao...");
        if (!t.localizacao.equalsIgnoreCase("BR")) {
            System.out.println("Localizaçao suspeita detectada.");
            return false;
        }
        return true;
    }
}

class VerificacaoHistorico extends Verificacao {
    @Override
    protected boolean executar(Transacao t) {
        System.out.println("Checando histórico...");
        if (!t.historicoLimpo) {
            System.out.println("Histórico irregular encontrado.");
            return false;
        }
        return true;
    }
}

class VerificacaoDispositivo extends Verificacao {
    @Override
    protected boolean executar(Transacao t) {
        System.out.println("Checando dispositivo...");
        if (!t.dispositivoComum) {
            System.out.println("Dispositivo incomum detectado.");
            return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema Antifraude ===");

        System.out.print("Valor da transaçao: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.print("Localizaçao (BR, US, etc): ");
        String local = sc.nextLine();

        System.out.print("Histórico limpo? (s/n): ");
        boolean historico = sc.nextLine().equalsIgnoreCase("s");

        System.out.print("Dispositivo comum? (s/n): ");
        boolean dispositivo = sc.nextLine().equalsIgnoreCase("s");

        Transacao t = new Transacao(valor, local, historico, dispositivo);

        Verificacao cadeia = new VerificacaoValor();
        cadeia
            .definirProximo(new VerificacaoLocalizacao())
            .definirProximo(new VerificacaoHistorico())
            .definirProximo(new VerificacaoDispositivo());

        System.out.println("\n=== Iniciando Verificaçoes ===");

        boolean aprovado = cadeia.verificar(t);

        System.out.println("\nResultado final: " + (aprovado ? 
            "Transaçao Aprovada." : 
            "Transaçao Bloqueada."));
    }
}
