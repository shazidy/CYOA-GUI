import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class Tower extends GUI {




    public void start(){
chapterText.setText("_________   ___ ___    _____ __________________________________________  .___.___  \n" +
        "\\_   ___ \\ /   |   \\  /  _  \\\\______   \\__    ___/\\_   _____/\\______   \\ |   |   | \n" +
        "/    \\  \\//    ~    \\/  /_\\  \\|     ___/ |    |    |    __)_  |       _/ |   |   | \n" +
        "\\     \\___\\    Y    /    |    \\    |     |    |    |        \\ |    |   \\ |   |   | \n" +
        " \\______  /\\___|_  /\\____|__  /____|     |____|   /_______  / |____|_  / |___|___| \n" +
        "        \\/       \\/         \\/                            \\/         \\/            \n" +
        "______________ ______________ ___________________  __      _______________________ \n" +
        "\\__    ___/   |   \\_   _____/ \\__    ___/\\_____  \\/  \\    /  \\_   _____/\\______   \\\n" +
        "  |    | /    ~    \\    __)_    |    |    /   |   \\   \\/\\/   /|    __)_  |       _/\n" +
        "  |    | \\    Y    /        \\   |    |   /    |    \\        / |        \\ |    |   \\\n" +
        "  |____|  \\___|_  /_______  /   |____|   \\_______  /\\__/\\  / /_______  / |____|_  /\n" +
        "                \\/        \\/                     \\/      \\/          \\/         \\/ ");

chapterPanel.setVisible(false);

        dialoguePicture.setText(Characters.maggi);
        dialoguePicture2.setText(Characters.hero);
        mainTextArea.setText("once upon a time");
        GUI.chapterLabel.setText("sdfsdfsd");




        //dialogueTextArea.setText(charPict.hero);
        /*
        Inventory.inventory.add(Inventory.item = "Rusty Knife");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "Crap");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "More Crap");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "ugly shit");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "stupid hoe");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "kage");
        Inventory.inventory();

        Inventory.inventory.add(Inventory.item = "kage234");
        Inventory.inventory();

         */

        //Player player = new Player(15,15, 10);
        //player.HP += 3;
        //Enemy enemy = new Enemy("Duck", 30,2,2,10,"Dagger", "SuperDead");
        //Battle.battleSetup();
    }
    public void method(){
mainTextArea.setText("sdfsdfsdfsfdsfs");
    }

}
