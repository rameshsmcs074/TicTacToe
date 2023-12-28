package LLD3.TicTacToeDesign.ApplicationRunner;

import LLD3.TicTacToeDesign.controller.GameController;
import LLD3.TicTacToeDesign.exception.InvalidBotDifficultyLevelException;
import LLD3.TicTacToeDesign.exception.InvalidNumberOfBotsException;
import LLD3.TicTacToeDesign.exception.InvalidNumberOfPlayersException;
import LLD3.TicTacToeDesign.exception.InvalidPlayerSymbolException;
import LLD3.TicTacToeDesign.models.*;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.ColumnWinningStrategies;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.DiagonalWinningStrategies;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.RowWinningStrategies;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppRunner {

    public static void main(String[] args) throws InvalidNumberOfBotsException, InvalidNumberOfPlayersException, InvalidPlayerSymbolException, InvalidBotDifficultyLevelException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Board Dimension");
        int boardDimension = input.nextInt();

        Player player1 = new Player(1, "Ramesh",'X', PlayerType.HUMAN);
        Player player2 = new Bot(2, "GPT",'O', PlayerType.BOT, BotDifficultyLevel.MEDIUM);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        WinningStrategies rowWinningStrategy = new RowWinningStrategies();
        WinningStrategies colWinningStrategy = new ColumnWinningStrategies();
        WinningStrategies diagWinningStrategy = new DiagonalWinningStrategies();

        List<WinningStrategies> winningStrategies = new ArrayList<>();
        winningStrategies.add(rowWinningStrategy);
        winningStrategies.add(colWinningStrategy);
        winningStrategies.add(diagWinningStrategy);

        GameController gameController = new GameController();
        Game game = gameController.startGame(boardDimension, players, winningStrategies);

        while(GameState.IN_PROGRESS.equals(game.getGameState())){

            /*
            * 1. Print the board
            * 2. Ask whther the any user would like to undo
            * 3. Ask the player to make a move*/

            game.printBoard();

            System.out.println("Do you want to undo the previous move(s)?");
            String undoing= input.nextLine();
            if(undoing.equals("Y"))
            {
                //! undo the last move
                continue;
            }

            gameController.makeMove(game);
        }

        System.out.println("Board after the final results");
        game.printBoard();
    }

}
