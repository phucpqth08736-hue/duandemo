/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class QualityGradingCriteria {

    private int criterionId;
    private String criterionName;
    private String category;
    private Double weight;

    public QualityGradingCriteria() {
    }

    public QualityGradingCriteria(int criterionId, String criterionName, String category, Double weight) {
        this.criterionId = criterionId;
        this.criterionName = criterionName;
        this.category = category;
        this.weight = weight;
    }

    public int getCriterionId() {
        return criterionId;
    }

    public void setCriterionId(int criterionId) {
        this.criterionId = criterionId;
    }

    public String getCriterionName() {
        return criterionName;
    }

    public void setCriterionName(String criterionName) {
        this.criterionName = criterionName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
