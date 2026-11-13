/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class IphoneSpecification {

    private int specId;
    private int modelId;
    private String screenSize;
    private String chipset;
    private String ram;
    private String cameraSpecs;
    private Integer batteryCapacityMah;
    private String chargingTech;
    private String biometricsType;

    public IphoneSpecification() {
    }

    public IphoneSpecification(int specId, int modelId, String screenSize, String chipset, String ram, String cameraSpecs, Integer batteryCapacityMah, String chargingTech, String biometricsType) {
        this.specId = specId;
        this.modelId = modelId;
        this.screenSize = screenSize;
        this.chipset = chipset;
        this.ram = ram;
        this.cameraSpecs = cameraSpecs;
        this.batteryCapacityMah = batteryCapacityMah;
        this.chargingTech = chargingTech;
        this.biometricsType = biometricsType;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCameraSpecs() {
        return cameraSpecs;
    }

    public void setCameraSpecs(String cameraSpecs) {
        this.cameraSpecs = cameraSpecs;
    }

    public Integer getBatteryCapacityMah() {
        return batteryCapacityMah;
    }

    public void setBatteryCapacityMah(Integer batteryCapacityMah) {
        this.batteryCapacityMah = batteryCapacityMah;
    }

    public String getChargingTech() {
        return chargingTech;
    }

    public void setChargingTech(String chargingTech) {
        this.chargingTech = chargingTech;
    }

    public String getBiometricsType() {
        return biometricsType;
    }
}
