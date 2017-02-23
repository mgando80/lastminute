/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gandolfi.salestaxes;

/**
 * Generic taxes engine interface
 * @author m.gandolfi
 * @param <T>
 */
public interface TaxesEngine<T> {
    public double calculateTaxesAmount(T object);
}
