package game;

import story.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** dialogue and story-text work as follow: if the symbol ► is at the start of either dialogue or story, it will not be
 * the starting text, but the second. to go from one dialogue to another mark the end by \n. to change from dialogue to
 *
 */

public class Game {
    UI ui = new UI();
    Buttons buttons = new Buttons(ui);
    Story story = new Story(ui);
    Splash splash = new Splash();
    JPanel start, titlePane, buttonPane;
    JScrollPane startScroll;
    JTextArea startText, titleText;
    String sound;
    Audio audio = new Audio();
    public static void main(String[] args){
        new Game();
    }

    public Game(){

        //introSplash();
        //ui.window.setVisible(true);
        //JScrollBar sb = startScroll.getVerticalScrollBar();
        //sb.setValue(sb.getMaximum());

        test();
    }
    public void test(){
        ui.createUI();
        ui.menu();
        ui.itemPrompt();
        ui.noteViewer();
        ui.info();
        ui.options();
        ui.mainArea();
        ui.singleUse();
        ui.buttonPanels();
        ui.dialogue();
        buttons.buttons();
        story.start();
        ui.window.setVisible(true);
    }

    public void introSplash(){
        ui.createUI();

        titlePane = new JPanel();
        titlePane.setBounds(180,520,600,120);
        titlePane.setBackground(Color.black);
        titlePane.setVisible(false);
        ui.container.add(titlePane);

        buttonPane = new JPanel();
        buttonPane.setBounds(30,530,120,120);
        buttonPane.setBackground(Color.yellow);
        buttonPane.setVisible(false);
        buttonPane.setLayout(new GridLayout(4,1));
        ui.container.add(buttonPane);

        titleText = new JTextArea(splash.title);
        titleText.setFont(new Font("Lucida Console", Font.BOLD, 4));
        titleText.setBackground(Color.black);
        titleText.setForeground(Color.white);
        titlePane.add(titleText);

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
        startText.setFont(new Font("Lucida Console", Font.BOLD, 3));
        startText.setLineWrap(true);
        startScroll.getViewport().add(startText);

        Timer t = new Timer((int)Math.round(13.7), new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                startScroll.getVerticalScrollBar().setValue(startScroll.getVerticalScrollBar().getValue() - 1);
                if (startScroll.getVerticalScrollBar().getValue() < startScroll.getVerticalScrollBar().getMinimum()) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        t.start();

        sound = "src/audio/NS3ELPH-505_09 Final Word.wav";
        audio.setFile(sound);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        sound = "src/audio/GOTHIC-049_09 Serene Main.wav";
                        audio.setFile(sound);
                        Timer t2 = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                startScroll.getVerticalScrollBar().setValue(startScroll.getVerticalScrollBar().getValue() + 1);
                                if (startScroll.getVerticalScrollBar().getValue() >= startScroll.getVerticalScrollBar().getMaximum()) {
                                    ((Timer) e.getSource()).stop();
                                }
                            }
                        });
                        titlePane.setVisible(true);
                        buttonPane.setVisible(true);
                        t.stop();
                        t2.start();
                    }
                },
                10000
        );
        new Choice("START", "story.start",ui);
        new Choice("LOAD", "story.start",ui);
        new Choice("CREDITS", "story.start",ui);
        new Choice("QUIT", "quit",ui);
    }


    public class Choice extends JButton implements ActionListener, MouseListener {
        UI ui;
        String method;
        public Choice(String text, String methodCall, UI userI) {
            method = methodCall;
            ui = userI;
            this.setText(text);
            this.setBackground(Color.black);
            this.setForeground(Color.white);
            this.setFont(ui.asciiFont);
            this.addActionListener(this::actionPerformed);
            this.setActionCommand("choice");
            this.setFocusPainted(false);
            this.addMouseListener(this);
            this.setBorder(BorderFactory.createLineBorder(Color.black, 0));
            buttonPane.add(this);
            if (this.getText().equals("")) {this.setVisible(false);}
        }
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            Component c = e.getComponent();
            c.setBackground(Color.darkGray); }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.black); }

        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "choice" : selectPosition(method); break;
            }
        }

        public void selectPosition(String nextPosition) {
            switch (nextPosition) {
                case "story.start":
                    audio.clip.stop();
                    titlePane.setVisible(false);
                    start.removeAll();
                    start.setVisible(false);
                    buttonPane.setVisible(false);
                    //
                    ui.menu();
                    ui.itemPrompt();
                    ui.noteViewer();
                    ui.info();
                    ui.options();
                    ui.mainArea();
                    ui.singleUse();
                    ui.buttonPanels();
                    ui.dialogue();
                    buttons.buttons();
                    story.start(); break;
                case "quit" : System.exit(0); break;
            }
        }
    }
}



