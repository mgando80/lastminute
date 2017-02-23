/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Engine class that defines how sales taxes are to be applied to a ShoppingItem 
 * @author m.gandolfi
 */
public class SalesTaxesEngine implements TaxesEngine<ShoppingItem> {
    private static final String FILE = "salestaxes.properties";
    private int basicTaxRate;
    private List<String> basicTaxExemptions;
    private int importTaxRate;

    public SalesTaxesEngine() {
        this.loadProperties();
    }
    
    //Reads from a .properties file and initializes instance variables
    private void loadProperties() {
        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE));
            this.basicTaxRate = Integer.parseInt(prop.getProperty("basic.rate"));
            this.basicTaxExemptions = new ArrayList<>(Arrays.asList(prop.getProperty("basic.exemptions").split(",")));
            this.importTaxRate = Integer.parseInt(prop.getProperty("import.rate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public double calculateTaxesAmount(ShoppingItem item) {
        double taxesAmount = 0;
        //Calculate basic sales tax
        if (!basicTaxExemptions.contains(item.getType().toUpperCase())) {
            taxesAmount += this.round(item.getPrice() / 100 * basicTaxRate);
        }
        //Calculate import sales tax
        if (item.isImported()) {
            taxesAmount += this.round(item.getPrice() / 100 * importTaxRate);
        }
        return taxesAmount;
    }
    
    //Rounds up to the nearest 0.05
    private double round(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }

    public int getBasicTaxRate() {
        return basicTaxRate;
    }

    public void setBasicTaxRate(int basicTaxRate) {
        this.basicTaxRate = basicTaxRate;
    }

    public List<String> getBasicTaxExemptions() {
        return basicTaxExemptions;
    }

    public void setBasicTaxExemptions(List<String> basicTaxExemptions) {
        this.basicTaxExemptions = basicTaxExemptions;
    }

    public int getImportTaxRate() {
        return importTaxRate;
    }

    public void setImportTaxRate(int importTaxRate) {
        this.importTaxRate = importTaxRate;
    }
}
