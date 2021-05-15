public class HelloWorld implements Printable{
    int numero;

    HelloWorld (int numero) {
        this.numero = numero;
    }

    public void say() {
        System.out.println("Hello World!");
    }

    public HelloWorld eu() {
        return this;
    }

    public String toString() {
        return "" + numero;
    }
}