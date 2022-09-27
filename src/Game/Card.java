package Game;

public class Card extends Deck{
    public enum Couleur{ 
        COEUR,
        CARRE,
        TREFLE,
        PIQUE;
    } 
    public enum Valeur{
        AS,
        SEPT,
        HUIT,
        NEUF,
        DIX,
        VALET,
        REINE,
        ROI;
    }
    public final Valeur valeur;
    public final Couleur couleur;

    public Card(Valeur valeur, Couleur couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public Valeur getValeur(){
        return valeur;
    }

    public Couleur getCouleur(){
        return couleur;
    }

    public String affichage(){
        return valeur + " de " + couleur;
    }

}
