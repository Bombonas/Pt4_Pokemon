package pt_Pokemon;
import java.util.Random;
public class Aigua extends Pokemon implements Atacable, Comparable{
	private int vidaActual;
	
	public Aigua(String nom, int vida) {
		super(15, 10, 80, vida);
		this.vidaActual = vida;
		this.setNom(nom);
	}
	
	public void resetStats() {
		// TODO Auto-generated method stub
		vidaActual = getVida();
		this.setEnergia(100);
	}
	
	public int getAtac() {
		// TODO Auto-generated method stub
		if(this.getEnergia() >= this.getDanyBase()) {
			Random rand = new Random();
			int dmg = this.getDanyBase() + rand.nextInt(30, 91);
			int atkType = rand.nextInt(3);
			switch(atkType) {
				case 0:
					dmg += 7;
					break;
				case 1:
					dmg += 13;
					break;
				case 2:
					dmg += 5;
					break;
			}
			this.setEnergia(this.getEnergia()-this.getDanyBase());
			return dmg;
		}else {
			this.setEnergia(0);
			System.out.println("The pokemon have no energy");
			return 0;
		}
	}
	
	public String toString() {
		return "Aigua\n" + super.toString();
	}
	
	
	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return this.getEnergia() - o.getEnergia();
	}
}
