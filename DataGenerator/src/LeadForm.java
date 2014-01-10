import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by kkhrebtov on 1/10/14.
 */
public class LeadForm extends JDialog implements ActionListener, ItemListener {

    private JComboBox companyNameComboBox;
    private JComboBox titleComboBox;
    private JTextField leadNameTextField;
    private JComboBox EmailText;
    private JTextField phoneTextField;
    private JComboBox statusComboBox;
    private JButton cleanFormButton;
    private JButton createButton;
    private JButton generateSQLButton;


    public LeadForm() {

        cleanFormButton.addActionListener(new ButtonListener() {
        });
        createButton.addActionListener(new ButtonListener() {
        });
        generateSQLButton.addActionListener(new ButtonListener() {
        });

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();

            String label = o.getText();
            System.out.println("Button " + label + " pressed");

        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox combo = (JComboBox) e.getSource();
            int index = combo.getSelectedIndex();

            switch(index) {
                case 0:
                    System.out.println("Selected Opportunity");
                    OpportunityForm oppForm = new OpportunityForm();
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
}
