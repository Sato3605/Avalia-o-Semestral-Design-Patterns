public class ModeloConservador implements EstrategiaRisco {
    @Override
    public String calcularPerfil(double renda, double idade, double patrimonio) {
        double score = (renda * 0.2) + (patrimonio * 0.4) - (idade * 0.05);
        return "Risco Conservador | Score: " + score;
    }
}
