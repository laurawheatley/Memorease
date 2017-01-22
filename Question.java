import java.util.Arrays;

public class Question {
	
	private int length;
	private String[] phrase = new String[length];
	private String keyword;
	//private int keywordIndex;
	
	public Question(){
		length = 0;
		nullArray(phrase);
		keyword = null;
	}
	public Question(int length, String[] phrase){
		setLength(length);
		setPhrase(phrase);
		setKeyword(phrase);
	}
	public int getLength(){
		return length;
	}
	public void setLength(int length){
		this.length = length;
	}
	public String[] getPhrase(){
		return phrase;
	}
	public void setPhrase(String[] sentence){
		setLength(sentence.length);
		for (int i=0; i < sentence.length; i++){
			phrase[i] = sentence[i];
		}
		this.phrase = phrase;
	}
	public String getKeyword(){
		//setKeyword(phrase);
		return keyword;
	}
	public void setKeyword(String[] sentence){
		String keyword = null;
		for(int i=0; i < sentence.length; i++){
			String [] unusableWords = {"an", "a", "the", "is", "so", "but", "if", "this", "can", "as", "did", "does"};
			if (Arrays.asList(unusableWords).contains(sentence[i])){
				break;
			} else if (Arrays.asList(unusableWords).contains(sentence[i - 1])){
				keyword = sentence[i];
			}
			if (keyword == null){
				keyword = sentence[(int) (Math.random()*(sentence.length))];
			}
		}
		this.keyword = keyword;
	}
	public void nullArray(String[] a){
		for (int i = 0; i < a.length; i++){
			a[i] = null;
		}
		
	}
}

