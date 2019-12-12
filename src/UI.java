import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

public class UI {
    //TODO: make maintextarea to JLabel for HTML (is it necessary?)
    JFrame window;
    JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, noteText, optionTextArea, singleTextArea;
    JScrollPane mainScrollPane, dialogueScrollPane, optionScrollPane, singleScrollPane, noteScrollPane;
    JPanel mainTextPanel, choicePanel,nextPanel, returnPanel, infoPanel, dialoguePicturePanel, dialogueTextPanel, dialoguePicturePanel2, notePanel, optionPanel;
    JLabel chapterLabel, legendInfo, itemCount0, itemCount1, itemCount2, itemCount3, itemCount4, itemCount5, itemCount6, itemCount7, itemCount8, itemCount9;
    JButton choice1, choice2, choice3, choice4, choice5, choice6, choice7, next, returnB, returnNote,
            item0, item1, item2, item3, item4, item5, item6, item7, item8, item9, item11;
    Font noteFont = new Font("Lucida Console", Font.PLAIN, 15);
    Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    Container container;
   // ArrayList <JButton> iButtons = new ArrayList<JButton>(5);
    GridBagConstraints gbc = new GridBagConstraints();


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

        //TODO: ChapterPanel
        notePanel = new JPanel();
        notePanel.setBounds(450, 30, 425, 580);
        notePanel.setBackground(Color.white);
        notePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 4));
        notePanel.setVisible(false);
        container.add(notePanel);

        noteScrollPane = new JScrollPane();
        noteScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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


        window.setVisible(true);


    }
    public void info(){
        //TODO: needs reworking to display relevant information --- maybe legend or inventory
        infoPanel = new JPanel();
        infoPanel.setBounds(30, 15, 620, 70);
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
        //option panel

        optionPanel = new JPanel();
        optionPanel.setBounds(652, 100, 252, 325);
        optionPanel.setBackground(Color.black);
        //optionPanel.setLayout(new GridLayout(10,2));
        container.add(optionPanel);



/*
        optionScrollPane = new JScrollPane();
        optionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        optionScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        optionScrollPane.setBorder(null);
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


        optionTextArea = new JTextArea(15, 19);// works for some reason
        optionTextArea.setBackground(Color.black);
        optionTextArea.setForeground(Color.white);
        optionTextArea.setFont(asciiFont);
        optionTextArea.setLineWrap(true);
        optionTextArea.setWrapStyleWord(true);
        optionTextArea.setEditable(false);
        optionTextArea.setHighlighter(null);
        optionTextArea.setMargin(new Insets(3,3,0,0));

        optionTextPanel.add(optionTextArea);
        optionTextPanel.add(optionScrollPane);
        optionScrollPane.getViewport().add(optionTextArea);

 */
    }
    public void mainArea(){
        //main text panel
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(30, 100, 622, 325);
        mainTextPanel.setBackground(Color.white);
        container.add(mainTextPanel);

        mainScrollPane = new JScrollPane();
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setBorder(null);
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

        mainTextArea = new JTextArea(15, 50);
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
        mainTextPanel.add(mainScrollPane);
        mainScrollPane.getViewport().add(mainTextArea);
    }
    public void singleUse(){
        //single use text area
        singleScrollPane = new JScrollPane();
        singleScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        singleScrollPane.setBorder(null);
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

        singleTextArea = new JTextArea(15, 50);// works for some reason
        singleTextArea.setBackground(Color.black);
        singleTextArea.setForeground(Color.white);
        singleTextArea.setFont(asciiFont);
        singleTextArea.setLineWrap(true);
        singleTextArea.setWrapStyleWord(true);
        singleTextArea.setEditable(false);
        singleTextArea.setHighlighter(null);
        singleTextArea.setMargin(new Insets(3,3,0,0));
        mainTextPanel.add(singleScrollPane);
        singleScrollPane.getViewport().add(singleTextArea);
    }
    public void choiceButtons(Game.ChoiceHandler cHandler, Game.MouseHover mHover){
        //choice buttons
        choicePanel = new JPanel();
        choicePanel.setBounds(30, 435, 874, 35);
        choicePanel.setBackground(Color.black);
        choicePanel.setLayout(new GridLayout(1, 7));
        container.add(choicePanel);

        choice1 = new JButton();
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFont(asciiFont);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choice1.setFocusPainted(false);
        choice1.addMouseListener(mHover);
        choice1.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFont(asciiFont);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choice2.setFocusPainted(false);
        choice2.addMouseListener(mHover);
        choice2.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice2);

        choice3 = new JButton();
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFont(asciiFont);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choice3.setFocusPainted(false);
        choice3.addMouseListener(mHover);
        choice3.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice3);

        choice4 = new JButton();
        choice4.setBackground(Color.white);
        choice4.setForeground(Color.black);
        choice4.setFont(asciiFont);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choice4.setFocusPainted(false);
        choice4.addMouseListener(mHover);
        choice4.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice4);

        choice5 = new JButton();
        choice5.setBackground(Color.white);
        choice5.setForeground(Color.black);
        choice5.setFont(asciiFont);
        choice5.addActionListener(cHandler);
        choice5.setActionCommand("c5");
        choice5.setFocusPainted(false);
        choice5.addMouseListener(mHover);
        choice5.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice5);

        choice6 = new JButton();
        choice6.setBackground(Color.white);
        choice6.setForeground(Color.black);
        choice6.setFont(asciiFont);
        choice6.addActionListener(cHandler);
        choice6.setActionCommand("c6");
        choice6.setFocusPainted(false);
        choice6.addMouseListener(mHover);
        choice6.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice6);

        choice7 = new JButton();
        choice7.setBackground(Color.white);
        choice7.setForeground(Color.black);
        choice7.setFont(asciiFont);
        choice7.addActionListener(cHandler);
        choice7.setActionCommand("c7");
        choice7.setFocusPainted(false);
        choice7.addMouseListener(mHover);
        choice7.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        choicePanel.add(choice7);
    }
    public void nextButton(Game.MouseHover mHover, Game.MouseTimer mTimer){
        nextPanel = new JPanel();
        nextPanel.setBounds(230, 435, 200, 35);
        nextPanel.setBackground(Color.orange);
        nextPanel.setLayout(new GridLayout(1, 1));
        nextPanel.setVisible(false);
        container.add(nextPanel);

        next = new JButton("Continue");
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setFont(asciiFont);
        next.setFocusPainted(false);
        next.addMouseListener(mHover);
        next.addMouseListener(mTimer);
        next.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        nextPanel.add(next);}
    public void returnButtons(Game.MouseHover mHover, Game.returnClick rClick){
        //returnbutton from single use textarea
        returnPanel = new JPanel();
        returnPanel.setBounds(230, 435, 200, 35);
        returnPanel.setBackground(Color.orange);
        returnPanel.setLayout(new GridLayout(1, 1));
        returnPanel.setVisible(false);
        container.add(returnPanel);

        returnB = new JButton("Return");
        returnB.setBackground(Color.white);
        returnB.setForeground(Color.black);
        returnB.setFont(asciiFont);
        returnB.setFocusPainted(false);
        returnB.addMouseListener(mHover);
        returnB.addMouseListener(rClick);
        returnB.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        returnPanel.add(returnB);

        returnNote = new JButton("Return");
        returnNote.setBackground(Color.white);
        returnNote.setForeground(Color.black);
        returnNote.setFont(asciiFont);
        returnNote.setFocusPainted(false);
        returnNote.addMouseListener(mHover);
        returnNote.addMouseListener(rClick);
        returnNote.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        notePanel.add(returnNote);
    }
    public void dialogue(){
        //dialogue-picture 1
        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(30, 480, 160, 160);
        dialoguePicturePanel.setBackground(Color.white);
        container.add(dialoguePicturePanel);

        dialoguePicture = new JTextArea();
        dialoguePicture.setBounds(30, 480, 160, 160);
        dialoguePicture.setBackground(Color.black);
        dialoguePicture.setForeground(Color.white);
        dialoguePicture.setFont(dialogueAsciiFont);
        dialoguePicture.setLineWrap(true);
        dialoguePicture.setEditable(false);
        dialoguePicturePanel.add(dialoguePicture);
//dialogue-picture 2
        dialoguePicturePanel2 = new JPanel();
        dialoguePicturePanel2.setBounds(742, 480, 162, 160);
        dialoguePicturePanel2.setBackground(Color.white);
        container.add(dialoguePicturePanel2);

        dialoguePicture2 = new JTextArea();
        dialoguePicture2.setBounds(740, 480, 162, 160);
        dialoguePicture2.setBackground(Color.black);
        dialoguePicture2.setForeground(Color.white);
        dialoguePicture2.setFont(dialogueAsciiFont);
        dialoguePicture2.setLineWrap(true);
        dialoguePicture2.setEditable(false);
        dialoguePicturePanel2.add(dialoguePicture2);
// dialogue
        dialogueTextPanel = new JPanel();
        dialogueTextPanel.setBounds(190, 480, 552, 160);
        dialogueTextPanel.setBackground(Color.white);
        container.add(dialogueTextPanel);

        dialogueScrollPane = new JScrollPane();
        dialogueScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dialogueScrollPane.setBorder(null);
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

        dialogueTextArea = new JTextArea(7, 44);// works for some reason
        dialogueTextArea.setBackground(Color.black);
        dialogueTextArea.setForeground(Color.white);
        dialogueTextArea.setFont(asciiFont);
        dialogueTextArea.setLineWrap(true);
        dialogueTextArea.setWrapStyleWord(true);
        dialogueTextArea.setEditable(false);
        dialogueTextArea.setHighlighter(null);
        dialogueTextArea.setMargin(new Insets(3,3,0,0));
        dialogueTextPanel.add(dialogueTextArea);
        dialogueTextPanel.add(dialogueScrollPane);
        dialogueScrollPane.getViewport().add(dialogueTextArea);
    }
    public void inventory(Game.ChoiceHandler cHandler, Game.ItemHover mHover){
//TODO: ideally make 99 buttons and a scrollpane to fit them
        item0 = new JButton("item0");
        item0.setBackground(Color.darkGray);
        item0.setForeground(Color.white);
        item0.setFont(asciiFont);
        item0.addActionListener(cHandler);
        item0.addMouseListener(mHover);
        item0.setFocusPainted(false);
        item0.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item0.setPreferredSize(new Dimension(215,27));
        item0.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item0);

        itemCount0 = new JLabel("##");
        itemCount0.setPreferredSize(new Dimension(25,27));
        itemCount0.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount0.setFont(asciiFont);
        optionPanel.add(itemCount0);

        item1 = new JButton("item1");
        item1.setBackground(Color.darkGray);
        item1.setForeground(Color.white);
        item1.setFont(asciiFont);
        item1.addActionListener(cHandler);
        item1.addMouseListener(mHover);
        item1.setFocusPainted(false);
        item1.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item1.setPreferredSize(new Dimension(215,27));
        item1.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item1);

        itemCount1 = new JLabel("##");
        itemCount1.setPreferredSize(new Dimension(25,27));
        itemCount1.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount1.setFont(asciiFont);
        optionPanel.add(itemCount1);

        item2 = new JButton("item2");
        item2.setBackground(Color.darkGray);
        item2.setForeground(Color.white);
        item2.setFont(asciiFont);
        item2.addActionListener(cHandler);
        item2.addMouseListener(mHover);
        item2.setFocusPainted(false);
        item2.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item2.setPreferredSize(new Dimension(215,27));
        item2.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item2);

        itemCount2 = new JLabel("##");
        itemCount2.setPreferredSize(new Dimension(25,27));
        itemCount2.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount2.setFont(asciiFont);
        optionPanel.add(itemCount2);

        item3 = new JButton("item3");
        item3.setBackground(Color.darkGray);
        item3.setForeground(Color.white);
        item3.setFont(asciiFont);
        item3.addActionListener(cHandler);
        item3.addMouseListener(mHover);
        item3.setFocusPainted(false);
        item3.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item3.setPreferredSize(new Dimension(215,27));
        item3.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item3);

        itemCount3 = new JLabel("##");
        itemCount3.setPreferredSize(new Dimension(25,27));
        itemCount3.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount3.setFont(asciiFont);
        optionPanel.add(itemCount3);

        item4 = new JButton("item4");
        item4.setBackground(Color.darkGray);
        item4.setForeground(Color.white);
        item4.setFont(asciiFont);
        item4.addActionListener(cHandler);
        item4.addMouseListener(mHover);
        item4.setFocusPainted(false);
        item4.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item4.setPreferredSize(new Dimension(215,27));
        item4.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item4);

        itemCount4 = new JLabel("##");
        itemCount4.setPreferredSize(new Dimension(25,27));
        itemCount4.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount4.setFont(asciiFont);
        optionPanel.add(itemCount4);

        item5 = new JButton("item5");
        item5.setBackground(Color.darkGray);
        item5.setForeground(Color.white);
        item5.setFont(asciiFont);
        item5.addActionListener(cHandler);
        item5.addMouseListener(mHover);
        item5.setFocusPainted(false);
        item5.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item5.setPreferredSize(new Dimension(215,27));
        item5.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item5);

        itemCount5 = new JLabel("##");
        itemCount5.setPreferredSize(new Dimension(25,27));
        itemCount5.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount5.setFont(asciiFont);
        optionPanel.add(itemCount5);

        item6 = new JButton("item6");
        item6.setBackground(Color.darkGray);
        item6.setForeground(Color.white);
        item6.setFont(asciiFont);
        item6.addActionListener(cHandler);
        item6.addMouseListener(mHover);
        item6.setFocusPainted(false);
        item6.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item6.setPreferredSize(new Dimension(215,27));
        item6.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item6);

        itemCount6 = new JLabel("##");
        itemCount6.setPreferredSize(new Dimension(25,27));
        itemCount6.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount6.setFont(asciiFont);
        optionPanel.add(itemCount6);

        item7 = new JButton("item7");
        item7.setBackground(Color.darkGray);
        item7.setForeground(Color.white);
        item7.setFont(asciiFont);
        item7.addActionListener(cHandler);
        item7.addMouseListener(mHover);
        item7.setFocusPainted(false);
        item7.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item7.setPreferredSize(new Dimension(215,27));
        item7.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item7);

        itemCount7 = new JLabel("##");
        itemCount7.setPreferredSize(new Dimension(25,27));
        itemCount7.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount7.setFont(asciiFont);
        optionPanel.add(itemCount7);

        item8 = new JButton("item8");
        item8.setBackground(Color.darkGray);
        item8.setForeground(Color.white);
        item8.setFont(asciiFont);
        item8.addActionListener(cHandler);
        item8.addMouseListener(mHover);
        item8.setFocusPainted(false);
        item8.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item8.setPreferredSize(new Dimension(215,27));
        item8.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item8);

        itemCount8 = new JLabel("##");
        itemCount8.setPreferredSize(new Dimension(25,27));
        itemCount8.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount8.setFont(asciiFont);
        optionPanel.add(itemCount8);

        item9 = new JButton("item9");
        item9.setBackground(Color.darkGray);
        item9.setForeground(Color.white);
        item9.setFont(asciiFont);
        item9.addActionListener(cHandler);
        item9.addMouseListener(mHover);
        item9.setFocusPainted(false);
        item9.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        item9.setPreferredSize(new Dimension(215,27));
        item9.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item9);

        itemCount9 = new JLabel("##");
        itemCount9.setPreferredSize(new Dimension(25,27));
        itemCount9.setHorizontalAlignment(SwingConstants.RIGHT);
        itemCount9.setFont(asciiFont);
        optionPanel.add(itemCount9);

        item11 = new JButton("item11");
        item11.setBackground(Color.white);
        item11.setForeground(Color.black);
        item11.setFont(asciiFont);
        item11.addActionListener(cHandler);
        item11.addMouseListener(mHover);
        item11.setFocusPainted(false);
        item11.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        optionPanel.add(item11);


    }

}





