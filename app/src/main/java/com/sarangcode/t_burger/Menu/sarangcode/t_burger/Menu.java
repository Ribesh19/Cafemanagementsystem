
package com.sarangcode.t_burger.Menu.sarangcode.t_burger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("orderid")
    @Expose
    private Integer orderid;
    @SerializedName("tableno")
    @Expose
    private String tableno;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("categoryitem")
    @Expose
    private String categoryitem;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryitem() {
        return categoryitem;
    }

    public void setCategoryitem(String categoryitem) {
        this.categoryitem = categoryitem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
