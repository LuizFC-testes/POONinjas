package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public abstract class Monstro extends Componente{
	/** Atributo de força do monstro de 0 a 100, sendo 100 invencível */
    protected int forca;
    /** Pontos que o monstro fornece caso derrotado */
    protected int saque;

    /** Construtor */
    Monstro(int linha, int coluna, Caverna cave, int forca, int saque) {
        super(linha, coluna, cave);
        this.forca = forca;
        this.saque = saque;
        gerarEfeito();
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 1;
        this.cave.adicionarComponente(this);
    }

    /**
     * Retorna força do monstro
     */
    public int getForca() {
        return forca;
    }

    /**
     * Luta contra um heroi
     * @return score fornecido ao heroi após combate
     */
    public int confrontarHeroi(Heroi h) {
    	// Caso heroi ganhe o confronto
        if (h.confrontarMonstro(this)) {
            mensagemDeMorte();
            return morrer();
        }
        
        // Caso o heroi perca
        mensagemDeVitoria();
        return h.morrer();
    }

    /**
     * Mata o monstro
     * @return Pontos de saque fornecidos ao morrer
     */
    private int morrer() {
        cave.removerComponente(this);
        anularEfeito();
        return saque;
    }

    /**
     * Gera o efeito nas redondezas do monstro
     */
    protected abstract void gerarEfeito();

    /**
     * Elimina o efeito do monstro das suas redondezas
     */
    protected abstract void anularEfeito();

    /**
     * Ação de anunciar a presença do componente no console
     */
    public abstract void anunciar();

    /**
     * Anucia vitória do monstro no caso de combate
     */
    public abstract void mensagemDeVitoria();

    /**
     * Anuncia a morte do monstro
     */
    public abstract void mensagemDeMorte();
}