package lesson1.ex8;

public class Main {
    public static void main(String[] args) {
        SeaBattle sea = new SeaBattle();
        sea.initialization(sea.ground);

        sea.horizontal(1);
        sea.horizontal(1);
        sea.horizontal(1);
        sea.horizontal(1);

        sea.horizontal(2);
        sea.horizontal(2);
        sea.horizontal(2);

        sea.horizontal(3);
        sea.horizontal(3);

        sea.horizontal(4);


        sea.printArray(sea.ground);

    }
}
