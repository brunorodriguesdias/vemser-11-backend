package model;

public class ContaPoupanca extends Conta implements Impressao{
    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public ContaPoupanca() {}

    public void creditarTaxa(){
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("model.Cliente: " + getCliente().getNome());
        System.out.printf("Número da conta %s agência: %s \n", getNumeroConta(), getAgencia());
        System.out.println("O saldo da conta é: " + getSaldo());
    }
}
