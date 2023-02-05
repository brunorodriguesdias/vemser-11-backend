import java.util.Scanner;
public class Exercicio10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Calculadora de notas");
        System.out.print("Digite o id do aluno: ");
        int id = ler.nextInt();

        System.out.print("Digite o valor da nota 1: ");
        double nota1 = ler.nextDouble();
        System.out.print("Digite o valor da nota 2: ");
        double nota2 = ler.nextDouble();
        System.out.print("Digite o valor da nota 3: ");
        double nota3 = ler.nextDouble();
        System.out.print("Digite o valor da média dos exercícios: ");
        double mediaExercicios = ler.nextDouble();

        double mediaAproveitamento = (nota1 + (nota2 * 2) + (nota3 * 3) + mediaExercicios) / 7;
        String conceito = "";
        String mensagem = "O aluno " + id + " teve as seguintes notas" +
                "\n" + "Nota 1: " + nota1 + " Nota 2: " + nota2 + " Nota 3: " + nota3 + " Média de exercícios: " + mediaExercicios +
                "\n" + "A média de aproveitamento foi de " + mediaAproveitamento;

        if (mediaAproveitamento >= 9.0) {
            conceito = "A";
            System.out.println(mensagem);
            System.out.println("O conceito final é " + conceito + ", e o aluno foi aprovado!");
        } else if (mediaAproveitamento >= 7.5) {
            conceito = "B";
            System.out.println(mensagem);
            System.out.println("O conceito final é " + conceito + ", e o aluno foi aprovado!");
        } else if (mediaAproveitamento >= 6.0) {
            conceito = "C";
            System.out.println(mensagem);
            System.out.println("O conceito final é " + conceito + ", e o aluno foi aprovado!");
        } else if (mediaAproveitamento >= 4.0) {
            conceito = "D";
            System.out.println(mensagem);
            System.out.println("O conceito final é " + conceito + ", e o aluno foi reprovado!");
        } else {
            conceito = "E";
            System.out.println(mensagem);
            System.out.println("O conceito final é " + conceito + ", e o aluno foi reprovado!");
        }
    }
}
