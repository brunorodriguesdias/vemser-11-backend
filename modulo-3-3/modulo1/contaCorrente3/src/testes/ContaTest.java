package testes;

import model.ContaCorrente;
import model.ContaPagamento;
import model.ContaPoupanca;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        double saldoConta = 0;
        contaPoupanca.setSaldo(saldoConta);
        double valorSaque = 50;

        boolean falhaSaque = (contaPoupanca.sacar(50));

        Assert.assertFalse(falhaSaque);

        Assert.assertEquals(saldoConta, contaPoupanca.getSaldo(), 0);
    }
    @Test
    public void deveTestarDepositoNegativo() {
        ContaCorrente contaCorrente = new ContaCorrente();
        double saldoConta = 1000;
        contaCorrente.setSaldo(saldoConta);
        double valorSaque = -50;

        boolean falhaSaque = contaCorrente.sacar(valorSaque);

        Assert.assertFalse(falhaSaque);

        Assert.assertEquals(saldoConta, contaCorrente.getSaldo(), 0);
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        ContaPagamento contaPagamento = new ContaPagamento();
        ContaCorrente contaCorrente = new ContaCorrente();
        double saldoConta = 500;
        contaPagamento.setSaldo(saldoConta);
        double valorTransferencia = 700;

        boolean falhaTransferencia = contaPagamento.transferir(contaCorrente, valorTransferencia);

        Assert.assertFalse(falhaTransferencia);

        Assert.assertEquals(saldoConta, contaPagamento.getSaldo(), 0);
    }
    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        double saldoConta = 1500;
        contaPoupanca.setSaldo(saldoConta);
        double valorSaque = 500;
        double resultado = 1000;

        boolean saqueEfetivado = contaPoupanca.sacar(valorSaque);

        Assert.assertTrue(saqueEfetivado);

        Assert.assertEquals(resultado, contaPoupanca.getSaldo(), 0);
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = new ContaCorrente();
        double saldoConta = 5000;
        contaCorrente.setSaldo(saldoConta);
        double valorDeposito = 2000;
        double resultado = 7000;

        boolean depositoEfetivado = contaCorrente.depositar(valorDeposito);

        Assert.assertTrue(depositoEfetivado);

        Assert.assertEquals(resultado, contaCorrente.getSaldo(), 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo () {
        ContaPagamento contaPagamento = new ContaPagamento();
        double saldoConta = 775;
        contaPagamento.setSaldo(saldoConta);
        double valorSaque = 832;

        boolean saqueNegado = contaPagamento.sacar(832);

        Assert.assertFalse(saqueNegado);

        Assert.assertEquals(saldoConta, contaPagamento.getSaldo(), 0);
    }
    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso () {
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        double saldoContaCorrente = 1575;
        double saldoContaPoupanca = 2575;
        double valorTransferencia = 425;
        double resultado = valorTransferencia + saldoContaPoupanca;

        contaCorrente.setSaldo(saldoContaCorrente);
        contaPoupanca.setSaldo(saldoContaPoupanca);

        boolean transferenciaEfetuada = contaCorrente.transferir(contaPoupanca, valorTransferencia);

        Assert.assertTrue(transferenciaEfetuada);

        Assert.assertEquals(resultado, contaPoupanca.getSaldo(), 0);
    }
}
