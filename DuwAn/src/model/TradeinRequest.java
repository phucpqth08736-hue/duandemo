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
public class TradeinRequest {

    private int requestId;
    private Integer userId;
    private String sellerName;
    private String sellerPhone;
    private String sellerEmail;
    private String modelName;
    private String capacity;
    private String userDescribedCondition;
    private String status;
    private Date createdAt;

    public TradeinRequest() {
    }

    public TradeinRequest(int requestId, Integer userId, String sellerName, String sellerPhone, String sellerEmail, String modelName, String capacity, String userDescribedCondition, String status, Date createdAt) {
        this.requestId = requestId;
        this.userId = userId;
        this.sellerName = sellerName;
        this.sellerPhone = sellerPhone;
        this.sellerEmail = sellerEmail;
        this.modelName = modelName;
        this.capacity = capacity;
        this.userDescribedCondition = userDescribedCondition;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getUserDescribedCondition() {
        return userDescribedCondition;
    }

    public void setUserDescribedCondition(String userDescribedCondition) {
        this.userDescribedCondition = userDescribedCondition;
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
