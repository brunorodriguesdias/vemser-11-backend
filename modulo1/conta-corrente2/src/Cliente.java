public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contato = new Contato[2];
    private Endereco[] endereco = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contato, Endereco[] endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public void imprimirContatos() {
        for (int i = 0; i < contato.length; i++) {
            if (contato[i] != null) {
                contato[i].imprimirContato();
            }
        }
    }
    public void imprimirEnderecos() {
        for (int i = 0; i < endereco.length; i++) {
            if (endereco[i] != null) {
                endereco[i].imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public Contato[] getContato() {
        return contato;
    }
    public void setContato(Contato[] contato) {
        this.contato = contato;
    }
    public Endereco[] getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco[] endereco) {
        this.endereco = endereco;
    }
}

