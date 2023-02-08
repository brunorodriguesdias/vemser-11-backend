public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    void imprimirContaCorrente(){
        System.out.println("Cliente: " + cliente.nome);
        System.out.printf("Número da conta %s agência: %s \n", numeroConta, agencia);
        System.out.println("O saldo da conta é: " + saldo);
        System.out.println("Valor cheque especial: " + chequeEspecial);
    }
    boolean sacar(double valorSaque){
        if (valorSaque < saldo + chequeEspecial && valorSaque > 0) {
            saldo -= valorSaque;
            return true;
        } else {
            System.out.printf("Saldo indisponivel!");
            return false;
        }
    }
    boolean depositar(double valorDeposito) {
        if(valorDeposito > 0){
            saldo += valorDeposito;
            return true;
        } else {
            return false;
        }
    }
    double retornarSaldoComChequeEspecial(){
        System.out.println(saldo+chequeEspecial);
        return saldo + chequeEspecial;
    }

    boolean transferir(ContaCorrente contaDestino, double valorTransferencia){
        if (valorTransferencia < (saldo + chequeEspecial) && valorTransferencia > 0){
            saldo -= valorTransferencia;
            contaDestino.saldo += valorTransferencia;
            return true;
        } else {
            System.out.println("Saldo insuficiente!");
            return false;
        }
    }
}
