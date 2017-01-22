
public class SentenceBuilder {
	
	/* The SentenceBuilder class has attributes paragraph, sentence,
	 * head, and tail. This class searches through a paragraph and retreives an array
	 * representing a sentence.
	 */
	
private String[] paragraph;
private String[] sentence;
private int head;
private int tail;

//default constructor
public SentenceBuilder(){
	nullArray(paragraph);
	nullArray(sentence);
	head = 0;
	tail = 0;
}
//constructor where we DONT KNOW head and tail
public SentenceBuilder(String[] paragraph){
	this.paragraph = paragraph;
	setSentence();
}
//constructor where we KNOW head and tail
public SentenceBuilder(String[] paragraph, int head, int tail){
	this.paragraph = paragraph;
	this.head = head;
	this.tail = tail;
	setSentence();
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
		firstSentenceBuilder(paragraph, head, tail);
	} else if (head != 0){
		laterSentenceBuilder(paragraph, head, tail);
	}
}
public void firstSentenceBuilder(String[] paragraph, int head, int tail){
		String[] sentence = new String[(tail + 1) - head];
		int passerCount=0;
		for (int k = (head); k <= tail; k++){
				sentence[passerCount] = paragraph[k];
				passerCount += 1;
		}
		this.sentence = sentence;
}
public void laterSentenceBuilder(String[] paragraph, int head, int tail){
		String[] sentence = new String[(tail) - head];
		int passerCount=0;
		for (int k = (head+1); k <= tail; k++){
				sentence[passerCount] = paragraph[k];
				passerCount += 1;
		}
		this.sentence = sentence;
}
public void nullArray(String[] a){
	for (int i = 0; i < a.length; i++){
		a[i] = null;
	}
	
}
} //end class

