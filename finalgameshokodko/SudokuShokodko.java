import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

public class SudokuShokodko extends Applet implements ActionListener,MouseListener
{
    private int level;
    private int difficulty;

    private int show[][];// array that computer shows
   private int entered[][];//array that user enters numbers into 

    private arrayworkShokodko board;// vairble board is the class varible to call the class araywork
    private int numberinputed;// what number they want to input
    private boolean okay=false;// wether it is okay to put the number in,checked in class arraywork

    private int upperrightx; //upper right x value of the box
    private int upperrighty; // upper left y alue of the box
    private int boxX,boxY;// value at whoich to draw the number in the box
    private int  middleOfnumber;// x value of the middle of the number
    private int showed;//if it array show was showed then it changes to 1 to not redraw it.
    private int numberboxX;
    private int numberboxY;// where to draw box around selected #

    private int x,y;
    private int incorrectX,incorrectY;

    public void init(){
        level=1;
        showed=0;//if it array show was showed then it changes to 1 to not redraw it.
        numberboxX=-500;
        numberboxY=-500;// where to draw box around selected #

        x=250;//x mouse location
        y=250;//y mouse location
        setBackground(Color.BLACK);
        addMouseListener(this);       

    }

    public void mouseExited(MouseEvent me){

    }

    public void mouseEntered(MouseEvent me){

    }

    public void mouseReleased(MouseEvent me){
        x=me.getX();// x value used for clicking and going to next level/inputing numbers
        y=me.getY();// y value used for clikcing and going to next level/inputing numbers
        repaint();

    }

    public void mousePressed(MouseEvent me){

    }

    public void mouseClicked(MouseEvent me){

    }

    public void actionPerformed(ActionEvent ae){

    }

