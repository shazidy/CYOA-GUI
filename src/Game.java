import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** dialogue and story-text work as follow: the one preceding the other does not have the symbol ">" in front of its
 * first paragraph. IF dialogue comes before story, story has the symbol ">" in front of its first entry and dialogue
 * has the symbol "►". To reset both dialogue and story, put the symbol "•" at the end of either. If there is more
 * story at the end of a piece of dialogue mark the break by using the symbol"<" at the end of the dialogue paragraph
 * to switch to more story. If there is more dialogue after af story-paragraph, mark it with the symbol ">".
 *
 */

public class Game {

    ItemHover iHover = new ItemHover();
    MouseHover mHover = new MouseHover();
    MouseTimer mTimer = new MouseTimer();
    returnClick rClick = new returnClick();
    InventoryHandler iHandler = new InventoryHandler();
    ChoiceHandler cHandler = new ChoiceHandler();
    Characters cp = new Characters();
    UI ui = new UI();
    Story story = new Story(this, ui, cp);
    Items items = new Items(this, ui);
    int i=0, di = 0, iLength = 0;
    String[] playerItem = new String[10];

    String nextPosition1, nextPosition2, nextPosition3,
    nextPosition4, nextPosition5, nextPosition6,
    nextPosition7, storyText, dialogueText;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        ui.createUI();
        ui.noteViewer();
        ui.info();
        ui.options();
        ui.mainArea();
        ui.singleUse();
        ui.choiceButtons(cHandler, mHover);
        ui.nextButton(mHover, mTimer);
        ui.inventory(iHandler, iHover);
        ui.dialogue();
        ui.returnButtons(mHover, rClick);
        story.start();
        buttonVisibility();
        ui.window.setVisible(true);
    }


    Timer timer = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = storyText.toCharArray();
            int ArrayNumber = character.length;
            iLength = ArrayNumber;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            ui.mainTextArea.append(addedCharacter);

            i++;
            if (addedCharacter.equals(">")) {
                timer.stop();
                dtimer.start();
                ui.dialogueScrollPane.setVisible(true);
                ui.nextPanel.setVisible(true);
            }
            if (addedCharacter.equals("•")) {
                timer.stop();
                dtimer.stop();
                i = 0;
                ui.nextPanel.setVisible(false);
                ui.choicePanel.setVisible(true);
            }
        }
    });
    Timer dtimer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                char character[] = dialogueText.toCharArray();
                int ArrayNumber = character.length;

                String addedCharacter = "";
                String blank = "";

                addedCharacter = blank + character[di];
                ui.dialogueTextArea.append(addedCharacter);

                di++;

            if (addedCharacter.equals(">")) {
                dtimer.stop();
            }

            if (addedCharacter.equals("<")) {
                dtimer.stop();
                ui.nextPanel.setVisible(false);
                if (iLength != i)
                timer.start();
            }
            if (addedCharacter.equals("•")){
                dtimer.stop();
                timer.stop();
                ui.nextPanel.setVisible(false);
                ui.choicePanel.setVisible(true);
            }
        }
    });

    public void prepareText(){
        ui.choicePanel.setVisible(false);
        di = 0;
        i = 0;
        ui.nextPanel.setVisible(false);
        ui.dialogueScrollPane.setVisible(true);
        ui.mainTextArea.setText("");
        ui.dialogueTextArea.setText("");
        timer.start();
    }
    public void buttonVisibility(){
        if (ui.choice1.getText().equals("")){ ui.choice1.setVisible(false); }
        if (ui.choice2.getText().equals("")){ ui.choice2.setVisible(false); }
        if (ui.choice3.getText().equals("")){ ui.choice3.setVisible(false); }
        if (ui.choice4.getText().equals("")){ ui.choice4.setVisible(false); }
        if (ui.choice5.getText().equals("")){ ui.choice5.setVisible(false); }
        if (ui.choice6.getText().equals("")){ ui.choice6.setVisible(false); }
        if (ui.choice7.getText().equals("")){ ui.choice7.setVisible(false); }
        ui.item0.setText(playerItem[0]);
        ui.item1.setText(playerItem[1]);
        ui.item2.setText(playerItem[2]);
        ui.item3.setText(playerItem[3]);
        ui.item4.setText(playerItem[4]);
        ui.item5.setText(playerItem[5]);
        ui.item6.setText(playerItem[6]);
        ui.item7.setText(playerItem[7]);
        ui.item8.setText(playerItem[8]);
        ui.item9.setText(playerItem[9]);
        if (ui.item0.getText().equals("")){ ui.item0.setVisible(false); }
        if (ui.item1.getText().equals("")){ ui.item1.setVisible(false); }
        if (ui.item2.getText().equals("")){ ui.item2.setVisible(false); }
        if (ui.item3.getText().equals("")){ ui.item3.setVisible(false); }
        if (ui.item4.getText().equals("")){ ui.item4.setVisible(false); }
        if (ui.item5.getText().equals("")){ ui.item5.setVisible(false); }
        if (ui.item6.getText().equals("")){ ui.item6.setVisible(false); }
        if (ui.item7.getText().equals("")){ ui.item7.setVisible(false); }
        if (ui.item8.getText().equals("")){ ui.item8.setVisible(false); }
        if (ui.item9.getText().equals("")){ ui.item9.setVisible(false); }







    }
    public void singleUse(){
        ui.mainScrollPane.setVisible(false);
        ui.singleScrollPane.setVisible(true);
        ui.choicePanel.setVisible(false);
        ui.nextPanel.setVisible(false);
        ui.returnPanel.setVisible(true);
        //TODO: set return button visible that reverses visibility
    }
    public void noteViewer(){
        ui.notePanel.setVisible(true);
        ui.choicePanel.setVisible(false);
        ui.returnPanel.setVisible(false);
        ui.nextPanel.setVisible(false);
        ui.dialogueScrollPane.getVerticalScrollBar().setEnabled(false);
        ui.dialogueScrollPane.setWheelScrollingEnabled(false);
        ui.mainScrollPane.getVerticalScrollBar().setEnabled(false);
        ui.mainScrollPane.setWheelScrollingEnabled(false);
        //ui.optionScrollPane.getVerticalScrollBar().setEnabled(false);
        //ui.optionScrollPane.setWheelScrollingEnabled(false);

    }
    public class MouseHover implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
                 Component c = e.getComponent();
                 c.setBackground(Color.lightGray); }
        @Override public void mouseExited(MouseEvent e){
                 Component c = e.getComponent();
                 c.setBackground(Color.white); }
    }
    public class ItemHover implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            //if (!ui.notePanel.isVisible()){
            Component c = e.getComponent();
            c.setBackground(Color.lightGray); }
        //}
        @Override public void mouseExited(MouseEvent e){
            //if (!ui.notePanel.isVisible()){
            Component c = e.getComponent();
            c.setBackground(Color.darkGray); }
        //}
    }
    public class MouseTimer implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            dtimer.start();
        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }
    public class returnClick implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            ui.returnPanel.setVisible(false);
            ui.choicePanel.setVisible(true);
            ui.singleScrollPane.setVisible(false);
            ui.notePanel.setVisible(false);
            ui.mainScrollPane.setVisible(true);
            ui.dialogueScrollPane.getVerticalScrollBar().setEnabled(true);
            ui.dialogueScrollPane.setWheelScrollingEnabled(true);
            ui.mainScrollPane.getVerticalScrollBar().setEnabled(true);
            ui.mainScrollPane.setWheelScrollingEnabled(true);
            //ui.optionScrollPane.getVerticalScrollBar().setEnabled(true);
            //ui.optionScrollPane.setWheelScrollingEnabled(true);

        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }
    public class InventoryHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "item0" : items.itemUsed(0); break;
                case "item1" : items.itemUsed(1); break;
                case "item2" : items.itemUsed(2); break;
                case "item3" : items.itemUsed(3); break;
                case "item4" : items.itemUsed(4); break;
                case "item5" : items.itemUsed(5); break;
                case "item6" : items.itemUsed(6); break;
                case "item7" : items.itemUsed(7); break;
                case "item8" : items.itemUsed(8); break;
                case "item9" : items.itemUsed(9); break;
            }
        }

    } //has all inventory effects in Items
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "c1" : selectPosition(nextPosition1); break;
                case "c2" : selectPosition(nextPosition2); break;
                case "c3" : selectPosition(nextPosition3); break;
                case "c4" : selectPosition(nextPosition4); break;
                case "c5" : selectPosition(nextPosition5); break;
                case "c6" : selectPosition(nextPosition6); break;
                case "c7" : selectPosition(nextPosition7); break;
            }
        }
        public void selectPosition(String nextPosition) {
            switch (nextPosition) {
                case "choice1": story.choice1(); break;
                case "choice2": story.choice2(); break;
                case "choice3": story.choice3(); break;
                case "choice4": story.choice4(); break;
                case "room": story.room(); break;
            }
        }
    }
}



