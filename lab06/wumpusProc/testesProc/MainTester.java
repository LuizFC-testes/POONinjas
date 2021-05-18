public class MainTester {
    public static void main(String []args) throws ClassNotFoundException {
        Mostrador arte = new Arte("Mona Lisa", "DaVinci", null, "Romantismo");
        String classe = arte.getClass().getSimpleName();
        System.out.println(classe);
    }
}