package pt_Pokemon;

public abstract class Pokemon{
	private String nom;
	private int energia;
	private int vida;
	private int danyBase;
	private int defensa;
	private int precisio;

	public Pokemon(int danyBase, int defensa, int precisio, int vida) {
		super();
		this.danyBase = danyBase;
		this.defensa = defensa;
		this.precisio = precisio;
		this.energia = 100;
		this.vida = vida;
	}
	
	abstract void resetStats();

	public String toString() {
		return "Nom: " + nom + "\nEnergia: " + energia + "\nVida: " + vida + "\nDany Base: " + danyBase
				+ "\nDefensa: " + defensa + "\nPrecisio: " + precisio;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		boolean correct = false;
		while(!correct){
			if(!nom.equals("")) {
				correct = true;
				this.nom = nom;
			}else {
				System.out.println("The name can't be void.");
			}
		}
	}

	public int getEnergia() {
		return energia;
	}
	
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getVida() {
		return vida;
	}

	public int getDanyBase() {
		return danyBase;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getPrecisio() {
		return precisio;
	}

	
	
}
