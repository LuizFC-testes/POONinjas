public class ClassPrinter {
    public void printClass(Printable klass) {
        //Extrair o nome da classe
        Class classe = klass.getClass();
        String nome = classe.getCanonicalName();
//      Class classe2 = Class.forName(nome);
        System.out.println("Nome da classe: " + nome);
        // Converter interface para class
        HelloWorld hello = (HelloWorld)klass;
        System.out.println(hello);
    }
}