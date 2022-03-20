package haw41k.wheels.catalog.dao;

public class WheelParams {

    private int id;
    private int modelId;

    private byte sizeDiameter;
    private float sizeWidth;

    private byte pcdCount;
    private float pcdDiameter;

    private float et;
    private float dia;

    private String color;

    private int factoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public byte getSizeDiameter() {
        return sizeDiameter;
    }

    public void setSizeDiameter(byte sizeDiameter) {
        this.sizeDiameter = sizeDiameter;
    }

    public float getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(float sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public byte getPcdCount() {
        return pcdCount;
    }

    public void setPcdCount(byte pcdCount) {
        this.pcdCount = pcdCount;
    }

    public float getPcdDiameter() {
        return pcdDiameter;
    }

    public void setPcdDiameter(float pcdDiameter) {
        this.pcdDiameter = pcdDiameter;
    }

    public float getEt() {
        return et;
    }

    public void setEt(float et) {
        this.et = et;
    }

    public float getDia() {
        return dia;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(int factoryCode) {
        this.factoryCode = factoryCode;
    }
}
