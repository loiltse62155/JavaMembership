/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.MyUtil;

/**
 *
 * @author Ly Tan loi
 */
public class AccountDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from Account where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    private List<AccountDTO> listAccounts;

    public List<AccountDTO> getListAccounts() {
        return listAccounts;
    }

    public AccountDTO getAccount(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO account = new AccountDTO();
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from Account where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    account.setAccountID(rs.getString("accountID"));
                    account.setUsername(rs.getString("username"));
                    account.setAddress(rs.getString("address"));
                    account.setEmail(rs.getString("email"));
                    account.setPassword(rs.getString("password"));
                    account.setPhone(rs.getString("phone"));
                    account.setRoleID(rs.getString("roleID"));
                    account.setSsid(rs.getString("SSID"));
                }
            }
            return account;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
     public AccountDTO getAccountByID(String accoutID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO account = new AccountDTO();
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from Account where accountID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, accoutID);
               
                rs = stm.executeQuery();
                if (rs.next()) {
                    account.setAccountID(rs.getString("accountID"));
                    account.setUsername(rs.getString("username"));
                    account.setAddress(rs.getString("address"));
                    account.setEmail(rs.getString("email"));
                    account.setPassword(rs.getString("password"));
                    account.setPhone(rs.getString("phone"));
                    account.setRoleID(rs.getString("roleID"));
                    account.setSsid(rs.getString("SSID"));
                }
            }
            return account;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
     
      public boolean deleteAccount(String accountID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Delete from MembershipAccount where accountID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, accountID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }//end if con 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }

        return false;
    }
    
       public List<AccountDTO> getAllAccount() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountDTO account = new AccountDTO();
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from Account";
                stm = con.prepareStatement(sql);
             
                rs = stm.executeQuery();
                while (rs.next()) {
                    account.setAccountID(rs.getString("accountID"));
                    account.setUsername(rs.getString("username"));
                    account.setAddress(rs.getString("address"));
                    account.setEmail(rs.getString("email"));
                    account.setPassword(rs.getString("password"));
                    account.setPhone(rs.getString("phone"));
                    account.setRoleID(rs.getString("roleID"));
                    account.setSsid(rs.getString("SSID"));
                    if(listAccounts == null){
                        listAccounts = new ArrayList<>();
                        
                    }
                    listAccounts.add(account);
                }
            }
            return listAccounts;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    

}
