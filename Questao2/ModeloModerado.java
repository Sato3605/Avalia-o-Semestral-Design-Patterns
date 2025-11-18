public class ModeloModerado implements EstrategiaRisco {
    @Override
    public String calcularPerfil(double renda, double idade, double patrimonio) {
        double score = (renda * 0.3) + (patrimonio * 0.3) - (idade * 0.1);
        return "Risco Moderado | Score: " + score;
    }
}
