import java.awt.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by kkhrebtov on 12/30/13.
 */
public class OpportunityForm extends JDialog implements ActionListener, ItemListener {

    final String[] opportunityAttributes = {
            "Expected Close Date", "Amount",
            "Name","Description",
            "Stage Name", "Stage Description",
            "Status", "Result"};

    ArrayList createdOpportunities = new ArrayList();

    int oppsCounter = 0;

    private JTextField eventTsText = null;
    private JLabel eventTsLabel = null;

    private JTextField ECDText = null;
    private JLabel ECDLabel = null;

    private JTextField amountText = null;
    private JLabel amountLabel = null;

    private JTextField nameText = null;
    private JLabel nameLabel = null;

    private JTextField descriptionText = null;
    private JLabel descriptionLabel = null;

    private JTextField stageNameText = null;
    private JLabel stageNameLabel = null;

    private JTextField stageDescrText = null;
    private JLabel stageDescrLabel = null;

    private JTextField statusText = null;
    private JLabel statusLabel = null;

    private JTextField resultText = null;
    private JLabel resultLabel = null;

    private JButton createButton = null;
    private JButton cleanFormButton = null;
    private JButton generateSQLButton = null;

    public OpportunityForm() {

        System.out.println("Create new Opportunity");

        setLayout(new BoxLayout(getContentPane(),
                BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(0, 35)));

        eventTsText  = new JTextField("2011-07-11 11:00:00.000 +0:00");
        eventTsLabel = new JLabel();

        ECDText = new JTextField("2011-07-11 11:00:00.000 +0:00");
        ECDLabel = new JLabel();

        amountText = new JTextField("1000");
        amountLabel = new JLabel();

        nameText = new JTextField();
        nameLabel = new JLabel();

        descriptionText = new JTextField();
        descriptionLabel = new JLabel();

        stageNameText = new JTextField();
        stageNameLabel = new JLabel();

        stageDescrText = new JTextField();
        stageDescrLabel = new JLabel();

        statusText = new JTextField();
        statusLabel = new JLabel();

        resultText = new JTextField();
        resultLabel = new JLabel();

        createButton = new JButton("Create");
        cleanFormButton = new JButton("Clean Form");
        generateSQLButton = new JButton("Generate SQL");

        eventTsText.setBounds(210, 0, 190, 30);
        eventTsLabel.setBounds(30, 0, 150, 30);
        eventTsLabel.setText("Event TS");

        ECDText.setBounds(210, 30, 190, 30);
        ECDLabel.setBounds(30, 30, 150, 30);
        ECDLabel.setText("Expected Close Date");

        amountText.setBounds(210, 60, 150, 30);
        amountLabel.setBounds(30, 60, 80, 30);
        amountLabel.setText("Amount");

        nameText.setBounds(210, 90, 150, 30);
        nameLabel.setBounds(30, 90, 80, 30);
        nameLabel.setText("Name");

        descriptionText.setBounds(210, 120, 150, 30);
        descriptionLabel.setBounds(30, 120, 80, 30);
        descriptionLabel.setText("Description");

        stageNameText.setBounds(210, 150, 150, 30);
        stageNameLabel.setBounds(30, 150, 80, 30);
        stageNameLabel.setText("Stage Name");

        stageDescrText.setBounds(210, 180, 150, 30);
        stageDescrLabel.setBounds(30, 180, 80, 30);
        stageDescrLabel.setText("Stage Description");

        statusText.setBounds(210, 210, 150, 30);
        statusLabel.setBounds(30, 210, 80, 30);
        statusLabel.setText("Status");

        resultText.setBounds(210, 240, 150, 30);
        resultLabel.setBounds(30, 240, 80, 30);
        resultLabel.setText("Result");

        createButton.setBounds(210, 270, 90, 30);
        cleanFormButton.setBounds(210, 300, 120, 30);
        generateSQLButton.setBounds(210, 330, 120, 30);

        setLayout(null);

        add(eventTsLabel);
        add(eventTsText);

        add(ECDText);
        add(ECDLabel);

        add(amountText);
        add(amountLabel);

        add(nameText);
        add(nameLabel);

        add(descriptionText);
        add(descriptionLabel);

        add(stageNameText);
        add(stageNameLabel);

        add(stageDescrText);
        add(stageDescrLabel);

        add(statusText);
        add(statusLabel);

        add(resultText);
        add(resultLabel);

        add(createButton);
        add(cleanFormButton);
        add(generateSQLButton);

        setSize(420, 490);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        cleanFormButton.addActionListener(new ButtonListener());
        createButton.addActionListener(new ButtonListener());
        generateSQLButton.addActionListener(new ButtonListener());

    }

