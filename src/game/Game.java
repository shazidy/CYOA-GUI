package game;

import story.*;

/** dialogue and story-text work as follow: if the symbol ► is at the start of either dialogue or story, it will not be
 * the starting text, but the second. to go from one dialogue to another mark the end by \n. to change from dialogue to
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
        ui.choicePromt();
        ui.noteViewer();
        ui.info();
        ui.options();
        ui.mainArea();
        ui.singleUse();
        ui.choicePanel();
        ui.nextButton();
        ui.dialogue();
        ui.returnPanel();
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



