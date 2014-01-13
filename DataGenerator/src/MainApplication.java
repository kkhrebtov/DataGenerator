/**
 * Created by kkhrebtov on 12/26/13.
 */
import au.com.bytecode.opencsv.CSVReader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.*;

import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class MainApplication extends JDialog implements ActionListener, ItemListener {

    final String[] events = {
            "Opportunity", "Lead",
            "Stage", "Account",
            "Contact"
    };

    final String[] leadAttributes = {
            "Company", "Name",
            "Title","Email",
            "Phone", "Status"
    };

    final String[] accountAttributes = {
            "Account Number","Name",
            "Description", "Account Source"
    };

    final String[] contactAttributes = {
            "Name", "Role",
            "Title", "Email", "Phone"
    };

    private JComboBox combobox = null;
    private JComboBox accounts = null;
    private JButton   button = null;



    public MainApplication() {

        System.out.println("Call MainApplication constructor");
        initUI();

    }

    private String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    private void initUI() {

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        combobox = new JComboBox(events);
        combobox.setSelectedIndex(-1);
        combobox.setLocation(00, 20);
        combobox.setPreferredSize(new Dimension(140, 22));
        combobox.setMaximumSize(new Dimension(140, 22));
        combobox.addItemListener(this);
        add(combobox);

        try {
        accounts = new JComboBox(readLines("D:\\DataGenerator\\DataGenerator\\src\\accounts.txt"));
        accounts.setSelectedIndex(-1);
        accounts.setLocation(00, 50);
        accounts.setPreferredSize(new Dimension(220, 22));
        accounts.setMaximumSize(new Dimension(220, 22));
        accounts.addItemListener(this);
        add(accounts);

        } catch (IOException e) {System.out.println("Can't find file accounts.txt");}

        add(Box.createRigidArea(new Dimension(0, 15)));

        button = new JButton("Close");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        add(button);

        setSize(300, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();

            switch(index) {
                case 0:
                    System.out.println("Opportunity Selected");
                    OpportunityForm oppForm = new OpportunityForm();
                    break;
                case 1:
                    System.out.println("Lead Selected");
                    LeadForm leadForm = new LeadForm();
                    break;

                case 4:
                    ContactForm contactForm = new ContactForm();
                    break;
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {

     new MainApplication();

    }
}