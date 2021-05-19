package mc322.lab06;

import java.lang.Class;
import java.util.Random;

/**
 * @author João Victor Matoso
 * @author Luiz Felipe Cezar
 */
public class Heroi extends Componente {
    /** Nome do jogador */
    private String nome;
    /** Status de vida do jogador */
    private boolean statusVivo;
    /** Aljava que contém as flechas do heroi */
    private Aljava flechas;
    /** Mochila para guardar tesouros */
    private Tesouro mochila;

    /** Construtor */
    public Heroi(int linha, int coluna, Caverna cave) {
        super(linha, coluna, cave);
        this.flechas = new Aljava(1);    // Inicialmente com uma flecha
        this.statusVivo = true;
        this.mochila = null;
    }

    /**
     * Atualiza atributo prioridade com a prioridade da classe e adiciona componente na caverna
     */
    protected void prioridadeEAdd() {
        this.prioridade = 2;
        this.cave.adicionarComponente(this);
    }

    /**
     * Retorna nome do heroi
     */
    public String getNome() {
    	return this.nome;
    }

    /**
     * Define nome do jogador
     */
    public void setName(String nome) {
    	this.nome = nome;
    }

    /**
     * Verifica se  o herói está na porta de entrada/saída da caverna
     */
    public boolean estaNaPorta() {
    	if(getLinha() == 0 && getColuna() == 0) {
    		return true;
        }
    	return false;
    }

    /**
     * Exibe o mapa da caverna no console
     */
    public void exibirMapa() {
    	System.out.println(cave);
    }

    /**
     * Equipa uma flecha da aljava no arco do heroi
     * @return true se ação realizada, false senão
     */
    public boolean equiparFlecha() {
        return flechas.equiparFlecha();
    }

    /**
     * Verifica se existe alguma flecha atualmente equipada
     * @return true se flecha equipada, false senão
     */
    public boolean flechaEquipada() {
        return flechas.checarFlechaEquip();
    }

    /**
     * Retorna o número de flechas na aljava
     */
    public int contarFlechas() {
        return flechas.contarFlechas();
    }

    /**
     * Retorna se heroi está vivo ou morto
     * @return true se vivo, false se morto
     */
    public boolean getStatusVivo() {
        return statusVivo;
    }

    /**
     * Realiza a contagem do montante dos tesouros que o heroi possui atualmente.
     * @param Recebe um vetor com os nomes das classes dos tipos de tesouro que deseja verificar
     * @return Retorna vetor com os valores dos tesouros na mesma ordem que foi dado como parametro
     */
    public int[] checarEspolios(String[] tiposTesouros) throws ClassNotFoundException {
        // Depende da quantidade de tesouros diferentes
        int[] contagemEspolios = new int[tiposTesouros.length];
        Tesouro auxiliar = mochila;
        Class c;
        for (int i = 0; i < tiposTesouros.length; i++) {
            c = Class.forName(tiposTesouros[i]);
            while(auxiliar != null && auxiliar.getClass() == c) {
                contagemEspolios[i]++;
                auxiliar = auxiliar.getProximo();
            }
            i++;
        }
        return contagemEspolios;
    }

    /**
     * Retorna a soma de todos os tesouros que o heroi possui atualmente na mochila
     */
    public int contarFortuna() {
        int fortuna = 0;
        Tesouro auxiliar = mochila;
        while(auxiliar != null) {
            fortuna += auxiliar.getValor();
            auxiliar = auxiliar.getProximo();
        }
        return fortuna;
    }

    /**
     * Ação do personagem de verificar o que tem na sala
     */
    public void percepcao() {
        cave.getSala(linha, coluna).exporSala();
    }

    /**
     * Verifica e captura tesouro e o guarda na mochila
     * @return true se foi possível capturar tesouro, false senão
     */
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

    /**
     * Ação de mover o personagem pela caverna
     * @return score final após movimento
     */
    public int moverHeroi(String wasd) {
        int saldo = 0;
        // Move personagem se possível
        if (mover(wasd)) {
            saldo -= 15;    // penalidade de movimento
            
            // Expõe os componentes da sala
            percepcao();
            
            CompMovel maiorP = cave.getSala(linha, coluna).compMaisImportante();
            
            // Caso tenha um monstro
            if (maiorP instanceof Monstro) {
                Monstro m = (Monstro)maiorP;
                saldo += m.confrontarHeroi(this);
            }
            // Caso tenha um buraco
            else if (maiorP instanceof Buraco) {
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

    /** Dispara a flecha equipada
     * @return score após disparar flecha
     */
    public int disparar() {
        flechas.dispararFlecha();
        return -100;
    }

    /**
     * Luta contra um monstro passado por parametro
     * Se o heroi não tem flecha equipada, perde na hora
     * @param monstro a ser confrontado
     * @return true se ganhou do monstro, false se perdeu
     */
    public boolean confrontarMonstro(Monstro m) {
        if (flechaEquipada()) {
            Random rand = new Random();
            if (rand.nextInt(100) >= m.getForca()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mata o heroi
     * @return score após morrer
     */
    public int morrer() {
        statusVivo = false;
        return -1000;
    }

    /**
     * Ação de anunciar a presença do componente no console
     */
    public void anunciar() {
        return ;
    }

    /**
     * Caractere usado na representação no tabuleiro
     */
    public String toString() {
        return "P";
    }
}