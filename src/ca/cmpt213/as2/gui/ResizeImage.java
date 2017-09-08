package ca.cmpt213.as2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * ResizeImage class based on Brian Fraser's code in Assignment 3 description.
 */
public class ResizeImage {

    static public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(getScaledImage(icon.getImage(), width, height));
    }
    static private Image getScaledImage(Image srcImg, int width, int height){
        BufferedImage resizedImg =
                new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }
}
