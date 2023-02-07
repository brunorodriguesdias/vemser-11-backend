import java.util.Scanner;
public class Exercicio6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int igual = 0;
        int maiores = 0;
        int menores = 0;

        int[] vetor = {1, 2, 3, 4, 5 ,6 ,7 ,8, 9, 7};

        System.out.print("Digite um número: ");
        int numero = ler.nextInt();

        for (int i = 0; i < vetor.length; i++) {
            if(numero == vetor[i]) {
                igual++;
            } else if(numero < vetor[i]) {
                maiores++;
            } else {
                menores++;
            }
        }

        System.out.println("Quantidade de números iguais é " + igual);
        System.out.println("Quantidade de números menores é " + menores);
        System.out.println("Quantidade de números maiores é " + maiores);

    }
}
