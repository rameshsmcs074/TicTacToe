package LLD3.TicTacToeDesign.exception;

public class InvalidNumberOfBotsException extends Exception {
    private String message;

    public InvalidNumberOfBotsException(String message) {
        this.message = message;
    }
}
