public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];

    void imprimirContatos(){
        if (contato[0] != null) {
            contato[0].imprimirContato();
        }
        if (contato[1] != null) {
            contato[1].imprimirContato();
        }
    }
    void imprimirEnderecos(){
        if (endereco[0] != null) {
            endereco[0].imprimirEndereco();
        }
        if (endereco[1] != null) {
            endereco[1].imprimirEndereco();
        }
    }
    void imprimirCliente(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

}
