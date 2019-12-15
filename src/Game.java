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


    UI ui = new UI(this);
    Characters cp = new Characters();
    Notes no = new Notes(ui);
    Items items = new Items(ui);
    ChoiceHandler cHandler = new ChoiceHandler();
    int i=0, di = 0, iLength = 0;

    String nextPosition1, nextPosition2, nextPosition3,
    nextPosition4, nextPosition5, nextPosition6,
    nextPosition7, storyText, dialogueText;

    public static void main(String[] args) {
        new UI(new Game());
    }

    public Game(){
        ui.choiceButtons(cHandler);
        story.start();
        ui.window.setVisible(true);
        buttonVisibility();
        items.check();
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
                dTimer.start();
                ui.dialogueScrollPane.setVisible(true);
                ui.nextPanel.setVisible(true);
            }
            if (addedCharacter.equals("•")) {
                timer.stop();
                dTimer.stop();
                i = 0;
                ui.nextPanel.setVisible(false);
                ui.choicePanel.setVisible(true);
            }
        }
    });
    Timer dTimer = new Timer(10, new ActionListener() {
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
                dTimer.stop();
            }

            if (addedCharacter.equals("<")) {
                dTimer.stop();
                ui.nextPanel.setVisible(false);
                if (iLength != i)
                timer.start();
            }
            if (addedCharacter.equals("•")){
                dTimer.stop();
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
    }
    public void singleUse(){
        ui.mainScrollPane.setVisible(false);
        ui.singleScrollPane.setVisible(true);
        ui.choicePanel.setVisible(false);
        ui.nextPanel.setVisible(false);
        ui.returnPanel.setVisible(true);
    }


    Story story = new Story(this, ui, cp, no, items);
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



