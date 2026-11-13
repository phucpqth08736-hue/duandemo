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
public class ProductReview {

    private int reviewId;
    private int userId;
    private int deviceId;
    private int overallRating;
    private int qcAccuracyRating;
    private Integer batteryPostUseRating;
    private String comment;
    private String reviewImageUrl;
    private Date createdAt;

    public ProductReview() {
    }

    public ProductReview(int reviewId, int userId, int deviceId, int overallRating, int qcAccuracyRating, Integer batteryPostUseRating, String comment, String reviewImageUrl, Date createdAt) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.deviceId = deviceId;
        this.overallRating = overallRating;
        this.qcAccuracyRating = qcAccuracyRating;
        this.batteryPostUseRating = batteryPostUseRating;
        this.comment = comment;
        this.reviewImageUrl = reviewImageUrl;
        this.createdAt = createdAt;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public int getQcAccuracyRating() {
        return qcAccuracyRating;
    }

    public void setQcAccuracyRating(int qcAccuracyRating) {
        this.qcAccuracyRating = qcAccuracyRating;
    }

    public Integer getBatteryPostUseRating() {
        return batteryPostUseRating;
    }

    public void setBatteryPostUseRating(Integer batteryPostUseRating) {
        this.batteryPostUseRating = batteryPostUseRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewImageUrl() {
        return reviewImageUrl;
    }

    public void setReviewImageUrl(String reviewImageUrl) {
        this.reviewImageUrl = reviewImageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
