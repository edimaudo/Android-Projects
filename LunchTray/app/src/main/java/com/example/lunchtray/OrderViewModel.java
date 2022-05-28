package com.example.lunchtray;

import androidx.lifecycle.MutableLiveData;

import java.util.Map;
import java.lang.String;
import androidx.lifecycle.Transformations;
import java.text.NumberFormat;

class OrderViewModel {

  // Map of menu items
  DataSource dataSource = new DataSource();
  Map<String, MenuItem> mp = dataSource.getMenuItems();

  // Default values for item prices
  private Double previousEntreePrice = 0.0;
  private Double previousSidePrice = 0.0;
  private Double previousAccompanimentPrice = 0.0;

  // Default tax rate
  private Double taxRate = 0.08;

  // Entree for the order
  private MutableLiveData menuItem = new MutableLiveData<MenuItem>();
  Object entree = menuItem;//val entree: LiveData<MenuItem?> = _entree

  // Side for the order
  private MutableLiveData _side = new MutableLiveData<MenuItem>();
  Object side = _side;//val side: LiveData<MenuItem?> = _side

  // Accompaniment for the order.
  //private val _accompaniment = MutableLiveData<MenuItem?>()
  //val accompaniment: LiveData<MenuItem?> = _accompaniment


  // Subtotal for the order
private MutableLiveData _subtotal = new MutableLiveData(0.0);
String LiveData<String> subtotal = Transformations.map(_subtotal) {
    NumberFormat.getCurrencyInstance().format(it);
  }
//
//  // Total cost of the order
//  private val _total = MutableLiveData(0.0)
//  val total: LiveData<String> = Transformations.map(_total) {
//    NumberFormat.getCurrencyInstance().format(it)
//  }
//
//  // Tax for the order
//  private val _tax = MutableLiveData(0.0)
//  val tax: LiveData<String> = Transformations.map(_tax) {
//    NumberFormat.getCurrencyInstance().format(it)
//  }

  public void setEntree(String entree) {
    // TODO: if _entree.value is not null, set the previous entree price to the current
    //  entree price.

    // TODO: if _subtotal.value is not null subtract the previous entree price from the current
    //  subtotal value. This ensures that we only charge for the currently selected entree.

    // TODO: set the current entree value to the menu item corresponding to the passed in string
    // TODO: update the subtotal to reflect the price of the selected entree.
  }

  public void setSide(String side) {
    // TODO: if _side.value is not null, set the previous side price to the current side price.

    // TODO: if _subtotal.value is not null subtract the previous side price from the current
    //  subtotal value. This ensures that we only charge for the currently selected side.

    // TODO: set the current side value to the menu item corresponding to the passed in string
    // TODO: update the subtotal to reflect the price of the selected side.
  }

  public void setAccompaniment( String accompaniment) {
    // TODO: if _accompaniment.value is not null, set the previous accompaniment price to the
    //  current accompaniment price.

    // TODO: if _accompaniment.value is not null subtract the previous accompaniment price from
    //  the current subtotal value. This ensures that we only charge for the currently selected
    //  accompaniment.

    // TODO: set the current accompaniment value to the menu item corresponding to the passed in
    //  string
    // TODO: update the subtotal to reflect the price of the selected accompaniment.
  }


  private void updateSubtotal(Double itemPrice) {
    // TODO: if _subtotal.value is not null, update it to reflect the price of the recently
    //  added item.
    //  Otherwise, set _subtotal.value to equal the price of the item.

    // TODO: calculate the tax and resulting total
  }


  public void calculateTaxAndTotal() {
    // TODO: set _tax.value based on the subtotal and the tax rate.
    // TODO: set the total based on the subtotal and _tax.value.
  }


  public void resetOrder() {
    // TODO: Reset all values associated with an order
  }
}
