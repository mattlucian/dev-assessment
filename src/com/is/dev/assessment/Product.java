package com.is.dev.assessment;

import java.math.BigDecimal;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Created by Matt on 9/14/2016.
 */
@XmlRootElement(name="product")
public class Product {

    private String title;
    private String upc;
    private String sku;
    private BigDecimal price;
    private BigDecimal sellPrice;
    private String condition;
    private Integer quantity;

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement
    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }
    @XmlElement
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
    @XmlElement
    public String getCondition() { return condition; }

    public void setCondition(String condition) { this.condition = condition; }
    @XmlElement
    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    @XmlElement
    public String getSku() { return sku; }

    public void setSku(String sku) { this.sku = sku; }

    @XmlElement
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }
    public void printProduct() {
    	System.out.println("ITEM [ title = " + title + " , upc = " + upc + " ,sku= " +
    	", condition = " + condition + ", quanity= " + quantity + " ]" ); 
    }
    public String printJsonProduct() {
    	String jsonString= "";
    	return jsonString;
    }
    public void setProduct( String pTitle, String pUpc, String pSku, String pPrice, 
    		String pCondition, String pQuantity)
    {
    	title = pTitle;
    	upc = pUpc;
    	sku = pSku;
    	price = new BigDecimal( pPrice );
    	sellPrice = new BigDecimal( 0 );
    	condition = pCondition;
    	quantity = Integer.valueOf( pQuantity ) ;
    }

}
