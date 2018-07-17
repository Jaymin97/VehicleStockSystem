/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestocksystem;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author FlaYmiN
 */
public class Motorbike extends Vehicle {
    
    public Motorbike(String vRegistration, String vMake, String vModel, int vMileage, String vFuelType, String vEngineSize, double vPrice)
    {
        super(vRegistration, vMake, vModel, vMileage, vFuelType, vEngineSize, vPrice);
    }
}
