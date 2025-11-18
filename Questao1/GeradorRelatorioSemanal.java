public class GeradorRelatorioSemanal extends GeradorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        return new RelatorioSemanal();
    }
}
