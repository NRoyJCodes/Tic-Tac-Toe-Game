import java.util.*                                  ;
class Main{
    public static void main(String[] args){
        char[][]board = new char [3][3];

        //initially the board is empty: i.e; the row and column is empty
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){

                //initialize the board as empty:-
                board[row][col] = ' ';
            }
        }
        //Player initially starts with X:
        char player = 'X';
        boolean gameOver = false;

        //take player input:
        Scanner sc = new Scanner(System.in);

        while(!gameOver){ //this loop has all the moves of the player
            
            //firstly print the board:
            printBoard(board);
            //print the input:
            System.out.println("Player " + player + " enter: "); 

            int row = sc.nextInt();
            int col = sc.nextInt();

            //Input will initiall occur when the board is empty:
            if(board[row][col]==' '){

                //place the element:
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if(gameOver){ //if player wins:-
                    System.out.println("Player " + player + " has won: ");
                }else{ //if player not won, player switches and next player makes the move:
                    player = (player == 'X') ? 'O' : 'X';

                }
            }else{
                System.out.println("Inavlid Move! Try Again");
            }
        }
        printBoard(board);
    }
    public static boolean haveWon(char[][]board, char player){
        //to decide which player has won:
        //check row, col and diagona
        
        //Checking Rows:
        for(int row = 0; row < board.length; row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //check column:
        for(int col = 0; col < board[0].length; col++){ 
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //check diagonal:
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
