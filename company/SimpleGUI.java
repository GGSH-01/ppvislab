package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;



public class SimpleGUI {


    private Label label1 = new Label("Punkt #1 ");
    private JButton button11 = new JButton("внести");
    private JTextField text1 = new JTextField("", 2);
    private JComboBox<String> comboBox = new JComboBox<String>();

    private Label label2 = new Label("Punkt #2 ");
    private JTextField text2 = new JTextField("", 2);
    private JButton button21 = new JButton("изменение названия");
    private JButton button22 = new JButton("обмен названиями");

    private Label label3 = new Label("Punkt #3 ");
    private JTextField text3 = new JTextField("", 2);
    private JButton button31 = new JButton("выбрать");
    private JRadioButton radioButton31 = new JRadioButton("one");
    private JRadioButton radioButton32 = new JRadioButton("two");
    private JRadioButton radioButton33 = new JRadioButton("three");

    private Label label4 = new Label("Punkt #4 ");
    private JTextField text4 = new JTextField("", 2);
    private JButton button41 = new JButton("пометить");
    private JCheckBox checkBox41 = new JCheckBox("one");
    private JCheckBox checkBox42 = new JCheckBox("two");
    private JCheckBox checkBox43 = new JCheckBox("three");

    private Label label5 = new Label("Punkt #5 ");
    private JTextField text5 = new JTextField("", 2);
    private JButton button51 = new JButton("добавить");
    private JButton button52 = new JButton("сместить вправо");
    private JButton button53 = new JButton("сместить влево");
    private JTable table = new JTable(0,0);
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JScrollPane scrollPane = new JScrollPane(table);



    public SimpleGUI() {

        JFrame container = new JFrame() {};
        container.setVisible(true);
        container.setBounds(500, 1, 600,730);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new GridLayout( 5, 1, 1, 3));

        JPanel panelOne = new JPanel();
        panelOne.add(label1);
        text1.setColumns(10);
        panelOne.add(text1);
        panelOne.add(button11);
        // comboBox.setPrototypeDisplayValue("                    ");
        comboBox.setSize(150,50);
        panelOne.add(comboBox);
        button11.addActionListener(new ButtonEventOne());
        container.add(panelOne);


        JPanel panelTwo = new JPanel();
        panelTwo.add(label2);
        text2.setColumns(10);
        panelTwo.add(text2);
        button21.addActionListener(new ButtonEventTwo());
        panelTwo.add(button21);
        button22.addActionListener(new ButtonEventThree());
        panelTwo.add(button22);
        container.add(panelTwo);

        JPanel panelThree = new JPanel();
        panelThree.add(label3);
        text3.setColumns(10);
        panelThree.add(text3);
        panelThree.add(button31);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton31);
        buttonGroup.add(radioButton32);
        buttonGroup.add(radioButton33);
        panelThree.add(radioButton31);
        panelThree.add(radioButton32);
        panelThree.add(radioButton33);
        button31.addActionListener(new ButtonEventFour());
        container.add(panelThree);

        JPanel panelFour = new JPanel();
        panelFour.add(label4);
        text4.setColumns(10);
        panelFour.add(text4);
        panelFour.add(button41);
        panelFour.add(checkBox41);
        panelFour.add(checkBox42);
        panelFour.add(checkBox43);
        button41.addActionListener(new ButtonEventFive());
        container.add(panelFour);

        JPanel panelFive = new JPanel();
        panelFive.add(label5);
        text5.setColumns(10);
        panelFive.add(text5);
        panelFive.add(button51);
        button51.addActionListener(new ButtonEventSix());
        panelFive.add(button52);
        button52.addActionListener(new ButtonEventSeven());
        panelFive.add(button53);
        button53.addActionListener(new ButtonEventEight());
        panelFive.add(scrollPane);
        model.addColumn("Первый столбец");
        model.addColumn("Второй столбец");
        container.add(panelFive);





    }
    class  ButtonEventOne implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String items = text1.getText();
            Boolean proverka = false;
            int itemCount = comboBox.getItemCount();

            for (int i = 0; i < itemCount; i++) {
                if (items.equals(comboBox.getItemAt(i))) {
                    proverka = true;
                    JOptionPane.showMessageDialog(new JFrame(), "уже внесено", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (proverka == false) {
                comboBox.addItem(items);
            }
        }
    }

    class ButtonEventTwo implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                button21.setText(text2.getText());
            }
        }
    class ButtonEventThree implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String swapText = button21.getText();
            button21.setText(button22.getText());
            button22.setText(swapText);
        }
    }
    class ButtonEventFour implements ActionListener {
            public void actionPerformed(ActionEvent e) {
            String vibor3 = text3.getText();
            if (vibor3.equals("one")) {
                radioButton31.setSelected(true);
            }
            else if (vibor3.equals("two")) {
                radioButton32.setSelected(true);
            }
            else if (vibor3.equals("three")) {
                radioButton33.setSelected(true);
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "такой позиции не существует", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class ButtonEventFive implements ActionListener  {
        public void actionPerformed(ActionEvent e) {
            String vibor4 = text4.getText();
            if (vibor4.equals("one")) {
                checkBox41.setSelected(true);
            }
            else if (vibor4.equals("two")) {
                checkBox42.setSelected(true);
            }
            else if (vibor4.equals("three")) {
                checkBox43.setSelected(true);
            }
            else {
                JOptionPane.showMessageDialog(new JFrame(), "такой позиции не существует", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class ButtonEventSix implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String textField5 = text5.getText();
            model.addRow(new String[]{textField5, ""});
          /*  if (model.getRowCount() == 1) {
                table.setRowSelectionInterval(0, 0);
            }*/
        }
    }
    class ButtonEventSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            String tableText = (String) table.getValueAt(row, 0);
            table.setValueAt(tableText, row, 1);
            table.setValueAt("",row, 0);
        }
    }
    class ButtonEventEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            String tableText = (String) table.getValueAt(row, 1);
            table.setValueAt(tableText, row, 0);
            table.setValueAt("",row, 1);
        }
    }
}

