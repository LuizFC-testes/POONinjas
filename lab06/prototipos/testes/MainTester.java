public class MainTester {
    public static void main(String []args) {
        Printable hello = new HelloWorld(1);
        ClassPrinter cp = new ClassPrinter();
        cp.printClass(hello);
    }
}