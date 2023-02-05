import java.util.Scanner;
public class Exercicio6 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o total de eleitores do município: ");
        int totalEleitores = ler.nextInt();
        System.out.print("Digite o número de votos em branco: ");
        double votosEmBranco = ler.nextDouble();
        System.out.print("Digite o número de votos nulos: ");
        double votosNulos = ler.nextDouble();
        System.out.print("Digite o número de votos válidos: ");
        double votosValidos = ler.nextDouble();

        double totalVotos = votosEmBranco + votosNulos + votosValidos;
        if(totalVotos > totalEleitores || totalVotos < totalEleitores){
            System.out.println("Quantidade de votos inseridos diverge do total de eleitores, tente novamente!");
        } else {
            double resultado = votosEmBranco / totalEleitores;
            System.out.println("O percentual de votos em branco foi de " + resultado * 100 + "%");
            resultado = votosNulos / totalEleitores;
            System.out.println("O percentual de votos nulos foi de " + resultado * 100 + "%");
            resultado = votosValidos / totalEleitores;
            System.out.println("O percentual de votos válidos foi de " + resultado * 100 + "%");
        }
    }
}
