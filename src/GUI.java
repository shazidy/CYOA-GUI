import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GUI {


    //TODO: make maintextarea to JLabel for HTML --- linewrap needs to be implemented
    public static JFrame window;
    public static JTextArea mainTextArea, dialoguePicture, dialoguePicture2, dialogueTextArea, chapterText;
    public static JTextField inputTextArea;
    public static JScrollPane scrollPane;
    public static JPanel mainTextPanel, inputTextFieldPanel, infoPanel, dialoguePicturePanel, dialogueTextPanel, dialoguePicturePanel2, chapterPanel;
    public static JLabel chapterLabel, legendInfo;
    public static Font chapterFont = new Font("Lucida Console", Font.BOLD, 15);
    public static Font asciiFont = new Font("Lucida Console", Font.PLAIN, 20);
    public static Font dialogueAsciiFont = new Font("Lucida Console", Font.PLAIN, 2);
    public static Container container;
    public static Characters charPict;
    public static String text;


    public void gui() {

        window = new JFrame();
        window.setSize(960, 720);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.magenta);
        window.setResizable(true);
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
        charPict = new Characters();
        start();
    }

    public void start() {
        //dialogueTextArea.setText(charPict.maggi);
        //dialogueTextArea.setText(charPict.hero);



    }

    //TODO: Make input save string for choicehandler if-statements


    public void actionPerformed(ActionEvent evt) {
        text = inputTextArea.getText();
        inputTextArea.selectAll();
        //inputTextArea.setText("");
        System.out.println(text);

    //    if(text.equals("I")){
    //        mainTextArea.setText("slkjlrklvcj");
    //    }

    }




}



