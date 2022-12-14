package myapp;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main{
  public static void main(String[] args) {
    //Create a deck of cards (each card is an)
    String[] suits = {"Diamond", "Spade", "Club", "Heart"};
    String[] value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    Deck deck = new Deck();
    for(String s: suits){
      for(String v: value){
        Card card = new Card();
        card.setSuit(s);
        card.setValue(v);
        deck.getCardDeck().add(card);
        // System.out.printf("created %s, %s\n", s, v);
      }
    }

    // Get the size of the deck
    int num = deck.getCardDeck().size();
    System.out.println("The size of the deck is " + num);

    // get the first card
    String fcs = deck.getCardDeck().get(0).getSuit();
    String fcv = deck.getCardDeck().get(0).getValue();
    System.out.printf("The first card is %s%s\n", fcs, fcv);

    // shuffle the card
    Collections.shuffle(deck.getCardDeck());


    // get the first card again
    fcs = deck.getCardDeck().get(0).getSuit();
    fcv = deck.getCardDeck().get(0).getValue();
    System.out.printf("The first card is %s%s\n", fcs, fcv);    

    // get a random card
    Random rnd = new SecureRandom();
    int number = rnd.nextInt(num);
    System.out.println(number);
    System.out.printf("Pick a card, any card!\n%s %s\n", deck.getCardDeck().get(number).getSuit(), deck.getCardDeck().get(number).getValue());

    // read all the cards
    int count = 1;
    for(Card card: deck.getCardDeck()){
      System.out.println(count + ". " + card.getSuit() + " " + card.getValue());
      count++;
    }

    // shuffle cards
    List<Card> shuffled = new ArrayList<>();
    for(int i=0; i<deck.getCardDeck().size(); i++){
      int index = rnd.nextInt(deck.getCardDeck().size());
      System.out.println("index : " + index);
      shuffled.add(deck.getCardDeck().get(index));
      // System.out.println(index + "shuffled added " + deck.getCardDeck().get(index));
      deck.getCardDeck().remove(index);
      // System.out.println("deck removed "+ deck.getCardDeck().get(index));
    }

    int counter = 1;
    for(Card card: shuffled){
      System.out.println(counter + ". " + card.getSuit() + " " + card.getValue());
      counter++;
    }

    Deck secondDeck = new Deck();
    for(int i=0; i<shuffled.size(); i++){
      secondDeck.getCardDeck().add(shuffled.get(i));
    }
    System.out.println("shuffled: " + shuffled.size());

    int counttwo = 1;
    for(Card card: secondDeck.getCardDeck()){
      System.out.println(counttwo + ". " + card.getSuit() + " " + card.getValue());
      counttwo++;
    }

    System.out.println("=========original deck==========");
    int countthree = 1;
    for(Card card: deck.getCardDeck()){
      System.out.println(countthree + ". " + card.getSuit() + " " + card.getValue());
      countthree++;
    }
  }
}