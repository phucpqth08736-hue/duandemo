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
public class WarrantyRequest {

    private int requestId;
    private int cardId;
    private int userId;
    private String reportedFaultDescription;
    private String requestType;
    private String status;
    private String rejectionReason;
    private Date createdAt;

    public WarrantyRequest() {
    }

    public WarrantyRequest(int requestId, int cardId, int userId, String reportedFaultDescription, String requestType, String status, String rejectionReason, Date createdAt) {
        this.requestId = requestId;
        this.cardId = cardId;
        this.userId = userId;
        this.reportedFaultDescription = reportedFaultDescription;
        this.requestType = requestType;
        this.status = status;
        this.rejectionReason = rejectionReason;
        this.createdAt = createdAt;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReportedFaultDescription() {
        return reportedFaultDescription;
    }

    public void setReportedFaultDescription(String reportedFaultDescription) {
        this.reportedFaultDescription = reportedFaultDescription;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
