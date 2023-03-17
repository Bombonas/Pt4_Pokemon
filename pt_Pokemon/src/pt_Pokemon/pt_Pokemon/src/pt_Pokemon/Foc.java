package pt_Pokemon;
import java.util.Random;
public class Foc extends Pokemon implements Atacable{
	private int vidaActual;
	
	public Foc(String nom, int vida) {
		super(20, 15, 72, vida);
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
			int atkType = rand.nextInt(2);
			switch(atkType) {
				case 0:
					dmg += 12;
					break;
				case 1:
					dmg += 7;
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
		return "Foc\n" + super.toString();
	}
	
}
