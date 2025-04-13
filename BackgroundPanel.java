package java_course;
import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            backgroundImage = icon.getImage();
            if (backgroundImage == null) {
                throw new Exception("Image not found.");
            }
        } catch (Exception e) {
            System.out.println("Error loading background image: " + e.getMessage());
            backgroundImage = null;  // Set to null if image loading fails
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Draw the background image to cover the entire panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            // Optionally, you can fill the background with a default color if image loading fails
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
