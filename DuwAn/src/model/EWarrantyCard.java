/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class EWarrantyCard {

    private int cardId;
    private String warrantyCode;
    private int deviceId;
    private int orderId;
    private int packageId;
    private Date startDate;
    private Date endDate;
    private String status;

    public EWarrantyCard() {
    }

    public EWarrantyCard(int cardId, String warrantyCode, int deviceId, int orderId, int packageId, Date startDate, Date endDate, String status) {
        this.cardId = cardId;
        this.warrantyCode = warrantyCode;
        this.deviceId = deviceId;
        this.orderId = orderId;
        this.packageId = packageId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getWarrantyCode() {
        return warrantyCode;
    }

    public void setWarrantyCode(String warrantyCode) {
        this.warrantyCode = warrantyCode;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
