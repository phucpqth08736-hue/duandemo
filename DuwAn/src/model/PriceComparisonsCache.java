/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class PriceComparisonsCache {

    private int cacheId;
    private int variantId;
    private String qualityTier;
    private Integer avgBatteryHealth;
    private Double avgPrice;
    private Double savingsVsNew;

    public PriceComparisonsCache() {
    }

    public PriceComparisonsCache(int cacheId, int variantId, String qualityTier, Integer avgBatteryHealth, Double avgPrice, Double savingsVsNew) {
        this.cacheId = cacheId;
        this.variantId = variantId;
        this.qualityTier = qualityTier;
        this.avgBatteryHealth = avgBatteryHealth;
        this.avgPrice = avgPrice;
        this.savingsVsNew = savingsVsNew;
    }

    public int getCacheId() {
        return cacheId;
    }

    public void setCacheId(int cacheId) {
        this.cacheId = cacheId;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public String getQualityTier() {
        return qualityTier;
    }

    public void setQualityTier(String qualityTier) {
        this.qualityTier = qualityTier;
    }

    public Integer getAvgBatteryHealth() {
        return avgBatteryHealth;
    }

    public void setAvgBatteryHealth(Integer avgBatteryHealth) {
        this.avgBatteryHealth = avgBatteryHealth;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getSavingsVsNew() {
        return savingsVsNew;
    }

    public void setSavingsVsNew(Double savingsVsNew) {
        this.savingsVsNew = savingsVsNew;
    }
}
