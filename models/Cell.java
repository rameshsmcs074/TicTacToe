package LLD3.TicTacToeDesign.models;

public class Cell {

    private int row;
    private int column;
    private CellState cellState;

    public Player getPlayer() {
        return player;
    }

    private Player player;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        cellState = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }


    public int getColumn() {
        return column;
    }


    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void display() {
        if(CellState.FILLED.equals(cellState)){
            System.out.print("|"+player.getSymbol()+"|");
        }

        if(CellState.EMPTY.equals(cellState)){
            System.out.print("|-|");
        }
    }
}
