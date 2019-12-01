import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Game {
    ChoiceHandler cHandler = new ChoiceHandler();
    KeyHandler kHandler = new KeyHandler();
    Characters cp = new Characters();
    UI ui = new UI();
    Story story = new Story(this, ui, cp);
    String nextPosition1, nextPosition2, nextPosition3,
            nextPosition4, nextPosition5, nextPosition6,
            nextPosition7;
    int buttonPosition = 1;

    public static void main(String[] args) {
        new Game();
    }

    public Game(){

        ui.createUI(cHandler, kHandler);
        story.start();
        ui.window.requestFocus();
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
            buttonHighlight();
        }
        @Override
        public void keyReleased (KeyEvent event){

        }
        @Override
        public void keyTyped(KeyEvent event){

        }
    }

    public void buttonHighlight(){
        switch (buttonPosition){
            case 1 :
                ui.window.getRootPane().setDefaultButton(ui.choice1);
                ui.choice1.setBackground(Color.white);
                ui.choice1.setForeground(Color.black);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 2 :
                ui.window.getRootPane().setDefaultButton(ui.choice2);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.white);
                ui.choice2.setForeground(Color.black);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 3 :
                ui.window.getRootPane().setDefaultButton(ui.choice3);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.white);
                ui.choice3.setForeground(Color.black);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 4 :
                ui.window.getRootPane().setDefaultButton(ui.choice4);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.white);
                ui.choice4.setForeground(Color.black);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 5 :
                ui.window.getRootPane().setDefaultButton(ui.choice5);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.white);
                ui.choice5.setForeground(Color.black);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 6 :
                ui.window.getRootPane().setDefaultButton(ui.choice6);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.white);
                ui.choice6.setForeground(Color.black);
                ui.choice7.setBackground(Color.black);
                ui.choice7.setForeground(Color.white); break;
            case 7 :
                ui.window.getRootPane().setDefaultButton(ui.choice7);
                ui.choice1.setBackground(Color.black);
                ui.choice1.setForeground(Color.white);
                ui.choice2.setBackground(Color.black);
                ui.choice2.setForeground(Color.white);
                ui.choice3.setBackground(Color.black);
                ui.choice3.setForeground(Color.white);
                ui.choice4.setBackground(Color.black);
                ui.choice4.setForeground(Color.white);
                ui.choice5.setBackground(Color.black);
                ui.choice5.setForeground(Color.white);
                ui.choice6.setBackground(Color.black);
                ui.choice6.setForeground(Color.white);
                ui.choice7.setBackground(Color.white);
                ui.choice7.setForeground(Color.black); break;
        }
    }

}

