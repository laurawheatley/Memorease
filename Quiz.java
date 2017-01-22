import java.util.Scanner;

public class Quiz {
	
	/* The Quiz class organizes the game and draws from Question and SentenceBuilder
	 * in order to put together a conversational-style guessing game based on the user's
	 * text.
	 */
	
	private int sentenceCount; //number of sentences in the paragraph
	private int paragraphLength; //number of words in the paragraph
	private String[] paragraph; //body of text placed String-by-String in an array
	private Question[] game = new Question[sentenceCount];  //Array of Question objects
	
	public Quiz(){
		sentenceCount = 0;
		paragraph = new String[paragraphLength];
		paragraphLength = 0;
		game = new Question[sentenceCount];
	}
	
	public Quiz(String[] paragraph){
		sentenceCount = 0;
		paragraphLength = paragraph.length;
		//cycles through paragraph, determines number of words
		for (int i=0; i < paragraph.length; i++){	
			if(charCheck(paragraph[i])){
				sentenceCount += 1;
			}
		}//end for
		game = new Question[sentenceCount];
		int phraseLength = 0;
		String[] passerArray = new String[phraseLength];
		
		Scanner keyboard = new Scanner(System.in);
		
		
		//initialize objects
				int head = 0;
				int counter = 0;
		
		//cycles through paragraph, picks out end of sentences
		for (int j = 0; j < paragraphLength; j++){
					
					//checks paragraph again
					if(charCheck(paragraph[j])){
						int tail = j;
						SentenceBuilder theSentence = new SentenceBuilder(paragraph, head, tail);
						String[] sentence = theSentence.getSentence();
						game[counter] = new Question(sentence.length, sentence);
						counter += 1;
						head = tail;
					}
		}//end for
		
		gamify(game, paragraphLength);
		
	} //end public Quiz (String[] paragraph)
		
	public int getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(int sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

	public int getParagraphLength() {
		return paragraphLength;
	}

	public void setParagraphLength(int paragraphLength) {
		this.paragraphLength = paragraphLength;
	}

	public String[] getParagraph() {
		return paragraph;
	}

	public void setParagraph(String[] paragraph) {
		nullArrayString(paragraph);
	}

	public Question[] getGame() {
		return game;
	}

	public void setGame(Question[] game) {
		nullArrayQuestion(game);
	}

	public void gamify(Question[] game, int paragraphLength){
		
		Scanner keyboard = new Scanner(System.in);
		
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
		
	} //end public Quiz (String[] paragraph)
	
	
	//method that prints out a sentence array and blanks out the keyword
	public void printArray(Question a, String keyword){
		
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
	public boolean charCheck(String a){
		boolean finalWord = false;
			if (a.charAt(a.length()-1) == '.'){
				finalWord = true;
			}
		return finalWord;
	}
	public void nullArrayQuestion(Question[] a){
		for (int i = 0; i < a.length; i++){
			a[i] = null;
		}
	}
	public void nullArrayString(String[] a){
		for (int i = 0; i < a.length; i++){
			a[i] = null;
		}
	}
}



