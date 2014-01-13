import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by kkhrebtov on 1/10/14.
 */
public class LeadForm extends JDialog implements ActionListener, ItemListener {

    private JComboBox companyNameComboBox;
    private JLabel companyNameLabel;

    private JComboBox titleComboBox;
    private JLabel titleLabel;

    private JComboBox FirstNameTextField;
    private JLabel FirstNameLabel;

    private JTextField EmailText;
    private JLabel emailTextLabel;

    private JTextField phoneTextField;
    private JLabel phoneTextLabel;

    private JComboBox statusComboBox;
    private JLabel statusLabel;

    private JButton cleanFormButton;
    private JButton createButton;
    private JButton generateSQLButton;
    private JComboBox ownerIdComboBox;
    private JLabel ownerIdLabel;
    private JTextField convertedAccountIdTextField;
    private JLabel convertedAccountIdLabel;
    private JTextField convertedContactIdTextField;
    private JLabel  convertedContactIdLabel;
    private JTextField convertedOpportunityIdTextField;
    private JLabel convertedOpportunityIdLabel;
    private JTextField convertedDateTextField;
    private JLabel convertedDateLabel;
    private JTextField createdDateTextField;
    private JLabel createdDateLabel;
    private JRadioButton isConvertedRadioButton;


    public LeadForm() {

        System.out.println("Create new Lead");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        setSize(420, 490);
        setLayout(null);

        companyNameComboBox.setBounds(210, 0, 190, 22);
        companyNameLabel.setBounds(30, 0, 150, 22);

        titleComboBox.setBounds(210, 30, 190, 22);
        titleLabel.setBounds(30, 30, 150, 22);

        FirstNameTextField.setBounds(210, 60, 190, 22);
        FirstNameLabel.setBounds(30, 60, 150, 22);

        EmailText.setBounds(210, 90, 190, 22);
        emailTextLabel.setBounds(30, 90, 150, 22);

        phoneTextField.setBounds(210, 120, 190, 22);
        phoneTextLabel.setBounds(30, 120, 150, 22);

        statusComboBox.setBounds(210, 150, 190, 22);
        statusLabel.setBounds(30, 150, 150, 22);

        createButton.setBounds(210, 270, 90, 30);
        cleanFormButton.setBounds(210, 300, 120, 30);
        generateSQLButton.setBounds(210, 330, 120, 30);

        add(companyNameComboBox);
        add(companyNameLabel);

        add(titleComboBox);
        add(titleLabel);

        add(FirstNameTextField);
        add(FirstNameLabel);

        add(EmailText);
        add(emailTextLabel);

        add(phoneTextField);
        add(phoneTextLabel);

        add(statusComboBox);
        add(statusLabel);

        add(createButton);
        add(cleanFormButton);

        add(generateSQLButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

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
