import java.lang.Class;

public class Heroi extends Componente {
    
    private String nome;
    private boolean statusVivo;
    private Aljava flechas;
    private Tesouro mochila;

    public Heroi(int linha, int coluna, Caverna cave, String nome) {
        super(linha, coluna, cave);
        this.flechas = new Aljava(1);
        this.nome = nome;
        this.statusVivo = true;
        this.mochila = null;
        this.prioridade = 2;
    }

    public boolean equiparFlecha() {
        return flechas.equiparFlecha();
    }

    public boolean flechaEquipada() {
        if (this.flechas.contarFlechas() > 0) {
            return this.flechas.checarFlechaEquip();
        }
        return false; 
    }

    public int contarFlechas() {
        return flechas.contarFlechas();
    }

    public boolean getStatusVivo() {
        return statusVivo;
    }

    public Ouro getOuro() {
        // O ouro tem o maior valor "de todos os tesouros", então fica no início
        return mochila;
    }

    public int[] checarEspolios() {
        Tesouro[] tiposTesouros = {new Ouro()};
        // Depende da quantidade de tesouros diferentes
        int[] contagemEspolios = new int[tiposTesouros.length];
        Tesouro auxiliar = mochila;
        for (int i = 0; i < numTiposTesouros; i++) {
            contagemEspolios[i] = 0;
            while(auxiliar != null && auxiliar.getValor() == tiposTesouros[i].getValor()) {
                contagemEspolios[i]++;
                auxiliar = auxiliar.getProximo();
            }
            i++;
        }
        return contagemEspolios;
    }

    public int contarFortuna() {
        int fortuna = 0;
        Tesouro auxiliar = mochila;
        while(auxiliar != null) {
            fortuna += auxiliar.getValor();
            auxiliar = auxiliar.getProximo();
        }
        return fortuna;
    }

    public void percepcao() {
        cave.getSala(linha, coluna).exporSala();
    }

    public boolean capturarTesouro() {
        Componente comp = cave.getSala(linha, coluna).compMaisImportante();
        if (comp.getClass().getSuperclass == Tesouro) {
            if (mochila == null) {
                mochila = comp;
            } else {
                Tesouro auxiliar = mochila;
                while (auxiliar.getProximo() != null && (auxiliar.getProximo().getValor() > comp.getValor())) {
                    auxiliar = auxiliar.getProximo();
                }
                comp.setProximo(auxiliar.getProximo());
                auxiliar.setProximo(comp);
                comp.serCapturado();
            }
            System.out.println("Você conseguiu um tesouro!");
        } else {
            System.out.println("Você percebe que precisa de um cochilo depois de tentar pegar um tesouro que não estava aí");
        }
    }

    public int mover(String wasd) {
        //Fazer
    }

    public void disparar() {
        flechas.dispararFlecha();
    }

    public boolean confrontarWumpus() {
        //Fazer
    }

    public void morrer() {
        statusVivo = false;
    }

    public String toString() {
        return "P";
    }
}