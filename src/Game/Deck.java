import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    protected static List<Card> deckEssai = new ArrayList<Card>();

    static void shuffleDeck(List<Card> deck){
        Collections.shuffle(deck);
    }
    
    static{
        for (Card.Couleur couleur : Card.Couleur.values())
        {
            for (Card.Valeur valeur : Card.Valeur.values())
            {
                deckEssai.add(new Card(valeur, couleur));
            }
        }
    }

    public static List<Card> newRandomHand(List<Card> deck){
        List<Card> main = new ArrayList<Card>();
        for(int i = 0; i < 5; i++){
            Card temp = (Card) deck.get(i);
            main.add(temp);
        }
        for(int y = 0; y < 5; y++){
            deck.remove(0);
        }
        return main;       
    }

    public static void main(String ...args){
        Deck d = new Deck();
        shuffleDeck(deckEssai);
        System.out.println(d);
        int i = 0;
        for(Card elem: deckEssai)
        {
       	    System.out.println (elem.affichage());
            i += 1;
        }
        System.out.println(i);
        newRandomHand(deckEssai);
        System.out.println("----------------------------");
        i = 0;
        for(Card elem: deckEssai)
        {
       	    System.out.println (elem.affichage());
            i += 1;
        }
        System.out.println(i);
    }

    
}
