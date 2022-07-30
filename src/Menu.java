import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Menu {

    JFrame frame1 = new JFrame("Dragon's Dilemma");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();

    void createMenu() {

        Listener l1 = new Listener();

        b1.setText("Level 1");
        b1.addActionListener(l1);
        b1.setPreferredSize(new Dimension(640 / 5, 470));
        b1.setIcon(new ImageIcon("C:\\set1/level1.png"));
        b1.setBorder(new TitledBorder("Level 1"));

        b2.setText("Level 2");
        b2.addActionListener(l1);
        b2.setPreferredSize(new Dimension(640 / 5, 470));
        b2.setIcon(new ImageIcon("C:\\set1/level2.png"));
        b2.setBorder(new TitledBorder("Level 2"));

        b3.setText("Level 3");
        b3.addActionListener(l1);
        b3.setPreferredSize(new Dimension(640 / 5, 470));
        b3.setIcon(new ImageIcon("C:\\set1/level3.png"));
        b3.setBorder(new TitledBorder("Level 3"));

        b4.setText("Exit");
        b4.addActionListener(l1);
        b4.setPreferredSize(new Dimension(640 / 5, 470));
        b4.setIcon(new ImageIcon("C:\\set1/exit.png"));

        p1.add(new JLabel(new ImageIcon("C:\\set1/main.png")));
        p2.add(b1);
        p3.add(b2);
        p4.add(b3);
        p5.add(b4);


        frame1.setLayout(new GridLayout(1, 4));
        frame1.add(p1);
        frame1.add(p2);
        frame1.add(p3);
        frame1.add(p4);
        frame1.add(p5);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setSize(660, 505);
        frame1.setResizable(false);
        frame1.setVisible(true);

    }

    

    public class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            System.out.println("Game Starts");
            JFrame frame = new JFrame("Dragon's Dillema");

            boolean on1st = true;
            boolean on2nd = false;
            boolean on3rd = false;
            frame.setSize(1920, 1080);
            Background lb1 = new Background(1);
            Background lb2 = new Background(2);
            Background lb3 = new Background(3);

            if (e.getSource() == b1 && on1st == true) {

                String FILENAME = "E:\\File.txt";
                BufferedWriter bw = null;
                FileWriter fw = null;

                try {

                    String content = "0";

                    fw = new FileWriter(FILENAME);
                    bw = new BufferedWriter(fw);
                    bw.write(content);

                   // System.out.println("Done");

                } catch (IOException ee) {

                    ee.printStackTrace();

                } finally {

                    try {

                        if (bw != null) {
                            bw.close();
                        }

                        if (fw != null) {
                            fw.close();
                        }

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }

                }

                //KAJ
                frame.add(lb1);
                frame.setVisible(true);

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }

            if (e.getSource() == b2) {

                int go = 0;
                String FILENAME = "E:\\File.txt";
                BufferedReader br = null;
                FileReader fr = null;

                try {

                    fr = new FileReader(FILENAME);
                    br = new BufferedReader(fr);

                    String sCurrentLine;

                    br = new BufferedReader(new FileReader(FILENAME));

                    while ((sCurrentLine = br.readLine()) != null) {
                        go = Integer.parseInt(sCurrentLine);
                        lb2.score = go;
                    }

                } catch (IOException ee2) {

                    ee2.printStackTrace();

                } finally {

                    try {

                        if (br != null) {
                            br.close();
                        }

                        if (fr != null) {
                            fr.close();
                        }

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }
                }

                if (go >= 2) {
                    on2nd = true;
                }

                if (on2nd == true) {

                    frame.add(lb2);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
            }
            if (e.getSource() == b3) {
                int go = 0;
                String FILENAME = "E:\\File.txt";
                BufferedReader br = null;
                FileReader fr = null;

                try {

                    fr = new FileReader(FILENAME);
                    br = new BufferedReader(fr);

                    String sCurrentLine;

                    br = new BufferedReader(new FileReader(FILENAME));

                    while ((sCurrentLine = br.readLine()) != null) {
                        go = Integer.parseInt(sCurrentLine);
                        lb3.score = go;
                    }

                } catch (IOException ee2) {

                    ee2.printStackTrace();

                } finally {

                    try {

                        if (br != null) {
                            br.close();
                        }

                        if (fr != null) {
                            fr.close();
                        }

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }
                }

                if (go >= 6) {
                    on2nd = false;
                    on3rd = true;
                }

                if (on3rd == true) {
                    FILENAME = "E:\\File.txt";
                    BufferedWriter bw = null;
                    FileWriter fw = null;

                    try {

                        String content = "0";
                        System.out.println("HERE");
                        fw = new FileWriter(FILENAME);
                        bw = new BufferedWriter(fw);
                        bw.write(content);

                    } catch (IOException ee) {

                        ee.printStackTrace();

                    } finally {

                        try {

                            if (bw != null) {
                                bw.close();
                            }

                            if (fw != null) {
                                fw.close();
                            }

                        } catch (IOException ex) {

                            ex.printStackTrace();

                        }

                    }

                    frame.add(lb3);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
            if (e.getSource() == b4) {

                System.exit(0);
            }

        }

    }

}
