import java.util.Scanner;
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o número secreto: ");
        int numeroSecreto = ler.nextInt();

        System.out.println("-------------------------------------------------------");
        System.out.print("Tente acertar o número secreto, digite sua tentativa: ");
        int tentativa = ler.nextInt();

        while(tentativa != numeroSecreto) {
            if(numeroSecreto > tentativa) {
                System.out.print("O número secreto é maior do que o digitado, tente novamente: ");
                tentativa = ler.nextInt();
            } else {
                System.out.print("O número secreto é menor do que o digitado, tente novamente: ");
                tentativa = ler.nextInt();
            }
        }
        System.out.println("Parabéns você acertou o número secreto é " + numeroSecreto);
    }
}
