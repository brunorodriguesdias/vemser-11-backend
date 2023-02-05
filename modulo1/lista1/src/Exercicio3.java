import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Bem vindo ao tradutor!");
        System.out.print("Digite a palavra a ser traduzida: ");
        String palavra = ler.nextLine();
        switch(palavra) {
            case "Cachorro" -> {
                System.out.println("Cachorro em inglês é dog");
            }
            case "Dog" -> {
                System.out.println("Dog em português é cachorro");
            }
            case "Tempo" -> {
                System.out.println("Tempo em inglês é time");
            }
            case "Time" -> {
                System.out.println("Time em português é tempo");
            }
            case "Amor" -> {
                System.out.println("Amor em inglês é love");
            }
            case "Love" -> {
                System.out.println("Love em português é amor");
            }
            case "Cidade" -> {
                System.out.println("Cidade em inglês é City");
            }
            case "City" -> {
                System.out.println("City em português é cidade");
            }
            case "Feliz" -> {
                System.out.println("Feliz em inglês é happy");
            }
            case "Happy" -> {
                System.out.println("Happy em português é feliz");
            }
            case "Triste" -> {
                System.out.println("Triste em inglês é Sad");
            }
            case "Sad" -> {
                System.out.println("Sad em português é triste");
            }
            case "Deveria" -> {
                System.out.println("Deveria em inglês é should");
            }
            case "Should" -> {
                System.out.println("should em português é deveria");
            }
            case "Poderia" -> {
                System.out.println("Poderia em inglês é could");
            }
            case "Could" -> {
                System.out.println("could em português é poderia");
            }
            default -> {
                System.out.println("Essa palavra não é válida!");
            }
        }
    }
}
