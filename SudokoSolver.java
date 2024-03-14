import javax.swing.border.SoftBevelBorder;

public class SudokoSolver {
    public static boolean issafe(int sudoku[][],int row,int col,int digit){
        //row
        for(int i=0;i<=8;i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //col
        for(int j=0;j<=8;j++){
            if(sudoku[row][j] == digit )
            {
                return false;
            }
        }
        //3*3
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int x=sr;x<sr+3;x++){
            for(int y=sc;y<sc+3;y++){
                if(sudoku[row][col]==digit){
                    return false;
                }
            }
        }
        return true;


    }
    public static boolean Solver(int sudoku[][],int row,int col){
        //base case
        if(row==9 && col==0){
            return true;  
        }
        int nextrow=row,nextcol=col+1;
        if(col+1==9){
            nextrow= row+1;
            nextcol=0;
        }

        if(sudoku[row][col]!=0){
            return Solver(sudoku, nextrow, nextcol);
        }
    
    //kaam
    for(int digit=1;digit<=9;digit++){
        if(issafe(sudoku,row,col,digit)){
            sudoku[row][col]=digit;
            if(Solver(sudoku, nextrow, nextcol)){
                return true;
            }
            sudoku[row][col]=0;
        }
        
    }
    return false;

}
public static void print(int sudoku[][]){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(sudoku[i][j]+" ");
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        int sudoku[][]={{0,0,8,0,0,0,0,0,0},
    {4,9,0,1,5,7,0,0,2},
    {0,0,3,0,0,4,1,9,0},
    {1,8,5,0,6,0,0,2,0},
    {0,0,0,0,2,0,0,6,0},
    {9,6,0,4,0,5,3,0,0},
    {0,3,0,0,7,2,0,0,4},
    {0,4,9,0,3,0,0,5,7},
    {8,2,7,0,0,9,0,1,3},};
    if(Solver(sudoku, 0, 0)){
        System.out.println("Solution exits");
        print(sudoku);
    }
    else
    System.out.println("no solution exist");
}
}

