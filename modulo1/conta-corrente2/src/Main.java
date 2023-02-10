public class Main {
    public static void main(String[] args) {
        Contato contatoBruno = new Contato("Celular", "51994414634", 1);
        Contato contatoBruno2 = new Contato("Celular da esposa", "51996262896", 2);
        Endereco enderecoBruno = new Endereco(1, "General Ánapio Gomes", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil");
        Cliente bruno = new Cliente("Bruno Rodrigues", "84825855091");
        ContaCorrente contaBruno = new ContaCorrente(bruno, "12345", "3556", 1000, 300);
        bruno.getContato()[0] = contatoBruno;
        bruno.getContato()[1] = contatoBruno2;
        bruno.getEndereco()[0] = enderecoBruno;

        Contato contatoRitiele = new Contato("Celular", "51996262896", 1);
        Contato contatoRitiele2 = new Contato("Celular da marido", "51994414634", 2);
        Endereco enderecoRitiele = new Endereco(1, "General Ánapio Gomes", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil");
        Cliente ritiele = new Cliente("Ritiele Curtinaz Cabeleira", "01873005008");
        ContaPoupanca contaRitiele = new ContaPoupanca(ritiele, "98765", "3556", 5000);
        ritiele.getContato()[0] = contatoRitiele;
        ritiele.getContato()[1] = contatoRitiele2;
        ritiele.getEndereco()[0] = enderecoRitiele;

//        contaBruno.transferir(contaRitiele, 100);
//        contaBruno.depositar(500);
//        contaRitiele.depositar(500);
//        contaBruno.sacar(1600);
//        contaRitiele.sacar(100);
        contaRitiele.creditarTaxa();
        contaBruno.transferir(contaRitiele, 1200);

//        contaBruno.imprimir();
        contaBruno.imprimir();
        contaRitiele.imprimir();

    }
}
