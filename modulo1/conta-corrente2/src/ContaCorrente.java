public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial){
        setCliente(cliente);
        setNumeroConta(numeroConta);
        setAgencia(agencia);
        setSaldo(saldo);
        setChequeEspecial(chequeEspecial);
    }

    public boolean sacar(double valorSaque){
        if (valorSaque < retornarSaldoComChequeEspecial() && valorSaque > 0) {
            setSaldo(getSaldo() - valorSaque);
            return true;
        } else {
            return false;
        }
    }
    public double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.printf("Número da conta %s agência: %s \n", getNumeroConta(), getAgencia());
        System.out.println("O saldo da conta é: " + getSaldo());
        System.out.println("Valor cheque especial: " + chequeEspecial);
    }
}
