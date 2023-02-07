import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String[] nome = new String[100];
        int[] altura = new int[100];
        byte[] idade = new byte[100];
        byte[] peso = new byte[100];


        int maiorAltura = 0;
        int mediaDaAltura = 0;
        int maiorIdade = 0;
        int maiorPeso = 0;
        int indiceJogadorMaisVelho = 0;
        int indiceJogadorMaisPesado = 0;
        int contador = 0;


        while(true) {
            System.out.print("Digite o nome do jogador: ");
            nome[contador] = ler.nextLine().toLowerCase();
            if (nome[contador].equals("sair")) {
                break;
            }
            System.out.print("Digite a altura do jogador em cm: ");
            altura[contador] = ler.nextInt();
            System.out.print("Digite a idade do jogador jogador: ");
            idade[contador] = ler.nextByte();
            System.out.print("Digite o peso do jogador: ");
            peso[contador] = ler.nextByte();
            ler.nextLine();
            contador++;
        }
        for(int i = 0; i < altura.length; i++) {
            mediaDaAltura += altura[i];
            if (maiorAltura < altura[i]) {
                maiorAltura = altura[i];
            }
            if (maiorIdade < idade[i]) {
                maiorIdade = idade[i];
                indiceJogadorMaisVelho = i;
            }
            if (maiorPeso < peso[i]){
                maiorPeso = peso[i];
                indiceJogadorMaisPesado = i;
            }
        }

        System.out.println(contador + " jogadores foram cadastrados.");
        System.out.println("O jogador mais alto mede " + maiorAltura);
        System.out.println("O Jogador mais velho é " + nome[indiceJogadorMaisVelho] + " que tem " + maiorIdade + " anos.");
        System.out.println("O Jogador mais pesado é " + nome[indiceJogadorMaisPesado] + " que pesa " + maiorPeso + " Kgs.");
        System.out.println("A média da altura dos jogadores é de " + (mediaDaAltura / contador) + "cm.");
    }
}
