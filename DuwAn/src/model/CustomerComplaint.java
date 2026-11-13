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
public class CustomerComplaint {

    private int complaintId;
    private int userId;
    private Integer deviceId;
    private String complaintType;
    private String content;
    private String status;
    private String resolutionNote;
    private Date createdAt;

    public CustomerComplaint() {
    }

    public CustomerComplaint(int complaintId, int userId, Integer deviceId, String complaintType, String content, String status, String resolutionNote, Date createdAt) {
        this.complaintId = complaintId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.complaintType = complaintType;
        this.content = content;
        this.status = status;
        this.resolutionNote = resolutionNote;
        this.createdAt = createdAt;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolutionNote() {
        return resolutionNote;
    }

    public void setResolutionNote(String resolutionNote) {
        this.resolutionNote = resolutionNote;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
