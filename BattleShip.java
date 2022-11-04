import java.util.ArrayList;
import java.util.Scanner;
public class BattleShip{
    private int[][] shipHolder;
    private int[][]display;
    private ArrayList<Integer>shipAllSize;
    private ArrayList<Integer>count;
    private int shipAmount;
    private ArrayList<Integer>ship2;
    private ArrayList<Integer>ship3;
    private ArrayList<Integer>ship4;
    private ArrayList<Integer>ship5;
    
    public BattleShip(){
        shipHolder = new int[10][10];
        display = new int[10][10];
        shipAmount = 4;
        shipAllSize = new ArrayList<Integer>();
        count = new ArrayList<Integer>();
        ship2 = new ArrayList<Integer>(1);
        ship3 = new ArrayList<Integer>(2);
        ship4 = new ArrayList<Integer>(3);
        ship5 = new ArrayList<Integer>(4);
    }
    //This method places ships on a grid.
    private int[][] shipPlacer(){
        //Ship 3
        int ship1Hor = (int)(Math.random()*8);
        int ship1Vert = (int)(Math.random()*8);
        //Ship 2
        int ship2Hor = (int)(Math.random()*9);
        int ship2Vert = (int)(Math.random()*9);
        //Ship 4
        int ship3Hor = (int)(Math.random()*7);
        int ship3Vert = (int)(Math.random()*7);
        //Ship 5
        int ship4Hor = (int)(Math.random()*6);
        int ship4Vert = (int)(Math.random()*6);

        //The if statements below randomize if the ship is going
        //to be vertical or horizontal.
        
        //Ship one size three randomizer for vertical or horizontal
        int horOrVertShip3 = (int)(Math.random()*2);
        if(horOrVertShip3 == 1){
            shipHolder[ship1Hor][ship1Vert] = 3;
            shipHolder[ship1Hor+1][ship1Vert] = 3;
            shipHolder[ship1Hor+2][ship1Vert] = 3;
        }
        else{
            shipHolder[ship1Hor ][ship1Vert] = 3;
            shipHolder[ship1Hor ][ship1Vert+1] = 3;
            shipHolder[ship1Hor ][ship1Vert+2] = 3;
        }
        //Ship two size two randomizer for vertical or horizontal
        int horOrVertShip2 = (int)(Math.random()*2);
        if(horOrVertShip2 == 1){
            shipHolder[ship2Hor][ship2Vert] = 2;
            shipHolder[ship2Hor+1][ship2Vert] = 2;
        }
        else{
            shipHolder[ship2Hor ][ship2Vert] = 2;
            shipHolder[ship2Hor ][ship2Vert+1] = 2;
        }
        //Ship three size four randomizer for vertical or horizontal
        int horOrVertShip4 = (int)(Math.random()*2);
        if(horOrVertShip4 == 1){
            shipHolder[ship3Hor][ship3Vert] = 4;
            shipHolder[ship3Hor+1][ship3Vert] = 4;
            shipHolder[ship3Hor+2][ship3Vert] = 4;
            shipHolder[ship3Hor+3][ship3Vert] = 4;
        }
        else{
            shipHolder[ship3Hor ][ship3Vert] = 4;
            shipHolder[ship3Hor ][ship3Vert+1] = 4;
            shipHolder[ship3Hor ][ship3Vert+2] = 4;
            shipHolder[ship3Hor ][ship3Vert+3] = 4;
        }
        //Ship four size five randomizer for vertical or horizontal
        int horOrVertShip5 = (int)(Math.random()*2);
        if(horOrVertShip5 == 1){
            shipHolder[ship4Hor][ship4Vert] = 5;
            shipHolder[ship4Hor+1][ship4Vert] = 5;
            shipHolder[ship4Hor+2][ship4Vert] = 5;
            shipHolder[ship4Hor+3][ship4Vert] = 5;
            shipHolder[ship4Hor+4][ship4Vert] = 5;
        }
        else{
            shipHolder[ship4Hor ][ship4Vert] = 5;
            shipHolder[ship4Hor ][ship4Vert+1] = 5;
            shipHolder[ship4Hor ][ship4Vert+2] = 5;
            shipHolder[ship4Hor ][ship4Vert+3] = 5;
            shipHolder[ship4Hor][ship4Vert+4] = 5;
        }
        //This loop checks if the ships overlap
        //If the ships overlap the ships randomize again 
        //until the ships dont overlap eachother.
        boolean overLap = true;
        while(overLap){
            for(int row = 0;row<display.length;row++){
                for(int col = 0; col<display[row].length;col++){
                    if(shipHolder[row][col]>0){
                        shipAllSize.add(0);
                        if(shipAllSize.size()==14){
                            overLap = false;
                        }
                    }
                    else{
                        count.add(0);
                        if(count.size()>86){
                            for(int i = 0;i<display.length;i++){
                                for(int j = 0; j<display[i].length;j++){
                                    shipHolder[i][j] = 0;
                                }
                            }

                            ship2();
                            ship3();
                            ship4();
                            ship5();

                            count.clear();
                            shipAllSize.clear();
                        }
                    }
                }
            }
        }
        return shipHolder;
    }
    //Ship 2 placer if the ships overlap
    private void ship2(){
        int ship2Row = (int)(Math.random()*9);
        int ship2Col = (int)(Math.random()*9);
        int rowOrColShip2 = (int)(Math.random()*2);
        if(rowOrColShip2 == 1){
            shipHolder[ship2Row][ship2Col] = 2;
            shipHolder[ship2Row+1][ship2Col] = 2;
        }
        else{
            shipHolder[ship2Row][ship2Col] = 2;
            shipHolder[ship2Row][ship2Col+1] = 2;
        }
    }
    //Ship 3 placer if the ships overlap
    private void ship3(){
        int ship3Row = (int)(Math.random()*8);
        int ship3Col = (int)(Math.random()*8);
        int rowOrColShip3 = (int)(Math.random()*2);
        if(rowOrColShip3 == 1){
            shipHolder[ship3Row][ship3Col] = 3;
            shipHolder[ship3Row+1][ship3Col] = 3;
            shipHolder[ship3Row+2][ship3Col] = 3;
        }
        else{
            shipHolder[ship3Row][ship3Col] = 3;
            shipHolder[ship3Row][ship3Col+1] = 3;
            shipHolder[ship3Row][ship3Col+2] = 3;
        }
    }
    //Ship 4 placer if the ships overlap
    private void ship4(){
        int ship4Row = (int)(Math.random()*7);
        int ship4Col = (int)(Math.random()*7);
        int rowOrColShip4 = (int)(Math.random()*2);
        if(rowOrColShip4 == 1){
            shipHolder[ship4Row][ship4Col] = 4;
            shipHolder[ship4Row+1][ship4Col] = 4;
            shipHolder[ship4Row+2][ship4Col] = 4;
            shipHolder[ship4Row+3][ship4Col] = 4;
        }
        else{
            shipHolder[ship4Row][ship4Col] = 4;
            shipHolder[ship4Row][ship4Col+1] = 4;
            shipHolder[ship4Row][ship4Col+2] = 4;
            shipHolder[ship4Row][ship4Col+3] = 4;
        }
    }
    //Ship 5 placer if the ships overlap
    private void ship5(){
        int ship5Row = (int)(Math.random()*5);
        int ship5Col = (int)(Math.random()*5);
        int rowOrColShip5 = (int)(Math.random()*2);
        if(rowOrColShip5 == 1){
            shipHolder[ship5Row][ship5Col] = 5;
            shipHolder[ship5Row+1][ship5Col] = 5;
            shipHolder[ship5Row+2][ship5Col] = 5;
            shipHolder[ship5Row+3][ship5Col] = 5;
            shipHolder[ship5Row+4][ship5Col] = 5;
        }
        else{
            shipHolder[ship5Row][ship5Col] = 5;
            shipHolder[ship5Row][ship5Col+1] = 5;
            shipHolder[ship5Row][ship5Col+2] = 5;
            shipHolder[ship5Row][ship5Col+3] = 5;
            shipHolder[ship5Row][ship5Col+4] = 5;
        }
    }

