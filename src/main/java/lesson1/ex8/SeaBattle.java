package lesson1.ex8;

public class SeaBattle<ship> {
    String[][] ground = new String[10][10];
    String oneDeckOfTheShip = " ■ ";


    public void initialization(String[][] array ) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                array[i][j] = " • ";

            }
        }
    }

    public void printArray(String[][] array ) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                System.out.print(array[i][j]);
            }

            System.out.println();
        }
    }

    public void horizontal(int shipSize) {
        int x = rnd(0, 9);
        int y = rnd(0, 9);

        if (horizontalVerification(x, y,shipSize)) {
            horizontal(shipSize);
        } else {
            for (int i = 0; i < shipSize; i++) {
                ground[y][x + i]  = " ■ ";
            }
        }
    }




    public void vertical(int x, int y, int shipSize) {}

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private boolean horizontalVerification(int x, int y, int shipSize) {
        if ( (x + shipSize - 1 > 9)

                || (x != 0 && ground[y][x - 1].equals(" ■ "))
                || ((x + shipSize < 9) && (ground[y][x + shipSize].equals(" ■ ")))

                || (x != 0 && y != 0 && ground[y - 1][x - 1].equals(" ■ "))
                || (x != 0 && (y < 9) && ground[y + 1][x - 1].equals(" ■ "))
                || ((x + shipSize < 9) && y != 0 && ground[y - 1][x + shipSize].equals(" ■ "))
                || ((x + shipSize < 9) && (y < 9) && ground[y + 1][x + shipSize].equals(" ■ "))) {

            return true;

        } else {

            for (int i = 0; i < shipSize; i++) {
                if ( (ground[y][x + i].equals(" ■ "))

                        || ((y < 9) && ground[y + 1][x + i].equals(" ■ "))

                        || (y != 0 &&  ground[y - 1][x + i].equals(" ■ "))) {
                    return true;

                }
            }
            return false;
        }


    }

}
