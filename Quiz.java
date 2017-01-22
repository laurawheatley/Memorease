import java.util.Scanner;

public class Quiz {
	
	public static void main(String[] args){
		
		Scanner keyboard = new Scanner(System.in);
		
		int paragraphLength = 14;
		
		String[] paragraph = {"Our", "honourable", "friend.", "He", "was", "a", "roach.", "He", "was", "a", "roach.", "He", "was", "a", "roach."};
		//String[] paragraph = new String[paragraphLength];
		
		int sentenceCount = 0;
		
		for (int i=0; i < paragraph.length; i++){
			
			if(charCheck(paragraph[i])){
					sentenceCount += 1;
			}
		}//end for
		
		int phraseLength = 0;
		Question[] game = new Question[sentenceCount];
		
		//initialize objects
		int head = 0;
		int counter = 0;
		
		
		String[] passerArray = new String[phraseLength];
		
		//for loop that cycles through the paragraph
		for (int j = 0; j < paragraphLength; j++){
			
			//checks paragraph again
			if(charCheck(paragraph[j])){
				int tail = j;
					
					phraseLength = (tail - head);
					//game[counter].setLength(phraseLength); //this is buggy is counter ok?
					int passerCount = 0;
					
					for (int k = (head); k < tail; k++){
					//	String[] passerArray = new String[phraseLength];
						
						passerArray = new String[phraseLength];
						
						passerArray[passerCount] = paragraph[k];
						passerCount += 1;

					}
					game[counter] = new Question(passerArray.length, passerArray);
					counter += 1;
			}
			
			head = j;
		}//end for
		boolean anotherQuestion = false;
		int questionCount = 0;
		do{
			String keyword = game[questionCount].getKeyword();
			printArray(game[questionCount], keyword);
			System.out.println("Enter the missing word:");
			String answer = keyboard.next();
			if(answer.equals(keyword)){
				System.out.println("Congratulations! That's the correct answer! Would you like to play again?");
				String reply = keyboard.next();
				if(reply.equalsIgnoreCase("yes")){
					anotherQuestion = true;
				} else {
					anotherQuestion = false;
				}
			}
			else{
				System.out.println("The correct answer was: " + keyword + ". Would you like to play again?");
				String reply = keyboard.next();
				if(reply.equalsIgnoreCase("yes")){
					anotherQuestion = true;
				} else {
					anotherQuestion = false;
				}
					
			}
			questionCount += 1;
			
		}while(anotherQuestion == true);
	}
	//method that prints out a sentence array and blanks out the keyword
	public static void printArray(Question a, String keyword){
		
		String[] b = a.getPhrase().clone(); //.clone();
		for(int i=0; i < b.length; i++){
			if (b[i].equals(keyword)){
				System.out.print("_____" + " ");
			} else {
				System.out.print(b[i] + " ");
			}
		}
	}
	//method that determines whether a string contains a "."
	public static boolean charCheck(String a){
		boolean finalWord = false;
			if (a.charAt(a.length()-1) == '.'){
				finalWord = true;
			}
		return finalWord;
	}
}

