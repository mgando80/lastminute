/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

import java.util.List;

/**
 * Shopping basket data structure
 * @author m.gandolfi
 */
public class ShoppingBasket {
    private List<ShoppingItem> purchasedItems;
    private double salesTaxes;
    private double total;

    public ShoppingBasket() {
    }

    public ShoppingBasket(List<ShoppingItem> purchasedItems, double salesTaxes, double total) {
        this.purchasedItems = purchasedItems;
        this.salesTaxes = salesTaxes;
        this.total = total;
    }

    public List<ShoppingItem> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<ShoppingItem> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public double getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(double salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void printContent() {
        String output = "";
        for (ShoppingItem item : this.purchasedItems) {
            output += item.getQuantity() + " " + item.getDescription() + " : " + String.format("%.2f", item.getPriceWithTaxes()) + "\n";
        }
        output += "Sales Taxes: " + String.format("%.2f", this.salesTaxes) + "\n";
        output += "Total: " + String.format("%.2f", this.total);
        System.out.println(output);
    }
}
