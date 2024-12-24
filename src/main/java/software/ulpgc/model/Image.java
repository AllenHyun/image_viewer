package software.ulpgc.model;

import software.ulpgc.view.ImageDisplay;

public interface Image {
    String name();
    byte[] content();
    Format format();
    Image next();
    Image previous();

    enum Format{
        jpg,Jpeg, Png, Gif
    }

    record  Dimension(int width, int height){

    }
}
