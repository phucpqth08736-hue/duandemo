/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class WarrantyPackage {

    private int packageId;
    private String packageName;
    private int durationMonths;
    private String coverageTerms;
    private String qualityTierApplied;

    public WarrantyPackage() {
    }

    public WarrantyPackage(int packageId, String packageName, int durationMonths, String coverageTerms, String qualityTierApplied) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.durationMonths = durationMonths;
        this.coverageTerms = coverageTerms;
        this.qualityTierApplied = qualityTierApplied;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getCoverageTerms() {
        return coverageTerms;
    }

    public void setCoverageTerms(String coverageTerms) {
        this.coverageTerms = coverageTerms;
    }

    public String getQualityTierApplied() {
        return qualityTierApplied;
    }

    public void setQualityTierApplied(String qualityTierApplied) {
        this.qualityTierApplied = qualityTierApplied;
    }
}
