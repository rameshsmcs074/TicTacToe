package LLD3.TicTacToeDesign.strategies.PlayingStrategies;

import LLD3.TicTacToeDesign.exception.InvalidBotDifficultyLevelException;
import LLD3.TicTacToeDesign.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel) throws InvalidBotDifficultyLevelException
    {
        if(BotDifficultyLevel.EASY.equals(difficultyLevel))
        {
            return new EasyBotPlayingStrategy();
        }
        else if(BotDifficultyLevel.MEDIUM.equals(difficultyLevel))
        {
            return  new MediumBotPlayingStrategy();
        }
        else if(BotDifficultyLevel.HARD.equals(difficultyLevel))
        {
            return new HardBotPlayingStrategy();
        }

        throw new InvalidBotDifficultyLevelException("Invalid Bot difficulty level");
    }
}
