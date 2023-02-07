import java.util.Scanner;
public class Exercicio1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String produto = ler.nextLine();
        System.out.print("Digite o valor do produto R$");
        double valor = ler.nextInt();

        double desconto = 0.95;
        for (int i = 0; i < 10; i++) {
            double total = valor * desconto;
            System.out.printf("%d x R$%.2f = R$%.2f\n", i+1, total, total * (i+1));
            desconto -= 0.05;
        }
    }
}