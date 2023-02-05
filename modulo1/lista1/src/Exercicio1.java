import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o ser nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite a sua idade: ");
        int idade = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite a cidade aonde você mora: ");
        String cidade = ler.nextLine();
        System.out.print("Digite o estado aonde você mora: ");
        String estado = ler.nextLine();

        System.out.println("\nOlá seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de "+ estado + ".");
    }
}