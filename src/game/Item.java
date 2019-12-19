package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Item extends JButton implements MouseListener, ActionListener {
    UI ui;


    public Item(String name, UI userInterface) {
        ui = userInterface;
        itemButton(name);
    }

    public void itemButton(String name) {
        this.setText(name);
        this.setBackground(Color.darkGray);
        this.setForeground(Color.white);
        this.setFont(ui.asciiFont);
        this.addActionListener(this::actionPerformed);
        this.setActionCommand(name);
        this.addMouseListener(this);
        this.setFocusPainted(false);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setPreferredSize(new Dimension(ui.optionPanel.getWidth() - 10, 26));
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setPreferredSize(new Dimension(225, 26));
        this.setVisible(true);
        ui.optionPanel.add(this);
        ui.itemCount++;
        ui.optionPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
        if (ui.itemCount >= 50) {
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.darkGray);
    }


    public void actionPerformed(ActionEvent event) {
        ui.choicePromt.setVisible(true);
        ui.optionScrollPane.setVisible(false);
        ui.itemCount--;
        ui.optionPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
        String yourChoice = event.getActionCommand();
        switch (yourChoice) {
            case "Potion":
                ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
                this.setText("");
                break;
            case "Potio":
                ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
                this.setText("");
                break;
        }
            if (this.getText().equals("")) {
                this.setVisible(false);
            }
        }
    }

