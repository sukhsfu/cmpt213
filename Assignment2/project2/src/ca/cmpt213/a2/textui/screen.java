package ca.cmpt213.a2.textui;

/*
AUTHOR: OKAFOR EMMANUEL(301329115) - eokafor@sfu.ca
AUTHOR: Sukhwinder Singh (301368460) -sukhwind@sfu.ca
LAST MODIFIED DATE: 26/06/2020
DESCRIPTION: This screen class is the main class responsible for handling interactivity with the user. It displays the graph to user gotten from the graph class and decides which function to run based on user input.
 */

public class screen {
    private static final String HEADER = " Start  ";
    private static final String HEADER1 = " Map Reveal  ";
    private static final String HEADER3 = " Help Menu  ";
    private static final String HEADER7 = " Cheat code  ";

    private static final String[] MENU = {"#: Wall", "@: You (a hero)", "!: Monster", "$: Power", ".: Unexplored space"};

    static graph game = new graph();
    static display fullMaze = new display();
    static motion move = new motion();
    static motionGraph draw = new motionGraph();
    static boolean alreadyIn = true;
    static int taken = 0;
    static int stayed = 3;
    static int ability = 0;
    static String input = "";
    public static void main(String[] args) {
        int counter = 1;
        int demons = 3;
        options menu = new options(HEADER, MENU);
        menu.displayTitle(counter);
        menu.displayMainMenu();
        game.newGraph();
        menu.displayOptions(demons, taken, stayed);

        while (alreadyIn) {
            input = menu.getUserInput();
            switch (input) {
                case "m":
                    counter++;
                    menu = new options(HEADER1, MENU);
                    menu.displayTitle(counter);
                    System.out.println();
                    fullMaze.displayGraph();
                    System.out.println();
                    menu.displayOptions(demons, taken, stayed);
                    break;
                case "?":
                    counter++;
                    menu = new options(HEADER3, MENU);
                    menu.displayTitle(counter);
                    menu.displayMainMenu();
                    System.out.println();
                    draw.moveGraph();
                    System.out.println();
                    menu.displayOptions(demons, taken, stayed);
                    break;
                case "c":
                    counter++;
                    menu = new options(HEADER7, MENU);
                    menu.displayTitle(counter);
                    System.out.println();
                    draw.moveGraph();
                    System.out.println();
                    demons = 1;
                    menu.displayOptions(demons, taken, stayed);
                    ability = 1;
                    break;
                case "w":
                    int a = 1;
                    moveUp(a);
                    if(alreadyIn == true)
                    {
                        draw.moveGraph();
                        System.out.println();
                        menu.displayOptions(demons, taken, stayed);
                    }
                    break;
                case "a":
                    int b = 2;
                    moveLeft(b);
                    if(alreadyIn == true)
                    {
                        draw.moveGraph();
                        System.out.println();
                        menu.displayOptions(demons, taken, stayed);
                    }
                    break;
                case "s":
                    int c = 3;
                    moveDown(c);
                    if(alreadyIn == true)
                    {
                        draw.moveGraph();
                        System.out.println();
                        menu.displayOptions(demons, taken, stayed);
                    }
                    break;
                case "d":
                    int d = 4;
                    moveRight(d);
                    if(alreadyIn == true)
                    {
                        draw.moveGraph();
                        System.out.println();
                        menu.displayOptions(demons, taken, stayed);
                    }
                    break;
                case "q":
                    end();
                    fullMaze.displayGraph();
                    counter = 0;
                    break;
                default:
                    System.out.println("Invalid move. Please enter just A (left), S (down), D (right), or W (up).");
                    break;
            }
        }
    }

    private static void moveUp(int s) {
        int d = move.movement(s);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");
            System.out.println();
        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println();
                fullMaze.displayGraph();
                System.out.println();
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println();
                fullMaze.displayGraph();
                System.out.println();
                System.out.println("Congratulations! You've Won.");
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                taken--;
                stayed--;
            }
        }
        else if(d == 3)
        {
            System.out.println("You've grabbed a power!");
            taken++;
        }
        else if(d == 4)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                stayed--;
            }
        }
    }

    private static void moveLeft(int q) {
        int d = move.movement(q);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");
        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println();
                fullMaze.displayGraph();
                System.out.println("Im sorry, you've been eaten!");
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println();
                fullMaze.displayGraph();
                System.out.println("Congratulations! You've Won.");
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                System.out.println();
                taken--;
                stayed--;
            }
        }
        else if(d == 3)
        {
            System.out.println("You've grabbed a power!");
            System.out.println();
            taken++;
        }
        else if(d == 4)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                stayed--;
            }
        }
    }

    private static void moveDown(int v) {
        int d = move.movement(v);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");
        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                taken--;
                stayed--;
            }
        }
        else if(d == 3)
        {
            System.out.println("You've grabbed a power!");
            taken++;
        }
        else if(d == 4)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                stayed--;
            }
        }
    }

    private static void moveRight(int o) {
        int d = move.movement(o);
        if (d == 1){
            System.out.println("Invalid move: you cannot move through walls");
        }
        else if(d == 2)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                taken--;
                stayed--;
            }
        }
        else if(d == 3)
        {
            System.out.println("You've grabbed a power!");
            taken++;
        }
        else if(d == 4)
        {
            if(taken == 0)
            {
                System.out.println("Im sorry, you've been eaten!");
                fullMaze.displayGraph();
                end();
            }
            else if((stayed == 1)||(ability == 1))
            {
                System.out.println("Congratulations! You've Won.");
                fullMaze.displayGraph();
                end();
            }
            else
            {
                System.out.println("You've killed a monster!");
                stayed--;
            }
        }
    }

    public static void end()
    {
        alreadyIn = false;
    }

}
