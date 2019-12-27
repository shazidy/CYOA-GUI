package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Item implements MouseListener {
    ItemText iText = new ItemText();
    Notes no = new Notes();
    Buttons.MouseHover mHover = new Buttons.MouseHover();
    UI ui;
    JButton item, u_B, r_B, d_B, e_B;
    public Item(String name, UI userInterface) {
        ui = userInterface;
        itemButton(name);
    }
    public void removeItemPrompt(){
        ui.itemTextPanel.remove(e_B);
        ui.itemTextPanel.remove(d_B);
        ui.itemTextPanel.remove(r_B);
        ui.itemTextPanel.remove(u_B);
        ui.itemTextPanel.setVisible(false);
        ui.itemScrollPane.setVisible(true);
    }
    public void itemButton(String name) {
        item = new JButton(new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(name.contains("Ξ")){
                    ui.noteVisible();
                    no.notes();
                    for (int i = 0; i < no.noteText.size(); i++) {
                        if (no.noteText.get(i).contains(name)) {
                            ui.noteText.setText(no.noteText.get(i));
                        }
                    }
                } else {
                    ui.closeMenuButtonPanel.setVisible(false);
                    useButton(name);
                    discardButton();
                    equipButton();
                    returnButton();
                    ui.itemTextPanel.setVisible(true);
                    ui.itemScrollPane.setVisible(false);

                    iText.items();
                    for (int i = 0; i < iText.itemText.size(); i++) {
                        if (iText.itemText.get(i).contains(name)) {
                            ui.itemText.setText(iText.itemText.get(i));
                        }
                    }
                    if(name.contains("•")){
                        e_B.setEnabled(false);
                    }
                    if(name.contains("‡")){
                        u_B.setEnabled(false);
                    }
                }
            }
        });
        item.setBackground(Color.darkGray);
        item.setForeground(Color.white);
        item.setFont(ui.noteFont);
        item.addMouseListener(this);
        item.setFocusPainted(false);
        item.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item.setHorizontalAlignment(SwingConstants.LEFT);
        item.setPreferredSize(new Dimension(215, 26));
        item.setVisible(true);
        ui.itemPanel.add(item);
        ui.itemCount++;
        ui.itemPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
        if (ui.itemCount >= 50) {
        }
    }
    @Override public void mouseClicked(MouseEvent e) { }
    @Override public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.lightGray); }
    @Override public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        c.setBackground(Color.darkGray);
    }
    public void discardButton(){
        d_B = new JButton(new AbstractAction("DISCARD") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemPrompt();
                item.setText("");
                ui.itemCount--;
                ui.itemPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
                if (item.getText().equals("")) {
                    item.setVisible(false);
                }
            }
        });
        d_B.setBackground(Color.white);
        d_B.setForeground(Color.black);
        d_B.setFont(ui.asciiFont);
        d_B.addMouseListener(mHover);
        d_B.setFocusPainted(false);
        d_B.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        ui.itemTextPanel.add(d_B);
    }
    public void returnButton(){
        r_B = new JButton(new AbstractAction("RETURN") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemPrompt();
            }
        });
        r_B.setBackground(Color.white);
        r_B.setForeground(Color.black);
        r_B.setFont(ui.asciiFont);
        r_B.addMouseListener(mHover);
        r_B.setFocusPainted(false);
        r_B.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        ui.itemTextPanel.add(r_B);
    }
    public void equipButton(){
        e_B = new JButton(new AbstractAction("EQUIP") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemPrompt();
            }
        });
        e_B.setBackground(Color.white);
        e_B.setForeground(Color.black);
        e_B.setFont(ui.asciiFont);
        e_B.addMouseListener(mHover);
        e_B.setFocusPainted(false);
        e_B.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        ui.itemTextPanel.add(e_B);
    }
    public void useButton(String name){
        u_B = new JButton(new AbstractAction("USE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItemPrompt();
                ui.itemCount--;
                ui.itemPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
                String yourChoice = e.getActionCommand();
                switch (yourChoice) {
                    case "[•]Potion": ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>"); item.setText(""); break;
                    case "[•]Potia": ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER25</HTML>"); item.setText(""); break;
                   // case "ΞEmployment Notice" : ui.noteVisible(); ui.noteText.setText(no.firstNote); break;
                }
                if (item.getText().equals("")) {
                    item.setVisible(false);
                }
            }
        });
        u_B.setBackground(Color.white);
        u_B.setForeground(Color.black);
        u_B.setFont(ui.asciiFont);
        u_B.addMouseListener(mHover);
        u_B.setActionCommand(name);
        u_B.setFocusPainted(false);
        u_B.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        ui.itemTextPanel.add(u_B);
    }
}

