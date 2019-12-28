package story;
import game.*;
import maps.CityMaps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Story {
    CityMaps metro = new CityMaps();
    Conditions conditions = new Conditions();
    Audio audio = new Audio();
    Characters cp = new Characters();
    Notes no = new Notes();

    UI ui;
    public Story(UI userInterface) {
        ui = userInterface;
        //ui.localMap = ;
        ui.globalMap = metro.city;
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
            this.setFont(ui.noteFont);
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
                case "choice2" : ui.singleTextArea.setText("This is single use"); ui.singleUseVisible(); break;
                case "choice3" : new Item("[•]Potia", ui); new Item("[Ξ]Employment-Notice", ui); new Item("[‡]Pants", ui); break; //TODO: access arraylist or do something cleverer
                case "choice4": ui.choicePanel.removeAll(); choice4(); break;
                case "room": room(); this.setEnabled(false); break;
            }
        }
    }
    public void start() {

        new Item("[•]Potion", ui);
        new Item("[•]Potia", ui);
        new Item("[‡]Pants", ui);
        new Item("[Ξ]Employment-Notice", ui);

        //ui.noteText.setText(no.firstNote);
        ui.dialoguePicture.setText(cp.maggi);
        ui.dialoguePicture2.setText(cp.amia);
        //ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
        ui.locationLabel.setText("<HTML>LOCATION<BR/>Room</HTML>");

        /*
        new Dialogue(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et\n" +

                "At imperdiet dui accumsan sit\n" +

                "Risus viverra adipiscing at in tellus integer feugiat. Donec pretium vulputate sapien nec sagittis\n",

                "►\"lkjsdkfjlkdsj fije mlkjfl ksjfl skmlksm lkdjvlk smvljk klk fjlk jglkm lkdfj\"\n" +
                "\"lksdjflksdjflkjlko isoeohnjlm\" \n" +
                "\"lkjsdlfkjsdijlksdjflksdjflksjdflkdj\"\r\n" +

                "\"yrteycjyyuifhiuvusfr\" \n" +
                "\"ipwåokvkrælkjlfkgjlm\" \n" +
                "\"lkirmvrirkmlvsr\" \n" +
                "\"åpeoitjbtbmn\"\r\n" +

                "\"yrteycjyyuifhiuvusfr\" \n" +
                "\"ipwåokvkrælkjlfkgjlm\" \n" +
                "\"lkirmvrirkmlvsr\" \n" +
                "\"åpeoitjbtbmn\"" +
                " •",ui);
         */

        new Choice("FOLLOWEDS", "choice1", ui);
        new Choice("2", "choice2", ui);
        new Choice("3", "choice3", ui);
        new Choice("4", "choice4", ui);
        new Choice("room", "room", ui);
    }

    public void choice1() {

        new Dialogue("► choice1choi ce1choice1choice1choi ce1ch oice1c hoice1choice1 choi ce1choice14" +
                "choice 1choic e1choi ce1choice1c hoice1c hoice1choi ce1choice1 ch ice1 cho ice1c hoice1choice1" +
                "choice1c hoice1ch oice1c hoice1choi ce1choice1cho ice1choice1cho ice1ch oice1cho ice 1choice1\n" +

                "ksjd fhkjs dhfkksjdf hkjsdh fkksjdfhkj sdhfkk sjdfhkj sdhfk ksjdfhk j sdhfkksjdf hkjsdhfk" +
                "ksjdf hkjsdhfkk sjdfhk jsdhfkks jdfhkj sdhfkk sjdfhkjs dhfkksjdfhkjsdhfk •",

                "\"HAllohallo hallo\" \n" +
                "\"HAllohallo hallo\" \r\n" +

                "\"HAllohallo hallo\" \n" +
                "\"HAllohallo hallo\" \r\n",ui);

    }

    public void choice2() {
        ui.singleTextArea.setText(metro.city);
        ui.singleUseVisible();
    }

    public void choice3() {
        new Item("[•]Potia", ui);
        //ui.noteText.setText(no.firstNote);
        ui.noteVisible();
    }

    public void choice4() {
        new Dialogue("choice4\n","•\n",ui);
        ui.storyText ="choice4•";
        ui.dialogueText = "•\n";
        //game.prepareText();
        new Choice("Hola", "room", ui);

    }

    public void room() {
        ui.storyText = "room•";
        ui.dialogueText = "•\n";
        //game.prepareText();

    }
}

