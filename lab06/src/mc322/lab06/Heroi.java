package mc322.lab06;

import java.lang.Class;
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
        this.prioridade = 2;
    }
    
    public String getNome() {
    	return this.nome;
    }
    
    public void setName(String nome) {
    	this.nome = nome;
    }
    
    public boolean estaNaPorta() {
    	if(getLinha() == 0 && getColuna() == 0)
    		return true;
    	
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
        if (comp.getClass().getSuperclass() == Tesouro) {
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

    public int moverHeroi(String wasd) {
        int saldo = 0;
        
        if (mover(wasd)) {
            saldo -= 15; //Checar se depende de o mov ser válido ou não
            
            percepcao();
            
            Componente maiorP = cave.getSala(linha, coluna).compMaisImportante();
            
            if (maiorP != null) {
                saldo += maiorP.confrontarHeroi(this);
            }
            
            if (flechaEquipada()) { //Checar se depende de o mov ser válido ou não
                saldo += disparar();
            }
        } else {
            Random rand = new Random();
            int sorteio = rand.nextInt(5);
            if (sorteio < 3) {
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

    public String toString() {
        return "P";
    }

	protected void anunciar() {
		
	}
}