public abstract class GeradorRelatorio {
    public void processarRelatorio() {
        Relatorio relatorio = criarRelatorio();
        relatorio.preparar();
        relatorio.gerar();
    }
    protected abstract Relatorio criarRelatorio();
}
