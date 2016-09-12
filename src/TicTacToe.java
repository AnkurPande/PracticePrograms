
public class TicTacToe {
	private static final int O=-1;
	private static final int X=1;
	private static final int EMPTY =0;
	private int player;
	private int[][] board = new int[3][3];
		
	private void clearBoard(){
		for(int i=0;i<3;i++){
			for(int j =0;j<3;j++){
				board[i][j] = EMPTY;
			}
		}
		player = X;
	}
	public TicTacToe(){ clearBoard();}
	
	private void putMark(int i, int j) throws IllegalArgumentException{
		if(i<0||i>2||j<0||j>2)
			throw new IllegalArgumentException("Illegal Place Selected.");
		if(board[i][j]!=EMPTY)
			throw new IllegalArgumentException("Board Position Selected Is Already Occupied.");
		board[i][j] = player;
		player = -player;
	}
	
	private boolean isWin(int player){
		return ((board[0][0]+board[0][1]+board[0][2]) == player*3 || // Row 1
				(board[1][0]+board[1][1]+board[1][2]) == player*3 || // Row 2
				(board[2][0]+board[2][1]+board[2][2]) == player*3 || // Row 3
				(board[0][0]+board[1][0]+board[2][0]) == player*3 || // Column 1
				(board[0][1]+board[1][1]+board[2][1]) == player*3 || // Column 2
				(board[0][2]+board[1][2]+board[2][2]) == player*3 || // Column 3		
				(board[0][0]+board[1][1]+board[2][2]) == player*3 || // Diagonal 
				(board[2][0]+board[1][1]+board[0][2]) == player*3);  // Reverse Diagonal
	}
	
	private int isWinner(){
		if(isWin(X))
			return X;
		else if(isWin(O))
			return O;
		else return 0;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<3;i++){
			for(int j =0;j<3;j++){
				if(board[i][j]==X)			sb.append("X");
				else if(board[i][j]==O) 	sb.append("O");
				else if(board[i][j]==EMPTY)	sb.append(" ");
				
				if(j<2)	sb.append("|");
			}
			if(i<2)	sb.append("\n-----\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe( );
		 /* X moves: */ /* O moves: */
		 game.putMark(1,1); game.putMark(0,2);
		 game.putMark(2,2); game.putMark(0,0);
		 game.putMark(0,1); game.putMark(2,1);
		 game.putMark(1,2); //game.putMark(1,0);
		 game.putMark(2,0);
		 System.out.println(game);
	}

}
