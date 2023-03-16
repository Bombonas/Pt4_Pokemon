package pt_Pokemon;

public class Aigua extends Pokemon{
	private int vidaActual;
	
	public Aigua(String nom, int vida) {
		super(15, 10, 80, vida);
		this.vidaActual = vida;
	}
	
	public void resetStats() {
		// TODO Auto-generated method stub
		vidaActual = getVida();
		this.setEnergia(100);
	}
}
