public class App {
    public static void main(String[] args) throws Exception {
        circunferencia c = calculos.criarCirc(2.0);
        double area = calculos.perimetro(c);
        System.out.println(area);
    }
}
