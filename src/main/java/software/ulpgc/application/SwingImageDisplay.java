package software.ulpgc.application;

import software.ulpgc.view.ImageDisplay;
import software.ulpgc.model.Image;
import software.ulpgc.view.ViewPort;
import software.ulpgc.io.ImageDeserializer;

import javax.swing.*;
import java.awt.*;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private final ImageDeserializer deserializer;
    private Image image;

    public SwingImageDisplay(ImageDeserializer deserializer) {
        this.deserializer = deserializer;
    }

    public Image currentImage() {
        return image;
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawImage(g);
    }

    private void drawImage(Graphics g) {
        java.awt.Image image = desearilize();
        ViewPort viewPort = ViewPort.ofSize(this.getWidth(), this.getHeight())
                .fit(image.getWidth(null), image.getHeight(null));
        g.drawImage(image,viewPort.x(), viewPort.y(),viewPort.width(), viewPort.height(), null);
    }

    private java.awt.Image desearilize() {
        return (java.awt.Image) deserializer.desearilize(image.content());
    }
}


