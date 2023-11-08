package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics;


public class DiceSet {


    private static DiceSet instance;

    private DiceSet() {
    }

    public static DiceSet getInstance() {
        if (instance == null) {
            instance = new DiceSet();
        }
        return instance;
    }


    public static byte playDice() {
        byte dice = (byte) ((Math.random() * (6) + 1));

        Drawer.draw(dice);


        return dice;
    }


}
