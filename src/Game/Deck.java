package Game;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    private static List<Card> cards = new ArrayList<Card>();
    
    public static List<Card> getCards() {
    	return cards;   	
    }
    private Deck() {
    	
    }
    static
    {
        for (Card.Couleur couleur : Card.Couleur.values())
        {
            for (Card.Valeur valeur : Card.Valeur.values())
            {
                cards.add(new Card(valeur, couleur));
            }
        }
        Collections.shuffle(cards);
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
        cards.add(uneCarte);
        Collections.shuffle(cards);
    }

    public static Card getRandomCards(List<Card> deck){
        Card temp = (Card) deck.get(0);
        deck.remove(0);
        return temp;
    }
}
