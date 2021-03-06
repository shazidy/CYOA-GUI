package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

    public class Menu extends JButton implements ActionListener, MouseListener {
        UI ui;
        String method;
        public Menu(String text, String methodCall, UI userI) {
            method = methodCall;
            ui = userI;
            this.setText(text);
            this.setBackground(Color.white);
            this.setForeground(Color.black);
            this.setFont(ui.asciiFont);
            this.addActionListener(this::actionPerformed);
            this.setActionCommand("choice");
            this.setFocusPainted(false);
            this.addMouseListener(this);
            this.setPreferredSize(new Dimension(200,50));
            this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
            ui.menuPanel.add(this);
            if (this.getText().equals("")) {this.setVisible(false);}
        }
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            Component c = e.getComponent();
            c.setBackground(Color.lightGray); }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.white); }

        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch (yourChoice){
                case "choice" : selectPosition(method); break;
            }
        }
        public void selectPosition(String nextPosition) {
            switch (nextPosition) {
                case "Items" :
                    ui.menuPanel.setVisible(false);
                    ui.itemScrollPane.setVisible(true);
                    if(ui.itemPanel.isVisible()){
                        ui.choicePanel.setVisible(false);} break;
                case "Status" :
                    ui.singleUseVisible();
                    Player.status();
                    ui.returnPanel.setVisible(false);
                    ui.menuButtonPanel.setVisible(true);
                    ui.closeMenuButtonPanel.setVisible(true);
                    break;
                case "Logs" : break;
                case "Maps" :
                    ui.mapVisible();
                    ui.mapTextArea.setText(ui.globalMap);
                    ui.returnPanel.setVisible(false);
                    ui.menuButtonPanel.setVisible(true);
                    //ui.menuTextArea.setVisible(true);
                    ui.mapPanel.setVisible(true);
                    break;

                case "Quit" : System.exit(0);
                    break;




            }
        }

    }

