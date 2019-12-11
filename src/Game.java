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

    MouseHover mHover = new MouseHover();
    MouseTimer mTimer = new MouseTimer();
    ChoiceHandler cHandler = new ChoiceHandler();
    Characters cp = new Characters();
    UI ui = new UI();
    Story story = new Story(this, ui, cp);

    int i=0, di = 0, iLength = 0;
    String nextPosition1, nextPosition2, nextPosition3,
    nextPosition4, nextPosition5, nextPosition6,
    nextPosition7, storyText, dialogueText;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        ui.createUI(cHandler, mHover, mTimer);
        story.start();
    }

// typewriter text for story that switches to dialogue when needed
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
                ui.dialogueTextPanel.setVisible(true);
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
// typewriter text for dialogue that switches to story when needed
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
// resets the values for the text to start from scratch

    public void singleUse(){
        ui.mainScrollPane.setVisible(false);
        ui.singleScrollPane.setVisible(true);
        storyText ="•";
        dialogueText ="•";
        prepareText();
        //TODO: set return button visible that reverses visibility
    }
    public void prepareText(){
        ui.choicePanel.setVisible(false);
        di = 0;
        i = 0;
        ui.nextPanel.setVisible(false);
        ui.dialogueTextPanel.setVisible(true);
        ui.mainTextArea.setText("");
        ui.dialogueTextArea.setText("");
        timer.start();
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
    public class MouseTimer implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            dtimer.start();
        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }


    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "c1" : selecPosition(nextPosition1); break;
                case "c2" : selecPosition(nextPosition2); break;
                case "c3" : selecPosition(nextPosition3); break;
                case "c4" : selecPosition(nextPosition4); break;
                case "c5" : selecPosition(nextPosition5); break;
                case "c6" : selecPosition(nextPosition6); break;
                case "c7" : selecPosition(nextPosition7); break;
            }
        }
        public void selecPosition(String nextPosition) {
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



