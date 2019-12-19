package story;
import game.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Story {

    Characters cp = new Characters();
    Notes no = new Notes();
    Game game;
    UI ui;
    public Story(Game g, UI userInterface) {
        game = g;
        ui = userInterface;

    }
    public class Choice extends JButton implements ActionListener, MouseListener {
        UI ui;
        String method;
        public Choice(String text, String methodCall, UI userI) {
            method = methodCall;
            ui = userI;
            this.setText(text);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
            this.setFont(ui.asciiFont);
            this.addActionListener(this::actionPerformed);
            this.setActionCommand("choice");
            this.setFocusPainted(false);
            this.addMouseListener(this);
            this.setBorder(BorderFactory.createLineBorder(Color.black, 4));
            ui.choicePanel.add(this);
            if (this.getText().equals("")) {this.setVisible(false);}
        }
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            Component c = e.getComponent();
            c.setBackground(Color.lightGray); }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.white); }

        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "choice" : selectPosition(method); break;
            }
        }

        public void selectPosition(String nextPosition) {
            switch (nextPosition) {
                case "choice1": ui.choicePanel.removeAll(); choice1(); break;
                case "choice2": choice2(); break;
                case "choice3": choice3(); break;
                case "choice4": ui.choicePanel.removeAll(); choice4(); break;
                case "room": room(); this.setEnabled(false); break;
            }
        }
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

        new Item("•Potion", ui);
        new Item("•Potia", ui);
        new Item("•Potia", ui);
        new Item("•Potion", ui);
        new Item("•Potia", ui);
        new Item("•Potia", ui);
        new Item("•Potion", ui);
        new Item("•Potia", ui);
        /*
        new Item("Potio", ui);
        new Item("Potio", ui);
        new Item("Potion", ui);
        new Item("Potio", ui);
        new Item("Potio", ui);
        new Item("Potion", ui);
        new Item("Potio", ui);
        new Item("Potio", ui);
        new Item("Potion", ui);
        new Item("Potio", ui);
        new Item("Potio", ui);
        new Item("Potion", ui);
        new Item("Potio", ui);
        new Item("Potio", ui);

         */





        //ui.noteText.setText(no.firstNote);
        //game.noteViewer();
        ui.dialoguePicture.setText(cp.maggi);
        ui.dialoguePicture2.setText(cp.hero);
        //ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
        ui.legendInfo.setText("<HTML><P align=right>LOCATION<BR/>Room</HTML>");
        //story-part of method
        ui.storyText =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et\n" +

                "At imperdiet dui accumsan sit\n" +

                "Risus viverra adipiscing at in tellus integer feugiat. Donec pretium vulputate sapien nec sagittis" +
                " •";

        //dialogue-part of method
        ui.dialogueText =
                "► lkjsdkfjlkdsj fije mlkjfl ksjfl skmlksm lkdjvlk smvljk klk fjlk jglkm lkdfj\n" +
                "lksdjflksdjflkjlko isoeohnjlm \n" +
                "lkjsdlfkjsdijlksdjflksdjflksjdflkdj\r" +

                "yrteycjyyuifhiuvusfr \n" +
                "ipwåokvkrælkjlfkgjlm \n" +
                "lkirmvrirkmlvsr \n" +
                "åpeoitjbtbmn\r" +

                "yrteycjyyuifhiuvusfr \n" +
                "ipwåokvkrælkjlfkgjlm \n" +
                "lkirmvrirkmlvsr \n" +
                "åpeoitjbtbmn\r";
        game.prepareText();

        new Choice("FOLLOWEDS", "choice1", ui);
        new Choice("2", "choice2", ui);
        new Choice("3", "choice3", ui);
        new Choice("4", "choice4", ui);
        new Choice("room", "room", ui);
    }

    public void choice1() {
        ui.storyText =
                "► choice1choi ce1choice1choice1choi ce1ch oice1c hoice1choice1 choi ce1choice14" +
                "choice 1choic e1choi ce1choice1c hoice1c hoice1choi ce1choice1 ch ice1 cho ice1c hoice1choice1" +
                "choice1c hoice1ch oice1c hoice1choi ce1choice1cho ice1choice1cho ice1ch oice1cho ice 1choice1\n" +

                "ksjd fhkjs dhfkksjdf hkjsdh fkksjdfhkj sdhfkk sjdfhkj sdhfk ksjdfhk j sdhfkksjdf hkjsdhfk" +
                "ksjdf hkjsdhfkk sjdfhk jsdhfkks jdfhkj sdhfkk sjdfhkjs dhfkksjdfhkjsdhfk •";
        ui.dialogueText =
                "HAllohallo hallo\n" +
                "HAllohallo hallo\r" +
                "HAllohallo hallo\n" +
                "HAllohallo hallo\r";

        game.prepareText();
    }

    public void choice2() {
        ui.singleTextArea.setText("this is single use");
        ui.singleUseVisible();
    }

    public void choice3() {
        new Item("•Potia", ui);
        ui.noteText.setText(no.firstNote);
        ui.noteVisible();
    }

    public void choice4() {
        ui.storyText ="choice4•";
        ui.dialogueText = "•\n";
        game.prepareText();
        new Choice("Hola", "room", ui);

    }

    public void room() {
        ui.storyText = "room•";
        ui.dialogueText = "•\n";
        game.prepareText();

    }
}

