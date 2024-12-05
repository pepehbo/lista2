package exercicio11;

import javax.swing.*;
import java.awt.*;

/**
 * Demonstrates basic Swing components like JFrame, JPanel, JLabel, JButton, 
 * JTextField, and JTextArea.
 */
public class BasicComponentsDemo extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    
    public BasicComponentsDemo() {
        // Set up the frame
        setTitle("Basic Components Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create components
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Enter text:");
        textField = new JTextField(20);
        JButton button = new JButton("Add Text");
        
        // Add components to input panel
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(button);
        
        // Create text area
        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Add action listener to button
        button.addActionListener(e -> {
            String text = textField.getText().trim();
            if (!text.isEmpty()) {
                textArea.append(text + "\n");
                textField.setText("");
            }
        });
        
        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Pack and display
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BasicComponentsDemo().setVisible(true);
        });
    }
}