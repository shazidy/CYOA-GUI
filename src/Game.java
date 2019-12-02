import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    MouseHandler mHandler = new MouseHandler();
    MouseHover mHover = new MouseHover();
    ChoiceHandler cHandler = new ChoiceHandler();
    Characters cp = new Characters();
    UI ui = new UI();
    Story story = new Story(this, ui, cp);
    String nextPosition1, nextPosition2, nextPosition3,
            nextPosition4, nextPosition5, nextPosition6,
            nextPosition7;
    int buttonPosition = 1, i=0;
    String storyText;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){

        ui.createUI(cHandler, mHandler, mHover);
        story.start();
        //ui.window.requestFocus();
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



    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = storyText.toCharArray();
            int ArrayNumber = character.length;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            ui.mainTextArea.append(addedCharacter);

            i++;

            if (i == ArrayNumber) {
                i = 0;
                timer.stop();
            }
        }
    });

    public class MouseHandler implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            timer.stop();
            ui.mainTextArea.setText(storyText);
            i = 0; }
        @Override public void mouseReleased(MouseEvent e){}
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){

        }
    }
    public class MouseHover implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){}
        @Override public void mouseReleased(MouseEvent e){}
        @Override public void mouseEntered(MouseEvent e) {
                Component c = e.getComponent();
                c.setBackground(Color.lightGray); }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.white); }
    }



    public void prepareText(){
        i = 0;
        ui.mainTextArea.setText("");
        timer.start();
    }

    public class KeyHandler implements KeyListener {
        @Override
        public void keyPressed(KeyEvent event){
            switch (event.getKeyCode()){
                case KeyEvent.VK_RIGHT:
                    switch (buttonPosition){
                        case 1 : buttonPosition = 2; break;
                        case 2 : buttonPosition = 3; break;
                        case 3 : buttonPosition = 4; break;
                        case 4 : buttonPosition = 5; break;
                        case 5 : buttonPosition = 6; break;
                        case 6 : buttonPosition = 7; break;
                        case 7 : buttonPosition = 7; break;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    switch (buttonPosition){
                        case 1 : buttonPosition = 1; break;
                        case 2 : buttonPosition = 1; break;
                        case 3 : buttonPosition = 2; break;
                        case 4 : buttonPosition = 3; break;
                        case 5 : buttonPosition = 4; break;
                        case 6 : buttonPosition = 5; break;
                        case 7 : buttonPosition = 6; break;
                    }
                    break;
            }
        }
        @Override
        public void keyReleased (KeyEvent event){
        }
        @Override
        public void keyTyped(KeyEvent event){
        }
    }
}



