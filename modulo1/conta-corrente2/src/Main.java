public class Main {
    public static void main(String[] args) {
        Contato[] contatoBruno = new Contato[2];
        contatoBruno[0] = new Contato("Celular", "51994414634", 1);
        Endereco[] enderecoBruno = new Endereco[2];
        enderecoBruno[0] = new Endereco(1, "General Anapio", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil");
        Cliente bruno = new Cliente("Bruno Rodrigues", "84825855091", contatoBruno, enderecoBruno);
        ContaCorrente contaBruno = new ContaCorrente(bruno, "12345", "3556", 1000, 300);

        Contato[] contatoRitiele = new Contato[2];
        contatoRitiele[0] = new Contato("Celular", "519996262896", 1);
        Endereco[] enderecoRitiele = new Endereco[2];
        enderecoBruno[0] = new Endereco(1, "General Anapio", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil");
        Cliente ritiele = new Cliente("Ritiele Curtinaz Cabeleira", "01873005008", contatoRitiele, enderecoRitiele);
        ContaPoupanca contaRitiele = new ContaPoupanca(ritiele, "98765", "3556", 5000);

        contaBruno.transferir(contaRitiele, 100);
        contaBruno.depositar(500);
        contaRitiele.depositar(500);
        contaBruno.sacar(100);
        contaRitiele.sacar(100);





    }
}
