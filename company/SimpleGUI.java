package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;



public class SimpleGUI {

    private JTextField text1 = new JTextField("", 2);
    private JComboBox<String> comboBox = new JComboBox<String>();

    private JTextField text2 = new JTextField("", 2);
    private JButton button21 = new JButton("изменение названия");
    private JButton button22 = new JButton("обмен названиями");

    private JTextField text3 = new JTextField("", 2);
    private JRadioButton radioButton31 = new JRadioButton("one");
    private JRadioButton radioButton32 = new JRadioButton("two");
    private JRadioButton radioButton33 = new JRadioButton("three");

    private JTextField text4 = new JTextField("", 2);
    private JCheckBox checkBox41 = new JCheckBox("one");
    private JCheckBox checkBox42 = new JCheckBox("two");
    private JCheckBox checkBox43 = new JCheckBox("three");

    private JTextField text5 = new JTextField("", 2);
    private JTable table = new JTable(0,0);
    private DefaultTableModel model = (DefaultTableModel) table.getModel();


    public SimpleGUI() {

        JFrame container = new JFrame() {};
        container.setVisible(true);
        container.setBounds(150, 1, 1200,500);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new GridLayout( 3, 2, 1, 3));

        Label label1 = new Label("Punkt #1 ");
        JButton button11 = new JButton("внести");

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


        Label label2 = new Label("Punkt #2 ");

        JPanel panelTwo = new JPanel();
        panelTwo.add(label2);
        text2.setColumns(10);
        panelTwo.add(text2);
        button21.addActionListener(new ButtonEventTwo());
        panelTwo.add(button21);
        button22.addActionListener(new ButtonEventThree());
        panelTwo.add(button22);
        container.add(panelTwo);

        Label label3 = new Label("Punkt #3 ");
        JButton button31 = new JButton("выбрать");

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

        Label label4 = new Label("Punkt #4 ");
        JButton button41 = new JButton("пометить");

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

        Label label5 = new Label("Punkt #5 ");
        JButton button51 = new JButton("добавить");
        JButton button52 = new JButton("сместить вправо");
        JButton button53 = new JButton("сместить влево");
        JScrollPane scrollPane = new JScrollPane(table);

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
        container.add(panelFive);

        JPanel panelSix = new JPanel();
        int i=3;
        String tabletext1 =" первый столбец", tabletext2 =" второй столбец";
        Vector col = new Vector();
        panelSix.add(scrollPane);
        col.addElement(tabletext1);
        col.addElement(tabletext2);
        model.setColumnIdentifiers(col);
        TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
        TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);
        String str1 = moveString(tabletext1);
        String str2 = moveString(tabletext2);

        while (i<5) {
           /* start1 = tabletext1.substring(14, 15);
            tabletext1 = start1 + tabletext1;
            str1 = tabletext1.substring(0, 15);

            start2 = tabletext2.substring(14, 15);
            tabletext2 = start2 + tabletext2;
            str2 = tabletext2.substring(0, 15);*/

            str1 = moveString(str1);
            str2 = moveString(str2);

            column1.setHeaderValue(moveString(str1));
            column2.setHeaderValue(moveString(str2));
            container.add(panelSix);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
            }
        }


    }

    public String moveString(String text) {
        String str;
        int a = text.length() - 1;
        str = text.substring(text.length() - 1) + text.substring(0, a);
        return str;
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
                boolean one = checkBox41.isSelected();
                checkBox41.setSelected(!one);
            }
            else if (vibor4.equals("two")) {
                boolean two = checkBox42.isSelected();
                checkBox42.setSelected(!two);
            }
            else if (vibor4.equals("three")) {
                boolean three = checkBox43.isSelected();
                checkBox43.setSelected(!three);
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
        }
    }
    class ButtonEventSeven implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            String tableText = (String) table.getValueAt(row, 0);
            if (tableText.equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "ячейка пуста", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                table.setValueAt(tableText, row, 1);
                table.setValueAt("", row, 0);
            }
        }
    }
    class ButtonEventEight implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            String tableText = (String) table.getValueAt(row, 1);
            if (tableText.equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "ячейка пуста", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                table.setValueAt(tableText, row, 0);
                table.setValueAt("", row, 1);
            }
        }
    }
}

