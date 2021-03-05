//this is the left hand size of the gui. Think of it as a navigation bar
package swing.pkg3.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

    private final JLabel nameL;
    private final JLabel occupationL;
    private JTextField nameTF;
    private JTextField occupationTF;
    private final JButton submitButton;
    private FormListener formListener;
    private JList ageList;
    private final JLabel ageL;
    private final JComboBox employmentCombo;
    private JLabel employmentComboL;

    public FormPanel() {
        Dimension dimension = getPreferredSize(); //setting the size of a form component
        dimension.width = 250;
        setPreferredSize(dimension);

        this.nameL = new JLabel("Name: ");
        this.occupationL = new JLabel("Occupation: ");
        this.nameTF = new JTextField(10); //how many characters wide it should be
        this.occupationTF = new JTextField(10);
        this.ageList = new JList(); //will be the age
        this.ageL = new JLabel("Range of Age: ");
        this.employmentCombo = new JComboBox();
        this.employmentComboL = new JLabel("Employment:");
        this.submitButton = new JButton("Submit");

        /// Creating the Age List 
        DefaultListModel ageModel = new DefaultListModel();//creating list
        ageModel.addElement(new AgeCategory(0, "Under 18"));//adding to the elements to list. The numbers before it represent its ID within the list
        ageModel.addElement(new AgeCategory(1, "18 - 65"));
        ageModel.addElement(new AgeCategory(2, "65 or over"));
        ageList.setModel(ageModel); //setting the list
        ageList.setPreferredSize(new Dimension(110, 68)); //setting the font size of the list
        ageList.setBorder(BorderFactory.createEtchedBorder()); //creating border arround list      
        ageList.setSelectedIndex(1); //selecting default selected value

        //Creating the employment combobox
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();//creating combobox
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Unemployed");
        employmentCombo.setModel(empModel); //setting the combobox
        employmentCombo.setSelectedIndex(0); //selecting default selected value 
        
        
        //functionality when button is pressed
        this.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTF.getText(); //assigning name to what the user entered
                String occupation = occupationTF.getText();//assigning name to what the user entered
                AgeCategory ageCategory = (AgeCategory) ageList.getSelectedValue();
                System.out.println(ageCategory.getID());
                String employment = (String) employmentCombo.getSelectedItem();

                FormEvent formEvent = new FormEvent(this, name, occupation, ageCategory.getID(),employment); //Passsing what the user entered to be stored in class FormEvent

                if (formListener != null) {

                    formListener.formEventOccurred(formEvent);
                }
            }

        });

        Border innnerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5); //Treat this as Padding
        setBorder(BorderFactory.createCompoundBorder(innnerBorder, outterBorder)); //Combinning the borders together

        layoutComppnents();
    }

    //This class is responsible for the overall layout of the Form Panel
    public void layoutComppnents() {
        setLayout(new GridBagLayout());//layout manager

        //This is like CSS for swing. You are decorating how you want the layout of the cells to be
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE; //Tells the componets to take up all the space in a cell or not

        //-------FIRST ROW (Name)---------///
        gc.weightx = 1; //padding
        gc.weighty = 0.1; //padding
        gc.gridx = 0;//laying out the components on a grid. This is the X-Axis. Moves from left to right
        gc.gridy = 0;//This is the Y - Axis. Moves from top to bottom
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameL, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameTF, gc);

        //-------SECOND ROW (Occupation)---------///
        gc.gridy++;
        gc.weightx = 1; //padding
        gc.weighty = 0.1; //padding

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 0);

        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationL, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationTF, gc);

        //-------THIRD ROW (List)---------///    
        gc.gridy++;
        gc.weightx = 1; //padding
        gc.weighty = 0.2; //padding

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(ageL, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);

        //-------FOURTH ROW (List)---------/// 
        gc.gridy++;
        gc.weightx = 1; //padding
        gc.weighty = 0.2; //padding

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(employmentComboL, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(employmentCombo, gc);

        //-------FITH ROW (List)---------///
        gc.gridy++;
        gc.weightx = 1; //padding
        gc.weighty = 2.0; //padding 

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submitButton, gc);

    }

    public void setFormListener(FormListener listener) {

        this.formListener = listener;
    }

}

//This class is used as a ID identifyer in the List of Ages
class AgeCategory {

    private final int id;
    private final String text;

    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text; //printing out the text on the list
    }

    public int getID() {
        return id; //returning the ID of the selected value from the list
    }
}
