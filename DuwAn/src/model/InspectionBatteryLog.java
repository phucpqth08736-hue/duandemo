/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class InspectionBatteryLog {

    private int batteryLogId;
    private int ticketId;
    private int batteryHealthPercentage;
    private int chargeCycles;
    private boolean isOriginalBattery;
    private boolean batteryWarningStatus;
    private String qualityTier;

    public InspectionBatteryLog() {
    }

    public InspectionBatteryLog(int batteryLogId, int ticketId, int batteryHealthPercentage, int chargeCycles, boolean isOriginalBattery, boolean batteryWarningStatus, String qualityTier) {
        this.batteryLogId = batteryLogId;
        this.ticketId = ticketId;
        this.batteryHealthPercentage = batteryHealthPercentage;
        this.chargeCycles = chargeCycles;
        this.isOriginalBattery = isOriginalBattery;
        this.batteryWarningStatus = batteryWarningStatus;
        this.qualityTier = qualityTier;
    }

    public int getBatteryLogId() {
        return batteryLogId;
    }

    public void setBatteryLogId(int batteryLogId) {
        this.batteryLogId = batteryLogId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getBatteryHealthPercentage() {
        return batteryHealthPercentage;
    }

    public void setBatteryHealthPercentage(int batteryHealthPercentage) {
        this.batteryHealthPercentage = batteryHealthPercentage;
    }

    public int getChargeCycles() {
        return chargeCycles;
    }

    public void setChargeCycles(int chargeCycles) {
        this.chargeCycles = chargeCycles;
    }

    public boolean isIsOriginalBattery() {
        return isOriginalBattery;
    }

    public void setIsOriginalBattery(boolean isOriginalBattery) {
        this.isOriginalBattery = isOriginalBattery;
    }

    public boolean isBatteryWarningStatus() {
        return batteryWarningStatus;
    }

    public void setBatteryWarningStatus(boolean batteryWarningStatus) {
        this.batteryWarningStatus = batteryWarningStatus;
    }

    public String getQualityTier() {
        return qualityTier;
    }

    public void setQualityTier(String qualityTier) {
        this.qualityTier = qualityTier;
    }
}
