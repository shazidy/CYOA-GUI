import javax.swing.*;

public class Tower extends UI{
    public Tower(String s){

start(s);
    }



    public void start(String s) {

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
        chapterLabel.setText("sdfsdfsd");

        if (s.equals("choice1")) {
            choice1(s);
        }
        if (s.equals("choice2")){
            choice2();
        }


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

    public void choice1(String s) {
        mainTextArea.setText("choice1");

        if(s.equals("s")) {
            start(s);
        }
    }
    public void choice2() {
        mainTextArea.setText("choice2");
    }
    public void choice3() {
        mainTextArea.setText("choice3");
    }
    public void choice4() {
        mainTextArea.setText("choice55");
    }


}
