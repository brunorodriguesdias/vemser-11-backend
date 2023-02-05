import java.util.Scanner;
public class Exercicio9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        boolean horasValidas = true;
        boolean minutosValidos = true;
        System.out.println("Cálculo de tempo de jogo");
        System.out.print("Digite a hora de inicio do jogo: ");
        int horaInicio = ler.nextInt();
        System.out.print("Digite o minuto de inicio do jogo: ");
        int minutoInicio = ler.nextInt();
        System.out.print("Digite a hora de fim do jogo: ");
        int horaFinal = ler.nextInt();
        System.out.print("Digite o minuto de fim do jogo: ");
        int minutoFinal = ler.nextInt();
        if (horaInicio > 23 || horaFinal > 23) {
            horasValidas = false;
            System.out.println("A hora digitada é invalida!");
        } else if (minutoInicio > 59 || minutoFinal > 59) {
            minutosValidos = false;
            System.out.println("O minuto digitado é invalido");
        }
        if(horasValidas == true && minutosValidos == true) {
            int horaDuracao;
            int minutosDuracao;

            if (horaInicio > horaFinal) {
                horaDuracao = horaFinal - horaInicio + 24;
            } else {
                horaDuracao = horaFinal - horaInicio;
            }
            if (minutoInicio > minutoFinal) {
                horaDuracao -= 1;
                minutosDuracao = minutoFinal - minutoInicio + 60;
            } else {
                minutosDuracao = minutoFinal - minutoInicio;
            }
            System.out.println("O jogo durou " + horaDuracao + " horas e " + minutosDuracao + " minutos.");
        }

    }
}
