import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kkhrebtov on 1/9/14.
 */
public class ContactForm extends JDialog implements ActionListener, ItemListener {

    private JComboBox contactsList = null;

    public ContactForm() {

        CsvToBean<Contact> bean = new CsvToBean<Contact>();

        Map<String, String> columnMapping = new HashMap<String, String>();

        columnMapping.put("contact_name", "contactName");
        columnMapping.put("contact_role", "contactRole");
        columnMapping.put("contact_title", "contactTitle");
        columnMapping.put("email", "contactEmail");
        columnMapping.put("phone", "contactPhone");

        HeaderColumnNameTranslateMappingStrategy<Contact> strategy = new HeaderColumnNameTranslateMappingStrategy<Contact>();
        strategy.setType(Contact.class);
        strategy.setColumnMapping(columnMapping);

        List<Contact> list = null;
        File f = new File("d:\\DataGenerator\\DataGenerator\\resources\\contacts.csv");
        String[] contactNames = null;

        if(f.exists()) {
            CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("d:\\DataGenerator\\DataGenerator\\resources\\contacts.csv")));
            list = bean.parse(strategy, reader);


            int count = 0;
            for (Contact contact : list) {
                contactNames[count] = contact.getContactName();
                count++;
            }
        }

        System.out.println("Select Contact");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        contactsList = new JComboBox(contactNames);
        contactsList.setSelectedIndex(-1);
        contactsList.setLocation(00, 20);
        contactsList.setPreferredSize(new Dimension(140, 22));
        contactsList.setMaximumSize(new Dimension(140, 22));
        contactsList.addItemListener(this);
        add(contactsList);

        setSize(300, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();

        }

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }


}
