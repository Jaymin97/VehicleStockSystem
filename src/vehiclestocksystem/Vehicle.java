/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestocksystem;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author FlaYmiN
 */
public class Vehicle {
    
    private SimpleStringProperty registration;
    private SimpleStringProperty make;
    private SimpleStringProperty model;
    private SimpleIntegerProperty mileage;
    private SimpleStringProperty fuelType;
    private SimpleStringProperty engineSize;
    private SimpleDoubleProperty price;
    
    public Vehicle(String vRegistration, String vMake, String vModel, int vMileage, String vFuelType, String vEngineSize, double vPrice)
    {
        registration = new SimpleStringProperty(vRegistration);
        make = new SimpleStringProperty(vMake);
        model = new SimpleStringProperty(vModel);
        mileage = new SimpleIntegerProperty(vMileage);
        fuelType = new SimpleStringProperty(vFuelType);
        engineSize = new SimpleStringProperty(vEngineSize);
        price = new SimpleDoubleProperty(vPrice);
    }
    
    public String getRegistration()
    {
        return registration.get();
    }
    
    public void setRegistration(String vehRegistration)
    {
        registration = new SimpleStringProperty(vehRegistration);
    }
    
    public String getMake()
    {
        return make.get();
    }
    
    public void setMake(String vehMake)
    {
        make = new SimpleStringProperty(vehMake);
    }
    
    public String getModel()
    {
        return model.get();
    }
    
    public void setModel(String vehModel)
    {
        model = new SimpleStringProperty(vehModel);
    }
    
    public int getMileage()
    {
        return mileage.get();
    }
    
    public void setMileage(int vehMileage)
    {
        mileage = new SimpleIntegerProperty(vehMileage);
    }
    
    public String getFuelType()
    {
        return fuelType.get();
    }
    
    public void setFuelType(String vehFuelType)
    {
        fuelType = new SimpleStringProperty(vehFuelType);
    }
    
    public String getEngineSize()
    {
        return engineSize.get();
    }
    
    public void setEngineSize(String vehEngineSize)
    {
        engineSize = new SimpleStringProperty(vehEngineSize);
    }    
    
    public double getPrice()
    {
        return price.get();
    }
    
    public void setPrice(double vehPrice)
    {
        price = new SimpleDoubleProperty(vehPrice);
    }
}
