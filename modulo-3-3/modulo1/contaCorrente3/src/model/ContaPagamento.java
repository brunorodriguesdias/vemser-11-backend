package model;

public class ContaPagamento extends Conta implements Impressao{

    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento () {}

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

        public boolean sacar(double valorSaque) {
        if(valorSaque > 0 && getSaldo() >= (valorSaque + TAXA_SAQUE)){
            setSaldo(getSaldo() - (valorSaque + TAXA_SAQUE));
            return true;
        } else {
            return false;
        }
    }

    public boolean transferir(Conta contaDestino, double valorTransferencia) {
        if(super.sacar(valorTransferencia)){
            contaDestino.depositar(valorTransferencia);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("model.Cliente: " + getCliente().getNome());
        System.out.printf("Número da conta %s agência: %s \n", getNumeroConta(), getAgencia());
        System.out.println("O saldo da conta é: " + getSaldo());
    }
}
