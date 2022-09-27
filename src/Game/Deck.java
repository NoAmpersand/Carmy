package Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    protected static List<Card> deckEssai = new ArrayList<Card>();

    static
    {
        for (Card.Couleur couleur : Card.Couleur.values())
        {
            for (Card.Valeur valeur : Card.Valeur.values())
            {
                deckEssai.add(new Card(valeur, couleur));
            }
        }
        Collections.shuffle(deckEssai);
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

    public static void addDeck(Card uneCarte){
        deckEssai.add(uneCarte);
        Collections.shuffle(deckEssai);
    }

    public static Card getRandomCards(List<Card> deck){
        Card temp = (Card) deck.get(0);
        deck.remove(0);
        return temp;
    }
