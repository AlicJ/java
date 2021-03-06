package sort;

public class Word implements Comparable<Word>{
	private String word;
	private int score;
	
	public Word(String w, int s)
	{
		this.word = w;
		this.score = s;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int s)
	{
		this.score = s;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String w)
	{
		this.word = w;
	}
	
	@Override
	public int compareTo(Word w)
	{
		// if the ranking of this is higher, return 1
		if (this.score > w.score)
			return 1;
		// if the ranking of w is higher, return -1
		else if (this.score < w.score)
			return -1;
		// with the same ranking, return 0
		return 0;
	}
	
	public String toString()
	{
		return "{" + this.word + "," + this.score + "}";
	}

}
