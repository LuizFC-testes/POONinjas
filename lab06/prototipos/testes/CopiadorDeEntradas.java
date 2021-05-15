import java.util.Scanner;

public class CopiadorDeEntradas {
    CopiadorDeEntradas() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Cópia: " + keyboard.nextLine());
    }
}