public abstract class Componente {
    protected int linha;
    protected int coluna;
    protected Caverna cave;
    protected prioridade; // A partir de 1, e, quanto menor o número, mais alta

    public Componente (int linha, int coluna, Caverna cave) {
        this.linha = linha;
        this.coluna = coluna;
        this.cave = cave;
        this.cave.adicionarComponente(this);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void posicionar() {
        // FAZER
    }

    public void mover(String wasd) {
        int novaLinha = linha, novaColuna = coluna;
        if (wasd == "w") {
            novaLinha--;
        } else if (wasd == "a") {
            novaColuna--;
        } else if (wasd == "s") {
            novaLinha++;
        } else {
            novaColuna++;
        }
        boolean moveu = cave.moverComponente(this, novaLinha, novaColuna)
        if (moveu) {
            linha = novaLinha;
            coluna = novaColuna;
        }
        return moveu;
    }

    public int getPrioridade() {
        return prioridade;
    }

    // Protótipos gerais

    public abstract String toString();

    // Protótipos Heroi

    public abstract Flecha getFlecha();

    public abstract boolean flechaEquipada();

    public abstract Ouro getOuro();

    public abstract int[] checarEspolios();

    public abstract int contarFortuna();

    public abstract void percepcao(); // Pode imprimir as mensagens diretamente

    public abstract boolean capturarTesouro();

    public abstract void moverHeroi(Sala s);

    public abstract void disparar();

    public abstract boolean confrontarWumpus();

    public abstract void morrer();

    // Protótipos Tesouro

    public abstract int getValor();

    public abstract void serCapturado();

    public abstract void anunciar();

    // Protótipos Buraco

    public abstract void capturarHeroi(Heroi h);

    // Protótipos Monstro

    public abstract int getForca();

    public abstract void confrontarHeroi(Heroi h);

    public abstract void gerarEfeito();
}