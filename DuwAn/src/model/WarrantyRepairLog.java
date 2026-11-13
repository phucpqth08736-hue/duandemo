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
public class WarrantyRepairLog {

    private int repairLogId;
    private int requestId;
    private int technicianId;
    private String faultDiagnosed;
    private String replacedPartName;
    private String repairResult;
    private Date completedAt;

    public WarrantyRepairLog() {
    }

    public WarrantyRepairLog(int repairLogId, int requestId, int technicianId, String faultDiagnosed, String replacedPartName, String repairResult, Date completedAt) {
        this.repairLogId = repairLogId;
        this.requestId = requestId;
        this.technicianId = technicianId;
        this.faultDiagnosed = faultDiagnosed;
        this.replacedPartName = replacedPartName;
        this.repairResult = repairResult;
        this.completedAt = completedAt;
    }

    public int getRepairLogId() {
        return repairLogId;
    }

    public void setRepairLogId(int repairLogId) {
        this.repairLogId = repairLogId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    public String getFaultDiagnosed() {
        return faultDiagnosed;
    }

    public void setFaultDiagnosed(String faultDiagnosed) {
        this.faultDiagnosed = faultDiagnosed;
    }

    public String getReplacedPartName() {
        return replacedPartName;
    }

    public void setReplacedPartName(String replacedPartName) {
        this.replacedPartName = replacedPartName;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
