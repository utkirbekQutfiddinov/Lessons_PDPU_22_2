package lessons.module_5.lesson_5_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;

public class Encoding {
    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("music.txt");

        FileOutputStream outputStream = new FileOutputStream("music.mp3");

        byte[] bytes = in.readAllBytes();
        outputStream.write(decoding(bytes));
        outputStream.flush();


    }

    private static byte[] encoding(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();

        byte[] encodedString = encoder.encode(bytes);
        return encodedString;
    }

    private static byte[] decoding(byte[] encodedString) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedString = decoder.decode(encodedString);
        return decodedString;
    }
}
