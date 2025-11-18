public class CalculadoraRisco {
    private EstrategiaRisco estrategia;

    public void setEstrategia(EstrategiaRisco estrategia) {
        this.estrategia = estrategia;
    }
    
        public void analisar(double renda, double idade, double patrimonio) {
            if(estrategia == null){
                System.out.println("Nenhuma estratégia definida.");
                return;
            }
            String resultado = estrategia.calcularPerfil(renda, idade, patrimonio);
            System.out.println(resultado);
        }
}
