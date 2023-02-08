public class Contato {
    String descricao;
    String telefone;
    int tipo;

    void imprimirContato() {
        System.out.println("Descrição do contato: " + descricao);
        System.out.println("Telefone :" + telefone);
        System.out.println("tipo de contato: " + tipo);
    }
}