    public Opportunity getOpportunity(int i) {
     return (Opportunity) createdOpportunities.get(i);
    }

    public int getOpportunitiesCount() {
        return createdOpportunities.size();
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

//    class TextListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            JTextField o = (JTextField) e.getSource();
//
//            String label = o.getName();
//
//            //switch(label){
//            //    case "ECD": ECDValue
//            //}
//        }
//    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton o = (JButton) e.getSource();

            String label = o.getText();
            System.out.println("Button " + label + " pressed");

            switch(label){
                case "Clean Form":
                    eventTsText.setText("2011-07-11 11:00:00.000 +0:00");
                    ECDText.setText("2011-07-11 11:00:00.000 +0:00");
                    nameText.setText("");
                    amountText.setText("1000");
                    descriptionText.setText("");
                    stageNameText.setText("");
                    stageDescrText.setText("");
                    statusText.setText("");
                    resultText.setText("");
                    break;
                case "Create":
                    createdOpportunities.add(new Opportunity(eventTsText.getText(), ECDText.getText(), nameText.getText(), amountText.getText(), descriptionText.getText(), stageNameText.getText(), stageDescrText.getText(), statusText.getText(),resultText.getText()));
                    oppsCounter++;
                    eventTsText.setText("2011-07-11 11:00:00.000 +0:00");
                    ECDText.setText("2011-07-11 11:00:00.000 +0:00");
                    nameText.setText("");
                    amountText.setText("1000");
                    descriptionText.setText("");
                    stageNameText.setText("");
                    stageDescrText.setText("");
                    statusText.setText("");
                    resultText.setText("");
                    System.out.println("Total opportunities created: " + createdOpportunities.size());
                    break;
                case "Generate SQL":
                    generateSQL(createdOpportunities);
            }
        }
    }

    private void generateSQL(ArrayList<Opportunity> createdOpportunities) {
        int event_id = 10;
        for (Opportunity opp: createdOpportunities) {

            String SQLexpression1 = "INSERT INTO AAL_EVENTS_DUMP_EVENTS (event_id_, user_, timestamp_, trigger_, category_ ) VALUES\n"+
                    "("+event_id+",'employee_name','"+opp.getEventTs()+"', 'OpenButtonClicked', 'WorkUnitStateChange:Open'),\n";


            String SQLexpression2 = "INSERT INTO AAL_EVENT_DUMP_EVENTS_DATA (event_id_, name_, value_ ) VALUES\n" +
                    "("+event_id+", 'planned_close_date', '"+opp.getECD()+"'),\n"+
                    "("+event_id+", 'amount', '"+opp.getAmount()+"'),\n"+
                    "("+event_id+", 'name', '"+opp.getName()+"'),\n"+
                    "("+event_id+", 'description', '"+opp.getDescription()+"'),\n"+
                    "("+event_id+", 'stage', '"+opp.getStageName()+"'),\n"+
                    "("+event_id+", 'stage_description', '"+opp.getStageDescription()+"'),\n"+
                    "("+event_id+", 'status', '"+opp.getStatus()+"'),\n"+
                    "("+event_id+", 'result', '"+opp.getResult()+"')\n";
            event_id+=10;
            System.out.println(SQLexpression1);
            System.out.println(SQLexpression2);

        }
    }

}
