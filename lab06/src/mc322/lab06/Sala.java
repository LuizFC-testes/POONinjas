package mc322.lab06;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Sala {
	/** Indica se a sala está visível ao usuário */
    private boolean visivel;
    /** Posição da sala na caverna */
    private int linha,
                coluna;
    /** Lista de componentes presenntes na sala */
    private CompMovel[] componentes;

    /** Construtor */
    Sala (int linha, int coluna, int maxComp) {
        visivel = false;
        this.linha = linha;
        this.coluna = coluna;
        componentes = new CompMovel[maxComp];
    }

    /**
     * Tornar a sala visível ao usuário
     */
    public void tornarVisivel() {
        visivel = true;
    }

    /**
     * Adicionar um componente na sala
     * @return true se componente adicionado, false senão
     */
    public boolean adicionarComponente(Componente c) {
        int idx = c.getPrioridade() - 1;
        
        if (componentes[idx] == null) {
            CompMovel cm = (CompMovel)c;
            componentes[idx] = cm;
            if (c instanceof Heroi && !visivel) {
                tornarVisivel();
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna o componente com a prioridade mais alta
     */
    public CompMovel compMaisImportante() {
        return componentes[0];
    }

    /**
     * Remove um componente específico da sala
     * @return true se componente removido, false senão
     */
    public boolean removerComponente(Componente c) {
        if (c.getLinha() == linha && c.getColuna() == coluna) {
            componentes[c.getPrioridade() - 1] = null;
            return true;
        }
        return false;
    }

    /**
     * Remove o componente com uma prioridade específica da sala
     */
    public void removerComponente(int prioridade) {
        componentes[prioridade - 1] = null;
    }

    /**
     * Expõe os componentes existentes dentro da sala
     */
    public void exporSala() {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] != null) {
                componentes[i].anunciar();
            }
        }
    }

    /**
     * Retorna a representação da sala no mapa da caverna
     * Indicará sempre a representação do componente mais prioritário
     */
    public String toString() {
        if (!visivel) {
            return "-";
        } else {
            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i] != null) {
                    return componentes[i].toString();
                }
            }
            return "#";
        }
    }
}