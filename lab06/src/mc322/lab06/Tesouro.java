package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public abstract class Tesouro extends Componente{
	/** Valor do tesouro */
    protected int valor;
    /** Ponteiro para próximo tesouro / Mochila do herói utiliza uma lista ligada */
    protected Tesouro proximo;

    /** Construtor */
    Tesouro(int linha, int coluna, Caverna cave, int valor) {
        super(linha, coluna, cave);
        this.valor = valor;
        this.proximo = null;
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    /**
     * Retorna valor do tesouro
     */
    public int getValor() {
        return valor;
    }

    /**
     * Retorna o próximo tesouro da lista ligada
     */
    public Tesouro getProximo() {
        return proximo;
    }

    /**
     * Define o ponteiro para o próxima tesouro da lista ligada
     */
    public void setProximo(Tesouro proximo) {
        this.proximo = proximo;
    }

    /**
     * Função para ser chamada  quando tesouro for capturado
     */
    public void serCapturado() {
        this.linha = -1;
        this.coluna = -1;
    }

}