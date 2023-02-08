public class Main {
    public static void main(String[] args){

        //CLIENTE 1

        Contato contatoBruno = new Contato();
        contatoBruno.descricao = "Celular";
        contatoBruno.telefone = "51994414634";
        contatoBruno.tipo = 1;

        Contato contatoBruno2 = new Contato();
        contatoBruno2.descricao = "Celular esposa - Somente mensagem";
        contatoBruno2.telefone = "51996262896";
        contatoBruno2.tipo = 2;

        Endereco enderecoBruno = new Endereco();
        enderecoBruno.tipo = 1;
        enderecoBruno.logradouro = "Av General Ánapio Gomes";
        enderecoBruno.numero = 1081;
        enderecoBruno.complemento = "Final da rua";
        enderecoBruno.cep = "94920-270";
        enderecoBruno.cidade = "Cachoeirinha";
        enderecoBruno.estado = "Rio Grande do Sul";
        enderecoBruno.pais = "Brasil";

        Cliente bruno = new Cliente();
        bruno.nome = "Bruno Rodrigues";
        bruno.cpf = "84825855091";
        bruno.contato[0] = contatoBruno;
        bruno.contato[1] = contatoBruno2;
        bruno.endereco[0] = enderecoBruno;

        ContaCorrente contaBruno = new ContaCorrente();
        contaBruno.cliente = bruno;
        contaBruno.numeroConta = "522643";
        contaBruno.agencia = 100;
        contaBruno.saldo = 500;
        contaBruno.chequeEspecial = 200;


        //CLIENTE 2

        Contato contatoRitiele = new Contato();
        contatoRitiele.descricao = "Celular";
        contatoRitiele.telefone = "51996262896";
        contatoRitiele.tipo = 1;

        Contato contatoRitiele2 = new Contato();
        contatoRitiele2.descricao = "Celular marido - Somente mensagem";
        contatoRitiele2.telefone = "51994414634";
        contatoRitiele2.tipo = 2;

        Endereco enderecoRitiele = new Endereco();
        enderecoRitiele.tipo = 1;
        enderecoRitiele.logradouro = "Av General Ánapio Gomes";
        enderecoRitiele.numero = 1081;
        enderecoRitiele.complemento = "Final da rua";
        enderecoRitiele.cep = "94920-270";
        enderecoRitiele.cidade = "Cachoeirinha";
        enderecoRitiele.estado = "Rio Grande do Sul";
        enderecoRitiele.pais = "Brasil";

        Cliente ritiele = new Cliente();
        ritiele.nome = "Ritiele Cabeleira";
        ritiele.cpf = "01873005008";
        ritiele.contato[0] = contatoRitiele;
        ritiele.contato[1] = contatoRitiele2;
        ritiele.endereco[0] = enderecoRitiele;

        ContaCorrente contaRitiele = new ContaCorrente();
        contaRitiele.cliente = ritiele;
        contaRitiele.numeroConta = "529977";
        contaRitiele.agencia = 100;
        contaRitiele.saldo = 500;
        contaRitiele.chequeEspecial = 200;

//        contaRitiele.depositar(200);
//        contaRitiele.transferir(contaBruno, 750);
//
//        contaRitiele.imprimirContaCorrente();
//        contaBruno.imprimirContaCorrente();

//        contaBruno.sacar(100);
//        contaBruno.imprimirContaCorrente();

        



    }
}