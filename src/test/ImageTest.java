package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Auther: zhongj
 * @Date: 2021/7/26 - 07 - 26 - 14:37
 * @Description: test
 * @version: 1.0
 */
public class ImageTest {
    @Test
    void test() throws IOException {
        System.out.println("TEST START....");

        BufferedImage image1 = ImageIO.read(new File("G:/图片/Lion.jpg"));
        assertNotNull(image1);

        BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/1.gif"));
        assertNotNull(image2);

        System.out.println("TEST END....");
    }

}
