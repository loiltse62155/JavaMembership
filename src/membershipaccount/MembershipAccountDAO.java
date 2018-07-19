/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipaccount;

import account.AccountDTO;
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
public class MembershipAccountDAO implements Serializable {

    private List<MembershipAccountDTO> listMembershipAccounts;

    public List<MembershipAccountDTO> getListMembershipAccounts() {
        return listMembershipAccounts;
    }

    public List<MembershipAccountDTO> getData(String accountID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from MembershipAccount where accountID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                   MembershipAccountDTO dto = new MembershipAccountDTO(
                           rs.getString("memID"),
                           rs.getString("memEmail"),
                           rs.getString("memAddr"),
                           rs.getString("memPhone"),
                           rs.getString("accountID"),
                           rs.getInt("memPoint"),
                           rs.getString("barNumber"),
                           rs.getString("branchID"),
                           rs.getString("barTypeID"),
                           rs.getBoolean("barStatus"),
                           rs.getString("barExpiredDay"));
                   if(listMembershipAccounts == null){
                       this.listMembershipAccounts = new ArrayList<MembershipAccountDTO>();
                   }
                   this.listMembershipAccounts.add(dto);
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
        return listMembershipAccounts;
    }
    
     public MembershipAccountDTO getRecord(String memID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from MembershipAccount where memID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, memID);
                rs = stm.executeQuery();
                if (rs.next()) {
                   MembershipAccountDTO dto = new MembershipAccountDTO(
                           rs.getString("memID"),
                           rs.getString("memEmail"),
                           rs.getString("memAddr"),
                           rs.getString("memPhone"),
                           rs.getString("accountID"),
                           rs.getInt("memPoint"),
                           rs.getString("barNumber"),
                           rs.getString("branchID"),
                           rs.getString("barTypeID"),
                           rs.getBoolean("barStatus"),
                           rs.getString("barExpiredDay"));
                  return dto;
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
        return null;
    }
     
     public boolean addACard(MembershipAccountDTO dto) throws SQLException, ClassNotFoundException{
           Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Insert into MembershipAccount values(?,?,?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getMemID());
                stm.setString(2, dto.getMemPhone());
                stm.setString(3, dto.getMemMail());
                stm.setString(4, dto.getMemAddress());
                stm.setString(5, dto.getAccountID());
                stm.setInt(6, dto.getMemPoint());
                stm.setString(7, dto.getBrandID());
                stm.setString(8, dto.getBarNumber());
                stm.setString(9, dto.getBarTypeID());
                stm.setBoolean(10, dto.isBarStatus());
                stm.setString(11, dto.getBarExpiredDay());
                int i = stm.executeUpdate();
                if (i>0) {
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
      public boolean deleteRecord(String memID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Delete from MembershipAccount where memID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, memID);
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

}

