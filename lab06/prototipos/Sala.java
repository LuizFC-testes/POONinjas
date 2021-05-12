public class Sala {
    private boolean visivel;
    private Componente[] componentes;

    Sala (int maxComp) {
        visivel = false;
        componentes = new Componente[maxComp];
        for (int i = 0; i < maxComp; i++) {
            componentes[i] = null;
        }
    }

    public void tornarVisivel() {
        visivel = true;
    }

    public boolean adicionarComponente(Componente c) {
        int idx = c.getPrioridade() - 1;
        if (componentes[idx] == null) {
            componentes[idx] = c;
            return true;
        }
        return false;
    }

    public Componente compMaisImportante() {
        return componentes[0];
    }

    public boolean removerComponente(Componente c) {
        if (c.getLinha() == linha && c.getColuna() == coluna) {
            componentes[c.getPrioridade() - 1];
            return true;
        }
        return false;
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
                    return componentes[i].toString;
                }
            }
            return "#";
        }
    }
}