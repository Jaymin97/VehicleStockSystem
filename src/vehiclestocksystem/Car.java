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
public class Car extends Vehicle{
    
    private SimpleIntegerProperty numberOfDoors;
    private SimpleIntegerProperty numberOfSeats;
    private SimpleStringProperty transmission;
    
    public Car(String vRegistration, String vMake, String vModel, int vMileage, String vFuelType, String vEngineSize, double vPrice, int vNumberOfDoors, int vNumberOfSeats, String vTransmission)
    {
        super(vRegistration, vMake, vModel, vMileage, vFuelType, vEngineSize, vPrice);
        numberOfDoors = new SimpleIntegerProperty(vNumberOfDoors);
        numberOfSeats = new SimpleIntegerProperty(vNumberOfSeats);
        transmission = new SimpleStringProperty(vTransmission);
    }
    
    public int getNumberOfDoors()
    {
        return numberOfDoors.get();
    }
    
    public void setNumberOfDoors(int noOfDoors)
    {
        numberOfDoors = new SimpleIntegerProperty(noOfDoors);
    }
    
    public int getNumberOfSeats()
    {
        return numberOfSeats.get();
    }
    
    public void setNumberOfSeats(int noOfSeats)
    {
        numberOfSeats = new SimpleIntegerProperty(noOfSeats);
    }
    
    public String getTransmission()
    {
        return transmission.get();
    }
    
    public void setTransmission(String tranny)
    {
        transmission = new SimpleStringProperty(tranny);
    }
}
