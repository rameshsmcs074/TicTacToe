package LLD3.TicTacToeDesign.models;

import LLD3.TicTacToeDesign.exception.InvalidNumberOfBotsException;
import LLD3.TicTacToeDesign.exception.InvalidNumberOfPlayersException;
import LLD3.TicTacToeDesign.exception.InvalidPlayerSymbolException;
import LLD3.TicTacToeDesign.strategies.WinningStrategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private List<Move> moves;
    private int nextPlayerIndex;
    private List<WinningStrategies> winningStrategies;

    private Game(int size, List<Player> players, List<WinningStrategies> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        gameState = GameState.IN_PROGRESS;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }


    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }

    public void printBoard() {
        System.out.println("Printing the current state board");
        board.printBoard();
    }

    public void makeMove() {

        Player player = players.get(nextPlayerIndex);
        System.out.println("Player "+player.getName()+" ,turns to make next move");
        Cell cell = player.makeMove(board);

        Move move = new Move(cell, player);
        moves.add(move);

        //! check for winner
        if (checkWinner(move, player)){
            gameState = GameState.CONCLUDED;
            System.out.println("Congratulations!!!, "+ player.getName() +". Yon won the game.");
            return;
        }

        //! check for draw
        if(checkForDraw(board))
        {
            gameState = GameState.DRAW;
            System.out.println("Game ended in Draw");
            return;
        }


        //! update the next player index
        nextPlayerIndex= (nextPlayerIndex+1)%players.size();
    }

    private boolean checkForDraw(Board board) {
        for (List<Cell> row: board.getCells())
        {
            for (Cell cell: row)
            {
                if(cell.getCellState().equals(CellState.EMPTY))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWinner(Move move, Player player) {
        for (WinningStrategies winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board, move))
            {
                return true;
            }
        }
        return false;
    }

    public static class GameBuilder{

        private int size;
        private List<Player> players;

        private List<WinningStrategies> winningStrategies;

        public GameBuilder(){
            //! nothing to add here
        }

        public Game buildGame() throws InvalidNumberOfBotsException, InvalidPlayerSymbolException, InvalidNumberOfPlayersException
        {
            validateBotCount();
            ValidatePlayerSymbol();
            validatePlayerCount();

            return new Game(size, players, winningStrategies);
        }

        private void validatePlayerCount() throws InvalidNumberOfPlayersException{
            if(players.size()!=(size-1))
            {
                throw new InvalidNumberOfPlayersException("Exactly N-1 players to be played");
            }
        }

        private void ValidatePlayerSymbol() throws InvalidPlayerSymbolException{
            HashSet<Character> setOfSymbols = new HashSet<Character>();
            for (int i=0;i<players.size();i++)
            {
                char symbol = players.get(i).getSymbol();
                if(setOfSymbols.contains(symbol))
                {
                    throw new InvalidPlayerSymbolException("Symbol is already in use by other player");
                }

            }
        }

        private void validateBotCount() throws InvalidNumberOfBotsException{
            int countOfBots=0;
            for (int i=0;i<players.size();i++)
            {
                if(players.get(i).getPlayerType()==PlayerType.BOT)
                    countOfBots++;
                if(countOfBots>1){
                    throw new InvalidNumberOfBotsException("Only one Bot is allowed in a Game");
                }
            }
        }


        public GameBuilder setSize(int size) {
            this.size = size;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public GameBuilder setWinningStrategies(List<WinningStrategies> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
