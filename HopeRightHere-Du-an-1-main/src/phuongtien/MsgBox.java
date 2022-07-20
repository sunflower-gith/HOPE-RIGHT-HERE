/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtien;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Thanh Lam
 */
public class MsgBox {

    public static boolean confirm(Component parent, String message) {
        ImageIcon icon = new ImageIcon("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\couple_question_mark_50px.png");
        int result = JOptionPane.showConfirmDialog(parent, message, "NHÀ SÁCH HOPE RIGHT HERE",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        return result == JOptionPane.YES_OPTION;
    }

    //Hàm alert cảnh báo
    public static void alert(Component parent, String message) {
        ImageIcon icon = new ImageIcon("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\Laptop Alert_48px.png");
        JOptionPane.showMessageDialog(parent, message, "NHÀ SÁCH HOPE RIGHT HERE", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    //Hàm alert thành công
    public static void alertSuccessful(Component parent, String message) {
        ImageIcon icon = new ImageIcon("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\cloud_checked_64px.png");
        JOptionPane.showMessageDialog(parent, message, "NHÀ SÁCH HOPE RIGHT HERE", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
