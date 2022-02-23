/**
 * Package that contains the methods to see the information by windows
 */
package View;

import javax.swing.*;

/**
 * Class that contains the methods to see the information by windows
 */
public class Window {
    /**
     * Constructor method
     */
    public Window(){ }

    /**
     * Method that reads an int type like a string
     * @param msg Message that the user write in the program
     * @return An int value
     */
    public int readInt (String msg) {
        String aux = JOptionPane.showInputDialog(msg);
        int obj = Integer.parseInt(aux);
        return obj;
    }

    /**
     * Method that reads a string
     * @param msg Message that the user write in the program
     * @return A string value
     */
    public String readString(String msg) {
        String obj = JOptionPane.showInputDialog(msg);
        return obj;
    }

    /**
     * Method that generate a string to show by windows
     * @param msg Message that the window shows
     */
    public void showInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
