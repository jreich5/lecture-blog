package com.codeup.lectureblog.models;

import javax.persistence.*;

@Entity
@Table(name="details")
public class AdDetails {

    @Id
    @GeneratedValue
    private long id;

    private String brand;

    @Column(name="avg_market_value")
    private double avgMarketValue;

    @OneToOne
    private Ad ad;

    public AdDetails() {
    }

    public AdDetails(String brand, double avgMarketValue) {
        this.brand = brand;
        this.avgMarketValue = avgMarketValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getAvgMarketValue() {
        return avgMarketValue;
    }

    public void setAvgMarketValue(double avgMarketValue) {
        this.avgMarketValue = avgMarketValue;
    }
}
