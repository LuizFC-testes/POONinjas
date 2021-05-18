public class Arte implements Mostrador {
    public String nome;
    public String autor;
    public Data dataCriacao;
    public String escola;

    Arte(String nome, String autor, Data dataCriacao, String escola) {
        this.nome = nome;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
        this.escola = escola;
    }

    public String toString() {
        String eu = "Nome: " + nome + "\n";
        eu += "Autor: " + autor + "\n";
        eu += "Data da criação: " + dataCriacao + "\n";
        eu += "Escola: " + escola + "\n";
        return eu;
    }
}