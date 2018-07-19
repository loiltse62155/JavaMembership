/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import account.AccountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import membershipaccount.MembershipAccountDTO;
import utility.MyUtil;

/**
 *
 * @author Ly Tan loi
 */
public class DataTypeDAO implements Serializable {

    List<DataTypeDTO> listDataType;

    public List<DataTypeDTO> getListDataType() {
        return listDataType;
    }

    public List<DataTypeDTO> getData() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from DataType";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    DataTypeDTO dto = new DataTypeDTO(rs.getString("typeID"), rs.getString("Name"));
                    if (listDataType == null) {
                        listDataType = new ArrayList<DataTypeDTO>();
                    }
                    listDataType.add(dto);

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
        return listDataType;
    }
    
     public DataTypeDTO getAccountByID(String typeID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DataTypeDTO dto = new DataTypeDTO();
        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Select * from DataType where typeID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, typeID);
               
                rs = stm.executeQuery();
                if (rs.next()) {
                    dto.setName(rs.getString("Name"));
                    dto.setTypeID(rs.getString("typeID"));
                  
                }
            }
            return dto;
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
      public boolean deleteRecord(String typeID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = MyUtil.makeConnection();
            if (con != null) {
                String sql = "Delete from DataType where typeID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, typeID);
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
