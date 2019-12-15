public class Story {
    Game game;
    UI ui;
    Characters cp;
    Notes no;
    Items items;

    public Story(Game g, UI userInterface, Characters cPict, Notes notes, Items item) {
        game = g;
        ui = userInterface;
        cp = cPict;
        no = notes;
        items = item;
    }
/* Template
    game.storyText =
            "> " +
            "\n> " +
            "" +
            "\n> " +
            "" +
            " •";
    game.dialogueText =
            "► " +
            "> " +
            " <\n" +
            "> " +
            "> " +
            " <\n";
 */

    public void start() {

        //ui.noteText.setText(no.firstNote);
        //game.noteViewer();
        /*
        game.playerItem[0] = "Potion";
        game.playerItem[1] = "";
        game.playerItem[2] = "";
        game.playerItem[3] = "";
        game.playerItem[4] = "";

         */

        ui.dialoguePicture.setText(cp.maggi);
        ui.dialoguePicture2.setText(cp.hero);
        //ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
        ui.legendInfo.setText("<HTML><P align=right>LOCATION<BR/>Room</HTML>");
        //story-part of method
        game.storyText =
                "> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et" +

                "\n> " +
                "At imperdiet dui accumsan sit" +

                "\n> " +
                " Risus viverra adipiscing at in tellus integer feugiat. Donec pretium vulputate sapien nec sagittis" +

                " •";

        //dialogue-part of method
        game.dialogueText =
                "► lkjsdkfjlkdsj fije mlkjfl ksjfl skmlksm lkdjvlk smvljk klk fjlk jglkm lkdfj\n" +
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
        ui.singleTextArea.setText("this is single use");
        game.singleUse();

       // ui.optionPanel.remove();
        

    }

    public void choice3() {
        ui.noteText.setText(no.firstNote);
        game.noteViewer();
    }

    public void choice4() {
        game.storyText ="choice4•";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void room() {
        game.storyText = "room•";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void hall() {
        game.storyText ="hall•";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void office() {
        game.storyText = "office•";
        game.dialogueText = "•\n";
        game.prepareText();

    }

    public void kitchen() {
        game.storyText = "kitchen•";
        game.dialogueText = "•\n";
        game.prepareText();

    }


}

