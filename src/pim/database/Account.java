/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pim.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import pim.User;

/**
 *
 * @author lk
 */
public class Account {
    
    private Connection con;
    
    public Account(Connection con) {
        this.con = con;
    }
    
    public User createNewUser(String username, String password) throws SQLException {
        User user = null;
        CallableStatement stmt = con.prepareCall("{? = call insertUser (?, ?)}");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.execute();
        int userid = stmt.getInt(1);
        if (userid != 0) {
            user = new User(userid, username, password);
        }
        stmt.close();
        return user;
    }
    
    
    public User login(String username, String password) throws SQLException {
        User user = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'");
        if (rs.next()) {
            user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        rs.close();
        stmt.close();
        return user;
    }
}
