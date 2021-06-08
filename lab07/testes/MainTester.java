package testes;

public class MainTester {

    public static String DIRETORIO = MainTester.class.getResource(".").getPath();

    public static void main(String[] args) {
        JanButImg janela = new JanButImg();
        janela.adicionarBotao("PlagueIncCura.png");
        janela.adicionarBotao("SJWarriors.gif");
        janela.setVisible(true);
    }
}