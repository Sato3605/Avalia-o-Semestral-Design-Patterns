public class RelatorioDiario extends Relatorio{
    @Override
    public void preparar() {
        System.out.println("Preparando relatorio diario...");
    }

    @Override
    public void gerar() {
        System.out.println("Gerando relatorio diario...");
    }
}
