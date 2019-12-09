import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;

public class UI {
    //TODO: make maintextarea to JLabel for HTML (is it necessary?)
    JFrame window;
    JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, chapterText;
    JScrollPane mainScrollPane, dialogueScrollPane;
    JPanel mainTextPanel, choicePanel,nextPanel, infoPanel, dialoguePicturePanel, dialogueTextPanel, dialoguePicturePanel2, chapterPanel, optionTextPanel;
    JLabel chapterLabel, legendInfo;
    JButton choice1, choice2, choice3, choice4, choice5, choice6, choice7, next;
    Font chapterFont = new Font("Lucida Console", Font.BOLD, 15);
    Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    Container container;


    public void createUI(Game.ChoiceHandler cHandler, Game.MouseHover mHover, Game.MouseTimer mTimer) {

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
        chapterPanel = new JPanel();
        chapterPanel.setBounds(0, 180, 960, 280);
        chapterPanel.setBackground(Color.white);
        container.add(chapterPanel);

        chapterText = new JTextArea();
        chapterText.setBackground(Color.white);
        chapterText.setForeground(Color.black);
        chapterText.setFont(chapterFont);
        chapterText.setEditable(false);
        chapterPanel.add(chapterText);

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


        mainTextArea = new JTextArea(15, 50);// works for some reason
        DefaultCaret caret = (DefaultCaret) mainTextArea.getCaret(); //TODO: use for dialogue, when that has been implemented
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(asciiFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextArea.setHighlighter(null);
        mainTextArea.setMargin(new Insets(3,3,0,0));
        mainTextPanel.add(mainTextArea);
        mainTextPanel.add(mainScrollPane);
        mainScrollPane.getViewport().add(mainTextArea);

        optionTextPanel = new JPanel();
        optionTextPanel.setBounds(622, 100, 248, 325);
        optionTextPanel.setBackground(Color.white);
        container.add(optionTextPanel);


        //TODO: text input area --- must be visible, but invisible
        choicePanel = new JPanel();
        choicePanel.setBounds(30, 425, 870, 40);
        choicePanel.setBackground(Color.red);
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

        nextPanel = new JPanel();
        nextPanel.setBounds(365, 470, 200, 35);
        nextPanel.setBackground(Color.orange);
        nextPanel.setLayout(new GridLayout(1, 1));
        nextPanel.setVisible(false);
        container.add(nextPanel);

        next = new JButton("Continue");
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setFont(asciiFont);
        next.setActionCommand("c1");
        next.setFocusPainted(false);
        next.addMouseListener(mHover);
        next.addMouseListener(mTimer);
        next.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        nextPanel.add(next);




        //TODO: something is wrong with the format from machine to machine ... "pictures" are formatted differently

        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(30, 510, 160, 160);
        dialoguePicturePanel.setBackground(Color.white);
        container.add(dialoguePicturePanel);

        dialoguePicture = new JTextArea();
        dialoguePicture.setBounds(30, 510, 160, 160);
        dialoguePicture.setBackground(Color.black);
        dialoguePicture.setForeground(Color.white);
        dialoguePicture.setFont(dialogueAsciiFont);
        dialoguePicture.setLineWrap(true);
        dialoguePicture.setEditable(false);
        dialoguePicturePanel.add(dialoguePicture);

        dialoguePicturePanel2 = new JPanel();
        dialoguePicturePanel2.setBounds(742, 510, 162, 160);
        dialoguePicturePanel2.setBackground(Color.white);
        container.add(dialoguePicturePanel2);

        dialoguePicture2 = new JTextArea();
        dialoguePicture2.setBounds(740, 510, 162, 160);
        dialoguePicture2.setBackground(Color.black);
        dialoguePicture2.setForeground(Color.white);
        dialoguePicture2.setFont(dialogueAsciiFont);
        dialoguePicture2.setLineWrap(true);
        dialoguePicture2.setEditable(false);
        dialoguePicturePanel2.add(dialoguePicture2);

        dialogueTextPanel = new JPanel();
        dialogueTextPanel.setBounds(190, 510, 552, 160);
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

        window.setVisible(true);


    }

}





