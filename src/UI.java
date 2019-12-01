import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;


public class UI {
    //TODO: make maintextarea to JLabel for HTML --- linewrap needs to be implemented
    JFrame window;
    JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, chapterText;
    JScrollPane scrollPane;
    JPanel mainTextPanel, choicePanel, infoPanel, dialoguePicturePanel, dialogueTextPanel, dialoguePicturePanel2, chapterPanel;
    JLabel chapterLabel, legendInfo;
    JButton choice1, choice2, choice3, choice4, choice5, choice6, choice7;
    Font chapterFont = new Font("Lucida Console", Font.BOLD, 15);
    Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    Container container;



    public void createUI(Game.ChoiceHandler cHandler, Game.KeyHandler kHandler) {

        window = new JFrame();
        window.setSize(960, 720);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.magenta);
        window.setResizable(true);
        window.addKeyListener(kHandler);
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
        infoPanel.setBounds(30, 15, 870, 70);
        infoPanel.setBackground(Color.black);
        infoPanel.setLayout(new GridLayout(1, 1));
        container.add(infoPanel);

        chapterLabel = new JLabel("<HTML>CHAPTER I:<BR/>THE TOWER</HTML>");
        chapterLabel.setFont(asciiFont);
        chapterLabel.setForeground(Color.WHITE);
        infoPanel.add(chapterLabel);
        legendInfo = new JLabel("Various Legends");
        legendInfo.setFont(asciiFont);
        legendInfo.setForeground(Color.white);
        infoPanel.add(legendInfo);
        //TODO: Main text Panel for displaying story text --- needs scrolling
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(30, 100, 870, 365);
        mainTextPanel.setBackground(Color.green);
        container.add(mainTextPanel);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setBackground(Color.black);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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

        mainTextArea = new JTextArea(17, 71);// works for some reason
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(/*splashFont*/asciiFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(true);
        mainTextPanel.add(mainTextArea);
        mainTextPanel.add(scrollPane);
        scrollPane.getViewport().add(mainTextArea);


        //TODO: text input area --- must be visible, but invisible
        choicePanel = new JPanel();
        choicePanel.setBounds(30, 465, 870, 40);
        choicePanel.setBackground(Color.red);
        choicePanel.setLayout(new GridLayout(1, 4));
        container.add(choicePanel);

        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(asciiFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choice1.setBorderPainted(false);
        choicePanel.add(choice1);

        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(asciiFont);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choice2.setFocusPainted(false);
        choice2.setBorderPainted(false);
        choicePanel.add(choice2);

        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(asciiFont);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choice3.setFocusPainted(false);
        choice3.setBorderPainted(false);
        choicePanel.add(choice3);

        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(asciiFont);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choice4.setFocusPainted(false);
        choice4.setBorderPainted(false);
        choicePanel.add(choice4);

        choice5 = new JButton();
        choice5.setBackground(Color.black);
        choice5.setForeground(Color.white);
        choice5.setFont(asciiFont);
        choice5.addActionListener(cHandler);
        choice5.setActionCommand("c5");
        choice5.setFocusPainted(false);
        choice5.setBorderPainted(false);
        choicePanel.add(choice5);

        choice6 = new JButton();
        choice6.setBackground(Color.black);
        choice6.setForeground(Color.white);
        choice6.setFont(asciiFont);
        choice6.addActionListener(cHandler);
        choice6.setActionCommand("c6");
        choice6.setFocusPainted(false);
        choice6.setBorderPainted(false);
        choicePanel.add(choice6);

        choice7 = new JButton();
        choice7.setBackground(Color.black);
        choice7.setForeground(Color.white);
        choice7.setFont(asciiFont);
        choice7.addActionListener(cHandler);
        choice7.setActionCommand("c7");
        choice7.setFocusPainted(false);
        choice7.setBorderPainted(false);
        choicePanel.add(choice7);



        //TODO: Displays dialogue Panel --- needs frame for images and textarea

        dialoguePicturePanel = new JPanel();
        dialoguePicturePanel.setBounds(30, 510, 160, 160);
        dialoguePicturePanel.setBackground(Color.red);
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
        dialoguePicturePanel2.setBounds(740, 510, 162, 160);
        dialoguePicturePanel2.setBackground(Color.red);
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
        dialogueTextPanel.setBounds(190, 510, 550, 160);
        dialogueTextPanel.setBackground(Color.yellow);
        container.add(dialogueTextPanel);

        dialogueTextArea = new JTextArea("dfdfgdfg\nsdfsdffsd\nsdfdsfds\nsdfdsfsdf\nskdjfhksdj\nskdjfsdjk\nsjfhksdjf");
        dialogueTextArea.setBounds(190, 510, 550, 160);
        dialogueTextArea.setBackground(Color.black);
        dialogueTextArea.setForeground(Color.white);
        dialogueTextArea.setFont(asciiFont);
        dialogueTextArea.setLineWrap(true);
        dialogueTextArea.setEditable(false);
        dialogueTextPanel.add(dialogueTextArea);


        window.setVisible(true);


    }

}





