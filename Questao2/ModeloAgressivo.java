public class ModeloAgressivo implements EstrategiaRisco{
    @Override
    public String calcularPerfil(double renda, double idade, double patrimonio) {
        double score = (renda * 0.5) + (patrimonio * 0.4) - (idade * 0.2);
        return "Risco Agressivo | Score " + score; 
    }
}