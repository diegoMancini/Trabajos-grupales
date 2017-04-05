package TrabajoPractico_Sudoku;


/**
 * Created by Tomas on 30/3/2017.
 */
public class Sudoku {
    private static int[][] sudoku = new int[9][9];

    public Sudoku(){
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                sudoku[i][j] = 0;
            }
        }
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] +" / " );
            }
            System.out.println();
        }
    }
    public void setValueAtPosition(int numberToAdd, int posRow, int posCol){
        sudoku[posRow][posCol] = numberToAdd;
   }

    public boolean solver(int posRow, int posColumn, int[][] sudoku) {
        if (posRow == 9) {
            posRow = 0;
            if (++posColumn == 9)
                return true;
        }
        if (sudoku[posRow][posColumn] != 0)
            return solver(posRow+1, posColumn, sudoku);

        for (int val = 1; val <= 9; ++val) {
            if (checkForAvailability(val, posRow,posColumn)) {
                sudoku[posRow][posColumn] = val;
                if (solver(posRow+1, posColumn, sudoku))
                    return true;
            }
        }
        sudoku[posRow][posColumn] = 0;
        return false;
    }

    public boolean boardIsValid(Sudoku sudoku){
        boolean b = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku.getSudoku()[i][j] != 0)
                    b = checkForAvailability(sudoku.getSudoku()[i][j], i, j);
            }
        }
        return b;
    }

    private boolean checkForAvailability(int numberToCheck, int posRow, int posColumn){
        return (checkForAvailabilityInColumn(numberToCheck, posColumn) && checkForAvailabilityInRow(numberToCheck, posRow) && checkForAvailabilityInBox(numberToCheck, posRow, posColumn));
    }

    private boolean checkForAvailabilityInColumn(int numberToCheck, int column){
        for (int row = 0; row < 9; row++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    private boolean checkForAvailabilityInRow(int numberToCheck, int row){
        for (int column = 0; column < 9; column++){
            if (sudoku[row][column] == numberToCheck)
                return false;
        }
        return true;
    }
    private boolean checkForAvailabilityInBox(int numberToCheck, int row, int column) {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (sudoku[i][j] == numberToCheck)
                    return false;
            }
        }
        return true;
    }
}
