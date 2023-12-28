package LLD3.TicTacToeDesign.models;

import java.util.Scanner;

public class Player {

    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    private Scanner input;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        input = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Cell makeMove(Board board) {

        int x = -1;
        int y = -1;
        do{
            System.out.println("Input the Cell co-ordinates to make the move");
             x= input.nextInt();
             y = input.nextInt();
        }while(!validateTheCoordinates(x, y, board));

        Cell cell = board.getCells().get(x).get(y);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }

    private boolean validateTheCoordinates(int x, int y, Board board) {
        if(x<0 || x>=board.getSize() || y<0 || y>=board.getSize())
        {
            return false;
        }
        if(!CellState.EMPTY.equals(board.getCells().get(x).get(y).getCellState()))
        {
            return false;
        }
        return true;
    }
}
