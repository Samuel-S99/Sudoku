import java.util.*;
public class arrayworkShokodko
{
    int gameboard[][]=new int[9][9];// the array
     int checked[][]=new int[3][3];
    int puzzle[][]=new int[9][9];// the array its displaying to start level
    int entered[][]=new int[9][9];// array where number are being inputed
   private  int xPos,yPos;//x and y position of broken box

 private    int row;// row of array
 private    int col;// column of array
 private    int smallbox;// the box 1-9 containg numbers 1-9 used to check conlfict

private    String whatsbroken;// tells me what is broken row column or box
 private    int firstboxwith5=0;// vairble to determine wich small box should have 5 numbers displayed


    int colbroken;//location of broken column
   int rowbroken;//location of broken row
    public static void main(String args[]){
        arrayworkShokodko array=new arrayworkShokodko(5);

      
       
    }
    public int[][] getboard(){
        return puzzle;// gets the board to delete
    }

    public int[][] getsolvedboard(){// get the completly solved board

        return gameboard;
    }

    public arrayworkShokodko(int nbrToshowPerbox){// generates the array to display
        fillarray();
        int lx=0;
        int ly=0;
        if(nbrToshowPerbox==5){// if the level == easy
            for(int box=1;box<=9;box++){
                lx=computelx(box);
                ly=computely(box);
                int ctr=0;
                while(ctr<nbrToshowPerbox){
                    int row=(int)(Math.random()*(3)+ly);
                    int col=(int)(Math.random()*(3)+lx);
                    if(puzzle[row][col]==0){
                        puzzle[row][col]=gameboard[row][col];
                        entered[row][col]=puzzle[row][col];// puts the numbers to srat in he array were user will be inputting 
                        ctr++;
                    }
                }

            }
        }
        else if(nbrToshowPerbox==4){// level is meduim
            for(int box=1;box<=9;box++){
                lx=computelx(box);
                ly=computely(box);

                int ctr=0;
                if(box==4 ||box==5 || box==6){
                    while(ctr<5){
                        int row=(int)(Math.random()*(3)+ly);
                        int col=(int)(Math.random()*(3)+lx);
                        if(puzzle[row][col]==0){
                            puzzle[row][col]=gameboard[row][col];
                            entered[row][col]=puzzle[row][col];
                            ctr++;
                        }
                    }
                }
                else if(box==1 ||box==2||box==3){
                    int whichofthreehas5=(int)(Math.random()*(3)+1);
                    if(box==whichofthreehas5){
                        while(ctr<5){
                            int row=(int)(Math.random()*(3)+ly);
                            int col=(int)(Math.random()*(3)+lx);
                            if(puzzle[row][col]==0){
                                puzzle[row][col]=gameboard[row][col];
                                entered[row][col]=puzzle[row][col];
                                ctr++;
                            }
                        }
                    }
                    else{

                        while(ctr<nbrToshowPerbox){
                            int row=(int)(Math.random()*(3)+ly);
                            int col=(int)(Math.random()*(3)+lx);
                            if(puzzle[row][col]==0){
                                puzzle[row][col]=gameboard[row][col];
                                entered[row][col]=puzzle[row][col];
                                ctr++;
                            }

                        }
                    }

                }
                else{
                    int whichofthreehas5=(int)(Math.random()*(3)+7);
                    if(box==whichofthreehas5){
                        while(ctr<5){
                            int row=(int)(Math.random()*(3)+ly);
                            int col=(int)(Math.random()*(3)+lx);
                            if(puzzle[row][col]==0){
                                puzzle[row][col]=gameboard[row][col];
                                entered[row][col]=puzzle[row][col];
                                ctr++;
                            }
                        }
                    }
                    else{

                        while(ctr<nbrToshowPerbox){
                            int row=(int)(Math.random()*(3)+ly);
                            int col=(int)(Math.random()*(3)+lx);
                            if(puzzle[row][col]==0){
                                puzzle[row][col]=gameboard[row][col];
                                entered[row][col]=puzzle[row][col];
                                ctr++;
                            }

                        }
                    }

                }
            }
        }
        else{// level is hard

            for(int box=1;box<=9;box++){
                lx=computelx(box);
                ly=computely(box);
                int ctr=0;
                if(box==4 ||box==5 || box==6){
                    while(ctr<5){
                        int row=(int)(Math.random()*(3)+ly);
                        int col=(int)(Math.random()*(3)+lx);
                        if(puzzle[row][col]==0){
                            puzzle[row][col]=gameboard[row][col];
                            entered[row][col]=puzzle[row][col];
                            ctr++;
                        }
                    }
                }
                else{
                    while(ctr<4){
                        int row=(int)(Math.random()*(3)+ly);
                        int col=(int)(Math.random()*(3)+lx);
                        if(puzzle[row][col]==0){
                            puzzle[row][col]=gameboard[row][col];
                            entered[row][col]=puzzle[row][col];
                            ctr++;
                        }
                    }

                }
            }

        }

    }

