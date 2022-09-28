package Game;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ClosedPoker {
    public static void main(String ...args){
        Player p1 = new Player("Nicolas");
        Player p2 = new Player("Elio");
        Player p3 = new Player("Flavio");
        
        //give the players some cards
        p1.setHand(Deck.newRandomHand(Deck.getCards()));
        p2.setHand(Deck.newRandomHand(Deck.getCards()));
        p3.setHand(Deck.newRandomHand(Deck.getCards()));
        
        //returns the cards the players want to discard and get new ones    
        System.out.println("La main de p1 :");
        List<Card>  mainp1 = p1.getHand();
        p1.getHandAfficher();
        mainp1 = p1.getCardsToDiscard(mainp1);
        p1.addCard(mainp1);
        System.out.println("La main de p1 après changement :");
        p1.getHandAfficher();
        System.out.println("--------------------------------");

        System.out.println("La main de p2 :");
        List<Card>  mainp2 = p2.getHand();
        p2.getHandAfficher();
        mainp2 = p2.getCardsToDiscard(mainp2);
        p2.addCard(mainp2);
        System.out.println("La main de p2 après changement :");
        p2.getHandAfficher();
        System.out.println("--------------------------------");

        System.out.println("La main de p3 :");
        List<Card>  mainp3 = p3.getHand();
        p3.getHandAfficher();
        mainp3 = p3.getCardsToDiscard(mainp3);
        p3.addCard(mainp3);
        System.out.println("La main de p3 après changement :");
        p3.getHandAfficher();
        System.out.println("--------------------------------");

        //check who wins
        if(p1.beats(p2) && p1.beats(p3)){
            System.out.println("P1 wins with hand");
            p1.getHandAfficher();
        }

        else if(p2.beats(p1) && p2.beats(p3)){
        	System.out.println("P2 wins with hand");
            p2.getHandAfficher();
        }

        else if(p3.beats(p1) && p3.beats(p2)){
        	System.out.println("P3 wins with hand");
            p3.getHandAfficher();
        }
        else{
            System.out.println("there is a draw");
        }
    }
}