    //This method is made to process the users guesses.
    public void guess(){
        shipHolder = shipPlacer();
        Scanner input = new Scanner(System.in);
        //Dispalays the grid for the user.
        for(int row = 0;row<display.length;row++){
            for(int col = 0; col<display[row].length;col++){
                System.out.print(display[row][col]+"   ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        for(int row = 0;row<display.length;row++){
            for(int col = 0; col<display[row].length;col++){
                System.out.print(shipHolder[row][col]+"   ");
            }
            System.out.println(" ");
        }
        //This loop checks if you hit a ship or missed
        //and checks if you sunk a ship
        //also checks if you won or lost.
        loop:
        for(int i = 50;i>0;i--){
            if(i==1){
                System.out.println("This is your last guess");
            }
            else{
                System.out.println("You have "+i+" tries");
            }
            System.out.print("Eenter Y Axis: ");
            int readX = input.nextInt();
            System.out.print("Enter X Axis: ");
            int readY = input.nextInt();
            System.out.println(" ");
            readX -= 1;
            readY -= 1;
            if(shipHolder[readX][readY] == 2){
                ship2.add(2);
                display[readX][readY] = shipHolder[readX][readY];
                shipHolder[readX][readY]-= shipHolder[readX][readY];
                System.out.println("HIT");
                if(ship2.size()==2){
                    System.out.println("Ship Size 2 Has Been Sunk");
                    shipAmount--;
                    if(shipAmount == 1){
                        System.out.println("There is one ship left");
                    }
                    else{
                        System.out.println("There are "+shipAmount+" ships left in the grid");
                    }
                }
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            else if(shipHolder[readX][readY]==3){
                ship3.add(3);
                display[readX][readY] = shipHolder[readX][readY];
                shipHolder[readX][readY] -= shipHolder[readX][readY];
                System.out.println("HIT");
                if(ship3.size()==3){
                    System.out.println("Ship Size 3 Has Been Sunk");
                    shipAmount--;
                    if(shipAmount == 1){
                        System.out.println("There is one ship left");
                    }
                    else{
                        System.out.println("There are "+shipAmount+" ships left in the grid");
                    }
                }
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            else if(shipHolder[readX][readY]==4){
                ship4.add(4);
                display[readX][readY] = shipHolder[readX][readY];
                shipHolder[readX][readY] -= shipHolder[readX][readY];
                System.out.println("HIT");
                if(ship4.size()==4){
                    System.out.println("Ship Size 4 Has Been Sunk");
                    shipAmount--;
                    if(shipAmount == 1){
                        System.out.println("There is one ship left");
                    }
                    else{
                        System.out.println("There are "+shipAmount+" ships left in the grid");
                    }
                }
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            else if(shipHolder[readX][readY]==5){
                ship5.add(5);
                display[readX][readY] = shipHolder[readX][readY];
                shipHolder[readX][readY] -= shipHolder[readX][readY];
                System.out.println("HIT");
                if(ship5.size()==5){
                    System.out.println("Ship Size 5 Has Been Sunk");
                    shipAmount--;
                    if(shipAmount == 1){
                        System.out.println("There is one ship left");
                    }
                    else{
                        System.out.println("There are "+shipAmount+" ships left in the grid");
                    }
                }
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            else if(display[readX][readY] > 0){
                System.out.print("You already guess at this position");
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            else{
                display[readX][readY] = 1;
                System.out.println("MISS");
                for(int row = 0;row<display.length;row++){
                    for(int col = 0; col<display[row].length;col++){
                        System.out.print(display[row][col]+"   ");
                    }
                    System.out.println(" ");
                }
            }
            System.out.print("\n");
            if(shipAmount==0){
                System.out.println("\n"+"YOU WIN");
                break loop;
            }

        }
        loseCheck();
    }

    private void loseCheck(){
        if(shipAmount>0){
            System.out.println("\n"+"YOU LOSE");
            for(int row = 0;row<shipHolder.length;row++){
                for(int col = 0; col<shipHolder[row].length;col++){
                    System.out.print(shipHolder[row][col]+"   ");
                }
                System.out.println(" ");
            }
        }
    }
}