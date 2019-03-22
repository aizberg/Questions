package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static java.awt.Frame.MAXIMIZED_BOTH;
import static javax.swing.JOptionPane.showMessageDialog;

public class MainQuestion {

    private JFrame window;

    private boolean mode;

    public MainQuestion(){

        window = new JFrame("TEST");
//        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setJMenuBar(CreateMenuBar());

        window.add(new TestPane1());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);

//        window.add(new JScrollPane(new JTextArea(null, null, 10, 5)));
    }

    public static class TestPane1 extends JFrame {



        private JTextArea ta[] = new JTextArea[5];
        private JTextArea ta2[] = new JTextArea[5];
        private JRadioButton rb[] = new JRadioButton[5];
        private JCheckBox chb[] = new JCheckBox[5];
        private JLabel l[] = new JLabel[6];
        private JLabel l2[] = new JLabel[6];

        boolean checkBVisibly = false;


        private JTextArea ta1;
        //        private JTextArea ta1;
        private JButton button, button2;
        private JLabel l1;
//        private JFrame jFrame;

        JRadioButton rb1, rb2;

        private GridBagConstraints gbc = new GridBagConstraints();

        TestPane1() {

            JFrame window = new JFrame("TEST");
            window.getContentPane().setLayout(new GridBagLayout());
//        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//
//            window.pack();
//            window.setLocationRelativeTo(null);
//            window.setResizable(false);
//            window.setVisible(true);
//            window.setExtendedState(MAXIMIZED_BOTH);

            window.getContentPane().setLayout(new GridBagLayout());
            window.getContentPane().setBackground(new Color(52, 124, 155));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 5, 5, 5);

            JPanel jpLeft = new JPanel();
            jpLeft.add(LeftPanel());

            JPanel jpCenter = new JPanel();
            jpCenter.add(CenterPanel());

            JPanel jpRight = new JPanel();
            jpRight.add(RightPanel());

            JPanel jpBottom = new JPanel();
            jpBottom.add(BottomPanel());

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            window.getContentPane().add(jpLeft, gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.gridheight = GridBagConstraints.RELATIVE;
            window.getContentPane().add(jpCenter, gbc);

            gbc.gridx = 4;
            gbc.gridy = 0;
            window.getContentPane().add(jpRight, gbc);

            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            window.getContentPane().add(jpBottom, gbc);


            button = new JButton("Add question");
            gbc.gridx = 5;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.EAST;
            window.getContentPane().add(button, gbc);

            button2 = new JButton("Clean All");
            gbc.gridx = 4;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.WEST;
            window.getContentPane().add(button2, gbc);

            rb1.addActionListener(e -> {

                checkBVisibly = !checkBVisibly;
                for (int i = 0; i < 5; i++){
                    rb[i].setVisible(true);
                    chb[i].setVisible(false);
                }

            });

            rb2.addActionListener(e -> {

                checkBVisibly = !checkBVisibly;
                for (int i = 0; i < 5; i++){
                    rb[i].setVisible(false);
                    chb[i].setVisible(true);
                }
            });

            button.addActionListener(e -> {

                Question q = new Question();
                Answer a[] = new Answer[5];

                if (ta1.getText() != null && !ta1.getText().equals("")) {
                    q.setQuestion(ta1.getText());
                } else {
                    showMessageDialog(null, "My Goodness, this is so concise");
                    return;
                }

                for (int i = 0; i < 5; i++) {
                    if (ta[i] != null && ta[i].getText() != null && !ta[i].getText().equals("")) {
                        a[i] = new Answer(ta[i].getText(), rb1.isSelected() ? rb[i].isSelected() : chb[i].isSelected(), ta2[i].getText());
                    } else {
                        showMessageDialog(null, "Check all answers");
                        return;
                    }
                }

                q.setAnswers(a);

                writeToFile(q);
            });

            button2.addActionListener(e -> {
                for (JTextArea i : ta) {
                    i.setText("");
                }

                ta1.setText("");

                for (JTextArea ta : ta2) {
                    ta.setText("");
                }
            });


//            window.getContentPane().add(butPanel, BorderLayout.NORTH);
//            window.getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//            window.setPreferredSize(new Dimension(250, 200));
//            window.pack();
//            window.setLocationRelativeTo(null);
//            window.setVisible(true);

            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            window.setJMenuBar(CreateMenuBar());

//            window.add(new TestPane1());
            window.pack();
            window.setLocationRelativeTo(null);
            window.setResizable(false);
            window.setVisible(true);
            window.setExtendedState(MAXIMIZED_BOTH);

        }

//        @Override
//        public Dimension getPreferredSize() {
//            return new Dimension(1200, 1000);
//        }

        private JMenuBar CreateMenuBar(){
            JMenuBar menuBar = new JMenuBar();

            JMenu file = new JMenu("Файл");
            JMenuItem item1 = new JMenuItem("Change");
            JMenuItem item2 = new JMenuItem("Закрыть");
            file.add(item1);
            file.add(item2);

            menuBar.add(file);

            item1.addActionListener(e -> {
//                    mode = !mode;
//                    window.add(new TestPane1(false));

                ta2[3].setText("Worked");



//                window.pack();
            });

            item2.addActionListener(e -> System.exit(0));

            return menuBar;
        }

        private void newRow(GridBagConstraints gbc) {
            gbc.gridy = gbc.gridy + 1;
        }

        private JPanel LeftPanel() {

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            ta1 = new JTextArea(null, 53, Toolkit.getDefaultToolkit().getScreenSize().width / (12 * 3));
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = 1;

            panel.add(new JScrollPane(ta1), gbc);

            return panel;
        }

        private JPanel CenterPanel() {


            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
//            panel.setBackground(new Color(52, 124, 155));

            gbc.gridy = 0;
            ButtonGroup bg = new ButtonGroup();

            for (int i = 0; i < 5; i++) {
                gbc.gridx = 0;

                l[i] = new JLabel("Answer №" + i);
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                panel.add(l[i], gbc);
                newRow(gbc);

                chb[i] = new JCheckBox();
                chb[i].setSelected(false);
                gbc.anchor = GridBagConstraints.WEST;
                gbc.gridwidth = GridBagConstraints.RELATIVE;
                panel.add(chb[i], gbc);
//                newRow(gbc);
//                gbc.gridx++;

                chb[i].setVisible(checkBVisibly);

                rb[i] = new JRadioButton();
                rb[i].setSelected(false);
//                gbc.anchor = GridBagConstraints.WEST;
                bg.add(rb[i]);
                panel.add(rb[i], gbc);
//                newRow(gbc);
                rb[i].setVisible(!checkBVisibly);


                gbc.gridx = 1;
                ta[i] = new JTextArea(null, null, 8, Toolkit.getDefaultToolkit().getScreenSize().width / (12 * 3));
                gbc.anchor = GridBagConstraints.EAST;
                panel.add(new JScrollPane(ta[i]), gbc);
                newRow(gbc);

            }

            return panel;
        }

        private JPanel RightPanel() {

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

//            if (!mode){
                gbc.gridy = 0;
                for (int i = 0; i < 5; i++) {
                    gbc.gridx = 0;

                    l2[i] = new JLabel("Answer №" + i);
                    gbc.anchor = GridBagConstraints.WEST;
                    panel.add(l2[i], gbc);
                    gbc.gridy++;

                    ta2[i] = new JTextArea(null, null, 8, 50);
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.anchor = GridBagConstraints.EAST;
                    panel.add(new JScrollPane(ta2[i]), gbc);
                    newRow(gbc);

                }
//            } else {
//                JLabel label = new JLabel("fljkghls;fdlkjsdfnkjg");
//
////                gbc.gridx = 0;
//                gbc.fill = GridBagConstraints.BOTH;
//                panel.add(label, gbc);
//
//            }



            return panel;


        }

        private JPanel BottomPanel() {
            JPanel panel = new JPanel();


            ButtonGroup bg1 = new ButtonGroup();
            GridBagConstraints gbctest = new GridBagConstraints();
            gbctest.insets = new Insets(5,5,5,5);

            rb1 = new JRadioButton("Один вариант");
            rb2 = new JRadioButton("Несколько вариантов");
            bg1.add(rb1);
            bg1.add(rb2);

            gbctest.gridx = 0;
            gbctest.anchor = GridBagConstraints.WEST;
            panel.add(rb1, gbctest);

            gbctest.gridx = 1;
            gbctest.anchor = GridBagConstraints.EAST;
            panel.add(rb2, gbctest);

            rb1.setSelected(true);


            return panel;
        }
    }

    private JMenuBar CreateMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        JMenuItem item1 = new JMenuItem("Change");
        JMenuItem item2 = new JMenuItem("Закрыть");
        file.add(item1);
        file.add(item2);

        menuBar.add(file);

        item1.addActionListener(e -> {

            window.getContentPane();
            mode = !mode;
            window.add(new TestPane1());


//                window.pack();
        });

        item2.addActionListener(e -> System.exit(0));

        return menuBar;
    }

    private static void writeToFile(Question question) {

        try(FileReader reader = new FileReader("javaQuestios.txt")){

                        /*BufferedReader br = new BufferedReader(reader);

                        String line = null;
                        String text = "";

                        while ((line = br.readLine()) != null){
                            text = text.concat(line) + System.lineSeparator();
                        }*/

//                    ta[2].setText("IT WORKS " + i++);

                    try(FileWriter writer = new FileWriter("javaQuestios.txt", true))
                    {
                        String quest = "Вопрос";
                        String answ = "Ответ";
                        String info = "Инфо";
                        String start = "Начало";
                        String end = "Конец";
                        String newRow = String.format("%n");

                        // запись всей строки
//                        String text = ta[1].getText();
//                        writer.write(text);

                        writer.write(quest + start);
                        writer.write(newRow);
                        writer.write(question.getQuestion());
                        writer.write(newRow);
                        writer.write(quest + end);
                        writer.write(newRow);

                        for (Answer a : question.getAnswers()) {

                            writer.write(answ + start);
                            writer.write(newRow);
                            writer.write(a.isRight() ? "true" : "false");
                            writer.write(newRow);
                            writer.write(a.getAnswer());
                            writer.write(newRow);
                            writer.write(answ + end);
                            writer.write(newRow);

                            writer.write(info + start);
                            writer.write(newRow);
                            if (a.getInfo() != null && !a.getInfo().equals("")){
                                writer.write(a.getInfo());
                                writer.write(newRow);
                            }
                            writer.write(info + end);
                            writer.write(newRow);
                        }


                        // запись по символам
//                    writer.append('\r');
//                        writer.append(newRow);
//                        writer.append('E');

                        writer.flush();
                    }
                    catch(IOException ex){

                        showMessageDialog(null, "something wrong");
                    }

        } catch(IOException ex){
            showMessageDialog(null, "This is even shorter");
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame.setDefaultLookAndFeelDecorated(true);
            new TestPane1();
        });

    }


}