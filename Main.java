package tictactoe;

import java.util.Scanner;

public class Main {
    public static String[][] field = new String[3][5];
    public static String[] tempArray;
    Scanner scanner = new Scanner(System.in);
    static String status = "";

    void buildField() {
        field[0] = new String[]{"|", "_", "_", "_","|"};
        field[1] = new String[]{"|","_", "_", "_", "|"};
        field[2] = new String[]{"|","_", "_", "_", "|"};
        tempArray = new String[]{"_", "_", "_", "_", "_", "_", "_", "_", "_",};
    }
    void takeInput() {
        System.out.println("Enter cells: ");
        String input = scanner.nextLine();
        tempArray = input.split("");
    }
    void transformArray() {
        for (int i = 0; i < 3; i++) {
            field[0][i + 1] = tempArray[i];
            field[1][i + 1] = tempArray[i + 3];
            field[2][i + 1] = tempArray[i + 6];
        }
    }
    void printResult() {
        System.out.println("---------");
        for (String[] row: field) {
            for (String element: row) {
                System.out.print(element + " ");
            }
            System.out.print("\n");
        }
        System.out.println("---------");
    }
    String checkStatus(){
        int x = 0;
        int o = 0;
        for (int i = 0; i < 9; i++) {
            if (tempArray[i].equals("X")) {
                x++;
            } else if (tempArray[i].equals("O")){
                o++;
            }
        }
        if (((tempArray[0].equals("X") && tempArray[1].equals("X") && tempArray[2].equals("X")) ||
                (tempArray[3].equals("X") && tempArray[4].equals("X") && tempArray[5].equals("X")) ||
                (tempArray[6].equals("X") && tempArray[7].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[0].equals("X") && tempArray[3].equals("X") && tempArray[6].equals("X")) ||
                (tempArray[1].equals("X") && tempArray[4].equals("X") && tempArray[7].equals("X")) ||
                (tempArray[2].equals("X") && tempArray[5].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[0].equals("X") && tempArray[4].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[2].equals("X") && tempArray[4].equals("X") && tempArray[6].equals("X"))) &&
                ((tempArray[0].equals("O") && tempArray[1].equals("O") && tempArray[2].equals("O")) ||
                        (tempArray[3].equals("O") && tempArray[4].equals("O") && tempArray[5].equals("O")) ||
                        (tempArray[6].equals("O") && tempArray[7].equals("O") && tempArray[8].equals("O")) ||
                        (tempArray[0].equals("O") && tempArray[3].equals("O") && tempArray[6].equals("O")) ||
                        (tempArray[1].equals("O") && tempArray[4].equals("O") && tempArray[7].equals("O")) ||
                        (tempArray[2].equals("O") && tempArray[5].equals("O") && tempArray[8].equals("O")) ||
                        (tempArray[0].equals("O") && tempArray[4].equals("O") && tempArray[8].equals("O")) ||
                        (tempArray[2].equals("O") && tempArray[4].equals("O") && tempArray[6].equals("O"))) ||
                Math.abs(x - o) > 1) {
            //System.out.println("Impossible");
            return "Impossible";
        } else if ((tempArray[0].equals("X") && tempArray[1].equals("X") && tempArray[2].equals("X")) ||
                (tempArray[3].equals("X") && tempArray[4].equals("X") && tempArray[5].equals("X")) ||
                (tempArray[6].equals("X") && tempArray[7].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[0].equals("X") && tempArray[3].equals("X") && tempArray[6].equals("X")) ||
                (tempArray[1].equals("X") && tempArray[4].equals("X") && tempArray[7].equals("X")) ||
                (tempArray[2].equals("X") && tempArray[5].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[0].equals("X") && tempArray[4].equals("X") && tempArray[8].equals("X")) ||
                (tempArray[2].equals("X") && tempArray[4].equals("X") && tempArray[6].equals("X"))) {
            //System.out.println("X wins");
            return "X wins";
        }else if ((tempArray[0].equals("O") && tempArray[1].equals("O") && tempArray[2].equals("O")) ||
                (tempArray[3].equals("O") && tempArray[4].equals("O") && tempArray[5].equals("O")) ||
                (tempArray[6].equals("O") && tempArray[7].equals("O") && tempArray[8].equals("O")) ||
                (tempArray[0].equals("O") && tempArray[3].equals("O") && tempArray[6].equals("O")) ||
                (tempArray[1].equals("O") && tempArray[4].equals("O") && tempArray[7].equals("O")) ||
                (tempArray[2].equals("O") && tempArray[5].equals("O") && tempArray[8].equals("O")) ||
                (tempArray[0].equals("O") && tempArray[4].equals("O") && tempArray[8].equals("O")) ||
                (tempArray[2].equals("O") && tempArray[4].equals("O") && tempArray[6].equals("O"))) {
            //System.out.println("O wins");
            return "O wins";
        } else if (!tempArray[0].equals("_") && !tempArray[1].equals("_") && !tempArray[2].equals("_") &&
                !tempArray[3].equals("_") && !tempArray[4].equals("_") && !tempArray[5].equals("_") &&
                !tempArray[6].equals("_") && !tempArray[7].equals("_") && !tempArray[8].equals("_")) {
            //System.out.println("Draw");
            return "Draw";
        } else {
            //System.out.println("Game not finished");
            return "Game not finished";
        }
    }

    int getCoordinates() {
        int x = -1;
        int y = -1;
        boolean checker = true;
        while (checker) {
            System.out.println("Enter the coordinates: ");
            try {
                x = Integer.parseInt(scanner.next());
                y = Integer.parseInt(scanner.next());
                System.out.println("Parsed x, y" + x + y);
                if ((x == 1 || x == 2 || x == 3) && (y == 1 || y == 2 || y == 3)) {
                    checker = false;
                    break;
                } else {
                    System.out.println(x +"-"+ y +" Coordinates should be numbers 1 to 3!");
                }
            } catch (Exception e) {
                System.out.println("Exception!");
            }
        }


        int index = -1;
        System.out.println(x + "-" + y);
        switch (x) {
            case 1:
                switch (y) {
                    case 1:
                        index = 6;
                        break;
                    case 2:
                        index = 3;
                        break;
                    case 3:
                        index = 0;
                        break;
                    default:
                        System.out.println("Wrong input!");
                        break;
                }
                break;
            case 2:
                switch (y) {
                    case 1:
                        index = 7;
                        break;
                    case 2:
                        index = 4;
                        break;
                    case 3:
                        index = 1;
                        break;
                    default:
                        System.out.println("Wrong input!");
                        break;
                }
                break;
            case 3:
                switch (y) {
                    case 1:
                        index = 8;
                        break;
                    case 2:
                        index = 5;
                        break;
                    case 3:
                        index = 2;
                        break;
                    default:
                        System.out.println("Wrong input!");
                        break;
                }
                break;
            default:
                System.out.println("Wrong input (x)");
                break;
        }
        System.out.println("Index " + index);
        return index;
    }



    public static void main(String[] args) {

        Main game = new Main();
        game.buildField();
        //game.takeInput();
        //game.transformArray();
        game.printResult();
        int player = 0;
        while (!(status.equals("X wins") || status.equals("O wins") || status.equals("Draw"))) {
            while (true) {
                int position = game.getCoordinates();
                if (tempArray[position].equals("_")) {
                    tempArray[position] = player % 2 == 0 ? "X" : "O";
                    player++;
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
            game.transformArray();
            game.printResult();
            status = game.checkStatus();
            System.out.println(status);
        }
        //System.out.println("End.");



    }
}
