import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory extends GUI{
    static ArrayList<String> inventory = new ArrayList<>();
    static String item;
   // static boolean isNumeric;
   // public static String item;
   // public static int [] amount = new int[5];

    // Create an ArrayList that holds references to String
    public static void inventory() {
        boolean isNumeric = false;



//TODO: Rework inventory to work with GUI

        System.out.println("\nYou found " + item);

//        if (Location.inventory.contains(item)) {
//            Location.inventory.indexOf(item);
//            item = item + amount[Location.inventory.indexOf(item)] + 1;
//            System.out.println(item);
//        }


        if (inventory.size() > 5) {
            System.out.println("But your inventory is full.\nPlease replace item in chosen slot:\n");
            for (int i = 0; i < 5; i++) {
                System.out.println("Slot " + i + " " + inventory.get(i));
            }

            Scanner choice = new Scanner(System.in);

            while (!isNumeric)
                try {
                    int replace = choice.nextInt();
                    isNumeric = true;  //numeric value entered, so it breaks the while loop
                    while (replace > 4) {
                        System.err.println("Invalid slot");
                        replace = choice.nextInt();
                    }

                    if (replace <= 4) {
                        System.out.println("[" + inventory.get(replace) + "]" + " was removed from your inventory\n" +
                                "and replaced with " + "[" + item + "]\n");
                        inventory.set(replace, item);
                        inventory.remove(5);
                        // prints out inventory if full
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Slot " + i + " " + inventory.get(i));
                        }
                    }
//if input is not a number it gets caught and is run through IME and sets isNumeric to false so the while loop can try again

                } catch (InputMismatchException ime) {
                    System.err.println("Invalid input");
                    isNumeric = false;
                    choice.nextLine();
                }
        }
    }
}



