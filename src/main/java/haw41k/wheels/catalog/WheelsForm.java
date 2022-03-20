package haw41k.wheels.catalog;

public class WheelsForm {
    private int brandId = -1;

    private byte sizeDiameter = -1;
    private float sizeWidth = -1;

    private byte pcdCount = -1;
    private float pcdDiameter = -1;

    private float et = -1;
    private float dia = -1;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
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
}
