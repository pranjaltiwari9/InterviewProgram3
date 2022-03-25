package com.company;
import java.lang.Math;

public class Product {
    String productName;
    int productQuantity;
    double productPrice;

    public Product() {
    }

    public void updateAndRoundOffPrice(double taxOnProduct){
        this.productPrice = this.productPrice + taxOnProduct;
        this.productPrice = (Math.round(this.productPrice * 100))/100;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
