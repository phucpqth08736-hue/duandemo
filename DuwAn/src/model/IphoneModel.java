/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class IphoneModel {

    private int modelId;
    private String modelName;
    private String generation;
    private Integer releaseYear;
    private Double originalMsrp;
    private String status;

    public IphoneModel() {
    }

    public IphoneModel(int modelId, String modelName, String generation, Integer releaseYear, Double originalMsrp, String status) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.generation = generation;
        this.releaseYear = releaseYear;
        this.originalMsrp = originalMsrp;
        this.status = status;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getOriginalMsrp() {
        return originalMsrp;
    }

    public void setOriginalMsrp(Double originalMsrp) {
        this.originalMsrp = originalMsrp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
