package Game; 

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player {
    
    private String nom;
    private List<Card> hand = new ArrayList<Card>();

    //constructeur classe player
    public Player(String unNom){ 
        this.nom = unNom; 
    }

    public void setHand(List<Card> main){
        this.hand = main;
    }

    public List getHand(){
        return hand;
    }
    
    public void getHandAfficher(){
        for(Card elem: hand)
        {
       	    System.out.println (elem.affichage());
        }
    }


    public List getCardsToDiscard(List<Card> main){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de carte voulez vous enlevez : ");
        int nbDiscards = scanner.nextInt();
        List<Integer> numDiscard = new ArrayList<Integer>();

        for(int i = 0; i < nbDiscards; i++){
            System.out.println("Numero de la carte que vous voulez enlevez; elle sont noté de 1 à 5");
            int numeroCards = scanner.nextInt();
            numDiscard.add((int)numeroCards);
        }

        for(int i = 0; i < numDiscard.size(); i++){
            int temp = numDiscard.get(i);
            numDiscard.set(i,temp - 1);
        }

        Collections.sort(numDiscard, Collections.reverseOrder());
        for(int i : numDiscard){
            Card tempAjoutDeck = main.get(i);
            Deck.addDeck(tempAjoutDeck);
            main.remove(i);
        }
        
        return main;
    }

    public List addCard(List<Card> main){
        int taille = main.size();
        int nbAjout = 5 - taille;
        for(int i = 0; i < nbAjout; i++){
            main.add(Deck.getRandomCards(Deck.deckEssai));
        }
        return main;
    }
    
    private static Map<Card.Valeur, Integer> checkHand(List<Card> hand) {
    	Map<Card.Valeur, Integer> handMap = new HashMap<>();
        for(Card card : hand ){
            if(handMap.containsKey(card.valeur)){
                int newOcc = handMap.get(card.valeur)+1;
                handMap.put(card.valeur, newOcc);
            } else {
                handMap.put(card.valeur, 1);
            }
        }
        return handMap;
    }
    
    private int score() {
    	Map<Card.Valeur, Integer> playerScore = checkHand(this.getHand());
		int paireExist = 0;
		int brelanExist = 0;
		int carreExist = 0;
    	for(Map.Entry<Card.Valeur, Integer> valeurCarte : playerScore.entrySet()) {
    		if(valeurCarte.getValue() == 2){
                paireExist++;
            }
            else if(valeurCarte.getValue() == 3){
                brelanExist++;
            }
            else if(valeurCarte.getValue() == 4){
                carreExist++;
            }
        }
    	int totalScore = paireExist + 3*brelanExist + 5*carreExist;
    	
    	return totalScore;
    }
    public boolean beats(Player p) {
    	if(this.score() > p.score()) {
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
