public abstract class calculos {
    
    public static circunferencia criarCirc(double raio){
        return new circunferencia(raio);
    }

    public static double perimetro(circunferencia circunf){
        return 2*(circunf.raio)*3.14;
    }
}
