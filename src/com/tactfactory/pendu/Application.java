package com.tactfactory.pendu;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Application {

	public static void main(String[] args) {
		
		boolean bon = false;
		Scanner scan = new Scanner(System.in);
		int life = 5;
		
		// User input.
		String line;
		
		// List of random words.
		List<String> list = Arrays.asList("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix");
		Random rand = new Random();
		
		// Mistery word.
		String word = list.get(rand.nextInt(list.size()));
		
		// Declare and Init state.
		char[] state = new char[word.length()];
		for (int i=0; i < word.length(); i++) {
			state[i] = '_' ;
		}
		
		// Menu messages.
		final String MENU_START = "Saisis un mot, il te reste " + life + " vies.";
		final String WIN = "C'est gagné, c'est gagné !";
		final String LOSE = "Perdu, tu n'as plus de vies, le mot mystère était : " + word
							+ "\nPour rejouer, appuies sur CTRL + F11 !";
		
		// Start message.
		System.out.println(MENU_START);
		System.out.println(word);
		
		do {
			// Test if first try.
			 if (life <5) {
				 System.out.println("Try again, il ne te reste plus que " + life + " vie" + (life == 1 ? "" : "s") + "." );
			 }
			 
			 // Trim out useless spaces and wait until correct try.
			while("".equals(line = scan.nextLine().trim()));
			
			// Accept one letter of word.
			if(line.length() == 1) {
				char letter = line.charAt(0);
				if(word.contains(Character.toString(letter))) {
					for(byte i=0; i<word.length(); i++) {
						if(i == word.indexOf(Character.toString(letter)) )
						state[i] = letter;
					}
				}
				System.out.println("Voilà un indice : " + String.valueOf(state));
			}
			
			// Test if word is right.
			if(line.equals(word)) {
				bon = true;
				System.out.println(WIN);
			}	else {	
					life -=1;
					if(life == 0) {
						System.out.println(LOSE);
					} 
				}
		}
		while(bon == false && life > 0);
	}

}
