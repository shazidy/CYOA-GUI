package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item implements MouseListener {
    public static ArrayList<JButton> buttonArrayList = new ArrayList<JButton>();
    //Player player = new Player();
    ItemText iText = new ItemText();
    Notes no = new Notes();
    Buttons.MouseHover mHover = new Buttons.MouseHover();
    UI ui;
    JButton item, u_B, r_B, d_B, returnNote, discardNote;

    public Item(String name, UI userInterface) {
        ui = userInterface;
        itemButton(name);
        if (name.contains("Ξ")) {
            new Audio("src/audio/Page_Turn-Mark_DiAngelo-1304638748.wav");
            noteButtons();
            ui.noteVisible();
            no.notes();
            for (int i = 0; i < no.noteText.size(); i++) {
                if (no.noteText.get(i).contains(name)) {
                    ui.noteText.setText(no.noteText.get(i));
                }
            }
        }
    }
    public void removeNote(){
        ui.notePanel.remove(returnNote);
        ui.notePanel.remove(discardNote);
        for (int i = 0; i < buttonArrayList.size() ; i++) {
            buttonArrayList.get(i).setEnabled(true);
        }
    }
    public void removeItemPrompt(){
        ui.closeMenuButtonPanel.setVisible(true);
        ui.menuButtonPanel.setVisible(true);
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
                ui.menuButtonPanel.setVisible(false);
                if (ui.noteScrollPane.isVisible()){}
                if(name.contains("Ξ")){
                    new Audio("src/audio/Page_Turn-Mark_DiAngelo-1304638748.wav");
                    noteButtons();
                    ui.noteVisible();
                    no.notes();
                    for (int i = 0; i < no.noteText.size(); i++) {
                        if (no.noteText.get(i).contains(name)) {
                            ui.noteText.setText(no.noteText.get(i));
                        }
                    }
                    for (int i = 0; i < buttonArrayList.size() ; i++) {
                        buttonArrayList.get(i).setEnabled(false);
                    }
                } else {
                    ui.closeMenuButtonPanel.setVisible(false); //TODO something with return button that makes closebutton disappear
                    useButton(name);
                    discardButton();
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
                        u_B.setText("USE");
                    }
                    if(name.contains("‡")){
                        u_B.setText("EQUIP");
                        //u_B.setEnabled(false);
                    }
                }
            }
        });
        item.setBackground(Color.darkGray);
        item.setForeground(Color.white);
        item.setFont(ui.asciiFont);
        item.addMouseListener(this);
        item.setFocusPainted(false);
        item.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        item.setHorizontalAlignment(SwingConstants.LEFT);
        item.setPreferredSize(new Dimension(310, 26));
        item.setVisible(true);
        buttonArrayList.add(item);

        for (int i = 0; i < buttonArrayList.size() ; i++) {
            //System.out.println(buttonArrayList.get(i).getText());
            //System.out.println(buttonArrayList.size());
            ui.itemPanel.add(buttonArrayList.get(i));
            Collections.sort(buttonArrayList,new Comparator<JButton>() {
                @Override
                public int compare(JButton o1, JButton o2) {
                    return o2.getText().compareTo(o1.getText());
                }
            });
        }

        ui.itemCount++;
        ui.itemPanel.setPreferredSize(new Dimension(322, (int) Math.round(ui.itemCount * 31.7)));
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
    public void noteButtons(){
        returnNote = new JButton(new AbstractAction("Return") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeNote();
                if (ui.itemScrollPane.isVisible()){
                    ui.choicePanel.setVisible(false);
                } else {
                    ui.choicePanel.setVisible(true);
                }
                ui.mainScrollPane.setVisible(true);
                ui.dialogueScrollPane.getVerticalScrollBar().setEnabled(true);
                ui.dialogueScrollPane.setWheelScrollingEnabled(true);
                ui.mainScrollPane.getVerticalScrollBar().setEnabled(true);
                ui.mainScrollPane.setWheelScrollingEnabled(true);
                ui.menuButtonPanel.setVisible(true);
                ui.closeMenuButtonPanel.setVisible(true);
                ui.returnPanel.setVisible(false);
                ui.singleScrollPane.setVisible(false);
                ui.notePanel.setVisible(false);
            }
        });
        returnNote.setBackground(Color.white);
        returnNote.setForeground(Color.black);
        returnNote.setFont(ui.asciiFont);
        returnNote.setFocusPainted(false);
        returnNote.addMouseListener(mHover);
        returnNote.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        ui.notePanel.add(returnNote);

        discardNote = new JButton(new AbstractAction("Discard") {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeNote();
                item.setText("");
                ui.itemCount--;
                ui.itemPanel.setPreferredSize(new Dimension(225, (int) Math.round(ui.itemCount * 31.7)));
                if (item.getText().equals("")) {
                    item.setVisible(false);
                }
                if (ui.itemScrollPane.isVisible()){
                    ui.choicePanel.setVisible(false);
                } else {
                    ui.choicePanel.setVisible(true);
                }
                ui.mainScrollPane.setVisible(true);
                ui.dialogueScrollPane.getVerticalScrollBar().setEnabled(true);
                ui.dialogueScrollPane.setWheelScrollingEnabled(true);
                ui.mainScrollPane.getVerticalScrollBar().setEnabled(true);
                ui.mainScrollPane.setWheelScrollingEnabled(true);
                ui.menuButtonPanel.setVisible(true);
                ui.closeMenuButtonPanel.setVisible(true);
                ui.returnPanel.setVisible(false);
                ui.singleScrollPane.setVisible(false);
                ui.notePanel.setVisible(false);
            }
        });
        discardNote.setBackground(Color.white);
        discardNote.setForeground(Color.black);
        discardNote.setFont(ui.asciiFont);
        discardNote.setFocusPainted(false);
        discardNote.addMouseListener(mHover);
        discardNote.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        ui.notePanel.add(discardNote);
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
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
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
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        ui.itemTextPanel.add(r_B);

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
                    case "[•]Potion": Player.maxHP += 25; item.setText(""); item.setText(""); break;
                    case "[•]Potia": Player.HP += 50; item.setText(""); item.setText(""); break;
                    case "[‡]Pants": Player.maxHP -= 25; item.setText(""); break;
                }
                if (item.getText().equals("")) {
                    item.setVisible(false);
                }
                if (ui.singleScrollPane.isVisible()){Player.status();}
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
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        ui.itemTextPanel.add(u_B);
    }
}

