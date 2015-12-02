/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Rewdon
 */
public class Frame2 extends JFrame implements ActionListener, ItemListener {

    private JButton greenButton;
    private JButton amberButton;
    private JButton redButton;
    private JPanel colourPanel;
    private JRadioButton greenRadio, redRadio, amberRadio;
    private ButtonGroup radioGroup;
    private JCheckBox greenCheck, redCheck, amberCheck;

    public Frame2() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        greenButton = new JButton("green");
        amberButton = new JButton("amber");
        redButton = new JButton("red");

        greenButton.addActionListener(this);
        amberButton.addActionListener(this);
        redButton.addActionListener(this);

        greenRadio = new JRadioButton("Green");
        redRadio = new JRadioButton("Red");
        amberRadio = new JRadioButton("Amber");

        radioGroup = new ButtonGroup();
        radioGroup.add(greenRadio);
        radioGroup.add(redRadio);
        radioGroup.add(amberRadio);

        greenRadio.addActionListener(this);
        amberRadio.addActionListener(this);
        redRadio.addActionListener(this);

        greenCheck = new JCheckBox("Green");
        redCheck = new JCheckBox("Red");
        amberCheck = new JCheckBox("Amber");

        greenCheck.addItemListener(this);
        amberCheck.addItemListener(this);
        redCheck.addItemListener(this);

        colourPanel = new JPanel();
        colourPanel.setPreferredSize(new Dimension(200, 200));
        colourPanel.setBackground(Color.BLACK);
    //greenButton.setPreferredSize(new Dimension(300,300));
        //JPanel jp = new JPanel(new FlowLayout());
        JPanel jp = new JPanel(new GridLayout(3, 1));
        jp.add(greenButton);
        //add(jp, BorderLayout.NORTH);
        add(jp, BorderLayout.SOUTH);
        add(colourPanel, BorderLayout.CENTER);

        jp.add(amberButton);
        jp.add(redButton);

        JPanel jpRadio = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpRadio.add(greenRadio);
        jpRadio.add(amberRadio);
        jpRadio.add(redRadio);
        add(jpRadio, BorderLayout.NORTH);

        JPanel jpCheck = new JPanel(new GridLayout(3, 1));
        jpCheck.add(greenCheck);
        jpCheck.add(amberCheck);
        jpCheck.add(redCheck);
        add(jpCheck, BorderLayout.EAST);
        pack();

    }

    public static void main(String args[]) throws Exception {
        new Frame2().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if ((e.getSource() == greenButton) || (e.getSource() == greenRadio)) {
            System.out.println("Green");
            colourPanel.setBackground(Color.GREEN);
            greenRadio.setSelected(true);
        }

        if ((e.getSource() == redButton) || (e.getSource() == redRadio)) {
            System.out.println("Red");
            colourPanel.setBackground(Color.RED);
            redRadio.setSelected(true);
        }

        if ((e.getSource() == amberButton) || (e.getSource() == amberRadio)) {
            System.out.println("Amber");
            colourPanel.setBackground(Color.ORANGE);
            amberRadio.setSelected(true);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //if (e.getStateChange() == ItemEvent.SELECTED) {
            if (greenCheck.isSelected()) {
                System.out.println("Green");
                this.actionPerformed(new ActionEvent(greenButton, -1, "Green"));
            } else if (amberCheck.isSelected()) {
                System.out.println("Amber");
                this.actionPerformed(new ActionEvent(amberButton, -1, "Amber"));
            } else if (redCheck.isSelected()) {
                System.out.println("Red");
                this.actionPerformed(new ActionEvent(redButton, -1, "Red"));
            }
        //}
        if ((greenCheck.isSelected()) && (redCheck.isSelected())
                && (amberCheck.isSelected())) {
            colourPanel.setBackground(Color.BLACK);
        } else if ((greenCheck.isSelected()) & (redCheck.isSelected())
                || (greenCheck.isSelected()) & (amberCheck.isSelected())
                || (redCheck.isSelected()) & (amberCheck.isSelected())) {
            colourPanel.setBackground(Color.GRAY);

        }

    }

}
