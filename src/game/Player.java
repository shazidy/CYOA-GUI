package game;

public class Player {

    public static int
            HP = 10,
            maxHP = 200;

    public static void status(){
        if (HP >= maxHP) {HP = maxHP;}
        UI.singleTextArea.setText("Health: " + HP + " / " + maxHP);


    }
}
