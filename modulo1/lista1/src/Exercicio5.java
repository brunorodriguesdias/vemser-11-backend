import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Vamos calcular a área do retangulo!");
        System.out.print("Digite a base (em metros): ");
        double base = ler.nextDouble();
        System.out.print("Digite a altura (em metros): ");
        double altura = ler.nextDouble();

        System.out.println("A área do retangulo é: " + base * altura + "m².");

    }
}
