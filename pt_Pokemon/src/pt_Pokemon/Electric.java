package pt_Pokemon;

public class Electric extends Pokemon{
	private int vidaActual;
	
	public Electric(String nom, int vida) {
		super(25, 15, 63, vida);
		this.vidaActual = vida;
	}
	
	public void resetStats() {
		// TODO Auto-generated method stub
		vidaActual = getVida();
		this.setEnergia(100);
	}
}
