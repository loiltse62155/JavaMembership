/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membershipaccount;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Ly Tan loi
 */
public class MembershipAccountDTO implements Serializable{
    private String memID;
    private String memMail;
    private String memAddress;
    private String memPhone;
    private String accountID;
    private int memPoint;
    private String barNumber;
    private String brandID;
    private String barTypeID;
    private boolean barStatus;
    private String barExpiredDay;

    public MembershipAccountDTO() {
    }

    public MembershipAccountDTO(String memID, String memMail, String memAddress, String memPhone, String accountID, int memPoint, String barNumber, String brandID, String barTypeID, boolean barStatus, String barExpiredDay) {
        this.memID = memID;
        this.memMail = memMail;
        this.memAddress = memAddress;
        this.memPhone = memPhone;
        this.accountID = accountID;
        this.memPoint = memPoint;
        this.barNumber = barNumber;
        this.brandID = brandID;
        this.barTypeID = barTypeID;
        this.barStatus = barStatus;
        this.barExpiredDay = barExpiredDay;
    }

   
    
  

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public int getMemPoint() {
        return memPoint;
    }

    public void setMemPoint(int memPoint) {
        this.memPoint = memPoint;
    }

    public String getBarNumber() {
        return barNumber;
    }

    public void setBarNumber(String barNumber) {
        this.barNumber = barNumber;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBarTypeID() {
        return barTypeID;
    }

    public void setBarTypeID(String barTypeID) {
        this.barTypeID = barTypeID;
    }

    public boolean isBarStatus() {
        return barStatus;
    }

    public void setBarStatus(boolean barStatus) {
        this.barStatus = barStatus;
    }

    public String getBarExpiredDay() {
        return barExpiredDay;
    }

    public void setBarExpiredDay(String barExpiredDay) {
        this.barExpiredDay = barExpiredDay;
    }

    
    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }
    
    
    
}
