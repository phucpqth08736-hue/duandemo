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
public class PricingReferenceMatrix {

    private int matrixId;
    private int variantId;
    private Double baseNewPrice;
    private Double baseUsedPrice;
    private Date updatedAt;

    public PricingReferenceMatrix() {
    }

    public PricingReferenceMatrix(int matrixId, int variantId, Double baseNewPrice, Double baseUsedPrice, Date updatedAt) {
        this.matrixId = matrixId;
        this.variantId = variantId;
        this.baseNewPrice = baseNewPrice;
        this.baseUsedPrice = baseUsedPrice;
        this.updatedAt = updatedAt;
    }

    public int getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(int matrixId) {
        this.matrixId = matrixId;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public Double getBaseNewPrice() {
        return baseNewPrice;
    }

    public void setBaseNewPrice(Double baseNewPrice) {
        this.baseNewPrice = baseNewPrice;
    }

    public Double getBaseUsedPrice() {
        return baseUsedPrice;
    }

    public void setBaseUsedPrice(Double baseUsedPrice) {
        this.baseUsedPrice = baseUsedPrice;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
