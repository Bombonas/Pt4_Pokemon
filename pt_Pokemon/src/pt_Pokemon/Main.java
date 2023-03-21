package pt_Pokemon;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

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
		ArrayList<String> noms = new ArrayList<String>(Arrays.asList("Charmander", "Pikachu", "Bulvasur", 
				"Piplup", "Axiew", "Hydreigon", "Charizard", "Bidoff", "Machop", "Geodude"));
		
		for(int i=0; i<6; ++i) {
			int opt = rand.nextInt(1, 4);
			switch(opt) {
			case 1:
				equipoBot.add(new Foc(noms.get(rand.nextInt(10)), rand.nextInt(250, 401)));
				break;
			case 2:
				equipoBot.add(new Aigua(noms.get(rand.nextInt(10)), rand.nextInt(250, 401)));
				break;
			case 3:
				equipoBot.add(new Electric(noms.get(rand.nextInt(10)), rand.nextInt(250, 401)));
				break;
			}
		}
		Usuari bot = new Usuari("bot", equipoBot);
		
		equipo = player.getEquip();
		equipoBot = bot.getEquip();
		
		Collections.sort(equipo);
		Collections.sort(equipoBot);

		System.out.printf("%-15s %s %n", player.getAlias(), bot.getAlias());
		System.out.println("--------------------------------");
		for(int i=0; i<6; ++i) {
			System.out.printf("%-15s %s %n", equipo.get(i).getNom(), equipoBot.get(i).getNom());
		}		
		
		System.out.println("\n");
		boolean salir = false;
		while(!salir) {
			int opt = 0;
			boolean correct = false;
			while(!correct) {
				System.out.println("1.Lluita\n2.Tornar a jugar\n3.Sortir");
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
			switch(opt) {
			case 1:
				int vP = 0;
				int vB = 0;
				for(int i=0; i<6; ++i) {
					vP += player.getEquip().get(i).getVida();
					vB += bot.getEquip().get(i).getVida();
				}
				boolean turno;
				if(vP > vB) {
					turno = false;
				}else {
					turno = true;
				}
				
				boolean partida = true;
				while(partida) {
				
					boolean playeable = false;
					Pokemon pPlayer;
					while(playeable) {
						pPlayer = player.getEquip().get(rand.nextInt(6));
						if(pPlayer.getVidaActual() > 0 & pPlayer.getEnergia() > 0) {
							playeable = true;
						}
					}
					Pokemon pBot;
					playeable = false;
					while(playeable) {
						pBot = player.getEquip().get(rand.nextInt(6));
						if(pBot.getVidaActual() > 0 & pBot.getEnergia() > 0) {
							playeable = true;
						}
					}
					
					if(turno) {
					
						
						
						turno = false;
					}else {
						
						
						turno = true;
					}
				}
				break;
			case 2:
				for(int i=0; i<6; ++i) {
					player.getEquip().get(i).resetStats();
					bot.getEquip().get(i).resetStats();
				}
				break;
			case 3:
				salir = true;
				System.out.println("Adeu!");
				break;
			}
		}
		
	}
}

