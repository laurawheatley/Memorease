
public class SentenceBuilder {
	
	/* The SentenceBuilder class has attributes length (for length of the sentence), 
	 * phrase (a String array which holds every word of the sentence), and 
	 * keyword, which determines which word to remove from the sentence when quizzing.
	 */
	
private String[] paragraph;
private String[] sentence;
private int head;
private int tail;

public SentenceBuilder(){
	nullArray(paragraph);
	nullArray(sentence);
	head = 0;
	tail = 0;
}
public SentenceBuilder(String[] paragraph){
	this.paragraph = paragraph;
	setSentence(paragraph);
	set
}
	
public int getHead() {
	return head;
}
public void setHead(int head) {
	this.head = head;
}
public int getTail() {
	return tail;
}
public void setTail(int tail) {
	this.tail = tail;
}
public String[] getParagraph() {
	return paragraph;
}
public void setParagraph(String[] paragraph) {
	this.paragraph = paragraph;
}
public String[] getSentence() {
	return sentence;
}
public void setSentence() {
	if (head == 0){
		this.sentence = firstSentenceBuilder(paragraph, head, tail);
	} else if (head != 0){
		this.sentence = laterSentenceBuilder(paragraph, head, tail);
	}
}
public String[] firstSentenceBuilder(String[] paragraph, int head, int tail){
		String[] sentence = new String[(tail + 1) - head];
		int passerCount=0;
		for (int k = (head); k <= tail; k++){
				sentence[passerCount] = paragraph[k];
				passerCount += 1;
		}
		return sentence;
}
public String[] laterSentenceBuilder(String[] paragraph, int head, int tail){
		String[] sentence = new String[(tail) - head];
		int passerCount=0;
		for (int k = (head+1); k <= tail; k++){
				sentence[passerCount] = paragraph[k];
				passerCount += 1;
		}
		return sentence;
}
public void nullArray(String[] a){
	for (int i = 0; i < a.length; i++){
		a[i] = null;
	}
	
}
} //end class

