/*

//Behavior of battle once initiated. Alters stats for player and enemy accordingly and sets conditions when threshold is reached.
//the try/catch for inputmismatch wasn't fixed in time. Type only A, B or C

import game.Player;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    //    static PlayerSetup playerSetup;
//    static EnemySetup enemySetup;
    private static String choice;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    //A lower bound for giving enemy damage ...
//could be placed as a stat in playerSetup
// (would actually give more sense)
    private static int lowerBound = 5;
    private static boolean isABC;


    public static void battleSetup() {

        Player.status();
        Enemy.status();

        System.out.println("\nYou engage the enemy: " + Enemy.name);


        // this is just a bunch of numbers being crunched
        isABC = false; // ensures more battles can be instantiated in the same methods
        while (Enemy.HP > 0 && !isABC) {
            System.out.println(
                    "\n(A) Attack\n(B) Block\n(C) Evade");
            choice = scanner.nextLine();
            if (choice.equals("A")) {
                Player.HP -= random.nextInt(Enemy.ATK * 2);
                Enemy.HP -= lowerBound - (Player.STR / 3)
                        + (random.nextInt(Player.STR) / 2)
                        + random.nextInt(Enemy.DEF);
            }
            if (choice.equals("B")) {
                Player.HP -= random.nextInt(Enemy.ATK);
                Enemy.HP -= random.nextInt(Player.INT / 2);
            } else if (choice.equals("B") && Player.INT < 5) {
                Player.HP -= random.nextInt(Enemy.ATK);
                Enemy.HP -= lowerBound * Player.INT
                        + random.nextInt(Player.INT * Player.STR);

            }
            if (choice.equals("C")) {
                Player.HP -= random.nextInt(Enemy.ATK / 2);
                Enemy.HP -= lowerBound
                        + random.nextInt(Player.INT * 2);
            }

            System.out.println();
            Player.status();
            Enemy.status();
        }
    }
}

 */


