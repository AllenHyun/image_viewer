package software.ulpgc.application;

import software.ulpgc.control.NextCommand;
import software.ulpgc.control.PreviousCommand;
import software.ulpgc.io.FileImageLoader;
import software.ulpgc.model.Image;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.create();
        mainFrame
                .initWidth(firstImage())
                .add("next", new NextCommand(mainFrame.imageDisplay()))
                .add("previous", new PreviousCommand(mainFrame.imageDisplay()))
                .setVisible(true);
    }

    private static Image firstImage(){
        return new FileImageLoader(new File("images")).load();
    }
}
