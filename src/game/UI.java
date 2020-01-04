package game;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

public class UI{
    Splash splash = new Splash();
    public static Container container;
    public static JFrame window;
    public static JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, noteText, singleTextArea, itemText, menuTextArea, mapTextArea;
    public static JScrollPane mainScrollPane, dialogueScrollPane, itemScrollPane, singleScrollPane, noteScrollPane, mapScrollPane;
    public static JPanel choicePanel,nextPanel, returnPanel, infoPanel, dialoguePicturePanel, dialoguePicturePanel2, notePanel,
    itemPanel, itemTextPanel, menuPanel, menuButtonPanel, mapPanel, closeMenuButtonPanel;
    public static JLabel chapterLabel, locationLabel;
    public static Font noteFont = new Font("Lucida Console", Font.PLAIN, 15);
    public static Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    public static Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    public String dialogueText, storyText;
    public double itemCount;
    public String localMap, globalMap;


    public void createUI()  {
        window = new JFrame();
        //window.setSize(960, 720);
        window.setSize(1600, 900);
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
    public void menu(){
        menuPanel = new JPanel();
        menuPanel.setBounds(1100, 100, 360, 420);
        menuPanel.setBackground(Color.black);
        menuPanel.setVisible(true);
        //menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        menuPanel.setLayout(new GridLayout(3,2));
        container.add(menuPanel);
/*
        menuTextArea = new JTextArea(splash.menuSplash);
        menuTextArea.setPreferredSize(new Dimension(230, 312));
        menuTextArea.setLineWrap(true);
        menuTextArea.setEditable(false);
        menuTextArea.setHighlighter(null);
        menuTextArea.setBackground(Color.black);
        menuTextArea.setForeground(Color.white);
        menuTextArea.setFont(dialogueAsciiFont);
        menuPanel.add(menuTextArea);

 */

        new Menu("Status","Status", this);
        new Menu("Items","Items", this);
        new Menu("Logs","Logs", this);
        new Menu("Maps","Maps", this);
        new Menu("Save","Save", this);
        new Menu("Quit","Quit", this);

        menuButtonPanel = new JPanel();
        menuButtonPanel.setBounds(1190, 528, 125, 45);
        menuButtonPanel.setBackground(Color.red);
        menuButtonPanel.setLayout(new GridLayout(1,1));
        container.add(menuButtonPanel);

        closeMenuButtonPanel = new JPanel();
        closeMenuButtonPanel.setBounds(1315, 528, 45, 45);
        closeMenuButtonPanel.setBackground(Color.red);
        closeMenuButtonPanel.setLayout(new GridLayout(1,1));
        container.add(closeMenuButtonPanel);
    }
    public void itemPrompt(){
        itemTextPanel = new JPanel();
        itemTextPanel.setBounds(1100, 100, 360, 420);
        itemTextPanel.setBackground(Color.white);
        itemTextPanel.setVisible(false);
        itemTextPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        container.add(itemTextPanel);

        itemText = new JTextArea();
        itemText.setPreferredSize(new Dimension(350, 240));
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
        notePanel.setBounds(310, 50, 620, 750);
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

        noteText = new JTextArea(30,46);
        DefaultCaret caret1 = (DefaultCaret) noteText.getCaret();
        caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        noteText.setBackground(Color.white);
        noteText.setForeground(Color.black);
        noteText.setFont(asciiFont);
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
        infoPanel.setBackground(Color.red);
        infoPanel.setLayout(new GridLayout(1, 1));
        container.add(infoPanel);

        chapterLabel = new JLabel();
        chapterLabel.setFont(asciiFont);
        chapterLabel.setForeground(Color.WHITE);
        infoPanel.add(chapterLabel);

        locationLabel = new JLabel();
        locationLabel.setFont(asciiFont);
        locationLabel.setForeground(Color.white);
        infoPanel.add(locationLabel);
    }
    public void items(){
        itemScrollPane = new JScrollPane();
        itemScrollPane.setBounds(1100, 100, 360, 420);
        itemScrollPane.setBackground(Color.white);
        itemScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        itemScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        itemScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        itemScrollPane.getVerticalScrollBar().setBackground(Color.black);
        itemScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(30, 0));
        itemScrollPane.setVisible(false);
        itemScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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
        itemScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        container.add(itemScrollPane);

        itemPanel = new JPanel();
        itemPanel.setBackground(Color.black);
        itemScrollPane.getViewport().add(itemPanel);
    }
    public void mainArea(){
        mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(140, 100, 950, 420);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        mainScrollPane.getVerticalScrollBar().setBackground(Color.black);
        mainScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(30, 0));
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
    public static void singleUse(){
        singleScrollPane = new JScrollPane();
        singleScrollPane.setBounds(140, 100, 950, 420);
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
    public void map(){
        mapScrollPane = new JScrollPane();
        mapScrollPane.setBounds(140, 100, 950, 420);
        mapScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mapScrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        mapScrollPane.getVerticalScrollBar().setBackground(Color.black);
        mapScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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
        container.add(mapScrollPane);

        mapTextArea = new JTextArea();
        DefaultCaret caret = (DefaultCaret) mapTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        mapTextArea.setBackground(Color.black);
        mapTextArea.setForeground(Color.white);
        mapTextArea.setFont(asciiFont);
        mapTextArea.setLineWrap(true);
        mapTextArea.setWrapStyleWord(true);
        mapTextArea.setEditable(false);
        mapTextArea.setHighlighter(null);
        mapTextArea.setMargin(new Insets(3,3,0,0));
        mapScrollPane.getViewport().add(mapTextArea);
    }
    public void buttonPanels(){
        choicePanel = new JPanel();
        choicePanel.setBounds(1100, 100, 360, 420);
        choicePanel.setBackground(Color.black);
        choicePanel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        choicePanel.setLayout(new GridLayout(7, 1));
        container.add(choicePanel);

        nextPanel = new JPanel();
        nextPanel.setBounds(515, 528, 200, 45);
        nextPanel.setBackground(Color.orange);
        nextPanel.setLayout(new GridLayout(1, 1));
        nextPanel.setVisible(false);
        container.add(nextPanel);

        returnPanel = new JPanel();
        returnPanel.setBounds(515, 528, 200, 45);
        returnPanel.setBackground(Color.orange);
        returnPanel.setLayout(new GridLayout(1, 1));
        returnPanel.setVisible(false);
        container.add(returnPanel);

        mapPanel = new JPanel();
        mapPanel.setBounds(30, 435, 375, 35);
        mapPanel.setBackground(Color.orange);
        mapPanel.setLayout(new GridLayout(1, 3));
        mapPanel.setVisible(false);
        container.add(mapPanel);
    }
    public void dialogue(){
        //TODO: needs tweaking
        //dialogue-picture 1
        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(140, 580, 240, 240);
        dialoguePicturePanel.setBackground(Color.black);
        dialoguePicturePanel.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        container.add(dialoguePicturePanel);

        dialoguePicture = new JTextArea();
        dialoguePicture.setPreferredSize(new Dimension(226,226));
        dialoguePicture.setBackground(Color.black);
        dialoguePicture.setForeground(Color.white);
        dialoguePicture.setFont(dialogueAsciiFont);
        dialoguePicture.setHighlighter(null);
        dialoguePicture.setLineWrap(true);
        dialoguePicture.setEditable(false);
        dialoguePicturePanel.add(dialoguePicture);
//dialogue-picture 2
        dialoguePicturePanel2 = new JPanel();
        dialoguePicturePanel2.setBounds(850, 580, 240, 240);
        dialoguePicturePanel2.setBackground(Color.black);
        dialoguePicturePanel2.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        container.add(dialoguePicturePanel2);

        dialoguePicture2 = new JTextArea();
        dialoguePicture2.setPreferredSize(new Dimension(226,226));
        dialoguePicture2.setBackground(Color.black);
        dialoguePicture2.setForeground(Color.white);
        dialoguePicture2.setFont(dialogueAsciiFont);
        dialoguePicture2.setHighlighter(null);
        dialoguePicture2.setLineWrap(true);
        dialoguePicture2.setEditable(false);
        dialoguePicturePanel2.add(dialoguePicture2);
// dialogue
        dialogueScrollPane = new JScrollPane();
        dialogueScrollPane.setBounds(390, 580, 450, 240);
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
        singleScrollPane.setVisible(true);
        returnPanel.setVisible(true);
        mainScrollPane.setVisible(false);
        mapScrollPane.setVisible(false);
        choicePanel.setVisible(false);
        nextPanel.setVisible(false);
        menuButtonPanel.setVisible(false);
        closeMenuButtonPanel.setVisible(false);
    }
    public void mapVisible(){
        mapScrollPane.setVisible(true);
        mainScrollPane.setVisible(false);
        singleScrollPane.setVisible(false);
        choicePanel.setVisible(false);
        nextPanel.setVisible(false);
        returnPanel.setVisible(false);
    }
    public void noteVisible(){
        notePanel.setVisible(true);
        menuButtonPanel.setVisible(false);
        closeMenuButtonPanel.setVisible(false);
        choicePanel.setVisible(false);
        returnPanel.setVisible(false);
        nextPanel.setVisible(false);
        dialogueScrollPane.getVerticalScrollBar().setEnabled(false);
        dialogueScrollPane.setWheelScrollingEnabled(false);
        mainScrollPane.getVerticalScrollBar().setEnabled(false);
        mainScrollPane.setWheelScrollingEnabled(false);
    }

}





