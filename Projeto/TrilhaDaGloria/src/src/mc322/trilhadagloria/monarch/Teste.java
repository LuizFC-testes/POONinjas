package mc322.trilhadagloria.monarch;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		ArrayList<String> ss = new ArrayList<String>();
		
		ss.add("Uno");
		ss.add("Dos");
		ss.add("Tres");
		ss.add("Quatro");
		ss.add("Cinco");
		
		System.out.println(ss);
		ss.remove(0);
		System.out.println(ss);
		ss.remove(0);
		System.out.println(ss);
		ss.remove(0);
		System.out.println(ss);
		ss.remove(0);
		System.out.println(ss + " " + ss.size());
		ss.remove(0);
		System.out.println(ss + " " + ss.size());
	}

}
