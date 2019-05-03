/* Jasmin Agustin
 * CECS 274 - 05
 * Project 2 - LinkedList
 * 10/4/2016
 */

import java.util.Random;
import java.util.Scanner;
public class LinkedList{

	public static void main(String[] args){
		
		int nWords = 0;
		char Choice = 0;
		String deleteWord;
		Scanner keyboard = new Scanner(System.in);
		while (nWords < 15 || nWords > 240){
			System.out.println("How many words do you want? (15-240)");
			nWords = keyboard.nextInt();
			if(nWords < 15 || nWords > 240)
				System.out.println("Error. Please choose a number between the range of 15 - 240");
		}
		LinkList myList = new LinkList();
		for (int i = 1; i <= nWords; i++ ){
			myList.inOrder(wordGenerator());
		}
		myList.display();
		while (Choice != 'Q'){
			Choice = Menu();
			switch(Choice){
				case 'A':
				case 'a':
					myList.inOrder(wordGenerator());
					myList.addDisplay();
					break;
				case 'D':
				case 'd':
					System.out.println("Which word do you want to delete?");
					deleteWord = keyboard.next();
					myList.delete(deleteWord);
					myList.display();
					break;
				case 'Q':
				case 'q':
					System.out.println("You have chosen to quit the code.");
					break;
				default:
					System.out.println("Error. Invalid input please try again.");
					break;
			}
		}

	}//end of main
	
	public static char Menu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("\nMenu:\n"
			+ "(A)dd\n"
			+ "(D)elete\n"
			+ "(Q)uit\n");
		char UserInput = keyboard.next().charAt(0);
		return UserInput;
	}
	
	public static String wordGenerator(){
		String word = "";
		boolean finish = false;
		while(!finish){
			Random rand = new Random();
			word += (char)(rand.nextInt(26)+97);
			finish = (word.length() == 5);
		}
		return word;
	}
	
}//end of class
