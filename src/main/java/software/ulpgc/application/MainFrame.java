package software.ulpgc.application;

import software.ulpgc.control.Command;
import software.ulpgc.view.ImageDisplay;
import software.ulpgc.model.Image;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class MainFrame extends JFrame {
    private final SwigImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    private MainFrame() throws HeadlessException{
        this.commands = new HashMap<>();
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(imageDisplay = creatImageDisplay());
        this.add(toolbar(), BorderLayout.SOUTH);
    }

    private Component button(String name){
        JButton button = new JButton(name);
        button.addActionListener(e -> commands.get(name).execute());
        return button;
    }

    public ImageDisplay imageDisplay(){
        return imageDisplay;
    }
    public  SwigImageDisplay creatImageDisplay(){
        return new SwigImageDisplay(new SwigImageDeserializer());
    }

    public MainFrame initWidth(Image image){
        imageDisplay.show(image);
        return this;
    }

    public static MainFrame create(){
        return new MainFrame();
    }

    public MainFrame add(String name, Command command){
        commands.put(name, command);
        return this;
    }
}
