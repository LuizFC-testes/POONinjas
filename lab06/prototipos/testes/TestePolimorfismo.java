public class TestePolimorfismo {
    Subclasse sub;
    Superclasse sup;

    TestePolimorfismo() {
        sub = new Subclasse(true);
        sup = new Subclasse(false);
    }

    public void imprimir() {
        System.out.println(sub.getPrioridade());
        System.out.println(sup.getPrioridade());
    }
}