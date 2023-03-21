package pt_Pokemon;
import java.util.Random;
public class Foc extends Pokemon implements Atacable, Defensable{
	
	public Foc(String nom, int vida) {
		super(20, 15, 72, vida);
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
	
   public String getDefensa(Pokemon enemic, int atacEnemic) {
        Random rand = new Random();
        int probAtac = rand.nextInt(100);
        String resultat = "";
        if (probAtac > enemic.getPrecisio()) {
            resultat =  enemic.getNom() + " ha fallat l'atac";
        }else {
            if (enemic instanceof Foc) {
                setVidaActual(atacEnemic - this.getDefensa()*2);
                resultat = "L'atac es poc efectiu. La vida s'ha reduit en " +(atacEnemic - this.getDefensa()*2)+" punts"
                        + "del Pokemon "+this.getNom();
            }else if (enemic instanceof Aigua) {
                setVidaActual(3*atacEnemic - this.getDefensa()*2);
                resultat = "Atac critic. La vida s'ha reduit en "+(3*atacEnemic - this.getDefensa()*2)+ " punts "
                        + "del Pokemon "+this.getNom();
            }else if (enemic instanceof Electric) {
                setVidaActual(atacEnemic - this.getDefensa());
                resultat = "La vida s'ha reduit en "+(atacEnemic - this.getDefensa())+" punts "
                        + "del Pokemon "+this.getNom();
            }
        if (getVidaActual() <= 0) {
            this.setVidaActual(0);
            resultat = "El Pokemon "+this.getNom()+" s'ha debilitat";
        }else if (enemic.getEnergia() == 0) {
            resultat = "El pokemon enemic no te energia";
            }
        }
        return resultat;
    }
}
