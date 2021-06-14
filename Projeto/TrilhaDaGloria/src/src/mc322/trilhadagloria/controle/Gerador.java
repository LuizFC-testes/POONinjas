package mc322.trilhadagloria.controle;

import java.util.Random;

import mc322.trilhadagloria.battlefield.Caverna;
import mc322.trilhadagloria.battlefield.Deserto;
import mc322.trilhadagloria.battlefield.Floresta;
import mc322.trilhadagloria.battlefield.Montanha;
import mc322.trilhadagloria.battlefield.Oceano;
import mc322.trilhadagloria.battlefield.Planicie;
import mc322.trilhadagloria.battlefield.Terreno;
import mc322.trilhadagloria.battlefield.Tundra;
import mc322.trilhadagloria.battlefield.Vulcanico;
import mc322.trilhadagloria.monarch.Armadilha;
import mc322.trilhadagloria.monarch.Barbaro;
import mc322.trilhadagloria.monarch.Bardo;
import mc322.trilhadagloria.monarch.Carta;
import mc322.trilhadagloria.monarch.Clerigo;
import mc322.trilhadagloria.monarch.Druida;
import mc322.trilhadagloria.monarch.Guerreiro;
import mc322.trilhadagloria.monarch.Ladino;
import mc322.trilhadagloria.monarch.Magia;
import mc322.trilhadagloria.monarch.Mago;
import mc322.trilhadagloria.monarch.Monge;
import mc322.trilhadagloria.monarch.Paladino;
import mc322.trilhadagloria.monarch.Ranger;
import mc322.trilhadagloria.monarch.Sorcerer;
import mc322.trilhadagloria.monarch.Warlock;

public class Gerador {
	public static Carta gerarHeroi() {
		Random rnd = new Random();
		
		switch(rnd.nextInt(12)) {
		case 0:
			return new Barbaro();
		case 1:
			return new Bardo();
		case 2:
			return new Clerigo();
		case 3:
			return new Druida();
		case 4:
			return new Guerreiro();
		case 5:
			return new Ladino();
		case 6:
			return new Mago();
		case 7:
			return new Monge();
		case 8:
			return new Paladino();
		case 9:
			return new Ranger();
		case 10:
			return new Sorcerer();
		case 11:
			return new Warlock();
		default:
			return new Barbaro();
		}
	}
	
	public static Carta gerarMagia() {
		return new Magia();
	}
	
	public static Carta gerarArmadilha() {
		return new Armadilha();
	}
	
	public static Terreno gerarTerreno() {
		Random rnd = new Random();
		int p = rnd.nextInt(100);
		
		if(p < 13)
			return new Deserto();
		else if(p >= 13 && p < 25)
			return new Floresta();
		else if(p >= 25 && p < 37)
			return new Tundra();
		else if(p >= 37 && p < 50)
			return new Oceano();
		else if(p >= 50 && p < 63)
			return new Vulcanico();
		else if(p >= 63 && p < 76)
			return new Montanha();
		else if(p >= 76 && p < 86)
			return new Planicie();
		else
			return new Caverna();
	}
	
}
