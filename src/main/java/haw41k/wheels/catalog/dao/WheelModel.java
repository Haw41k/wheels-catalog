package haw41k.wheels.catalog.dao;

public class WheelModel {
    private int id;
    private String brandName;
    private String modelName;
    private String imgUrl;

    public WheelModel() {
    }

    public WheelModel(int id, String brandName, String modelName, String imgUrl) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
