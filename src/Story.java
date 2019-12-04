public class Story {
    Game game;
    UI ui;
    Characters cp;

    public Story(Game g, UI userInterface, Characters cPict) {
        game = g;
        ui = userInterface;
        cp = cPict;
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
        game.storyText = "once upon a time, there was something something in the month of may" +
                "once upon a time, there was something something in the month of may" +
                "once upon a time, there was something something in the month of may" +
                "once upon a time, there was something something in the month of may" +
                "once upon a time, there was something something in the month of may" +
                "once upon a time, there was something something in the month of may" +
                "";
        game.prepareText();
        ui.chapterLabel.setText("sdfsdfsd");
        //ui.dialogueTextArea.setText("dfdfgdfg\nsdfsdffsd\nsdfdsfds\nsdfdsfsdf\nskdjfhksdj\nskdjfsdjk\nsjfhksdjf");
        game.dialogueText = "lkjsdkfjlkdsjfijemlkjflksjflskmlksmlkdjvlksmvljkklkfjlkjglkmlkdfj•\n" +
                "lksdjflksdjflkjlko isoeohnjlm •\n" +
                "lkjsdlfkjsdijlksdjflksdjflksjdflkdj •\n";
        game.prepareDialogue();

        //Choices and their
        ui.choice1.setText("FOLLOW"); game.nextPosition1 = "choice1";
        ui.choice2.setText("2"); game.nextPosition2 = "choice2";
        ui.choice3.setText("3"); game.nextPosition3 = "choice3";
        ui.choice4.setText("4"); game.nextPosition4 = "choice4";
        ui.choice5.setText("room"); game.nextPosition5 = "room";
        ui.choice6.setText(""); game.nextPosition6 = "";
        ui.choice7.setText(""); game.nextPosition7 = "";

    }

    public void choice1() {
        game.storyText ="choice1choice1choice1choice1choice1choice1choice1choice1choice1choice14" +
                "choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1" +
                "choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1";
        game.dialogueText = "HAllohallo hallo•\n" +
                "HAllohallo hallo•\n" +
                "HAllohallo hallo•\n" +
                "HAllohallo hallo•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void choice2() {
        game.storyText = "...";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void choice3() {
        game.storyText = "choice3";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void choice4() {
        game.storyText ="choice4";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void room() {
        game.storyText = "room";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void hall() {
        game.storyText ="hall";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void office() {
        game.storyText = "office";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void kitchen() {
        game.storyText = "kitchen";
        game.dialogueText = "•\n";
        game.prepareText();
        game.prepareDialogue();
    }

    public void selecPosition(String nextPosition) {
        switch (nextPosition) {
            case "choice1": choice1(); break;
            case "choice2": choice2(); break;
            case "choice3": choice3(); break;
            case "choice4": choice4(); break;
            case "room": room(); break;
        }
    }
}

