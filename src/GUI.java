import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GUI{

    JFrame window;
    Container container;
    JPanel mainTextPanel, inputTextFieldPanel, infoPanel, dialoguePanel;
    JLabel chapterLabel, legendInfo; //TODO: make maintextarea to JLabel for HTML --- linewrap needs to be implemented

    Font titleFont = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    Font splashFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    Font normalFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    JButton startButton;
    JTextArea mainTextArea, dialogueTextArea;
    JTextField inputTextArea;
    JScrollPane scrollPane;
    String picture;

    CharPict charPict = new CharPict();


    public GUI() {

        window = new JFrame();
        window.setSize(960, 720);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.magenta);
        window.setResizable(true);
        window.setTitle("METROPOLIS");
        window.setLayout(null);
        container = window.getContentPane();


        //TODO: needs reworking to display relevant information --- maybe legend or inventory
        infoPanel = new JPanel();
        infoPanel.setBounds(30, 15, 870, 70);
        infoPanel.setBackground(Color.black);
        infoPanel.setLayout(new GridLayout(1, 1));
        container.add(infoPanel);

        chapterLabel = new JLabel("<HTML>CHAPTER I:<BR/>THE TOWER</HTML>");
        chapterLabel.setFont(normalFont);
        chapterLabel.setForeground(Color.WHITE);
        infoPanel.add(chapterLabel);
        legendInfo = new JLabel("Various Legends");
        legendInfo.setFont(normalFont);
        legendInfo.setForeground(Color.white);
        infoPanel.add(legendInfo);
        //TODO: Main text Panel for displaying story text --- needs scrolling
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(30, 100, 870, 365);
        mainTextPanel.setBackground(Color.green);
        //

        //
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
/////////////////////////
        mainTextPanel.add(scrollPane);
        //scrollPane.setBounds(50,100,860,350);
        //scrollPane.getViewport().setBackground(Color.black);

        scrollPane.getViewport().add(mainTextArea);


        //TODO: text input area --- must be visible, but invisible
        inputTextFieldPanel = new JPanel();
        inputTextFieldPanel.setBounds(30, 465, 870, 40);
        inputTextFieldPanel.setBackground(Color.red);
        inputTextFieldPanel.setLayout(new GridLayout(1, 1));
        container.add(inputTextFieldPanel);

        inputTextArea = new JTextField();
        inputTextArea.setBackground(Color.black);
        inputTextArea.setForeground(Color.white);
        inputTextArea.setFont(asciiFont);
        inputTextArea.setBorder(new LineBorder(Color.black));
        inputTextArea.addActionListener(this::actionPerformed);
        inputTextFieldPanel.add(inputTextArea);
        //TODO: Displays dialogue Panel --- needs frame for images and textarea
        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(30, 510, 870, 160);
        dialoguePanel.setBackground(Color.red);
        container.add(dialoguePanel);

        dialogueTextArea = new JTextArea(picture);
        dialogueTextArea.setBounds(30, 510, 870, 160);
        dialogueTextArea.setBackground(Color.black);
        dialogueTextArea.setForeground(Color.white);
        dialogueTextArea.setFont(dialogueAsciiFont);
        dialogueTextArea.setLineWrap(true);
        dialogueTextArea.setEditable(false);
        dialoguePanel.add(dialogueTextArea);

        window.setVisible(true);


    }
/*
    public void gui() {
        new GUI();

    }

 */
    public void start() {
        //dialogueTextArea.setText(charPict.maggi);
        //dialogueTextArea.setText(charPict.hero);
        Tower tower = new Tower();
        tower.start();



    }

    //TODO: Make input save string for choicehandler if-statements
    String text;

    public void actionPerformed(ActionEvent evt) {

        text = inputTextArea.getText();
        inputTextArea.selectAll();
    }

}



