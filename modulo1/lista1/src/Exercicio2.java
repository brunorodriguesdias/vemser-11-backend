import java.util.Scanner;
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Escolha um dos estados a seguir: \n 1- Rio grande do sul \n 2- Santa Catarina \n 3- Bahia");
        System.out.print("\nDigite a opção desejada: ");
        int estado = ler.nextInt();
        int cidade;
        switch(estado){
            case 1 -> {
                System.out.println("\nEscolha uma cidade: \n 1- Porto Alegre \n 2- Cachoeirinha");
                System.out.print("Digite a opção desejada: ");
                cidade = ler.nextInt();
                if (cidade == 1) {
                    System.out.println("\nPorto Alegre \n População: 1.492.530 habitantes. Principal festa: Carnaval. IDH: 0,805");
                } else {
                    System.out.println("\nCachoeirinha \n População: 129.307 habitantes. Principal festa: Aniversário da cidade. IDH: 0,757");
                }
            }
            case 2 -> {
                System.out.println("\nEscolha uma cidade \n 1- Florianópolis \n 2- Balneário camboriú");
                System.out.print("Digite a opção desejada: ");
                cidade = ler.nextInt();
                if (cidade == 1) {
                    System.out.println("\nFlorianópolis \n População: 574.200 habitantes. Principal festa: Ano novo. IDH: 0,847");
                } else {
                    System.out.println("\nBalneário camboriú \n População: 138.732 habitantes. Principal festa: Ano novo. IDH: 0,845");
                }
            }
            case 3 -> {
                System.out.println("\nEscolha uma cidade \n 1- Salvador \n 2- Porto Seguro");
                System.out.print("Digite a opção desejada: ");
                cidade = ler.nextInt();
                if (cidade == 1) {
                    System.out.println("\nSalvador \n População: 2.902.927 habitantes. Principal festa: Carnaval. IDH: 0,791");
                } else {
                    System.out.println("\nPorto Seguro \n População: 150.658 habitantes. Principal festa: Carnaval. IDH: 0,676");
                }
            }
            default -> {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

    }
}
