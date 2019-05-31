/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
public class ButtonGenerator implements ActionListener {

    JButton[][] buttons = new JButton[20][20];
//    JPanel mPanel = new JPanel();
//    JPanel bPanel = new JPanel();
//    JPanel cPanel = new JPanel();
    static public JPanel mPanel;
    static public JPanel bPanel;
    static public JPanel cPanel;
//    Container c = getContentPane();
    public int baris=3;
    public int kolom=3;
    
    public ButtonGenerator() {
//        c.add(mPanel);
//        setTitle("ButtonMaddness");
//        setSize(1000, 400);
//        setLocation(200, 200);
//        setVisible(true);
    }
    public void set_JPnel(JPanel panela,JPanel panelb,JPanel panelc,Container container){
//        mPanel = panela;
//        bPanel = panelb;
//        cPanel = panelc;
        panelb.setLayout(new GridLayout(baris, kolom));
        panela.setLayout(new BorderLayout());
        panela.add(panelb, BorderLayout.CENTER);
        panela.add(panelc, BorderLayout.SOUTH);
        container.add(panela);
        run_buttonGenerator(panelb);

    }

    private void run_buttonGenerator(JPanel panelb) {
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                String str_i = String.valueOf(i);
                String str_j = String.valueOf(j);
                buttons[i][j] = new JButton("MEJA"+str_i+"_"+str_j);
                buttons[i][j].setActionCommand("meja_"+i+"_"+ j);
                buttons[i][j].addActionListener(this);
                panelb.add(buttons[i][j]);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().contains("meja")) {
            System.out.println(""+e.getActionCommand());
        }
    }
//    public static void main(String[] args) {
//        ButtonGenerator myFrame = new ButtonGenerator();
//        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
