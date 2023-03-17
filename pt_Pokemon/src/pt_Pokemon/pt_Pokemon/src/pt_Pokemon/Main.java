package pt_Pokemon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce your nickname: ");
		String name = sc.next();
		Random rand = new Random();
		
		ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();
		
		for(int i = 0; i < 6; ++i) {
			int opt = 0;
			boolean correct = false;
			while(!correct) {
				System.out.println("Choose the Pokemon type\n1.Fire\n2.Water\n3.Electric");
				System.out.println("Option: ");
				if(sc.hasNextInt()) {
					opt = sc.nextInt();
					if (opt < 4 && opt > 0) {
						correct = true;
					}else {
						System.out.println("Please introduce a valid number");
					}
				}else {
					System.out.println("Please only introduce numbers");
					sc.nextLine();
				}
			}
			System.out.println("Choose the Pokemon name");
			String pokName = sc.next();
			switch(opt) {
			case 1:
				equipo.add(new Foc(pokName, rand.nextInt(250, 401)));
				break;
			case 2:
				equipo.add(new Aigua(pokName, rand.nextInt(250, 401)));
				break;
			case 3:
				equipo.add(new Electric(pokName, rand.nextInt(250, 401)));
				break;
			}
		}
		Usuari player = new Usuari(name, equipo);
		
		
		ArrayList<Pokemon> equipoBot = new ArrayList<Pokemon>();
		ArrayList<String> noms = new ArrayList<String>(Arrays.asList("Charmander", "Pikachu", "Vulvasur", 
				"Piplup", "Axiew", "Hydreigon", "Charizard", "Bidoff", "Machop", "Geodude"));
		
		for(int i=0; i<6; ++i) {
			int opt = rand.nextInt(1, 4);
			switch(opt) {
			case 1:
				equipoBot.add(new Foc(noms.get(rand.nextInt(11)), rand.nextInt(250, 401)));
				break;
			case 2:
				equipoBot.add(new Aigua(noms.get(rand.nextInt(11)), rand.nextInt(250, 401)));
				break;
			case 3:
				equipoBot.add(new Electric(noms.get(rand.nextInt(11)), rand.nextInt(250, 401)));
				break;
			}
		}
		Usuari bot = new Usuari("bot", equipoBot);
		
		for(Pokemon p: player.getEquip()) {
			System.out.println(p.toString());
			System.out.println("==========================");
		}
		System.out.println("***************************************");
		System.out.println("***************************************");
		for(Pokemon p: bot.getEquip()) {
			System.out.println(p.toString());
			System.out.println("==========================");
		}
	}

}
