public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];

    void imprimirContatos(){
        for(int i = 0; i < contato.length; i++){
            if (contato[i] != null) {
                contato[i].imprimirContato();
            }
        }
//        if (contato[1] != null) {
//            contato[1].imprimirContato();
//        }
    }
    void imprimirEnderecos(){
        for(int i = 0; i < endereco.length; i++){
            if (endereco[i] != null) {
                endereco[i].imprimirEndereco();
            }
        }
//        if (endereco[1] != null) {
//            endereco[1].imprimirEndereco();
//        }
    }
    void imprimirCliente(){
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

}
