package com.example.lunchtray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.example.lunchtray.DataSource;
import java.text.NumberFormat;
import java.util.Map;

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
  //private val _entree = MutableLiveData<MenuItem?>()
  //val entree: LiveData<MenuItem?> = _entree

  // Side for the order
  //private val _side = MutableLiveData<MenuItem?>()
  //val side: LiveData<MenuItem?> = _side

  // Accompaniment for the order.
  //private val _accompaniment = MutableLiveData<MenuItem?>()
  //val accompaniment: LiveData<MenuItem?> = _accompaniment

  
}
