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
public class DailyBusinessAnalytic {

    private Date statDate;
    private int totalTradeinCount;
    private int passedQcCount;
    private int failedQcCount;
    private int lowBatteryCount;
    private int replacedPartsCount;
    private Double totalRevenue;
    private Double totalTradeinCost;
    private Double grossProfit;
    private int totalWarrantyRequests;
    private int approvedWarrantyCount;
    private int avgQcProcessingTimeMins;

    public DailyBusinessAnalytic() {
    }

    public DailyBusinessAnalytic(Date statDate, int totalTradeinCount, int passedQcCount, int failedQcCount, int lowBatteryCount, int replacedPartsCount, Double totalRevenue, Double totalTradeinCost, Double grossProfit, int totalWarrantyRequests, int approvedWarrantyCount, int avgQcProcessingTimeMins) {
        this.statDate = statDate;
        this.totalTradeinCount = totalTradeinCount;
        this.passedQcCount = passedQcCount;
        this.failedQcCount = failedQcCount;
        this.lowBatteryCount = lowBatteryCount;
        this.replacedPartsCount = replacedPartsCount;
        this.totalRevenue = totalRevenue;
        this.totalTradeinCost = totalTradeinCost;
        this.grossProfit = grossProfit;
        this.totalWarrantyRequests = totalWarrantyRequests;
        this.approvedWarrantyCount = approvedWarrantyCount;
        this.avgQcProcessingTimeMins = avgQcProcessingTimeMins;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public int getTotalTradeinCount() {
        return totalTradeinCount;
    }

    public void setTotalTradeinCount(int totalTradeinCount) {
        this.totalTradeinCount = totalTradeinCount;
    }

    public int getPassedQcCount() {
        return passedQcCount;
    }

    public void setPassedQcCount(int passedQcCount) {
        this.passedQcCount = passedQcCount;
    }

    public int getFailedQcCount() {
        return failedQcCount;
    }

    public void setFailedQcCount(int failedQcCount) {
        this.failedQcCount = failedQcCount;
    }

    public int getLowBatteryCount() {
        return lowBatteryCount;
    }

    public void setLowBatteryCount(int lowBatteryCount) {
        this.lowBatteryCount = lowBatteryCount;
    }

    public int getReplacedPartsCount() {
        return replacedPartsCount;
    }

    public void setReplacedPartsCount(int replacedPartsCount) {
        this.replacedPartsCount = replacedPartsCount;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getTotalTradeinCost() {
        return totalTradeinCost;
    }

    public void setTotalTradeinCost(Double totalTradeinCost) {
        this.totalTradeinCost = totalTradeinCost;
    }

    public Double getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    public int getTotalWarrantyRequests() {
        return totalWarrantyRequests;
    }

    public void setTotalWarrantyRequests(int totalWarrantyRequests) {
        this.totalWarrantyRequests = totalWarrantyRequests;
    }

    public int getApprovedWarrantyCount() {
        return approvedWarrantyCount;
    }

    public void setApprovedWarrantyCount(int approvedWarrantyCount) {
        this.approvedWarrantyCount = approvedWarrantyCount;
    }

    public int getAvgQcProcessingTimeMins() {
        return avgQcProcessingTimeMins;
    }

    public void setAvgQcProcessingTimeMins(int avgQcProcessingTimeMins) {
        this.avgQcProcessingTimeMins = avgQcProcessingTimeMins;
    }
}
