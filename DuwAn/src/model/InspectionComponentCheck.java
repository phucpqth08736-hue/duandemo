/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
    public class InspectionComponentCheck {

        private int componentCheckId;
        private int ticketId;
        private int partId;
        private boolean isOriginal;
        private boolean isGenuineReplaced;
        private String icloudStatus;
        private String simLockStatus;
        private String blacklistedCheck;
        private String proofImageUrl;

        public InspectionComponentCheck() {
        }

        public InspectionComponentCheck(int componentCheckId, int ticketId, int partId, boolean isOriginal, boolean isGenuineReplaced, String icloudStatus, String simLockStatus, String blacklistedCheck, String proofImageUrl) {
            this.componentCheckId = componentCheckId;
            this.ticketId = ticketId;
            this.partId = partId;
            this.isOriginal = isOriginal;
            this.isGenuineReplaced = isGenuineReplaced;
            this.icloudStatus = icloudStatus;
            this.simLockStatus = simLockStatus;
            this.blacklistedCheck = blacklistedCheck;
            this.proofImageUrl = proofImageUrl;
        }

        public int getComponentCheckId() {
            return componentCheckId;
        }

        public void setComponentCheckId(int componentCheckId) {
            this.componentCheckId = componentCheckId;
        }

        public int getTicketId() {
            return ticketId;
        }

        public void setTicketId(int ticketId) {
            this.ticketId = ticketId;
        }

        public int getPartId() {
            return partId;
        }

        public void setPartId(int partId) {
            this.partId = partId;
        }

        public boolean isIsOriginal() {
            return isOriginal;
        }

        public void setIsOriginal(boolean isOriginal) {
            this.isOriginal = isOriginal;
        }

        public boolean isIsGenuineReplaced() {
            return isGenuineReplaced;
        }

        public void setIsGenuineReplaced(boolean isGenuineReplaced) {
            this.isGenuineReplaced = isGenuineReplaced;
        }

        public String getIcloudStatus() {
            return icloudStatus;
        }

        public void setIcloudStatus(String icloudStatus) {
            this.icloudStatus = icloudStatus;
        }

        public String getSimLockStatus() {
            return simLockStatus;
        }

        public void setSimLockStatus(String simLockStatus) {
            this.simLockStatus = simLockStatus;
        }

        public String getBlacklistedCheck() {
            return blacklistedCheck;
        }

        public void setBlacklistedCheck(String blacklistedCheck) {
            this.blacklistedCheck = blacklistedCheck;
        }

        public String getProofImageUrl() {
            return proofImageUrl;
        }

        public void setProofImageUrl(String proofImageUrl) {
            this.proofImageUrl = proofImageUrl;
        }
    }

