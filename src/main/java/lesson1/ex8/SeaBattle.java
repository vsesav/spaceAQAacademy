package lesson1.ex8;

import java.util.Random;

public class SeaBattle {
    String[][] ground = new String[10][10];
    String oneDeckOfTheShip = " ■ ";

    public SeaBattle() {
        initialization(ground);

        randomShipCreating(1);
        randomShipCreating(1);
        randomShipCreating(1);
        randomShipCreating(1);

        randomShipCreating(2);
        randomShipCreating(2);
        randomShipCreating(2);

        randomShipCreating(3);
        randomShipCreating(3);

        randomShipCreating(4);

    }

    // Создание поля морского боя
    private void initialization(String[][] array ) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                array[i][j] = " • ";

            }
        }
    }

    //  Вывод поля морского боя
    public void printGround() {
        for (int i = 0; i < ground.length; i++) {

            for (int j = 0; j < ground.length; j++) {

                System.out.print(ground[i][j]);
            }

            System.out.println();
        }
    }

    // Рандомное добавление горизонтально расположенного коробля заданного размера
    private void horizontal(int shipSize) {
        int x = rnd(0, 9);
        int y = rnd(0, 9);

        if (horizontalVerification(x, y,shipSize)) {
            horizontal(shipSize);
        } else {
            for (int i = 0; i < shipSize; i++) {
                ground[y][x + i]  = oneDeckOfTheShip;
            }
        }
    }

    // Рандомное добавление вертикально расположенного коробля заданного размера
    private void vertical(int shipSize) {
        int x = rnd(0, 9);
        int y = rnd(0, 9);

        if (verticalVerification(x, y, shipSize)) {
            vertical(shipSize);
        } else {
            for (int i = 0; i < shipSize; i++) {
                ground[y + i][x]  = oneDeckOfTheShip;
            }
        }
    }


    // Проверка возможности размещения вертикального корабля с заданными координатами и размером
    private boolean verticalVerification(int x, int y, int shipSize) {
        if ( (y + shipSize - 1 > 9)

                || (y != 0 && ground[y - 1][x].equals(oneDeckOfTheShip))
                || ((y + shipSize < 9) && (ground[y + shipSize][x].equals(oneDeckOfTheShip)))

                || (x != 0 && y != 0 && ground[y - 1][x - 1].equals(oneDeckOfTheShip))
                || (y != 0 && (x < 9) && ground[y - 1][x + 1].equals(oneDeckOfTheShip))
                || ((y + shipSize < 10) && x != 0 && ground[y + shipSize][x - 1].equals(oneDeckOfTheShip))
                || ((y + shipSize < 10) && (x < 9) && ground[y + shipSize][x + 1].equals(oneDeckOfTheShip))) {

            return true;

        } else {

            for (int i = 0; i < shipSize; i++) {
                if ( (ground[y + i][x].equals(oneDeckOfTheShip))

                        || ((x < 9) && ground[y + i][x + 1].equals(oneDeckOfTheShip))

                        || (x != 0 &&  ground[y + i][x - 1].equals(oneDeckOfTheShip))) {
                    return true;

                }
            }
            return false;
        }
    }

    // Проверка возможности размещения горизонтального корабля с заданными координатами и размером
    private boolean horizontalVerification(int x, int y, int shipSize) {
        if ( (x + shipSize - 1 > 9)

                || (x != 0 && ground[y][x - 1].equals(oneDeckOfTheShip))
                || ((x + shipSize < 9) && (ground[y][x + shipSize].equals(oneDeckOfTheShip)))

                || (x != 0 && y != 0 && ground[y - 1][x - 1].equals(oneDeckOfTheShip))
                || (x != 0 && (y < 9) && ground[y + 1][x - 1].equals(oneDeckOfTheShip))
                || ((x + shipSize < 10) && y != 0 && ground[y - 1][x + shipSize].equals(oneDeckOfTheShip))
                || ((x + shipSize < 10) && (y < 9) && ground[y + 1][x + shipSize].equals(oneDeckOfTheShip))) {

            return true;

        } else {

            for (int i = 0; i < shipSize; i++) {
                if ( (ground[y][x + i].equals(oneDeckOfTheShip))

                        || ((y < 9) && ground[y + 1][x + i].equals(oneDeckOfTheShip))

                        || (y != 0 &&  ground[y - 1][x + i].equals(oneDeckOfTheShip))) {
                    return true;

                }
            }
            return false;
        }


    }

    // Создает корабль рандомного направления заданного размера
    private void randomShipCreating(int shipSize) {
        Random random = new Random();
        if (random.nextBoolean()) {
            vertical(shipSize);
        } else {
            horizontal(shipSize);
        }


    }

    // Рандомайзер
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
