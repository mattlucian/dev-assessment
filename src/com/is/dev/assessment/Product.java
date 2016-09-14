package com.is.dev.assessment;

import java.math.BigDecimal;

/**
 * Created by Matt on 9/14/2016.
 */

public class Product {

    private String title;
    private String upc;
    private String sku;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private String condition;
    private Integer quantity;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getCondition() { return condition; }

    public void setCondition(String condition) { this.condition = condition; }


    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }


    public String getSku() { return sku; }

    public void setSku(String sku) { this.sku = sku; }


    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

}
