import java.util.Scanner;

public class Quiz {
	
	
	private int sentenceCount; //number of sentences in the paragraph
	private int paragraphLength; //number of words in the paragraph
	private String[] paragraph; //body of text placed String-by-String in an array
	private Question[] game = new Question[sentenceCount];  //Array of Question objects
	
	public Quiz(){
		sentenceCount = 0;
		paragraphLength = 0;
		paragraph = new String[paragraphLength];
		game = new Question[sentenceCount];
	}
	
	public Quiz(String[] paragraph){
		
	}
		
		Scanner keyboard = new Scanner(System.in);
		
		paragraphLength = 14;
		paragraph = {"Our", "honourable", "friend.", "He", "was", "a", "roach.", "He", "was", "a", "roach.", "He", "was", "a", "roach."};
		
		//String[] paragraph = new String[paragraphLength];
		
		sentenceCount = 0;
		
		for (int i=0; i < paragraph.length; i++){
			
			if(charCheck(paragraph[i])){
					sentenceCount += 1;
			}
		}//end for
		
		int phraseLength = 0;
		//Question[] game = new Question[sentenceCount];
		
		//initialize objects
		int head = 0;
		int counter = 0;
		
		String[] passerArray = new String[phraseLength];
		
		//for loop that cycles through the paragraph
		for (int j = 0; j < paragraphLength; j++){
			
			//checks paragraph again
			if(charCheck(paragraph[j])){
				int tail = j;
				if (head == 0){
					String[] sentence = firstSentenceBuilder(paragraph, head, tail);
					game[counter] = new Question(sentence.length, sentence);
					counter += 1;
					
				} else if (head != 0){
					String[] sentence = laterSentenceBuilder(paragraph, head, tail);
					game[counter] = new Question(sentence.length, sentence);
					counter += 1;
				}
				head = tail;
			}
		}//end for
		
		boolean anotherQuestion = false;
		int sentencesLeft = paragraphLength;
		int questionCount = 0;
		do{
			String keyword = game[questionCount].getKeyword();
			printArray(game[questionCount], keyword);
			sentencesLeft -= 1;
			System.out.println("Enter the missing word:");
			String answer = keyboard.next();
			if(answer.equalsIgnoreCase(keyword)){
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
			
		}while(anotherQuestion == true && sentencesLeft != 0);
	
	
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


