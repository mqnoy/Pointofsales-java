/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class buttonMaddness22 {

    public static void main(String[] args) {
//        butMaddFrame myFrame = new butMaddFrame();
//        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class butMaddFrame22 extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[20][20];
    JPanel mPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JPanel cPanel = new JPanel();
    JTextArea scoreKeeper = new JTextArea();
    Container c = getContentPane();
    public int baris=20;
    public int kolom=3;
    public butMaddFrame22() {
        butGen();
        //cPanel.add(scoreKeeper);
        bPanel.setLayout(new GridLayout(baris, kolom));
        mPanel.setLayout(new BorderLayout());
        mPanel.add(bPanel, BorderLayout.CENTER);
        mPanel.add(cPanel, BorderLayout.SOUTH);
        c.add(mPanel);

        setTitle("ButtonMaddness");
        setSize(1000, 400);
        setLocation(200, 200);
        setVisible(true);
    }

    private void butGen() {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                String str_i = String.valueOf(i);
                String str_j = String.valueOf(j);
                buttons[i][j] = new JButton("MEJA"+str_i+"_"+str_j);
                buttons[i][j].setActionCommand("meja_"+i+"_"+ j);
                buttons[i][j].addActionListener(this);
                bPanel.add(buttons[i][j]);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("meja")) {
            System.out.println(""+e.getActionCommand());
        }
    }
}
