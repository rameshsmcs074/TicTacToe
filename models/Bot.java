package LLD3.TicTacToeDesign.models;

import LLD3.TicTacToeDesign.exception.InvalidBotDifficultyLevelException;
import LLD3.TicTacToeDesign.strategies.PlayingStrategies.BotPlayingStrategy;
import LLD3.TicTacToeDesign.strategies.PlayingStrategies.BotPlayingStrategyFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;

    private List<Player> players;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id,String name, char symbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) throws InvalidBotDifficultyLevelException {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
        //! get the bot playing strategy based on the difficult level
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    public Cell makeMove(Board board) {
        Cell cell=  botPlayingStrategy.makeMove(board, players);
        System.out.println("Bot played: Row "+cell.getRow()+" Col "+cell.getColumn());
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
