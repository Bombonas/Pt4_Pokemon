package pt_Pokemon;

import java.util.ArrayList;

public class Usuari {
	private String alias;
	private ArrayList<Pokemon> equip;
	
	public Usuari(String alias, ArrayList<Pokemon> equip){
		this.alias = alias;
		this.equip = equip;
	}

	public String getAlias() {
		return alias;
	}

	public ArrayList<Pokemon> getEquip() {
		return equip;
	}
	
	
}
