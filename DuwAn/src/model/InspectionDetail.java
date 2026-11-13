/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class InspectionDetail {

    private int detailId;
    private int ticketId;
    private String checkItem;
    private String resultStatus;
    private String gradeValue;
    private String notes;

    public InspectionDetail() {
    }

    public InspectionDetail(int detailId, int ticketId, String checkItem, String resultStatus, String gradeValue, String notes) {
        this.detailId = detailId;
        this.ticketId = ticketId;
        this.checkItem = checkItem;
        this.resultStatus = resultStatus;
        this.gradeValue = gradeValue;
        this.notes = notes;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
