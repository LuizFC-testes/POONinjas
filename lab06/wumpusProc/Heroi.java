package wumpusProc;

//import java.lang.Class;
import java.util.Random;

public class Heroi extends Componente {
    
    private String nome;
    private boolean statusVivo;
    private Aljava flechas;
    private Tesouro mochila;

    public Heroi(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        this.flechas = new Aljava(1);
        this.statusVivo = true;
        this.mochila = null;
    }

    protected void prioridadeEAdd() {
        this.prioridade = 2;
        this.cave.adicionarComponente(this);
    }

    public String getNome() {
    	return this.nome;
    }

    public void setName(String nome) {
    	this.nome = nome;
    }

    public boolean estaNaPorta() {
    	if(getLinha() == 0 && getColuna() == 0) {
    		return true;
        }
    	return false;
    }

    public void exibirMapa() {
    	System.out.println(cave);
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

    /*public Ouro getOuro() {
        // O ouro tem o maior valor "de todos os tesouros", então fica no início
        if (mochila != null && mochila instanceof Ouro) {
            return (Ouro)mochila;
        }
        return null;
    }*/

    public int[] checarEspolios(String[] tiposTesouros) throws ClassNotFoundException {
        // Depende da quantidade de tesouros diferentes
        int[] contagemEspolios = new int[tiposTesouros.length];
        Tesouro auxiliar = mochila;
        Class c;
        for (int i = 0; i < tiposTesouros.length; i++) {
            //contagemEspolios[i] = 0;
            c = Class.forName(tiposTesouros[i]);
            while(auxiliar != null && auxiliar.getClass() == c) {
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
        CompMovel comp = cave.getSala(linha, coluna).compMaisImportante();
        if (comp instanceof Tesouro) {
            Tesouro t = (Tesouro)comp;
            if (mochila == null) {
                mochila = t;
            } else {
                Tesouro auxiliar = mochila;
                while (auxiliar.getProximo() != null && (auxiliar.getProximo().getValor() > t.getValor())) {
                    auxiliar = auxiliar.getProximo();
                }
                t.setProximo(auxiliar.getProximo());
                auxiliar.setProximo(t);
            }
            cave.removerComponente(t);
            t.serCapturado();
            System.out.println("Você conseguiu um tesouro!");
            return true;
        } else {
            System.out.println("Você percebe que precisa de um cochilo depois de tentar pegar um tesouro que não estava aí");
            return false;
        }
    }

    public int moverHeroi(String wasd) {
        int saldo = 0;
        if (mover(wasd)) {
            saldo -= 15;
            percepcao();
            CompMovel maiorP = cave.getSala(linha, coluna).compMaisImportante();
            if (maiorP instanceof Monstro) {
                Monstro m = (Monstro)maiorP;
                saldo += m.confrontarHeroi(this);
            } else if (maiorP instanceof Buraco) {
                Buraco b = (Buraco)maiorP;
                saldo += b.capturarHeroi(this);
            }
            if (flechaEquipada()) {
                saldo += disparar();
            }
        } else {
            Random rand = new Random();
            int sorteio = rand.nextInt(5);
            if (sorteio < 4) {
                System.out.println("Você se distrai e não percebe a parede se aproximando...");
            } else {
                System.out.println("Você procura uma passagem secreta na parede, mas não encontra");
            }
        }
        return saldo;
    }   

    public int disparar() {
        flechas.dispararFlecha();
        return -100;
    }

    public boolean confrontarMonstro(Monstro m) {
        if (flechaEquipada()) {
            Random rand = new Random();
            if (rand.nextInt(100) >= m.getForca()) {
                return true;
            }
        }
        return false;
    }

    public int morrer() {
        statusVivo = false;
        return -1000;
    }

    public void anunciar() {
        return ;
    }

    public String toString() {
        return "P";
    }
}