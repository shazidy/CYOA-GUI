//When PlayerSetup is called, initial stats are set. These can be altered through getters and setters, which are handled
//by Battle.battleSetup() method or through player actions. Identifiers are set in the PlayerSetups parameters to make
//initialization easier.


public class Player {

    public static int HP, STR, INT, XP;
    public static String name;

    public Player(int HP, int STR, int INT, String name){
        this.HP = HP;
        this.STR = STR;
        this.INT = INT;
        this.name = name;

    }


    //calls for a status of player stats and displays them.
    public static void status() {

        String visual = "█";

        System.out.println("Your Health is: ");
        for (int i = 0; i < Player.HP; i++) {
            System.out.print(visual);
        }
        System.out.println(" " + Player.HP);

//Runs conditions if an of them has reached below 1 (DEAD)
        if (Player.HP < 1 ){
            if (Player.HP <1 ){
                System.out.println(
                        "\nYou body has been punished beyond any reasonable measure. This new world has gotten the better \n" +
                                "of you.\n\nYou are Dead!!!"); }
            System.exit(0);
        }
    }
}




