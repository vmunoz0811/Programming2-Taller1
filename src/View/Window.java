/**
 * Package that contains the methods to see the information by windows
 */
package View;

import javax.swing.*;

/**
 * Class
 */
public class Window {
    /**
     *
     */
    public Window(){

    }

    /**
     *
     * @param msg
     * @return
     */
    public int readInt (String msg) {
        String aux = JOptionPane.showInputDialog(msg);
        int obj = Integer.parseInt(aux);
        return obj;
    }

    /**
     *
     * @param msg
     * @return
     */
    public String readString(String msg) {
        String obj = JOptionPane.showInputDialog(msg);
        return obj;
    }

    /**
     *
     * @param msg
     */
    public void showInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
