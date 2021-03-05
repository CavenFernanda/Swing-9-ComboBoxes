package swing.pkg3.forms;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final TextPanel textPanel;
    private final ToolBar toolBar;
    private final FormPanel formPanel;

    public MainFrame() {

        super("Hello World");
        this.toolBar = new ToolBar();
        this.textPanel = new TextPanel();
        this.formPanel = new FormPanel();

        toolBar.setStringLister(textPanel::apendText);

        formPanel.setFormListener(new FormListener() {

            @Override
            public void formEventOccurred(FormEvent e) {

                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCategory = e.getAgeCategory();
                String employment = e.getEmployment();
                
                textPanel.apendText("Name: "+name+" \nOccupation: "+occupation+"\nAge Category: "+ageCategory+"\nEmployment Status: "+employment+"\n-----------------------------\n");
            }
        });

        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(formPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
