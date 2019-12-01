

public class Story{
    Game game;
    UI ui;
    Characters cp;


    public Story(Game g, UI userInterface, Characters cPict){
        game = g;
        ui = userInterface;
        cp = cPict;

    }

    public void selecPosition(String nextPosition){
        switch (nextPosition){
            case "choice1" : choice1(); break;
            case "choice2" : choice2(); break;
            case "choice3" : choice3(); break;
            case "choice4" : choice4(); break;
            case "room" : room(); break;
        }

    }


    public void start() {

        ui.chapterText.setText("_________   ___ ___    _____ __________________________________________  .___.___  \n" +
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

        ui.chapterPanel.setVisible(false);

        ui.dialoguePicture.setText(cp.maggi);
        ui.dialoguePicture2.setText(cp.hero);
        ui.mainTextArea.setText("once upon a time");
        ui.chapterLabel.setText("sdfsdfsd");

        ui.choice1.setText("1");
        ui.choice2.setText("2");
        ui.choice3.setText("3");
        ui.choice4.setText("4");
        ui.choice5.setText("room");
        ui.choice6.setText("");
        ui.choice7.setText("");

        game.nextPosition1 = "choice1";
        game.nextPosition2 = "choice2";
        game.nextPosition3 = "choice3";
        game.nextPosition4 = "choice4";
        game.nextPosition5 = "room";
        game.nextPosition6 = "";
        game.nextPosition7 = "";


    }

    public void choice1() {
        ui.mainTextArea.setText("choice1");
    }
    public void choice2() {
        ui.mainTextArea.setText("choice2");
    }
    public void choice3() {
        ui.mainTextArea.setText("choice3");
    }
    public void choice4() {
        ui.mainTextArea.setText("choice55");
    }
    public void room() {
        ui.mainTextArea.setText("room");
    }
    public void hall() {
        ui.mainTextArea.setText("hall");
    }
    public void office() {
        ui.mainTextArea.setText("office");
    }
    public void kitchen() {
        ui.mainTextArea.setText("kitchen");
    }




}