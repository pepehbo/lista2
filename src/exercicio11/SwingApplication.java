package exercicio11;

import javax.swing.*;
import java.awt.*;

/**
 * Main application that demonstrates all Swing examples.
 */
public class SwingApplication extends JFrame {
    public SwingApplication() {
        setTitle("Swing Examples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));
        
        // Create buttons to launch demos
        JButton basicButton = new JButton("Basic Components Demo");
        JButton selectionButton = new JButton("Selection Components Demo");
        JButton menuButton = new JButton("Menu Demo");
        JButton layoutButton = new JButton("Layout Demo");
        
        // Add action listeners
        basicButton.addActionListener(e -> new BasicComponentsDemo().setVisible(true));
        selectionButton.addActionListener(e -> new SelectionComponentsDemo().setVisible(true));
        menuButton.addActionListener(e -> new MenuDemo().setVisible(true));
        layoutButton.addActionListener(e -> new LayoutDemo().setVisible(true));
        
        // Add buttons to frame
        add(basicButton);
        add(selectionButton);
        add(menuButton);
        add(layoutButton);
        
        // Set size and display
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SwingApplication().setVisible(true);
        });
    }
}