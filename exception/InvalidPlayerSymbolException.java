package LLD3.TicTacToeDesign.exception;

public class InvalidPlayerSymbolException extends Exception {
    private String message;
    public InvalidPlayerSymbolException(String s) {
        this.message = s;
    }
}
