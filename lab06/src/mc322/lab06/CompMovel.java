package mc322.lab06;

public interface CompMovel {
    public int getLinha();
    public int getColuna();
    public void atualizarCoord(int linha, int coluna);
    public boolean mover(String wasd);
    public int getPrioridade();
    public String toString();
    public void anunciar();
}