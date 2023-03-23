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
		boolean partidaNueva = true;
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
			
		
		System.out.println("\n");
		boolean salir = false;
		while(!salir) {
			equipo = player.getEquip();
			equipoBot = bot.getEquip();
			
			Collections.sort(equipo);
			Collections.sort(equipoBot);

			System.out.printf("%-15s %s %n", player.getAlias(), bot.getAlias());
			System.out.println("--------------------------------");
			for(int i=0; i<6; ++i) {
				System.out.printf("%-15s %s %n", equipo.get(i).getNom(), equipoBot.get(i).getNom());
			}		
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
				if(partidaNueva) {
					partidaNueva = false;
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
					boolean playeableP;
					boolean playeableB;
					
					while(partida) {
						playeableP = false;
						playeableB = false;
						Pokemon atq = player.getEquip().get(0);
						Pokemon def = bot.getEquip().get(0);
						if(turno) {
							//COMPROVAR QUE EL EQUIPO ATQ TIEN VIDA Y ENERGIA; Y EL EQUIPO DEF TIENE VIDA
							for(int i=0; i < 6; ++i) {
								if(player.getEquip().get(i).getEnergia() > 0 && player.getEquip().get(i).getVidaActual() > 0){
									playeableP = true; 
								}
								if(bot.getEquip().get(i).getVidaActual() > 0) {
									playeableB = true;
								}
							}
							//SI TODO OK:
							if(playeableP && playeableB) {
								//SELECCIONAMOS DOS POKEMONS RAND
								
								boolean vivo = false;
								while(!vivo) {
									atq = player.getEquip().get(rand.nextInt(6));
									if(atq.getEnergia() > 0 && atq.getVidaActual() > 0) {
										vivo = true;
									}
								}
								vivo = false;
								
								while(!vivo) {
									def = bot.getEquip().get(rand.nextInt(6));
									if(def.getVidaActual() > 0) {
										vivo = true;
									}
								}
								System.out.println("JUGADOR "+ player.getAlias() + " ATACA CON " + atq.getNom() + " A "
												  + bot.getAlias() + " QUE DEFIENDE CON " + def.getNom());
								
								//FUNCION ATQ
								while(true) {
									
									if(atq.getVidaActual() == 0 || def.getVidaActual() == 0) {
										break;
									}
									if(atq.getEnergia() == 0) {
										playeableP = false;
										for(int i=0; i < 6; ++i) {
											if(player.getEquip().get(i).getEnergia() > 0 && player.getEquip().get(i).getVidaActual() > 0){
												playeableP = true; 
											}
										}
										if(playeableP) {
											vivo = false;
											while(!vivo) {
												atq = player.getEquip().get(rand.nextInt(6));
												
												if(atq.getEnergia() > 0 && atq.getVidaActual() > 0) {
													vivo = true;
												}
											}
											System.out.println("JUGADOR "+ player.getAlias() + " ATACA CON " + atq.getNom() + " A "
													  + bot.getAlias() + " QUE DEFIENDE CON " + def.getNom());
										}else {
											break;
										}
									}
									System.out.println("ataca " + atq.getNom());
									System.out.println(def.getDefensa(atq, atq.getAtac()));
									if(def.getVidaActual() > 0) {
										System.out.println("ataca " + def.getNom());
										System.out.println(atq.getDefensa(def, def.getAtac()));
									}
									
								}
								turno = false;
							}else {
								//SALIR
								partida = false;
							}
							System.out.println("=================cambio de turno jugador==================");
						// TURNO BOT	
						}else {
							//COMPROVAR QUE EL EQUIPO ATQ TIEN VIDA Y ENERGIA; Y EL EQUIPO DEF TIENE VIDA
							for(int i=0; i < 6; ++i) {
								if(bot.getEquip().get(i).getEnergia() > 0 && bot.getEquip().get(i).getVidaActual() > 0){
									playeableB = true; 
								}
								if(player.getEquip().get(i).getVidaActual() > 0) {
									playeableP = true;
								}
							}
							
							//SI TODO OK:
							if(playeableP && playeableB) {
								//SELECCIONAMOS DOS POKEMONS RAND
								
								boolean vivo = false;
								while(!vivo) {
									atq = bot.getEquip().get(rand.nextInt(6));
									if(atq.getEnergia() > 0 && atq.getVidaActual() > 0) {
										vivo = true;
									}
								}
								vivo = false;
								
								while(!vivo) {
									def = player.getEquip().get(rand.nextInt(6));
									if(def.getVidaActual() > 0) {
										vivo = true;
									}
								}
								System.out.println("JUGADOR "+ bot.getAlias() + " ATACA CON " + atq.getNom() + " A "
										  + player.getAlias() + " QUE DEFIENDE CON " + def.getNom());
								
								//FUNCION ATQ
								while(true) {
									if(atq.getVidaActual() == 0 || def.getVidaActual() == 0) {
										break;
									}
									if(atq.getEnergia() == 0) {
										playeableB = false;
										for(int i=0; i < 6; ++i) {
											if(bot.getEquip().get(i).getEnergia() > 0 && bot.getEquip().get(i).getVidaActual() > 0){
												playeableB = true; 
											}
										}
										if(playeableB) {
											vivo = false;
											while(!vivo) {
												atq = bot.getEquip().get(rand.nextInt(6));
												if(atq.getEnergia() > 0 && atq.getVidaActual() > 0) {
													vivo = true;
												}
											}
											System.out.println("JUGADOR "+ bot.getAlias() + " ATACA CON " + atq.getNom() + " A "
													  + player.getAlias() + " QUE DEFIENDE CON " + def.getNom());
										}else {
											break;
										}
									}
									System.out.println("ataca " + atq.getNom());
									System.out.println(def.getDefensa(atq, atq.getAtac()));
									 if(def.getVidaActual() > 0) {
										 System.out.println("ataca " + def.getNom());
										 System.out.println(atq.getDefensa(def, def.getAtac()));
									 }
									
								}
								turno = true;
							}else {
								//SALIR
								partida = false;
							}
							System.out.println("=================cambio de turno jugador==================");
						}
					}
					int vidaP = 0;
					int vidaB = 0;
					int energiaP = 0;
					int energiaB = 0;
					for(int i=0; i<6; ++i) {
						vidaP += player.getEquip().get(i).getVidaActual();
						energiaP += player.getEquip().get(i).getEnergia();
						vidaB += bot.getEquip().get(i).getVidaActual();
						energiaB += bot.getEquip().get(i).getEnergia();
					}
					System.out.println("FIN LUCHA");
					if(vidaP == vidaB) {
						if(energiaP > energiaB) {
							System.out.println("Ha ganado " + player.getAlias());
						}else {
							System.out.println("Ha ganado " + bot.getAlias());
						}
					}else if(vidaP > vidaB) {
						System.out.println("Ha ganado " + player.getAlias());
					}else {
						System.out.println("Ha ganado " + bot.getAlias());
					}
					
					break;
				}else {
					System.out.println("¡Tienes que resetear los stats!");
				}
			case 2:
				for(int i=0; i<6; ++i) {
					player.getEquip().get(i).resetStats();
					bot.getEquip().get(i).resetStats();
				}
				partidaNueva = true;
				break;
			case 3:
				salir = true;
				System.out.println("Adeu!");
				break;
			}
		}
		
	}
	
	public static void combate(Pokemon atc, Pokemon def) {
		
		
	}
}

