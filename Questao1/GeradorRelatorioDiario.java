public class GeradorRelatorioDiario extends GeradorRelatorio {
    @Override
    protected Relatorio criarRelatorio() {
        return new RelatorioDiario();
    }
}
