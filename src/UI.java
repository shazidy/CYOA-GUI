import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

public class UI{
    Game game;
    JFrame window;
    JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, noteText, singleTextArea;
    JScrollPane mainScrollPane, dialogueScrollPane, optionScrollPane, singleScrollPane, noteScrollPane, glassScrollPane;
    JPanel choicePanel,nextPanel, returnPanel, infoPanel, dialoguePicturePanel, dialoguePicturePanel2, notePanel, optionPanel;
    JLabel chapterLabel, legendInfo;
    JButton choice1, choice2, choice3, choice4, choice5, choice6, choice7, next, returnB, returnNote,
            item0, item1, item2, item3, item4, item5, item6, item7, item8, item9;
    Font noteFont = new Font("Lucida Console", Font.PLAIN, 15);
    Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    Container container;


    ItemHover iHover = new ItemHover();
    MouseHover mHover = new MouseHover();
    MouseTimer mTimer = new MouseTimer();
    ReturnClick rClick = new ReturnClick();
    InventoryHandler iHandler = new InventoryHandler();
    public UI(Game g){
        game = g;
        createUI();
        noteViewer();
        info();
        options();
        mainArea();
        singleUse();
        nextButton();
        inventory();
        dialogue();
        returnButtons();

    }

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

        optionScrollPane = new JScrollPane();
        optionScrollPane.setBounds(652, 100, 252, 325);
        optionScrollPane.setBackground(Color.white);
        //optionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //optionScrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
        container.add(optionScrollPane);

