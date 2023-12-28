package LLD3.TicTacToeDesign.exception;

public class InvalidNumberOfPlayersException extends Exception{
    private String message;
    public InvalidNumberOfPlayersException(String s) {
        this.message = s;
    }
}
