public abstract class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    @Override
    public boolean sacar(double valorSaque) {
        if(this.saldo >= valorSaque && valorSaque > 0){
            saldo -= valorSaque;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean depositar(double valorDeposito) {
        if(valorDeposito > 0){
            saldo += valorDeposito;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean transferir(Conta contaDestino, double valorTransferencia) {
        if(sacar(valorTransferencia)){
            contaDestino.depositar(valorTransferencia);
            return true;
        } else {
            return false;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public String getNumeroConta(){
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
