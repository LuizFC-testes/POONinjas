public class Exibicao {
    public String nome;
    public String tema;
    public int ano;
    public double popularidade;
    public Arte[] obras;

    Exibicao(String nome, String tema, int ano, double popularidade, Arte[] obras) {
        this.nome = nome;
        this.tema = tema;
        this.ano = ano;
        this.popularidade = popularidade;
        this.obras = obras;
    }

    public void adicionarObra(Arte novaArte) {
        if (obras == null) {
            obras = new Arte[1];
            obras[0] = novaArte;
        } else {
            Arte[] novaLista = new Arte[obras.length];
            for (int i = 0; i < obras.length; i++) {
                novaLista[i] = obras[i];
            }
            novaLista[obras.length] = novaArte;
            obras = novaLista;
        }
    }

    public String toString() {
        String eu = "Nome: " + nome + "\n";
        eu += "Ano de exibição: " + ano + "\n";
        eu += "Popularidade: " + popularidade + "\n";
        eu += "Obras:\n\n";
        for (Arte obra : obras) {
            eu += obra.toString();
            eu += "\n   --------------------\n";
        }
        return eu;
    }
}