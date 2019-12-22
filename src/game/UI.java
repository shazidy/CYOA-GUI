package game;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

public class UI{
    public JFrame window;
    public JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, noteText, singleTextArea, itemText;
    public JScrollPane mainScrollPane, dialogueScrollPane, optionScrollPane, singleScrollPane, noteScrollPane;
    public JPanel choicePanel,nextPanel, returnPanel, infoPanel, dialoguePicturePanel, dialoguePicturePanel2, notePanel, optionPanel, itemTextPanel;
    public JLabel chapterLabel, legendInfo;
    public Font noteFont = new Font("Lucida Console", Font.PLAIN, 15);
    public Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    public Font dialogueAsciiFont = new Font("Lucida Console", Font.BOLD, 2);
    public String dialogueText, storyText;
    public Container container;
    public double itemCount;


    public void createUI() {
        window = new JFrame();
        window.setSize(960, 720);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setResizable(true);
        window.requestFocus();
        window.setTitle("METROPOLIS");
        window.setLayout(null);
        container = window.getContentPane();
    }
    public void choicePromt(){
        itemTextPanel = new JPanel();
        itemTextPanel.setBounds(650, 100, 250, 325);
        itemTextPanel.setBackground(Color.white);
        itemTextPanel.setVisible(false);
        itemTextPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        container.add(itemTextPanel);

        itemText = new JTextArea();
        itemText.setPreferredSize(new Dimension(230, 240));
        itemText.setBackground(Color.white);
        itemText.setForeground(Color.black);
        itemText.setFont(asciiFont);
        itemText.setEditable(false);
        itemText.setLineWrap(true);
        itemText.setWrapStyleWord(true);
        itemText.setMargin(new Insets(3,13,0,0));
        itemTextPanel.add(itemText);
    }
    public void noteViewer(){
        notePanel = new JPanel();
        notePanel.setBounds(100, 30, 425, 580);
        notePanel.setBackground(Color.white);
        notePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        notePanel.setVisible(false);
        container.add(notePanel);

        noteScrollPane = new JScrollPane();
        noteScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        noteScrollPane.isForegroundSet();
        noteScrollPane.setBorder(null);
        noteScrollPane.getVerticalScrollBar().setBackground(Color.white);
        noteScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.gray;
            }
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        });

        noteText = new JTextArea(30,40);
        DefaultCaret caret1 = (DefaultCaret) noteText.getCaret();
        caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        noteText.setBackground(Color.white);
        noteText.setForeground(Color.black);
        noteText.setFont(noteFont);
        noteText.setEditable(false);
        noteText.setLineWrap(true);
        noteText.setWrapStyleWord(true);
        noteText.setMargin(new Insets(20,20,20,20));
        notePanel.add(noteText);
        notePanel.add(noteScrollPane);
        noteScrollPane.getViewport().add(noteText);
    }
    public void info(){
        //TODO: needs reworking to display relevant information --- maybe legend or inventory
        infoPanel = new JPanel();
        infoPanel.setBounds(30, 15, 624, 70);
        infoPanel.setBackground(Color.black);
        infoPanel.setLayout(new GridLayout(1, 2));
        container.add(infoPanel);

        chapterLabel = new JLabel();
        chapterLabel.setFont(asciiFont);
        chapterLabel.setForeground(Color.WHITE);
        infoPanel.add(chapterLabel);
        legendInfo = new JLabel();
        legendInfo.setFont(asciiFont);
        legendInfo.setForeground(Color.white);
        infoPanel.add(legendInfo);
    }

    public void options(){

        optionScrollPane = new JScrollPane();
        optionScrollPane.setBounds(650, 100, 250, 325);
        optionScrollPane.setBackground(Color.white);
        optionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        optionScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        optionScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        optionScrollPane.getVerticalScrollBar().setBackground(Color.black);
        optionScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.white;
            }
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        });
        optionScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        container.add(optionScrollPane);


        optionPanel = new JPanel();
        optionPanel.setBackground(Color.black);
        optionScrollPane.getViewport().add(optionPanel);


    }
    public void mainArea(){
        mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(30, 100, 624, 325);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        mainScrollPane.getVerticalScrollBar().setBackground(Color.black);
        mainScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.white;
            }
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        });
        container.add(mainScrollPane);

        mainTextArea = new JTextArea();
        DefaultCaret caret = (DefaultCaret) mainTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(asciiFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextArea.setHighlighter(null);
        mainTextArea.setMargin(new Insets(3,3,0,0));
        mainScrollPane.getViewport().add(mainTextArea);
    }
    public void singleUse(){
        singleScrollPane = new JScrollPane();
        singleScrollPane.setBounds(30, 100, 624, 325);
        singleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        singleScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        singleScrollPane.getVerticalScrollBar().setBackground(Color.black);
        singleScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.white;
            }
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        });
        container.add(singleScrollPane);

        singleTextArea = new JTextArea();
        DefaultCaret caret = (DefaultCaret) singleTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        singleTextArea.setBackground(Color.black);
        singleTextArea.setForeground(Color.white);
        singleTextArea.setFont(asciiFont);
        singleTextArea.setLineWrap(true);
        singleTextArea.setWrapStyleWord(true);
        singleTextArea.setEditable(false);
        singleTextArea.setHighlighter(null);
        singleTextArea.setMargin(new Insets(3,3,0,0));
        singleScrollPane.getViewport().add(singleTextArea);
    }
    public void choicePanel(){
        choicePanel = new JPanel();
        choicePanel.setBounds(30, 435, 624, 35);
        choicePanel.setBackground(Color.red);
        choicePanel.setLayout(new GridLayout(1, 5));
        container.add(choicePanel);
    }
    public void nextButton(){
        nextPanel = new JPanel();
        nextPanel.setBounds(230, 435, 200, 35);
        nextPanel.setBackground(Color.orange);
        nextPanel.setLayout(new GridLayout(1, 1));
        nextPanel.setVisible(false);
        container.add(nextPanel);
    }
    public void returnPanel(){
        returnPanel = new JPanel();
        returnPanel.setBounds(230, 435, 200, 35);
        returnPanel.setBackground(Color.orange);
        returnPanel.setLayout(new GridLayout(1, 1));
        returnPanel.setVisible(false);
        container.add(returnPanel);
    }
    public void dialogue(){
        //TODO: needs tweaking
        //dialogue-picture 1
        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(30, 480, 160, 160);
        dialoguePicturePanel.setBackground(Color.black);
        dialoguePicturePanel.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        container.add(dialoguePicturePanel);

        dialoguePicture = new JTextArea();
        //dialoguePicture.setBounds(30, 480, 160, 160);
        dialoguePicture.setPreferredSize(new Dimension(146,146));
        dialoguePicture.setBackground(Color.black);
        dialoguePicture.setForeground(Color.white);
        dialoguePicture.setFont(dialogueAsciiFont);
        dialoguePicture.setHighlighter(null);
        dialoguePicture.setLineWrap(true);
        dialoguePicture.setEditable(false);
        dialoguePicturePanel.add(dialoguePicture);
//dialogue-picture 2
        dialoguePicturePanel2 = new JPanel();
        dialoguePicturePanel2.setBounds(740, 480, 160, 160);
        dialoguePicturePanel2.setBackground(Color.black);
        dialoguePicturePanel2.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        container.add(dialoguePicturePanel2);

        dialoguePicture2 = new JTextArea();
        //dialoguePicture2.setBounds(742, 480, 162, 160);
        dialoguePicture2.setPreferredSize(new Dimension(146,146));
        dialoguePicture2.setBackground(Color.black);
        dialoguePicture2.setForeground(Color.white);
        dialoguePicture2.setFont(dialogueAsciiFont);
        dialoguePicture2.setHighlighter(null);
        dialoguePicture2.setLineWrap(true);
        dialoguePicture2.setEditable(false);
        dialoguePicturePanel2.add(dialoguePicture2);
// dialogue
        dialogueScrollPane = new JScrollPane();
        dialogueScrollPane.setBounds(194, 480, 542, 160);
        dialogueScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dialogueScrollPane.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        dialogueScrollPane.getVerticalScrollBar().setBackground(Color.black);
        dialogueScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.white;
            }
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(Color.WHITE);
                return button;
            }
        });
        container.add(dialogueScrollPane);

        dialogueTextArea = new JTextArea();
        dialogueTextArea.setBackground(Color.black);
        dialogueTextArea.setForeground(Color.white);
        dialogueTextArea.setFont(asciiFont);
        dialogueTextArea.setLineWrap(true);
        dialogueTextArea.setWrapStyleWord(true);
        dialogueTextArea.setEditable(false);
        dialogueTextArea.setHighlighter(null);
        dialogueTextArea.setMargin(new Insets(3,3,0,0));
        dialogueScrollPane.getViewport().add(dialogueTextArea);
    }
    public void singleUseVisible(){
        mainScrollPane.setVisible(false);
        singleScrollPane.setVisible(true);
        choicePanel.setVisible(false);
        nextPanel.setVisible(false);
        returnPanel.setVisible(true);
    }
    public void noteVisible(){
        notePanel.setVisible(true);
        choicePanel.setVisible(false);
        returnPanel.setVisible(false);
        nextPanel.setVisible(false);
        dialogueScrollPane.getVerticalScrollBar().setEnabled(false);
        dialogueScrollPane.setWheelScrollingEnabled(false);
        mainScrollPane.getVerticalScrollBar().setEnabled(false);
        mainScrollPane.setWheelScrollingEnabled(false);
    }
}





