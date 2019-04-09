/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale_backend;

/**
 *
 * @author Rifky <qnoy.rifky@gmail.com>
 */
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Coba {

    public static void main(String[] args) {
        new Coba();
    }

    public Coba() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTable top;
        private JTable bottom;

        public TestPane() {
            setLayout(new GridLayout(2, 0));

            String[][] rowData = new String[10][10];
            for (int row = 0; row < 10; row++) {
                String[] data = new String[10];
                for (int col = 0; col < 10; col++) {
                    data[col] = row + "x" + col;
                }
                rowData[row] = data;
            }
            String[] names = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            DefaultTableModel model = new DefaultTableModel(rowData, names);
            top = new JTable(model);
            add(new JScrollPane(top));

            DefaultTableModel emptyModel = new DefaultTableModel(new String[10][10], names);
            bottom = new JTable(emptyModel);
            add(new JScrollPane(bottom));

            top.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        int row = top.rowAtPoint(e.getPoint());
                        if (row > -1) {
                            DefaultTableModel topModel = ((DefaultTableModel)top.getModel());
                            DefaultTableModel bottomModel = ((DefaultTableModel)bottom.getModel());
                            bottomModel.setRowCount(1);
                            for (int col = 0; col < topModel.getColumnCount(); col++) {
                                bottomModel.setValueAt(topModel.getValueAt(row, col), 0, col);
                            }
                        }
                    }
                }
            });
        }

    }

}
