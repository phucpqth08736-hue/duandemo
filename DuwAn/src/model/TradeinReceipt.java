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
public class TradeinReceipt {

    private int receiptId;
    private int requestId;
    private Integer deviceId;
    private int inspectorId;
    private Double initialEstimatedPrice;
    private Double finalOfferPrice;
    private String rejectionReason;
    private String transactionStatus;
    private Date paidAt;

    public TradeinReceipt() {
    }

    public TradeinReceipt(int receiptId, int requestId, Integer deviceId, int inspectorId, Double initialEstimatedPrice, Double finalOfferPrice, String rejectionReason, String transactionStatus, Date paidAt) {
        this.receiptId = receiptId;
        this.requestId = requestId;
        this.deviceId = deviceId;
        this.inspectorId = inspectorId;
        this.initialEstimatedPrice = initialEstimatedPrice;
        this.finalOfferPrice = finalOfferPrice;
        this.rejectionReason = rejectionReason;
        this.transactionStatus = transactionStatus;
        this.paidAt = paidAt;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public Double getInitialEstimatedPrice() {
        return initialEstimatedPrice;
    }

    public void setInitialEstimatedPrice(Double initialEstimatedPrice) {
        this.initialEstimatedPrice = initialEstimatedPrice;
    }

    public Double getFinalOfferPrice() {
        return finalOfferPrice;
    }

    public void setFinalOfferPrice(Double finalOfferPrice) {
        this.finalOfferPrice = finalOfferPrice;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }
}
