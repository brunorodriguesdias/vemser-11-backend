public class Exercicio4 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int transicao;

        transicao = a;
        a = b;
        b = transicao;

        System.out.println("Valor a: " + a);
        System.out.println("Valor b: " + b);
    }
}
