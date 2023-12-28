package LLD3.TicTacToeDesign.exception;

public class InvalidBotDifficultyLevelException extends Exception {
    String message;
    public InvalidBotDifficultyLevelException(String invalidBotDifficultyLevel) {
        message = invalidBotDifficultyLevel;
    }
}
