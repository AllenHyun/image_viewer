package software.ulpgc.io;

import java.io.IOException;

public interface ImageDeserializer {
    Object deserialize(byte[] bytes);

}
