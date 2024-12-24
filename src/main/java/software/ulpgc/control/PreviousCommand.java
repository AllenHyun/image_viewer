package software.ulpgc.control;

import software.ulpgc.view.ImageDisplay;

public class PreviousCommand implements Command{
    private final ImageDisplay display;
    public PreviousCommand(ImageDisplay display){
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(display.currentImage().previous());
    }
}
