public class ClassPrinter {
    public void printClass(Printable klass) throws ClassNotFoundException {
        //Extrair o nome da classe
        Class classe = klass.getClass();
        String nome = classe.getCanonicalName();
        Class classe2 = Class.forName(nome);
        System.out.println("Nome da classe: " + nome);
        // Converter interface para class
        if (classe == classe2) {
            System.out.println("Iguais");
        }
        HelloWorld hello = (HelloWorld)klass;
        System.out.println(hello);
    }
}