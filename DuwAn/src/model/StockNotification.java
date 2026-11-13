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
public class StockNotification {

    private int notificationId;
    private int userId;
    private int variantId;
    private String preferredQualityTier;
    private String status;
    private Date createdAt;

    public StockNotification() {
    }

    public StockNotification(int notificationId, int userId, int variantId, String preferredQualityTier, String status, Date createdAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.variantId = variantId;
        this.preferredQualityTier = preferredQualityTier;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public String getPreferredQualityTier() {
        return preferredQualityTier;
    }

    public void setPreferredQualityTier(String preferredQualityTier) {
        this.preferredQualityTier = preferredQualityTier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
