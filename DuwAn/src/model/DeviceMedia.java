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
public class DeviceMedia {

    private int mediaId;
    private int deviceId;
    private String mediaType;
    private String mediaUrl;
    private boolean isCover;
    private Date createdAt;

    public DeviceMedia() {
    }

    public DeviceMedia(int mediaId, int deviceId, String mediaType, String mediaUrl, boolean isCover, Date createdAt) {
        this.mediaId = mediaId;
        this.deviceId = deviceId;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.isCover = isCover;
        this.createdAt = createdAt;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public boolean isIsCover() {
        return isCover;
    }

    public void setIsCover(boolean isCover) {
        this.isCover = isCover;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
