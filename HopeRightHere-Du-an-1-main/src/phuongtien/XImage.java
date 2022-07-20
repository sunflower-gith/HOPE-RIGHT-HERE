/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtien;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Thanh Lam
 */
public class XImage {

    public static Image getLogo() {
        URL url = XImage.class.getResource("/hinhanh/nook_40px.png");
        return new ImageIcon(url).getImage();
    }

    public static ImageIcon readNhanVien(String fileName) {
        File path = new File("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\nhanvien", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static boolean saveNhanVien(File src) {
        File dst = new File("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\nhanvien", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ImageIcon readBiaSach(String fileName) {
        File path = new File("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\biasach", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static boolean saveBiaSach(File src) {
        File dst = new File("C:\\Users\\ACER\\Downloads\\Du_AN_1\\HopeProject2\\src\\hinhanh\\biasach", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
