/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class HardwareFaultCatalog {

    private int faultId;
    private String faultCode;
    private String faultName;
    private String category;

    public HardwareFaultCatalog() {
    }

    public HardwareFaultCatalog(int faultId, String faultCode, String faultName, String category) {
        this.faultId = faultId;
        this.faultCode = faultCode;
        this.faultName = faultName;
        this.category = category;
    }

    public int getFaultId() {
        return faultId;
    }

    public void setFaultId(int faultId) {
        this.faultId = faultId;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
