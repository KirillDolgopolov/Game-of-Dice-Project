package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics;

public class Drawer {
    private static String one = (" ------- \n" +
            "|       |\n" +
            "|   ●   |\n" +
            "|       |\n" +
            " ------- ");


    private static String two = (" ------- \n" +
            "| ●     |\n" +
            "|       |\n" +
            "|     ● |\n" +
            " ------- ");
    private static String three = (" ------- \n" +
            "| ●     |\n" +
            "|   ●   |\n" +
            "|     ● |\n" +
            " ------- ");
    private static String four = (" ------- \n" +
            "| ●   ● |\n" +
            "|       |\n" +
            "| ●   ● |\n" +
            " ------- ");

    private static String five = (" ------- \n" +
            "| ●   ● |\n" +
            "|   ●   |\n" +
            "| ●   ● |\n" +
            " ------- ");
 private static String six = (" ------- \n" +
            "| ●   ● |\n" +
            "| ●   ● |\n" +
            "| ●   ● |\n" +
            " ------- ");

 public static void draw (int dice) {
     switch (dice) {
         case 1 -> {
             System.out.println(one);
             System.out.println();
         }
         case 2 -> {
             System.out.println(two);
             System.out.println();
         }
         case 3 -> {
             System.out.println(three);
             System.out.println();
         }
         case 4 -> {
             System.out.println(four);
             System.out.println();
         }
         case 5 -> {
             System.out.println(five);
             System.out.println();
         }
         case 6 -> {
             System.out.println(six);
             System.out.println();
         }
     }
 }

}
