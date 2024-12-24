package software.ulpgc.view;


import software.ulpgc.model.Image;

public interface ImageDisplay {
    Image currentImage();
    void show(Image image);
}