    public boolean CheckForConflict(int inputrow,int inputcol,int inputednumber){// checks to see if user is inputting in a vaild place
       if( inputednumber==0){
            return false;
        }
        int lx=0;
        int ly=0;
        computebox(inputrow,inputcol);
        whatsbroken="nothing";
        colbroken=0;
        rowbroken=0;
        if(inputednumber==10){// if delete button pressed
            deletefunction(inputrow,inputcol);
            inputednumber=0;
            return false;

        }
        if(inputednumber==15){// if clear button pressed
            clearfunction();
            inputednumber=0;
            return false;

        }
        //check inputed col for conflict
        for(int rows=0;rows<9;rows++){
            if(entered[rows][inputcol-1]==inputednumber){

                colbroken=inputcol;
                rowbroken=rows+1;
                whatsbroken="col";
                return true;

            }
        }
        for(int cols=0;cols<9;cols++){
            if(entered[inputrow-1][cols]==inputednumber){

                colbroken=cols+1;
                rowbroken=inputrow;
                whatsbroken="row";
                return true;

            }
        }

        lx=computelx(smallbox);
        ly=computely(smallbox);
        for(int col=lx;col<lx+3;col++){
            for(int row=ly;row<ly+3;row++){
                if(entered[row][col]==inputednumber){

                    colbroken=col+1;
                    rowbroken=row+1;
                    whatsbroken="box";
                    return true;

                }
            }

        }

        //if everything works for where user wants to put it
        entered[inputrow-1][inputcol-1]=inputednumber;
        return false;

    }
    private void fillarray(){// generates the random array
        Initialize(checked, 3);
        Initialize(gameboard, 9);
        int lx=0;
        int ly=0;

        int ctr=0;

        for(int box=1;box<=9;box++){
            ctr=0;

            lx=computelx(box);
            ly=computely(box);
            for(int nbr=1;nbr<=9;nbr++){

                int placed=0;
                int timesfailed=0;// counts how many times it found a place number can't go 
                Initialize(checked, 3);
                while(placed==0){
                    int rowcheck=0;// vairble used to check all spots in the rows for same number
                    int colcheck=0;//vairble used to check all spots in the cols for same number
                    row=(int)(Math.random()*(3)+ly);
                    col=(int)(Math.random()*(3)+lx);
                    if(gameboard[row][col]==0){
                        if(checked[row-ly][col-lx]<nbr){
                            checked[row-ly][col-lx]=nbr;
                            for(int rowctr=0;rowctr<9;rowctr++){
                                if(gameboard[rowctr][col]==nbr){
                                    rowcheck=2;
                                    break;
                                }

                            } 

                            for(int colctr=0;colctr<9;colctr++){
                                if(gameboard[row][colctr]==nbr){
                                    colcheck=2;
                                    break; 
                                }
                            }
                            if(rowcheck==0 && colcheck==0){
                                gameboard[row][col]=nbr;
                                placed=1;
                            }
                            else{
                                timesfailed++;
                            }
                            if(timesfailed>=(9-nbr)+1){                                

                                Initialize(checked, 3);

                                timesfailed=0;

                                nbr=0;
                                placed=1;
                                ctr++;
                                if(ctr==25){
                                    Initialize(gameboard,9);
                                    box=1;
                                    ctr=0;
                                    lx=0;
                                    ly=0;

                                }
                                else{

                                    Reninitialize(gameboard,ly,lx);
                                }

                            }
                        }
                    }
                }

            }

        }

    }

    private static void Initialize(int checked[][], int size){ // make sthe whole thing full of 0's for the random array
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                checked[row][col]=0;
            }
        }
    }

    private static void Reninitialize(int gameboard[][], int startrow, int startcol){// if one box dosent work fills it with 0 again for the random array
        for(int row=startrow;row<startrow+3;row++){
            for(int col=startcol;col<startcol+3;col++){
                gameboard[row][col]=0;
            }
        }
    }

  

    public static int computelx(int box){// find column value to start at for evry box
        int lx=6;
        if(box==2|| box==5 || box==8){
            lx=3;
        }
        else if(box==1|| box==4 || box==7){
            lx=0;
        }
        return lx;
    }

    public static int computely(int box){// finds the row value to start at for every box
        int ly=0;
        if(box==4 || box==5 || box==6){
            ly=3;
        }
        else if(box==7 || box==8 || box==9){
            ly=6;
        }
        return ly;
    }

    public int computebox(int col,int row){// uses the row or column to get teh box to check for conflict 

        if(row>=1 && row<=3){
            if(col>=1 && col<=3){
                smallbox=1;

            }
            if(col>=4 && col<=6){
                smallbox=4;

            }
            if(col>=7 && col<=9){
                smallbox=7;

            }
        }
        if(row>=4 && row<=6){
            if(col>=1 && col<=3){
                smallbox=2;

            }
            if(col>=4 && col<=6){
                smallbox=5;

            }
            if(col>=7 && col<=9){
                smallbox=8;

            }

        }
        if(row>=7 && row<=9){
            if(col>=1 && col<=3){
                smallbox=3;

            }
            if(col>=4 && col<=6){
                smallbox=6;

            }
            if(col>=7 && col<=9){
                smallbox=9;

            }

        }

        return smallbox;
    }

    public int[][] deletefunction(int row,int col){
        if(puzzle[row-1][col-1]==0){
            entered[row-1][col-1]=0;

        }
        return entered;

    }
    public int[][] clearfunction(){
        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++){
                entered[row][col]=puzzle[row][col];

            }
        
        }
        return entered;

    }

}

