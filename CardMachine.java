/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac CardMachine.java
 *  Execution:    java CardMachine n
 *
 *  Simulates a card machine from an example math problem.
 *
 *  A card machine takes in a deck of n cards as input, where n is some positive integer, and each card has 
 *  a unique integer printed on it between 1 and n (inclusive). The machine is able to perform an operation
 *  on any two cards in the deck. The operation is defined as follows: remove any two cards from the deck
 *  and take the product and the sum of the two integers on the cards and add those results together 
 *  to form a new card with the product printed on top, then place this new card in the deck. 
 *  Each time the operation is performed the total number of cards left in the deck
 *  is reduced by one, and the machine repeates the operation until there is only one card left.
 *  The goal of this problem is to find out the number of ways in which we can operate on n cards,
 *  to find what the final card will be, and to prove that we will always get the same final card 
 *  no matter what order in which we operate on the n cards. Studying this problem in class, 
 *  we found that the number of ways in which we can operate on n cards is equal to the combination
 *  (n)C(2) and the final card will be (n+1)!-1.
 *
 ************************************************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;

public class CardMachine
{
	// n is the number of cards in the deck
	// cards is an ArrayList representing the deck of cards
	private int n;
	private ArrayList<Integer> cards;

	// define a CardMachine data type where we input n
	// and then create a deck of n cards for the machine, where 
	// the deck contains every integer from 1 to n (inclusive)
	// and each integer in the deck represents a card
	public CardMachine(int n)
	{
		this.n = n;
		cards = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			cards.add(i+1);
	}

	// overwrite toString() so the can print out the deck of cards in the machine
	public String toString()
	{
		Integer[] cardsArray = new Integer[cards.size()];
		cardsArray = cards.toArray(cardsArray);
		return Arrays.toString(cardsArray);
	}

	// define the operation to be performed on any two cards in the deck
	private void operation(Integer a, Integer b)
	{
		cards.remove(a);
		cards.remove(b);
		int result = a*b + a + b;
		cards.add(result);
	}

	// selecct two cards in the deck at random
	// this method calls randomInt() from Random.java
	private void randomSelection()
	{
		if (cards.size() > 1)
		{
			int k = Random.randomInt(0,cards.size()-1);
			int l = Random.randomInt(0,cards.size()-1);
			if (k == l) randomSelection();
			else
			{
				operation(cards.get(k),cards.get(l));
			}
		}
	}

	// compute the final card after operating on n cards
	public int finalCard()
	{
		return factorial(n+1)-1;
	}

	// compute the number of ways in which we can operate on n cards
	public int possibleCombinations()
	{
		if (n < 2) return 0;
		else return (factorial(n)/(factorial(n-2)*2));
	}

	// implement the factorial function
	private static int factorial(int m)
	{
		if (m == 0) return 1;
		else if (m == 1) return 1;
		else return m*factorial(m-1);
	}

	// operate on all n cards in random order
	public void runRandom()
	{
		for (int i = 0; i < n; i++)
		{
			randomSelection();
		}
	}

	public static void main(String[] args)
	{
		CardMachine cm = new CardMachine(Integer.parseInt(args[0]));
		System.out.println("Card deck is " + cm);
		System.out.println("Final card will be " + cm.finalCard());
		System.out.println("Number of combinations of operations on deck = " + cm.possibleCombinations());
		cm.runRandom();
		System.out.println("Final card = " + cm);
	}
}