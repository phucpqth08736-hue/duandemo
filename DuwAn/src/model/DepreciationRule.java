/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class DepreciationRule {

    private int ruleId;
    private String ruleType;
    private Double minVal;
    private Double maxVal;
    private Double deductionAmount;
    private Double deductionPercentage;

    public DepreciationRule() {
    }

    public DepreciationRule(int ruleId, String ruleType, Double minVal, Double maxVal, Double deductionAmount, Double deductionPercentage) {
        this.ruleId = ruleId;
        this.ruleType = ruleType;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.deductionAmount = deductionAmount;
        this.deductionPercentage = deductionPercentage;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Double getDeductionPercentage() {
        return deductionPercentage;
    }

    public void setDeductionPercentage(Double deductionPercentage) {
        this.deductionPercentage = deductionPercentage;
    }
}
