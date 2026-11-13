/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class IphoneVariant {

    private int variantId;
    private int modelId;
    private int capacityId;
    private int colorId;
    private String modelNumber;
    private String sku;

    public IphoneVariant() {
    }

    public IphoneVariant(int variantId, int modelId, int capacityId, int colorId, String modelNumber, String sku) {
        this.variantId = variantId;
        this.modelId = modelId;
        this.capacityId = capacityId;
        this.colorId = colorId;
        this.modelNumber = modelNumber;
        this.sku = sku;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(int capacityId) {
        this.capacityId = capacityId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
