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
public class QualityCertificate {

    private int certId;
    private String certCode;
    private int deviceId;
    private int ticketId;
    private Double overallScore;
    private String qualityTier;
    private Date issuedAt;
    private String pdfReportUrl;

    public QualityCertificate() {
    }

    public QualityCertificate(int certId, String certCode, int deviceId, int ticketId, Double overallScore, String qualityTier, Date issuedAt, String pdfReportUrl) {
        this.certId = certId;
        this.certCode = certCode;
        this.deviceId = deviceId;
        this.ticketId = ticketId;
        this.overallScore = overallScore;
        this.qualityTier = qualityTier;
        this.issuedAt = issuedAt;
        this.pdfReportUrl = pdfReportUrl;
    }

    public int getCertId() {
        return certId;
    }

    public void setCertId(int certId) {
        this.certId = certId;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }

    public String getQualityTier() {
        return qualityTier;
    }

    public void setQualityTier(String qualityTier) {
        this.qualityTier = qualityTier;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getPdfReportUrl() {
        return pdfReportUrl;
    }

    public void setPdfReportUrl(String pdfReportUrl) {
        this.pdfReportUrl = pdfReportUrl;
    }
}
