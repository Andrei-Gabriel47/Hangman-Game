import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("Words.txt"));
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> word = new ArrayList<>();
		while(scanner.hasNext()) {
			word.add(scanner.nextLine());
		}
		Random random = new Random();
		String hidden_word = word.get(random.nextInt(word.size()));
		
		char[] hidden_letters = hidden_word.toCharArray();
		char[] answer = new char[hidden_letters.length];
		
		for(int i =0;i<hidden_letters.length;i++) {
			answer[i] = '?';
		}
		boolean finish = false;
		int lives = 6;
		System.out.println("Welcome to hangman!");
		while(finish==false) {
			System.out.println("==========================" +"\n");
			String letter= input.next();
			boolean found = false;
			for(int i=0;i<hidden_letters.length;i++) {
				if(letter.charAt(0)==hidden_letters[i]) {
					answer[i]=hidden_letters[i];
					found = true;
				}
			}
			if(!found) {
				lives--;
			
			System.out.println("Wrong letter");
		}
			boolean done = true;
			for(int i =0;i<answer.length;i++) {
				if(answer[i]=='?') {
					System.out.print("_");
					done = false;
				}
			
			else {
				System.out.print(" "+ answer[i]);
			}
			}
			System.out.println("\n"+"Lives left : "+ lives);
			drawHangman(lives);
			if(done) {
				System.out.println("Congratulations!You have won!");
				finish = true;
			}
			if(lives<=0) {
				System.out.println("You Lost!"+"\n"+ "The word was : " + hidden_word);
				finish=true;
				
			}
		}

	}
	public static void drawHangman(int l) {
		  if(l == 6) {
		   System.out.println("|----------");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 5) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 4) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|    |");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 3) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 2) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else if(l == 1) {
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|   /");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		  else{
		   System.out.println("|----------");
		   System.out.println("|    O");
		   System.out.println("|   -|-");
		   System.out.println("|   /\\");
		   System.out.println("|");
		   System.out.println("|");
		   System.out.println("|");
		  }
		 }

}
