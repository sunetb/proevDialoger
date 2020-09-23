package com.company;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpelGUI extends JPanel implements ActionListener {
    protected JButton b1, b2;
    JLabel tekst;
    JTextField inputTekst;


    public SimpelGUI() {


        b1 = new JButton("OK");
        b1.setActionCommand("ok");
        b1.addActionListener(this);

        b2 = new JButton("Annuller");
        b2.setActionCommand("annuller");
        b2.addActionListener(this);

        tekst = new JLabel();
        tekst.setText("Skriv din alder og tryk OK");

        inputTekst = new JTextField("", 10);
        //Add Components to this container, using the default FlowLayout.
        add(tekst);
        add(inputTekst);
        add(b1);
        add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String mærkat = e.getActionCommand();
        System.out.println("Der blev trykket på: " + mærkat);
        if ("ok".equals(e.getActionCommand())) {
            String alder = inputTekst.getText();
            tekst.setText("Du er " + alder + " år gammel");

        } else if ("annuller".equals(e.getActionCommand())){
            tekst.setText("Ok prøv igen");
        }

        inputTekst.setText("");

    }


    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        SimpelGUI newContentPane = new SimpelGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}