
public class ScoreCard {

	private int numEntries =0;
	private GameEntry[] board;
	
	public ScoreCard(int capacity){
		board = new GameEntry[capacity];
	}
	
	public void add(GameEntry e){
		int newScore = e.getScore();
		
		if(numEntries<board.length || board[numEntries-1].getScore()<newScore){
			if(numEntries<board.length)
				numEntries++;
			int j = numEntries-1;
			while(j>0 && board[j-1].getScore()<newScore){
				board[j] =board[j-1];
				j--;
			}
			board[j] =e;
		}
	}
	
	public void remove(GameEntry e){
		int score = e.getScore();
		GameEntry temp;
		int j = numEntries -1;
		int index=0;
		while(j>0){
			if(board[j].getScore()==score){
				board[j]=null; index =j;
				temp = removeByIndex(index);
				break;
			}
			j--;
		}
	}
	
	public GameEntry removeByIndex(int index){
		if(index<0 || index>=numEntries)
			throw new IndexOutOfBoundsException("Invalid index :"+index);
		GameEntry temp = board[index];
		for(int i=index;i<numEntries -1;i++){
			board[i] = board[i+1];
		}
		board[numEntries-1] = null;
		numEntries--;
		return temp;
	}
}
