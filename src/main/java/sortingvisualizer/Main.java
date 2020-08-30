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
import javax.swing.JTextField;

/**
 *
 * @author parmin
 */
public class Main extends JPanel {

    public static int[] ar = new int[65];

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Frame setting up
        JFrame a = new JFrame("Sorting Visualizer");
        Main b = new Main();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(1000, 600);
        JTextField newTitle = new JTextField("Some Title"); 
        newTitle.setBounds(80, 40, 225, 20);
        a.setVisible(true);

        a.add(b);

        a.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Random rd = new Random();
        for(int p = 0; p < 65;p++){
            ar[p] = rd.nextInt(550);
        }
        
        

        //a random number to decide which algorithm to use
        int algorithm = rd.nextInt(3);
        System.out.println(algorithm);

        switch (algorithm) {
            //code for Bubble Sort
            case 0:
                a.setTitle("Sorting Visualizer - Bubble Sort");
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
                            Thread.sleep(10);
                        } catch (Exception ex) {
                        }
                        b.repaint();
                    }

                }
                break;
             //code for Insertion Sort
            case 1:
                a.setTitle("Sorting Visualizer - Insertion Sort");
                for (int i = 0; i < ar.length; i++) {
                    int index = ar[i];
                    int j = i - 1;

                    while (j >= 0 && ar[j] > index) {
                        ar[j + 1] = ar[j];
                        j = j - 1;
                    }
                    ar[j + 1] = index;
                    try {
                        Thread.sleep(100);
                    } catch (Exception ex) {
                    }
                    b.repaint();
                }
                break;
            // code for Selection Sort 
            case 2:                
                a.setTitle("Sorting Visualizer - Selection Sort");
                for (int j = 0; j < ar.length - 1; j++) {
                    int min_index = j;

                    for (int i = j + 1; i < ar.length; i++) {
                        if (ar[i] < ar[min_index]) {
                            min_index = i;
                        }
                    }

                    // put min at the correct position
                    int temp = ar[j];
                    ar[j] = ar[min_index];
                    ar[min_index] = temp;
                
                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
                b.repaint();
        }
                break;
        }

    }
    //decides the dimensions on the arrays on the page
    int xloc = 0, yloc = 700, width = 20;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);

    }
    // draws the array that need to be sorted 
    public void draw(Graphics g) {
        for (int x = 0; x < ar.length; x++) {
            xloc += width + 1;
            g.fillRect(xloc, yloc - ar[x], width, ar[x]);

        }
        xloc = 0;

    }

}
