/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.contact;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lk
 */
public class ImageChooser {

    public static BufferedImage chooseImage() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter(
                "Bilder", ImageIO.getReaderFileSuffixes()));
        
        if (fc.showOpenDialog(null) == 0) {
            File file = fc.getSelectedFile();
            BufferedImage img;
            try {
                img = ImageIO.read(file);
                Image scaled = img.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                BufferedImage scalledImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = scalledImage.createGraphics();
                g2d.drawImage(scaled, 0, 0, null);
                g2d.dispose();
                //ImageIO.write(scalledImage, "png", new File("C:\\bild.png"));
                return scalledImage;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
