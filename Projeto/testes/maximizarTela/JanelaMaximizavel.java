import javax.swing.*;
import java.awt.Container;

public class JanelaMaximizavel extends JFrame {

    //Deu ruim

    private static final long serialVersionUID = -2292999201904896674L;
    private static String DIRETORIO = JanelaMaximizavel.class.getResource(".").getPath();
    private Container painel;
    private JLabel mensagem;
    private JLabel imagem;

    public JanelaMaximizavel(String nomeDaImg, String mensagem) {
        configJanela();
        criarMensagem(mensagem);
        criarImagem(nomeDaImg);
    }

    private void configJanela() {
        painel = getContentPane();
        painel.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void criarMensagem(String mensagem) {
        this.mensagem = new JLabel(mensagem);
        this.mensagem.setSize(200, 50);
        this.mensagem.setLocation(50, 230);
        painel.add(this.mensagem);
    }

    private void criarImagem(String nomeImagem) {
        ImageIcon img = new ImageIcon(DIRETORIO + nomeImagem);
        imagem = new JLabel(img);
        imagem.setSize(200, 200);
        imagem.setLocation(50, 10);
        //imagem.setOpaque(false);
        painel.add(imagem);
    }
}

