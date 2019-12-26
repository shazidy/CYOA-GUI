package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dialogue extends JButton implements MouseListener{
    String story;
    String dialogue;
    int i = 0, di = 0, iLength;
    Buttons.MouseHover mHover = new Buttons.MouseHover();
    UI ui;
    public Dialogue(String sto, String dia, UI userI){
        story = sto;
        dialogue = dia;
        ui = userI;

        this.setText("CONTINUE");
        this.setBackground(Color.white);
        this.setForeground(Color.black);
        this.setFont(ui.asciiFont);
        this.setFocusPainted(false);
        this.addMouseListener(mHover);
        this.addMouseListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.nextPanel.add(this);
//
        //ui.menuPanel.setVisible(false);
        ui.menuButtonPanel.setVisible(false);
        ui.closeMenuButtonPanel.setVisible(false);
        ui.choicePanel.setVisible(false);
        di = 0;
        i = 0;
        ui.nextPanel.setVisible(false);
        ui.dialogueScrollPane.setVisible(true);
        ui.mainTextArea.setText("");
        ui.dialogueTextArea.setText("");
        timer.start();
    }

        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            dTimer.start();
        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }

    Timer timer = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            char character[] = story.toCharArray();
            int ArrayNumber = character.length;
            iLength = ArrayNumber;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[i];
            ui.mainTextArea.append(addedCharacter);

            i++;

            if (addedCharacter.contains("\n") || addedCharacter.contains("►") ) {
                timer.stop();
                dTimer.start();
                ui.dialogueScrollPane.setVisible(true);
                ui.nextPanel.setVisible(true);
            }
            if (addedCharacter.equals("•")) {
                ui.menuButtonPanel.setVisible(true);
                ui.closeMenuButtonPanel.setVisible(true);
                timer.stop();
                dTimer.stop();
                i = 0;
                ui.nextPanel.removeAll();
                ui.choicePanel.setVisible(true);
            }
        }
    });
    Timer dTimer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            char character[] = dialogue.toCharArray();
            //int ArrayNumber = character.length;

            String addedCharacter = "";
            String blank = "";

            addedCharacter = blank + character[di];
            ui.dialogueTextArea.append(addedCharacter);

            di++;

            if (addedCharacter.contains("\n") || addedCharacter.contains("►")) {
                dTimer.stop();
            }

            if (addedCharacter.contains("\r")) {
                dTimer.stop();
                ui.nextPanel.setVisible(false);
                if (iLength != i)
                    timer.start();
            }
            if (addedCharacter.equals("•")){
                ui.menuButtonPanel.setVisible(true);
                ui.closeMenuButtonPanel.setVisible(true);
                dTimer.stop();
                timer.stop();
                ui.nextPanel.removeAll();
                ui.choicePanel.setVisible(true);
            }
        }
    });
}
