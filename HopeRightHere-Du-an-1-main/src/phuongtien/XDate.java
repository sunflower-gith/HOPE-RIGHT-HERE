/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongtien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thanh Lam
 */
public class XDate {

    static SimpleDateFormat formater = new SimpleDateFormat();

    public static String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    public static Date toDate(String date, String pattern) {
        try {
            Date d = new SimpleDateFormat(pattern).parse(date);
            return d;
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    

}
