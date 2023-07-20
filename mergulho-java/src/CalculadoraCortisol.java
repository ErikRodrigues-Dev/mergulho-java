public class CalculadoraCortisol {
    public static void main(String[] args) {
        double cortisol = 18.6;

//        boolean resultadoNormal = cortisol >= 6.0 && cortisol <=18.4;
//        boolean resultadoAnormal = cortisol < 6.0 || cortisol > 18.4;

//        System.out.println("Cortisol nnormal: "+resultadoNormal);
//        System.out.println("Cortisol anormal: "+resultadoAnormal);

        if (cortisol >= 6.0 && cortisol <=18.4) {
            System.out.println("Cortisol normal");
        } else if (cortisol < 18.4) {
            System.out.println("Cortisol alto");
        } else {
            System.out.println("Cortisol Baixo");
        }

    }

}
