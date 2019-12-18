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
    UI ui = new UI();
    Buttons buttons = new Buttons(ui);
    Story story = new Story(this, ui);
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
        ui.choicePanel();
        ui.nextButton();
        ui.dialogue();
        ui.returnButtons();
        ui.window.setVisible(true);

        story.start();
        buttons.buttons();
        //buttonVisibility();
    }

    public void prepareText(){
        ui.choicePanel.setVisible(false);
        buttons.di = 0;
        buttons.i = 0;
        ui.nextPanel.setVisible(false);
        ui.dialogueScrollPane.setVisible(true);
        ui.mainTextArea.setText("");
        ui.dialogueTextArea.setText("");
        buttons.timer.start();
    }
}



