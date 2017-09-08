package ca.cmpt213.as2.gui;

import javax.swing.JOptionPane;

/**
 * PopupBox class to display a popup box.
 */
//Inspired by: http://stackoverflow.com/questions/7080205/popup-message-boxes
public class PopupBox {
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}