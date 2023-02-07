import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double[][] matriz = new double[10][3];
        double[] mediaMercados = new double[3];

        int indiceMercado = 0;

        for(int i = 0; i < 3; i++){
            int numeroProduto = 0;
            while(numeroProduto < 10) {
                System.out.print("Digite o preço do produto " + (numeroProduto + 1) + " no mercado " + (i + 1) + " : ");
                matriz[numeroProduto][i] = ler.nextDouble();
                mediaMercados[i] += matriz[numeroProduto][i];
                numeroProduto++;
            }
            double mercadoMaisBarato = mediaMercados[0];
            if(mediaMercados[i] < mercadoMaisBarato) {
                mercadoMaisBarato = mediaMercados[i];
                indiceMercado = i;
            }
        }
        System.out.println("\n-----------------------------------------------------------\n");
        System.out.println("O mercado mais barato é o mercado " + (indiceMercado + 1));
    }
}
