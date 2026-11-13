/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class IphoneCapacity {

    private int capacityId;
    private String capacityValue;

    public IphoneCapacity() {
    }

    public IphoneCapacity(int capacityId, String capacityValue) {
        this.capacityId = capacityId;
        this.capacityValue = capacityValue;
    }

    public int getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(int capacityId) {
        this.capacityId = capacityId;
    }

    public String getCapacityValue() {
        return capacityValue;
    }

    public void setCapacityValue(String capacityValue) {
        this.capacityValue = capacityValue;
    }
}
