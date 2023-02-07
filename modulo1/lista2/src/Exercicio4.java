import java.util.Scanner;
public class Exercicio4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double[][] matriz = new double[5][4];

        for (int i = 0; i < matriz.length; i++) {
            int coluna = 0;
            System.out.print("Digite a matricula do Aluno " + (i+1) + ": ");
            matriz[i][coluna] = ler.nextDouble();
            coluna++;
            System.out.print("Digite a média das provas do Aluno " + (i+1) + ": ");
            matriz[i][coluna] = ler.nextDouble();
            coluna++;
            System.out.print("Digite a média dos trabalhos do Aluno " + (i+1) + ": ");
            matriz[i][coluna] = ler.nextDouble();
            coluna++;
            matriz[i][coluna] = (matriz[i][1] * 0.6) + (matriz[i][2] * 0.4);
        }

        double mediaNotasFinais = 0;
        double maiorMedia = 0;
        int indiceMaiorNota = 0;
        for (int j = 0; j < matriz.length; j++) {
            mediaNotasFinais += matriz[j][3]; //Somando as notas finais para depois obter a média
            if (matriz[j][3] > maiorMedia) {
                maiorMedia = matriz[j][3];
                indiceMaiorNota = j;
            }
        }
        System.out.printf("A Matricula que teve a maior nota final foi %.0f \n", matriz[indiceMaiorNota][0]);
        System.out.println("A média das notas finais é " + mediaNotasFinais / matriz.length);
    }
}