    /**
     * Paint method for applet.
     * 
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g){

        if(level==1){
            drawtitle(g);// calling function to draw title
        }
        if(level==2){
            drawinstructions(g);// calling function to draw instructions

        }

        if(level==3){
            drawdifficulty(g);// calling function to draw difficulty screen

        }
        if(level==4){
            drawgamescreen(g);// calling function to draw the game screen

        }
        if(level==5){
            drawEndscreen(g);// caling function to draw the submit/final screen

        }
        if(level==6){
            g.fillRect(0,0,1000,1000);

        }
    }
    private void drawtitle(Graphics g){//function to draw the title page 
        g.setColor(Color.BLUE);// inner vertical lines
        for(int x=200;x<=760;x+=80){
            g.drawLine(x,160,x,880);
        }
        //inner horizontal lines
        for(int y=240;y<=800;y+=80){
            g.drawLine(120,y,840,y);
        }
        g.setColor(Color.RED);//outline
        g.drawRect(120,160,720,720);//outer red box
        g.drawLine(360,160,360,880);// first red vertical line
        g.drawLine(600,160,600,880);// seccond red vertical line
        g.drawLine(120,400,840,400);// first horizontal red line
        g.drawLine(120,640,840,640);// seccond horizontal red line
        g.setColor(Color.GREEN);
        g.setFont(new Font("default",Font.BOLD,140));
        g.drawString("SUDOKU",170,140);// drawing name of game
        g.setColor(Color.ORANGE);
        g.setFont(new Font("default",Font.BOLD,80));
        g.drawString("Instructions",200,960);//"button" to go to instructions
        //when mouse clicks instructions go to them
        if(x>200 && x<740 && y>880 && y<1000){
            level=2;
            repaint();
        }

    }

    private void drawinstructions(Graphics g){// function drawing instruction screen
        g.setColor(Color.CYAN);
        g.setFont(new Font("default",Font.BOLD,23));
        g.drawString("The goal is to get each number from 1 to 9 in every Row,Column and Box.",10,60);
        g.drawString("Click on the numbers at the top to select the number.",10,100);
        g.drawString("Then click where you wan't to place the number.",10,140);
        g.drawString("If you have placed the number correctly,then it will show up, in yellow",10,180);
        g.drawString("Otherwise a cyan x will show up in the place that stoped the placement.",10,240);
        g.drawString("Press clear twice to clear all the number you have entered.",10,300);
        g.drawString("To delete,press delete and then on,the number you wanna delete.",10,360);
        g.drawString("If you use the delete/clear feature you have to select the number you wanna enter.",10,420);
        g.drawString("Once you have completed the puzzle press submit.",10,480);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("default",Font.BOLD,80));
        g.drawString("Play",600,700);
        if(x>600 && x<900 && y>600 && y<1000){//wwhen play "button" clicked go to the diffuclty select screen
            level=3;
            repaint();
        }

    }

    private void drawdifficulty(Graphics g){// function drawing difficulty screen
        g.setFont(new Font("default",Font.BOLD,40));
        g.setColor(Color.GREEN);
        g.drawString("Choose Your Difficulty",50,100);
        g.setColor(Color.RED);
        g.drawString("EASY",270,300);
        g.drawString("MEDIUM",270,500);
        g.drawString("HARD",270,700);

        if(x>270 && y>265 && x<375 && y<370){// if mouse clicks easy go to that difficulty
            level=4;

            board=new arrayworkShokodko(5);// calling function that determines what numbers to display,function in arraywork
            repaint();// 5 tells function what difficulty was selected
        }
        else if(x>270 && y>465 && x<440 && y<505){// if mouse clicks meduim go to that difficulty
            level=4;

            board=new arrayworkShokodko(4);// calling function that determines what numbers to display,function in arraywork
            // 4 tells function waht difficulty was selected
            repaint();
        }
        else if(x>270 && y>665 && x<390 && y<705){// if mouse clicks hard go to that difficulty
            level=4;

            board=new arrayworkShokodko(3);// calling function that determines what numbers to display,function in arraywork
            // 3 tells function waht difficulty was selected
            repaint();
        }

    }

    private void drawgamescreen(Graphics g){
        g.setColor(Color.BLUE);// inner vertical lines
        for(int x=200;x<=760;x+=80){
            g.drawLine(x,160,x,880);

        }
        //iner horizontal lines
        for(int y=240;y<=800;y+=80){
            g.drawLine(120,y,840,y);
        }

        g.setColor(Color.RED);//outline
        g.drawRect(120,160,720,720);//
        g.drawLine(360,160,360,880);// first red vertical line
        g.drawLine(600,160,600,880);// seccond red vertical line
        g.drawLine(120,400,840,400);// first horizontal red line
        g.drawLine(120,640,840,640);// seccond horizontal red line

        g.setFont(new Font("default",Font.BOLD,25));
        g.setColor(Color.YELLOW);//draws the asterik
        if(x>=120 && x<=840 && y>=160 && y<=880){
            upperrightx=((x-120)/80)*80+170;
            upperrighty=((y-160)/80)*80+190;
            g.drawString("*",upperrightx,upperrighty);
        }

        show = board.getboard();// getthe array that determines waht numbers show up form the class

        g.setFont(new Font("default",Font.BOLD,20));
        g.setColor(Color.WHITE);
        int boxY=200;//where to draw the number
        if(showed==0){
            for(int row=0;row<9;row++){
                int boxX=160;
                for(int col=0;col<9;col++){
                    if(show[row][col]!=0){
                        g.drawString(""+show[row][col],boxX,boxY);
                    }
                    boxX+=80;
                }
                boxY+=80;
            }
        }
        else{
            for(int row=0;row<9;row++){
                int boxX=160;
                for(int col=0;col<9;col++){
                    if(show[row][col]!=0){
                        g.setColor(Color.WHITE);
                        g.drawString(""+show[row][col],boxX,boxY);

                    }
                    if(entered[row][col]!=0 && show[row][col]==0){
                        g.setColor(Color.ORANGE);
                        g.drawString(""+entered[row][col],boxX,boxY);

                    }
                    boxX+=80;
                }
                boxY+=80;
            }

        }

        int numberY=100;
        int numberX=90;
        g.setFont(new Font("default",Font.BOLD,50));

        for(int numbertodraw=1;numbertodraw<=9;numbertodraw++){// draws numbers at top for user to selcet what numbers to input
            g.setColor(Color.ORANGE);
            g.drawString(""+numbertodraw,numberX,numberY);

            numberX+=100;

        }

        g.setColor(Color.GREEN);
        g.setFont(new Font("default",Font.BOLD,20));

        g.drawString("SUBMIT",900,250);
        g.drawString("DELETE",900,550);
        g.drawString("CLEAR",900,850);

        if(x>=890 && x<=990 && y>=225 && y<=260){//submit

            level=5;

            repaint();

        }
        if(x>=890 && x<=990 && y>=525 && y<=560){//delete number 
            int deletecol=convertXtoCol(upperrightx);// find the col at which the user want to input the number
            int deleterow=convertYtoRow(upperrighty);// find the col at which the user want to input the number

            numberinputed=10;
            int col=convertXtoCol(x);
            int row=convertYtoRow(y);
            board.CheckForConflict(deleterow,deletecol,numberinputed);// tells it to call the function in arraywork to delte the numbers
            drawSelectednumbers(g);// re draws the numbers acordingly

        }
        if(x>=890 && x<=990 && y>=825 && y<=960){//clear 

            numberinputed=15;
            int clearcol=convertXtoCol(x);
            int clearrow=convertYtoRow(y);

            board.CheckForConflict(clearrow,clearcol,numberinputed);//calls the function that checks for conflict and tells it to erase the whole entered array
            drawSelectednumbers(g);// re draws the numberss acordingly

        }
        WhatnumberInputed(x);// detrmines what number was selected
        drawselectednumberbox(x);// determines which number to draw box around
        if( numberinputed>0 && numberinputed<10){// tells it to draw the box around the number based on previous called functions
            numberboxX=((middleOfnumber-20)/20)*20+10;
            numberboxY=60;
            g.drawRect(numberboxX,numberboxY,30,50);
        }
        else if(numberinputed==10 ||numberinputed==15){// tells it to draw the box around the delete/clear based on previous called function

            g.drawRect(890,middleOfnumber,100,35);
        }
        drawSelectednumbers(g);// redraw the numbers

    }

    private void drawSelectednumbers(Graphics g){// function to draw the numbers and call arraywork function to decide if doable
        g.setFont(new Font("default",Font.BOLD,20));
        if(x>=120 && x<=840 && y>=160 && y<=880){

            upperrightx=((x-120)/80)*80+170;
            upperrighty=((y-160)/80)*80+190;

            int cols=convertXtoCol(upperrightx);// find the col at which the user want to input the number
            int rows=convertYtoRow(upperrighty);// find the col at which the user want to input the number
            if(numberinputed==0){

                return;
            }

            if(show[rows-1][cols-1]==0){

                okay=board.CheckForConflict(rows,cols,numberinputed);
            }

            entered=board.entered;

            if(okay){
                int yPos=board.rowbroken;
                int xPos=board.colbroken;

                g.setColor(Color.CYAN);
                g.drawString("X",computeXvalueOfconlfict(xPos),computeYvalueOfconlfict(yPos)-10);

            }
        }
        if(!okay){

            int boxY=200;//where to draw the number
            for(int row=0;row<9;row++){
                int boxX=160;
                for(int col=0;col<9;col++){

                    if(show[row][col]!=0){
                        g.setColor(Color.WHITE);
                        g.drawString(""+show[row][col],boxX,boxY);

                    }
                    if(entered[row][col]!=0 && show[row][col]==0){
                        g.setColor(Color.ORANGE);
                        g.drawString(""+entered[row][col],boxX,boxY);

                    }

                    boxX+=80;
                }
                boxY+=80;
            }
            showed=1;
        }

    } 

    private int WhatnumberInputed(int x){
        if(x>=85 && x<=135 && y>=100-45 && y<=150){
            numberinputed=1;

        }
        else if(x>=185 && x<=235 && y>=100-45 && y<=150){
            numberinputed=2;

        }
        else if(x>=285 && x<=335 && y>=100-45 && y<=150){
            numberinputed=3;

        }
        else if(x>=385 && x<=435 && y>=100-45 && y<=150){
            numberinputed=4;

        }
        else if(x>=485 && x<=535 && y>=100-45 && y<=150){
            numberinputed=5;

        }
        else if(x>=585 && x<=635 && y>=100-45 && y<=150){
            numberinputed=6;

        }
        else if(x>=685 && x<=735 && y>=100-45 && y<=150){
            numberinputed=7;

        }
        else if(x>=785 && x<=835 && y>=100-45 && y<=150){
            numberinputed=8;

        }
        else if(x>=885 && x<=935 && y>=100-45 && y<=150){
            numberinputed=9;

        }

        return numberinputed;
    } 

    private int drawselectednumberbox(int x){

        if(numberinputed==1){

            middleOfnumber=110;

        }
        else if(numberinputed==2){

            middleOfnumber=210;

        }
        else if(numberinputed==3){

            middleOfnumber=310;

        }
        else if(numberinputed==4){

            middleOfnumber=410;

        }
        else if(numberinputed==5){

            middleOfnumber=510;

        }
        else if(numberinputed==6){

            middleOfnumber=610;

        }
        else if(numberinputed==7){

            middleOfnumber=710;

        }
        else if(numberinputed==8){

            middleOfnumber=810;

        }
        else if(numberinputed==9){

            middleOfnumber=910;
        }
        else if(numberinputed==10){

            middleOfnumber=525;

        }
        else if(numberinputed==15){

            middleOfnumber=825;
        }

        return middleOfnumber;
    }

    private int convertXtoCol(int x){
        int col=0;
        if(x==170){
            col=1;

        }
        else if(x==250){
            col=2;

        }
        else if(x==330){
            col=3;

        }
        else if(x==410){
            col=4;

        }
        else if(x==490){
            col=5;

        }
        else if(x==570){
            col=6;

        }
        else if(x==650){
            col=7;

        }
        else if(x==730){
            col=8;

        }
        else if(x==810){
            col=9;

        }

        return col;
    }

    private int convertYtoRow(int y){
        int row=0;
        if(y==190){
            row=1;

        }
        else if(y==270){
            row=2;

        }
        else if(y==350){
            row=3;

        }
        else if(y==430){
            row=4;

        }
        else if(y==510){
            row=5;

        }
        else if(y==590){
            row=6;

        }
        else if(y==670){
            row=7;

        }
        else if(y==750){
            row=8;

        }
        else if(y==830){
            row=9;

        }

        return row;
    }

    private void drawEndscreen(Graphics g){
        g.setFont(new Font("default",Font.BOLD,100));
        g.setColor(Color.GREEN);
        g.drawString("CONGRATS",100,100);
        g.setFont(new Font("default",Font.BOLD,20));
        g.setColor(Color.YELLOW);
        g.drawString("Click here to play again",600,300);
        g.drawString("End Game",600,600);

        if(x>=590 && x<=870 && y>=275 && y<=310){
            level=3;
            repaint();

        }
        if(x>=590 && x<=710 && y>=575 && y<=610){
            level=6;
            repaint();

        }
        g.drawString("Sudoku-BY:Sam Shokodko",250,500);

    }

    private int computeXvalueOfconlfict(int colbroken){
        if(colbroken==1){
            incorrectX=160;
        }
        else if(colbroken==2){
            incorrectX=240;

        }
        else if(colbroken==3){
            incorrectX=320;
        }
        else if(colbroken==4){
            incorrectX=400;

        }
        else if(colbroken==5){
            incorrectX=480;

        }
        else if(colbroken==6){
            incorrectX=560;

        }
        else if(colbroken==7){
            incorrectX=640;

        }
        else if(colbroken==8){
            incorrectX=720;

        }
        else if(colbroken==9){
            incorrectX=800;

        }

        return incorrectX;
    }

    private int computeYvalueOfconlfict(int rowbroken){

        if(rowbroken==1){
            incorrectY=190;

        }
        else if(rowbroken==2){
            incorrectY=270;

        }
        else if(rowbroken==3){
            incorrectY=350;

        }
        else if(rowbroken==4){

            incorrectY=430;

        }
        else if(rowbroken==5){

            incorrectY=510;

        }
        else if(rowbroken==6){
            incorrectY=590;

        }
        else if(rowbroken==7){
            incorrectY=670;

        }
        else if(rowbroken==8){

            incorrectY=750;

        }
        else if(rowbroken==9){

            incorrectY=830;

        }
        return incorrectY;
    }

}    
