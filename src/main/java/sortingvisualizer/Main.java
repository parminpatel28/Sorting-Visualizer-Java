/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualizer;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author parmin
 */
public class Main extends JPanel {

    public static int[] ar = {12, 14, 123, 45, 89, 12, 34, 45, 65, 67, 80, 34, 150};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame a = new JFrame();
        Main b = new Main();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(1000, 600);

        a.setVisible(true);

        a.add(b);

        a.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Random rd = new Random();
        int algorithm = 2;//rd.nextInt(3);
        System.out.println(algorithm);

        switch (algorithm) {
            //code for Bubble Sort
            case 0:
                for (int x = 0; x < b.ar.length; x++) {
                    for (int y = 0; y < b.ar.length - 1; y++) {
                        int temp = 0;
                        int next = y + 1;
                        if (b.ar[y] > b.ar[next]) {
                            temp = b.ar[next];
                            b.ar[next] = b.ar[y];
                            b.ar[y] = temp;
                        }
                        try {
                            Thread.sleep(300);
                        } catch (Exception ex) {
                        }
                        b.repaint();
                    }

                }
                break;
             //code for Insertion Sort
            case 1:
                for (int i = 0; i < ar.length; i++) {
                    int index = ar[i];
                    int j = i - 1;

                    while (j >= 0 && ar[j] > index) {
                        ar[j + 1] = ar[j];
                        j = j - 1;
                    }
                    ar[j + 1] = index;
                    try {
                        Thread.sleep(300);
                    } catch (Exception ex) {
                    }
                    b.repaint();
                }
                break;
            // code for Selection Sort 
            case 2:
                

                for (int step = 0; step < ar.length - 1; step++) {
                    int min_idx = step;

                    for (int i = step + 1; i < ar.length; i++) {
                        if (ar[i] < ar[min_idx]) {
                            min_idx = i;
                        }
                    }

                    // put min at the correct position
                    int temp = ar[step];
                    ar[step] = ar[min_idx];
                    ar[min_idx] = temp;
                
                try {
                    Thread.sleep(300);
                } catch (Exception ex) {
                }
                b.repaint();
        }
                break;
        }

    }

    int xloc = 0, yloc = 700, width = 40;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);

    }

    public void draw(Graphics g) {
        for (int x = 0; x < ar.length; x++) {
            xloc += width + 1;
            g.fillRect(xloc, yloc - ar[x], width, ar[x]);

        }
        xloc = 0;

    }

}
