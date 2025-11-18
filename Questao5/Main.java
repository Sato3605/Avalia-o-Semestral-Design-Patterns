public class Main {
    public static void main(String[] args) {

        LoggerSistema logger = LoggerSistema.getInstancia();

        logger.registrar("ERRO", "Falha no módulo de pagamentos.");
        logger.registrar("EVENTO", "Usuário realizou login.");
        logger.registrar("AUDITORIA", "Acesso à área administrativa.");

    }
}
