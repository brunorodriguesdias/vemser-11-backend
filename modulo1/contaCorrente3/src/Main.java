import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contato> contatoBruno = new ArrayList<>();
        contatoBruno.add(new Contato("Celular", "51994414634", 1));
        contatoBruno.add(new Contato("Filha gata, não sabe falar", "51999999999", 2));

        List<Endereco> enderecoBruno = new ArrayList<>();
        enderecoBruno.add(new Endereco(1, "General Ánapio Gomes", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil"));

        Cliente bruno = new Cliente("Bruno Rodrigues", "84825855091", contatoBruno, enderecoBruno);
        ContaCorrente contaBruno = new ContaCorrente(bruno, "12345", "3556", 1000, 300);

        List<Contato> contatoRitiele = new ArrayList<>();
        contatoRitiele.add(new Contato("Celular", "51996262896", 1));
        contatoRitiele.add(new Contato("Celular marido", "51994414634", 2));

        List<Endereco> enderecoRitiele = new ArrayList<>();
        enderecoRitiele.add(new Endereco(1, "General Ánapio Gomes", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil"));

        Cliente ritiele = new Cliente("Ritiele Curtinaz Cabeleira", "01873005008", contatoRitiele, enderecoRitiele);
        ContaPoupanca contaRitiele = new ContaPoupanca(ritiele, "98765", "3556", 5000);

        List<Contato> contatoAlasca = new ArrayList<>();
        contatoAlasca.add(new Contato("Celular", "51999999999", 1));
        contatoAlasca.add(new Contato("Pai", "51994414634", 2));

        List<Endereco> enderecoAlasca = new ArrayList<>();
        enderecoAlasca.add(new Endereco(1, "General Ánapio Gomes", 1098, "Final da rua", "94920-270", "Cachoeirinha", "RS", "Brasil"));

        Cliente alasca = new Cliente("Alasca Rodrigues Cabeleira", "999777888-55", contatoAlasca, enderecoAlasca);
        ContaPagamento contaAlasca = new ContaPagamento(alasca, "66655", "9997", 10000);

//        contaBruno.transferir(contaRitiele, 100);
//        contaBruno.depositar(500);
//        contaRitiele.depositar(500);
//        contaBruno.sacar(1600);
//        contaRitiele.sacar(100);
//        contaRitiele.creditarTaxa();
//        contaBruno.transferir(contaRitiele, 1200);

//        contaBruno.imprimir();
//        contaBruno.imprimir();
//        contaRitiele.imprimir();

//        bruno.imprimirContatos();
//        bruno.imprimirEnderecos();
        contaAlasca.sacar(10000);
        contaAlasca.imprimir();

    }
}
