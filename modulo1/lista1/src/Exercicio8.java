import java.util.Scanner;
public class Exercicio8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o cargo do funcionário :");
        int codigoCargo = ler.nextInt();
        System.out.print("Digite o salário do funcionario: ");
        double salario = ler.nextDouble();
        double novoSalario;

        if(codigoCargo == 101){
            novoSalario = salario * 1.1;
            System.out.println("Seu antigo salário era de R$" + salario);
            System.out.println("Seu novo salário de gerente será de R$" + novoSalario);
            System.out.println("A diferença será de R$" + (novoSalario - salario));
        } else if (codigoCargo == 102) {
            novoSalario = salario * 1.2;
            System.out.println("Seu antigo salário era de R$" + salario);
            System.out.println("Seu novo salário de engenheiro será de R$" + novoSalario);
            System.out.println("A diferença será de R$" + (novoSalario - salario));
        } else if (codigoCargo == 103) {
            novoSalario = salario * 1.3;
            System.out.println("Seu antigo salário era de R$" + salario);
            System.out.println("Seu novo salário de técnico será de R$" + novoSalario);
            System.out.println("A diferença será de R$" + (novoSalario - salario));
        } else {
            novoSalario = salario * 1.4;
            System.out.println("Seu antigo salário era de R$" + salario);
            System.out.println("Seu novo salário será de R$" + novoSalario);
            System.out.println("A diferença será de R$" + (novoSalario - salario));
        }
    }
}
