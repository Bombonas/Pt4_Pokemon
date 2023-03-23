package pt_Pokemon;
import java.util.Random;
public class Electric extends Pokemon implements Atacable, Defensable{
	
	public Electric(String nom, int vida) {
		super(25, 15, 63, vida);
		this.setNom(nom);
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
					dmg += 4;
					break;
			}
			this.setEnergia(this.getEnergia()-this.getDanyBase());
			return dmg;
		}else {
			this.setEnergia(0);
			//System.out.println("The pokemon have no energy");
			return 0;
		}
	}

	public String toString() {
		return "Electric\n" + super.toString();
	}
	
	public String getDefensa(Pokemon enemic, int atacEnemic) {
        Random rand = new Random();
        int probAtac = rand.nextInt(100);
        String resultat = "";
        if (enemic.getEnergia() == 0) {
            resultat = "El pokemon enemic no te energia";
        }else {
	        if (probAtac > enemic.getPrecisio()) {
	            resultat =  enemic.getNom() + " ha fallat l'atac";
	        }else {
	            if (enemic instanceof Aigua) {
	                setVidaActual(getVidaActual() - (atacEnemic - this.getDefensa()*2));
	                resultat = "L'atac es poc efectiu. La vida s'ha reduit en " +(atacEnemic - this.getDefensa()*2)+" punts"
	                        + "del Pokemon "+this.getNom();
	            }else if (enemic instanceof Foc) {
	                setVidaActual(getVidaActual() - (3*atacEnemic - this.getDefensa()*2));
	                resultat = "Atac critic. La vida s'ha reduit en "+(3*atacEnemic - this.getDefensa()*2)+ " punts "
	                        + "del Pokemon "+this.getNom();
	            }else if (enemic instanceof Electric) {
	                setVidaActual(getVidaActual() - (atacEnemic - this.getDefensa()));
	                resultat = "La vida s'ha reduit en "+(atacEnemic - this.getDefensa())+" punts "
	                        + "del Pokemon "+this.getNom();
	            }
		        if (getVidaActual() <= 0) {
		            this.setVidaActual(0);
		            resultat = resultat + "\nEl Pokemon "+this.getNom()+" s'ha debilitat";
		        }
	        }
        }
        return resultat;
    }
}
