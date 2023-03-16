package pt_Pokemon;

public class Foc extends Pokemon{
	private int vidaActual;
	
	public Foc(String nom, int vida) {
		super(20, 15, 72, vida);
		this.vidaActual = vida;
	}
	
	public void resetStats() {
		// TODO Auto-generated method stub
		vidaActual = getVida();
		this.setEnergia(100);
	}
}
