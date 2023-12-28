package LLD3.TicTacToeDesign.controller;

import LLD3.TicTacToeDesign.exception.InvalidNumberOfBotsException;
import LLD3.TicTacToeDesign.exception.InvalidNumberOfPlayersException;
import LLD3.TicTacToeDesign.exception.InvalidPlayerSymbolException;
import LLD3.TicTacToeDesign.models.Game;
import LLD3.TicTacToeDesign.models.Bot;
import LLD3.TicTacToeDesign.models.Player;
import LLD3.TicTacToeDesign.models.PlayerType;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.WinningStrategies;

import java.util.List;

public class GameController {

    public Game startGame(int id, List<Player> players, List<WinningStrategies> winningStrategies) throws InvalidNumberOfBotsException, InvalidNumberOfPlayersException, InvalidPlayerSymbolException {
        Game game = Game.getGameBuilder()
                .setSize(3)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .buildGame();

        for (Player player: game.getPlayers())
        {
            if(player.getPlayerType().equals(PlayerType.BOT)){
                Bot botplayer = (Bot) player;
                botplayer.setPlayers(players);
                break;
            }
        }

        return game;
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
