package com.example.carmanager.models;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String carType;
    private String carModel;
    private String region;
    private int productNum;
    private String imageURL;

    public Car() {}

    public Car(String carType, String carModel, String region, int productNum, String imageURL){
        this.carType = carType;
        this.carModel = carModel;
        this.region = region;
        this.productNum = productNum;
        this.imageURL = imageURL;
    }

    public Long getId() {
        return id;
    }

    public String getCarType() {
        return carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getRegion() {
        return region;
    }

    public int getProductNum() {
        return productNum;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", carModel='" + carModel + '\'' +
                ", region='" + region + '\'' +
                ", productNum=" + productNum +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
