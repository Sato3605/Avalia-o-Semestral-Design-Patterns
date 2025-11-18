public class Main {
    public static void main(String[] args) {
        CalculadoraRisco calculadora = new CalculadoraRisco();

        double renda = 8000;
        double idade = 30;
        double patrimonio = 50000;

        System.out.println("\n--- Modelo Agressivo ---");
        calculadora.setEstrategia(new ModeloAgressivo());
        calculadora.analisar(renda, idade, patrimonio);
        
        System.out.println("\n--- Modelo Conservador ---");
        calculadora.setEstrategia(new ModeloConservador());
        calculadora.analisar(renda, idade, patrimonio);

        System.out.println("\n--- Modelo Moderado ---");
        calculadora.setEstrategia(new ModeloModerado());
        calculadora.analisar(renda, idade, patrimonio);
    }
}
