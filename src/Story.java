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

        ui.chapterText.setText(cp.chapter2);
        ui.chapterPanel.setVisible(false);

        ui.dialoguePicture.setText(cp.maggi);
        ui.dialoguePicture2.setText(cp.hero);
        ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
        ui.legendInfo.setText("<HTML><P align=right>LOCATION<BR/>Room</HTML>");
        //story-part of method
        game.storyText =
                "> once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "\n> " +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "\n> " +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                "once upon a time, there was something something i" +
                " •";

        //dialogue-part of method
        game.dialogueText =
                "lkjsdkfjlkdsjfijemlkjflksjflskmlksmlkdjvlksmvljkklkfjlkjglkmlkdfj\n" +
                "> lksdjflksdjflkjlko isoeohnjlm \n" +
                "> lkjsdlfkjsdijlksdjflksdjflksjdflkdj" +
                " <\n" +
                "> yrteycjyyuifhiuvusfr \n" +
                "> ipwåokvkrælkjlfkgjlm \n" +
                "> lkirmvrirkmlvsr \n" +
                "> åpeoitjbtbmn" +
                " <\n" +
                "> yrteycjyyuifhiuvusfr \n" +
                "> ipwåokvkrælkjlfkgjlm \n" +
                "> lkirmvrirkmlvsr \n" +
                "> åpeoitjbtbmn" +
                " <\n";
        game.prepareText();

        //Choices and their method-calls
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
                "choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1choice1" +
                "\n>";
        game.dialogueText = "> HAllohallo hallo\n" +
                "> HAllohallo hallo\n" +
                "> HAllohallo hallo\n" +
                "> HAllohallo hallo" +
                " •";
        game.prepareText();
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

