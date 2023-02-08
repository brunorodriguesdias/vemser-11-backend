public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco(){
        System.out.println("Tipo de endereço: " + tipo);
        System.out.printf("Logradouro: %s número: %s \n", logradouro, numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("CEP: " + cep);
        System.out.println("Cidade: " + cidade);
        System.out.printf("Estado %s País: %s \n", estado, pais);
    }
}
