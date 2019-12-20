package game;

import story.*;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

/** dialogue and story-text work as follow: if the symbol ► is at the start of either dialogue or story, it will not be
 * the starting text, but the second. to go from one dialogue to another mark the end by \n. to change from dialogue to
 *
 */

public class Game {
    UI ui = new UI();
    Buttons buttons = new Buttons(ui);
    Story story = new Story(this, ui);
    Splash splash = new Splash();
    JPanel start;
    JScrollPane startScroll;
    JTextArea startText;
    public static void main(String[] args){
        new Game();
    }

    public Game(){
        ui.createUI();
        //start();

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
        //JScrollBar sb = startScroll.getVerticalScrollBar();
        //sb.setValue( sb.getMaximum() );

        story.start();
        buttons.buttons();
    }
    public void start(){
        start = new JPanel();
        start.setBounds(0, 100, 960, 400);
        start.setSize(new Dimension(960, 410));
        start.setBackground(Color.white);
        ui.container.add(start);
        startScroll = new JScrollPane();

        startScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        startScroll.setWheelScrollingEnabled(false);
        startScroll.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        startScroll.setPreferredSize(new Dimension(930, 400));
        start.add(startScroll);

        startText = new JTextArea();
        startText.setEditable(false);
        startText.setHighlighter(null);
        startText.setText(splash.intro + splash.intro2 + splash.intro3);
        startText.setFont(ui.dialogueAsciiFont);
        startText.setLineWrap(true);
        //startText.setWrapStyleWord(true);
        startScroll.getViewport().add(startText);

        Timer t = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startScroll.getVerticalScrollBar().setValue(startScroll.getVerticalScrollBar().getValue() - 2);
                if (startScroll.getVerticalScrollBar().getValue() >= startScroll.getVerticalScrollBar().getMaximum()) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        t.start();


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



