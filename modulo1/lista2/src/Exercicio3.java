import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome = "";
        while(!nome.equals("sair")) {
            System.out.print("Digite o nome do jogador: ");
            nome = ler.nextLine();
            System.out.print("Digite a altura do jogador em cm: ");
            int altura = ler.nextInt();
            System.out.print("Digite o nome do jogador: ");
            byte idade = ler.nextByte();
            System.out.print("Digite o nome do jogador: ");
            byte peso = ler.nextByte();
        }
    }
}
