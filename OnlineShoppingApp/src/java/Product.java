package com.shopping.model;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private String category;
    private String product;
    private BigDecimal unitPrice;
    private String district;
    private String phoneNo;
    private String emailId;

    public Product() {
    }

    public Product(String name, String category, String product,
                   BigDecimal unitPrice, String district,
                   String phoneNo, String emailId) {

        this.name = name;
        this.category = category;
        this.product = product;
        this.unitPrice = unitPrice;
        this.district = district;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}