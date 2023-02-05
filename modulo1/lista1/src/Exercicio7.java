import java.sql.SQLOutput;
import java.util.Scanner;
public class Exercicio7 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double abcd = 5.2;
        double xypk = 6.00;
        double klmp = 3.20;
        double qrst = 2.5;
        int quantidade;
        System.out.print("Digite o código do produto: ");
        String codigo = ler.nextLine();
        System.out.println(codigo);
        switch(codigo){
            case "ABCD" ->{
                System.out.print("Digite a quantidade desejada: ");
                quantidade = ler.nextInt();
                System.out.println("O valor total a ser pago é R$" + abcd * quantidade);
            }
            case "XYPK" ->{
                System.out.print("Digite a quantidade desejada: ");
                quantidade = ler.nextInt();
                System.out.println("O valor total a ser pago é R$" + xypk * quantidade);
            }
            case "KLMP" ->{
                System.out.print("Digite a quantidade desejada: ");
                quantidade = ler.nextInt();
                System.out.println("O valor total a ser pago é R$" + klmp * quantidade);
            }
            case "QRST" ->{
                System.out.print("Digite a quantidade desejada: ");
                quantidade = ler.nextInt();
                System.out.println("O valor total a ser pago é R$" + qrst * quantidade);
            }
            default -> {
                System.out.println("Código inválido, tente novamente!");
            }
        }
    }
}
