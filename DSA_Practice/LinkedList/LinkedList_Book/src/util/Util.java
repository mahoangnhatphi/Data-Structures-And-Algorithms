/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import linkedlist.Book;
import linkedlist.LinkedList;

/**
 *
 * @author Phi
 */
public class Util {
    public static void loadData(LinkedList linkedList) {
        String url = "jdbc:sqlserver://localhost;databasename=DBForDSA;user=sa;password=Phi";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tblBook");
            while (rs.next()) {
                linkedList.addTail(new Book(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
    }
}
