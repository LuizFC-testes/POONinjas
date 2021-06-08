package testes;

public class MainTester {

    public static String DIRETORIO = MainTester.class.getResource(".").getPath();

    public static void main(String[] args) {
        JanImg j = new JanImg(DIRETORIO + "PlagueIncCura.png");
        JanImg k = new JanImg(DIRETORIO + "SJWarriors.gif");
    }
}