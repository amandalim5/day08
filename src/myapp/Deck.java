package myapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Deck {
  private List<Card> cardDeck = new ArrayList<Card>();

  public List<Card> getCardDeck() {
    return cardDeck;
  }

  public void setCardDeck(List<Card> cardDeck) {
    this.cardDeck = cardDeck;
  } 
  
  
}
