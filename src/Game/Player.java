import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private String nom;
    private List<Card> hand = new ArrayList<Card>();

    //constructeur classe player
    public Player(String unNom){ 
        this.nom = unNom; 
    }

    public void setHand(List<Card> main){
        this.hand = main;
        for(Card elem: main)
        {
       	    System.out.println (elem.affichage());
        }
        System.out.println("-----------------");
    }

    public void setNom(String nom){
        this.nom = nom;
    }
}
