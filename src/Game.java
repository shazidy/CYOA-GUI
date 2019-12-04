import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {

    MouseHandler mHandler = new MouseHandler();
    MouseHover mHover = new MouseHover();
    MouseTimer mTimer = new MouseTimer();
    ChoiceHandler cHandler = new ChoiceHandler();
    Characters cp = new Characters();

    UI ui = new UI();

    int i=0, di = 0, iLength = 0;
    String nextPosition1, nextPosition2, nextPosition3,
    nextPosition4, nextPosition5, nextPosition6,
    nextPosition7, storyText, dialogueText;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        ui.createUI(cHandler, mHandler, mHover, mTimer);
        story.start();
        //tower.start();
    }
    Story story = new Story(this, ui, cp);

    Timer timer = new Timer(10, new ActionListener() {
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

            if (i == ArrayNumber) {
                ui.nextPanel.setVisible(true);
                ui.dialogueTextPanel.setVisible(true);
                i = 0;
                timer.stop();
            }
        }
    });
//TODO: somehow make the dialoguetext appear only when all the storytext has :S
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

                if (addedCharacter.equals("•")) {
                    dtimer.stop();
                }
                if (di == ArrayNumber) {
                    ui.nextPanel.setVisible(false);
                    ui.dialogueTextArea.setText(dialogueText);
                    di = 0;
                    dtimer.stop();
                }
            }
    });

    public void prepareDialogue(){
        di = 0;
        ui.dialogueTextArea.setText("");
        dtimer.start();
    }

    public void prepareText(){
        ui.nextPanel.setVisible(false);
        ui.dialogueTextPanel.setVisible(false);
        i = 0;
        ui.mainTextArea.setText("");
        timer.start();
    }

    public class MouseHandler implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            timer.stop();
            ui.mainTextArea.setText(storyText);
            i = 0;
            ui.dialogueTextPanel.setVisible(true);
            ui.nextPanel.setVisible(true);
        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
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
                case "c1" : story.selecPosition(nextPosition1); break;
                case "c2" : story.selecPosition(nextPosition2); break;
                case "c3" : story.selecPosition(nextPosition3); break;
                case "c4" : story.selecPosition(nextPosition4); break;
                case "c5" : story.selecPosition(nextPosition5); break;
                case "c6" : story.selecPosition(nextPosition6); break;
                case "c7" : story.selecPosition(nextPosition7); break;
            }
        }
    }
}



