package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buttons{

    JButton returnB, returnNote, menuButton, localMapButton, globalMapButton, closeMenuButton;
    ReturnClick rClick = new ReturnClick();
    MouseHover mHover = new MouseHover();
    int i = 0, di = 0, iLength;
    UI ui;
    public Buttons(UI userInterface){
        ui = userInterface;
    }


    public void buttons(){
        returnB = new JButton("Return");
        returnB.setBackground(Color.white);
        returnB.setForeground(Color.black);
        returnB.setFont(ui.asciiFont);
        returnB.setFocusPainted(false);
        returnB.addMouseListener(mHover);
        returnB.addMouseListener(rClick);
        returnB.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.returnPanel.add(returnB);

        menuButton = new JButton(new AbstractAction("Menu") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.menuPanel.setVisible(true);
                ui.mainScrollPane.setVisible(true);
                ui.itemScrollPane.setVisible(false);
                ui.singleScrollPane.setVisible(false);
                ui.mapPanel.setVisible(false);
                ui.choicePanel.setVisible(false);
                ui.menuTextArea.setVisible(false);
            }
        });
        menuButton.setBackground(Color.white);
        menuButton.setForeground(Color.black);
        menuButton.setFont(ui.asciiFont);
        menuButton.setFocusPainted(false);
        menuButton.addMouseListener(mHover);
        menuButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.menuButtonPanel.add(menuButton);

        closeMenuButton = new JButton(new AbstractAction("Х") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.itemScrollPane.setVisible(false);
                ui.mapPanel.setVisible(false);
                //TODO: fix if singleusearea is in effect.
                ui.choicePanel.setVisible(true);
                ui.menuPanel.setVisible(true);
                ui.menuTextArea.setVisible(true);
            }
        });
        closeMenuButton.setBackground(Color.white);
        closeMenuButton.setForeground(Color.black);
        closeMenuButton.setFont(ui.asciiFont);
        closeMenuButton.setFocusPainted(false);
        closeMenuButton.addMouseListener(mHover);
        closeMenuButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.closeMenuButtonPanel.add(closeMenuButton);


        localMapButton = new JButton(new AbstractAction("Local") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.singleTextArea.setText(ui.localMap);
            }
        });
        localMapButton.setBackground(Color.white);
        localMapButton.setForeground(Color.black);
        localMapButton.setFont(ui.asciiFont);
        localMapButton.setFocusPainted(false);
        localMapButton.addMouseListener(mHover);
        localMapButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.mapPanel.add(localMapButton);

        globalMapButton = new JButton(new AbstractAction("Global") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui.singleTextArea.setText(ui.globalMap);
            }
        });
        globalMapButton.setBackground(Color.white);
        globalMapButton.setForeground(Color.black);
        globalMapButton.setFont(ui.asciiFont);
        globalMapButton.setFocusPainted(false);
        globalMapButton.addMouseListener(mHover);
        globalMapButton.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        ui.mapPanel.add(globalMapButton);

        returnNote = new JButton("Return");
        returnNote.setBackground(Color.white);
        returnNote.setForeground(Color.black);
        returnNote.setFont(ui.asciiFont);
        returnNote.setFocusPainted(false);
        returnNote.addMouseListener(mHover);
        returnNote.addMouseListener(rClick);
        returnNote.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.black, 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)));
        ui.notePanel.add(returnNote);
    }
    public class ReturnClick implements MouseListener {
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){
            ui.returnPanel.setVisible(false);
            ui.choicePanel.setVisible(true);
            ui.singleScrollPane.setVisible(false);
            ui.notePanel.setVisible(false);
            ui.mainScrollPane.setVisible(true);
            ui.dialogueScrollPane.getVerticalScrollBar().setEnabled(true);
            ui.dialogueScrollPane.setWheelScrollingEnabled(true);
            ui.mainScrollPane.getVerticalScrollBar().setEnabled(true);
            ui.mainScrollPane.setWheelScrollingEnabled(true);

            //ui.optionScrollPane.getVerticalScrollBar().setEnabled(true);
            //ui.optionScrollPane.setWheelScrollingEnabled(true);

        }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e){ }
        @Override public void mouseExited(MouseEvent e){ }
    }
    public static class MouseHover implements MouseListener {
        @Override public void mouseClicked(MouseEvent e){ }
        @Override public void mousePressed(MouseEvent e){ }
        @Override public void mouseReleased(MouseEvent e){ }
        @Override public void mouseEntered(MouseEvent e) {
            Component c = e.getComponent();
            c.setBackground(Color.lightGray);
        if (c instanceof JButton && ((JButton) c).getText().equals("Х")){
            c.setBackground(Color.red);
        }
        }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.white); }
    }


}
