/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.io.Serializable;

/**
 *
 * @author Ly Tan loi
 */
public class DataTypeDTO implements Serializable{
    private String typeID;
    private String Name;

    public DataTypeDTO() {
    }

    public DataTypeDTO(String typeID, String Name) {
        this.typeID = typeID;
        this.Name = Name;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
}
