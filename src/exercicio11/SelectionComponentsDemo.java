package exercicio11;

import javax.swing.*;
import java.awt.*;

/**
 * Demonstrates selection components like JCheckBox, JRadioButton, JComboBox, 
 * and JList.
 */
public class SelectionComponentsDemo extends JFrame {
    private JTextArea resultArea;
    
    public SelectionComponentsDemo() {
        setTitle("Selection Components Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create panels
        JPanel controlPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        JPanel checkBoxPanel = createCheckBoxPanel();
        JPanel radioPanel = createRadioPanel();
        JPanel comboPanel = createComboPanel();
        JPanel listPanel = createListPanel();
        
        // Add panels to control panel
        controlPanel.add(checkBoxPanel);
        controlPanel.add(radioPanel);
        controlPanel.add(comboPanel);
        controlPanel.add(listPanel);
        
        // Create result area
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        // Add components to frame
        add(controlPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
        
        // Pack and display
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel createCheckBoxPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Checkboxes"));
        
        JCheckBox[] boxes = {
            new JCheckBox("Option 1"),
            new JCheckBox("Option 2"),
            new JCheckBox("Option 3")
        };
        
        for (JCheckBox box : boxes) {
            panel.add(box);
            box.addActionListener(e -> updateResult());
        }
        
        return panel;
    }
    
    private JPanel createRadioPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Radio Buttons"));
        
        ButtonGroup group = new ButtonGroup();
        String[] options = {"Choice 1", "Choice 2", "Choice 3"};
        
        for (String option : options) {
            JRadioButton radio = new JRadioButton(option);
            group.add(radio);
            panel.add(radio);
            radio.addActionListener(e -> updateResult());
        }
        
        return panel;
    }
    
    private JPanel createComboPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("Combo Box"));
        
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> combo = new JComboBox<>(items);
        combo.addActionListener(e -> updateResult());
        panel.add(combo);
        
        return panel;
    }
    
    private JPanel createListPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder("List"));
        
        String[] items = {"List Item 1", "List Item 2", "List Item 3", "List Item 4"};
        JList<String> list = new JList<>(items);
        list.setVisibleRowCount(3);
        list.addListSelectionListener(e -> updateResult());
        panel.add(new JScrollPane(list));
        
        return panel;
    }
    
    private void updateResult() {
        resultArea.setText("Selection changed at: " + 
            java.time.LocalTime.now().toString() + "\n");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SelectionComponentsDemo().setVisible(true);
        });
    }
}