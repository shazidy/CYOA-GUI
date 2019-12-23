package game;

import game.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buttons{

    JButton returnB, returnNote, next;
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
            c.setBackground(Color.lightGray); }
        @Override public void mouseExited(MouseEvent e){
            Component c = e.getComponent();
            c.setBackground(Color.white); }
    }


}
