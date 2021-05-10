public class Heroi extends Componente {
    
    private String nome;
    private Flecha flecha;
    private Ouro bolso;

    public Heroi(int linha, int coluna, Caverna cave, String nome) {
        super(linha, coluna, cave);
        this.flecha = new Flecha();
        this.nome = nome;
        this.bolso = null;
    }

    public Flecha getFlecha() {
        return this.flecha;
    }

    public boolean flechaEquipada() {
        if (this.flecha != null) {
            return this.flecha.statusEquipada();
        }
        return false; 
    }
}