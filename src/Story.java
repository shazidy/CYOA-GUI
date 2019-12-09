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
                "> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et" +
                " dolore magna aliqua. Egestas egestas fringilla phasellus faucibus scelerisque. Sit amet consectetur" +
                " adipiscing elit. Pellentesque massa placerat duis ultricies lacus sed." +
                "\n> " +
                "At imperdiet dui accumsan sit" +
                " amet nulla facilisi. Nisi lacus sed viverra tellus. Sagittis orci a scelerisque purus semper eget" +
                " duis. Dignissim convallis aenean et tortor at risus. Proin fermentum leo vel orci porta non." +
                "\n> " +
                " Risus viverra adipiscing at in tellus integer feugiat. Donec pretium vulputate sapien nec sagittis" +
                " aliquam. Morbi tristique senectus et netus et malesuada. Dui nunc mattis enim ut. Aliquet risus feugiat" +
                " in ante metus dictum at tempor commodo. Tempor commodo ullamcorper a lacus vestibulum sed arcu non." +
                " Nibh venenatis cras sed felis eget velit aliquet." +

                " •";

        //dialogue-part of method
        game.dialogueText =
                "► lkjsdkfjlkdsjfijemlkjflksjflskmlksmlkdjvlksmvljkklkfjlkjglkmlkdfj\n" +
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
        game.storyText ="► choice1choi ce1choice1choice1choi ce1ch oice1c hoice1choice1 choi ce1choice14" +
                "choice 1choic e1choi ce1choice1c hoice1c hoice1choi ce1choice1 ch ice1 cho ice1c hoice1choice1" +
                "choice1c hoice1ch oice1c hoice1choi ce1choice1cho ice1choice1cho ice1ch oice1cho ice 1choice1" +
                "\n>" +
                "ksjd fhkjs dhfkksjdf hkjsdh fkksjdfhkj sdhfkk sjdfhkj sdhfk ksjdfhk j sdhfkksjdf hkjsdhfk" +
                "ksjdf hkjsdhfkk sjdfhk jsdhfkks jdfhkj sdhfkk sjdfhkjs dhfkksjdfhkjsdhfk" +
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

    }

    public void choice3() {
        game.storyText = "choice3";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void choice4() {
        game.storyText ="choice4";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void room() {
        game.storyText = "room";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void hall() {
        game.storyText ="hall";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void office() {
        game.storyText = "office";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void kitchen() {
        game.storyText = "kitchen";
        game.dialogueText = "•\n";
        game.prepareText();

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

