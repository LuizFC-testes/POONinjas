package mc322.lab06;

public class Sala {
    private boolean visivel;
    private int linha,
                coluna;
    private CompMovel[] componentes;

    Sala (int linha, int coluna, int maxComp) {
        visivel = false;
        this.linha = linha;
        this.coluna = coluna;
        componentes = new CompMovel[maxComp];
        /*for (int i = 0; i < maxComp; i++) {
            componentes[i] = null;
        }*/
    }

    public void tornarVisivel() {
        visivel = true;
    }

    public boolean adicionarComponente(Componente c) {
        int idx = c.getPrioridade() - 1;
        //System.out.println(c.getPrioridade());
        //System.out.println(idx);
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

    public CompMovel compMaisImportante() {
        return componentes[0];
    }

    public boolean removerComponente(Componente c) {
        if (c.getLinha() == linha && c.getColuna() == coluna) {
            componentes[c.getPrioridade() - 1] = null;
            return true;
        }
        return false;
    }

    public void removerComponente(int prioridade) {
        componentes[prioridade - 1] = null;
    }

    public void exporSala() {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] != null) {
                componentes[i].anunciar();
            }
        }
    }

    public String toString() {
        if (visivel == false) {
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