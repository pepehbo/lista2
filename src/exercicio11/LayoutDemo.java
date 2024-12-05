package exercicio11;

import javax.swing.*;
import java.awt.*;

/**
 * Demonstrates different layout managers in Swing.
 */
public class LayoutDemo extends JFrame {
    public LayoutDemo() {
        setTitle("Layout Managers Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        
        // Add layout examples
        tabbedPane.addTab("Flow Layout", createFlowLayoutPanel());
        tabbedPane.addTab("Border Layout", createBorderLayoutPanel());
        tabbedPane.addTab("Grid Layout", createGridLayoutPanel());
        tabbedPane.addTab("Box Layout", createBoxLayoutPanel());
        
        // Add to frame
        add(tabbedPane);
        
        // Pack and display
        pack();
        setLocationRelativeTo(null);
    }
    
    private JPanel createFlowLayoutPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
        
        for (int i = 1; i <= 5; i++) {
            panel.add(new JButton("Button " + i));
        }
        
        return panel;
    }
    
    private JPanel createBorderLayoutPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
        
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("East"), BorderLayout.EAST);
        panel.add(new JButton("West"), BorderLayout.WEST);
        panel.add(new JButton("Center"), BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createGridLayoutPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 3, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
        
        for (int i = 1; i <= 6; i++) {
            panel.add(new JButton("Button " + i));
        }
        
        return panel;
    }
    
    private JPanel createBoxLayoutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
        
        for (int i = 1; i <= 3; i++) {
            JButton button = new JButton("Button " + i);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(button);
            panel.add(Box.createVerticalStrut(5));
        }
        
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LayoutDemo().setVisible(true);
        });
    }
}