        optionPanel = new JPanel();
        optionPanel.setPreferredSize(new Dimension(227, 317));
        optionPanel.setBackground(Color.black);
        // optionPanel.setLayout(new GridLayout(10,1));
        optionScrollPane.getViewport().add(optionPanel);
    }
    public void mainArea(){
        mainScrollPane = new JScrollPane();
        mainScrollPane.setBounds(30, 100, 622, 325);
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
        singleScrollPane.setBounds(30, 100, 622, 325);
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
    public void choiceButtons(Game.ChoiceHandler cHandler){
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
    public void nextButton(){
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
    public void returnButtons(){
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
        //TODO: needs tweaking
        //dialogue-picture 1
        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(30, 480, 160, 160);
        dialoguePicturePanel.setBackground(Color.black);
        dialoguePicturePanel.setBorder(BorderFactory.createLineBorder(Color.red, 4));
        container.add(dialoguePicturePanel);

        dialoguePicture = new JTextArea();
        //dialoguePicture.setBounds(30, 480, 160, 160);
        dialoguePicture.setBackground(Color.black);
        dialoguePicture.setForeground(Color.white);
        dialoguePicture.setFont(dialogueAsciiFont);
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
        dialoguePicture2.setBackground(Color.black);
        dialoguePicture2.setForeground(Color.white);
        dialoguePicture2.setFont(dialogueAsciiFont);
        dialoguePicture2.setLineWrap(true);
        dialoguePicture2.setEditable(false);
        dialoguePicturePanel2.add(dialoguePicture2);
// dialogue
        dialogueScrollPane = new JScrollPane();
        dialogueScrollPane.setBounds(190, 480, 550, 160);
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

        dialogueTextArea = new JTextArea();// works for some reason
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
    public void inventory(){

        item0 = new JButton();
        item0.setBackground(Color.darkGray);
        item0.setForeground(Color.white);
        item0.setFont(asciiFont);
        item0.addActionListener(iHandler);
        item0.setActionCommand("item0");
        item0.addMouseListener(iHover);
        item0.setFocusPainted(false);
        item0.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item0.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20, 26));
        item0.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item0);

        item1 = new JButton();
        item1.setBackground(Color.darkGray);
        item1.setForeground(Color.white);
        item1.setFont(asciiFont);
        item1.addActionListener(iHandler);
        item1.setActionCommand("item1");
        item1.addMouseListener(iHover);
        item1.setFocusPainted(false);
        item1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item1.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item1.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item1);

        item2 = new JButton();
        item2.setBackground(Color.darkGray);
        item2.setForeground(Color.white);
        item2.setFont(asciiFont);
        item2.addActionListener(iHandler);
        item2.setActionCommand("item2");
        item2.addMouseListener(iHover);
        item2.setFocusPainted(false);
        item2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item2.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item2.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item2);

        item3 = new JButton();
        item3.setBackground(Color.darkGray);
        item3.setForeground(Color.white);
        item3.setFont(asciiFont);
        item3.addActionListener(iHandler);
        item3.setActionCommand("item3");
        item3.addMouseListener(iHover);
        item3.setFocusPainted(false);
        item3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item3.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item3.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item3);

        item4 = new JButton();
        item4.setBackground(Color.darkGray);
        item4.setForeground(Color.white);
        item4.setFont(asciiFont);
        item4.addActionListener(iHandler);
        item4.setActionCommand("item4");
        item4.addMouseListener(iHover);
        item4.setFocusPainted(false);
        item4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item4.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item4.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item4);

        item5 = new JButton();
        item5.setBackground(Color.darkGray);
        item5.setForeground(Color.white);
        item5.setFont(asciiFont);
        item5.addActionListener(iHandler);
        item5.setActionCommand("item5");
        item5.addMouseListener(iHover);
        item5.setFocusPainted(false);
        item5.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item5.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item5.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item5);

        item6 = new JButton();
        item6.setBackground(Color.darkGray);
        item6.setForeground(Color.white);
        item6.setFont(asciiFont);
        item6.addActionListener(iHandler);
        item6.setActionCommand("item6");
        item6.addMouseListener(iHover);
        item6.setFocusPainted(false);
        item6.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item6.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item6.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item6);

        item7 = new JButton();
        item7.setBackground(Color.darkGray);
        item7.setForeground(Color.white);
        item7.setFont(asciiFont);
        item7.addActionListener(iHandler);
        item7.setActionCommand("item7");
        item7.addMouseListener(iHover);
        item7.setFocusPainted(false);
        item7.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item7.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item7.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item7);

        item8 = new JButton();
        item8.setBackground(Color.darkGray);
        item8.setForeground(Color.white);
        item8.setFont(asciiFont);
        item8.addActionListener(iHandler);
        item8.setActionCommand("item8");
        item8.addMouseListener(iHover);
        item8.setFocusPainted(false);
        item8.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item8.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item8.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item8);

        item9 = new JButton();
        item9.setBackground(Color.darkGray);
        item9.setForeground(Color.white);
        item9.setFont(asciiFont);
        item9.addActionListener(iHandler);
        item9.setActionCommand("item9");
        item9.addMouseListener(iHover);
        item9.setFocusPainted(false);
        item9.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item9.setPreferredSize(new Dimension(optionScrollPane.getWidth()-20,26));
        item9.setHorizontalAlignment(SwingConstants.LEFT);
        optionPanel.add(item9);


    }


    public class MouseHover implements MouseListener {
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
    public class ItemHover implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            //if (!ui.notePanel.isVisible()){
            Component c = e.getComponent();
            c.setBackground(Color.lightGray); }
        //}
        @Override public void mouseExited(MouseEvent e){
            //if (!ui.notePanel.isVisible()){
            Component c = e.getComponent();
            c.setBackground(Color.darkGray); }
        //}
    }
    public class MouseTimer implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            game.dTimer.start();
        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }
    public class ReturnClick implements MouseListener{
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            returnPanel.setVisible(false);
            choicePanel.setVisible(true);
            singleScrollPane.setVisible(false);
            notePanel.setVisible(false);
            mainScrollPane.setVisible(true);
            dialogueScrollPane.getVerticalScrollBar().setEnabled(true);
            dialogueScrollPane.setWheelScrollingEnabled(true);
            mainScrollPane.getVerticalScrollBar().setEnabled(true);
            mainScrollPane.setWheelScrollingEnabled(true);
            item0.setEnabled(true);
            item1.setEnabled(true);
            item2.setEnabled(true);
            item3.setEnabled(true);
            item4.setEnabled(true);
            item5.setEnabled(true);
            item6.setEnabled(true);
            item7.setEnabled(true);
            item8.setEnabled(true);
            item9.setEnabled(true);

            //ui.optionScrollPane.getVerticalScrollBar().setEnabled(true);
            //ui.optionScrollPane.setWheelScrollingEnabled(true);

        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }
    public class InventoryHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "item0" : game.items.itemUsed(0); break;
                case "item1" : game.items.itemUsed(1); break;
                case "item2" : game.items.itemUsed(2); break;
                case "item3" : game.items.itemUsed(3); break;
                case "item4" : game.items.itemUsed(4); break;
                case "item5" : game.items.itemUsed(5); break;
                case "item6" : game.items.itemUsed(6); break;
                case "item7" : game.items.itemUsed(7); break;
                case "item8" : game.items.itemUsed(8); break;
                case "item9" : game.items.itemUsed(9); break;
            }
        }

    } //has all inventory effects in Items
}





