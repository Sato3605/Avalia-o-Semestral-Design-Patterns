public class RelatorioEmergencial extends Relatorio{
    @Override
    public void preparar() {
        System.out.println("Preparando relatorio emergencial...");
    }

    @Override
    public void gerar() {
        System.out.println("Gerando relatorio emergencial...");
    }
}
