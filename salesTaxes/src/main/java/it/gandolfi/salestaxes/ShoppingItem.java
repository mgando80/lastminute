/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

/**
 * Purchased item data structure
 * @author m.gandolfi
 */
public class ShoppingItem {
    private String type;
    private String description;
    private int quantity;
    private boolean imported;
    private double price;
    private double taxesAmount;

    public ShoppingItem() {
    }

    public ShoppingItem(String type, String description, int quantity, boolean imported, double price) {
        this.type = type;
        this.description = description;
        this.quantity = quantity;
        this.imported = imported;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxesAmount() {
        return taxesAmount;
    }

    public void setTaxesAmount(double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    public double getPriceWithTaxes() {
        return price + taxesAmount;
    }
}
