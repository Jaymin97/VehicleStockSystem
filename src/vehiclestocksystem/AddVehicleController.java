/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestocksystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddVehicleController implements Initializable {
    
    @FXML private ChoiceBox vehType;
    @FXML private ChoiceBox noOfDoors;
    @FXML private ChoiceBox noOfSeats;
    @FXML private ChoiceBox fuelType;
    @FXML private ChoiceBox transmission;
    @FXML private TextField engineSize;
    @FXML private TextField regNo;
    @FXML private TextField make;
    @FXML private TextField model;
    @FXML private TextField mileage;
    @FXML private TextField price;
    private Car car;
    private Motorbike mb;
    private String reg, mk, mdl, fuel, tranny, engine;
    private int doors, seats, miles;
    private double prc;
    
    
    public void changeToHomeCancel(ActionEvent event) throws IOException
    {
        Parent home = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homeScene = new Scene(home);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
    
    public void changeToHomeConfirm(ActionEvent event) throws IOException
    {   
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent home = loader.load();
        Scene homeScene = new Scene(home);
        
        //enter conditions for confirm here, i.e entering info for all fields
        if(vehType.getSelectionModel().getSelectedItem().toString().equals("Car"))
        {
            reg = regNo.getText();
            mk = make.getText();
            mdl = model.getText();
            engine = engineSize.getText();
            fuel = fuelType.getSelectionModel().getSelectedItem().toString();
            tranny = transmission.getSelectionModel().getSelectedItem().toString();
            doors = (int) noOfDoors.getSelectionModel().getSelectedItem();
            seats = (int) noOfSeats.getSelectionModel().getSelectedItem();
            miles = Integer.parseInt(mileage.getText());
            prc = Double.parseDouble(price.getText());
            
            car = new Car(reg, mk, mdl, miles, fuel, engine, prc, doors, seats, tranny);
            FXMLDocumentController controller = loader.getController();
            controller.addToCar(car);
        }
        else
        {
            reg = regNo.getText();
            mk = make.getText();
            mdl = model.getText();
            engine = engineSize.getText();
            fuel = fuelType.getSelectionModel().getSelectedItem().toString();
            miles = Integer.parseInt(mileage.getText());
            prc = Double.parseDouble(price.getText());
            
            mb = new Motorbike(reg, mk, mdl, miles, fuel, engine, prc);
            FXMLDocumentController controller = loader.getController();
            controller.addToMotorbike(mb);
        }

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show(); 
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        vehType.getItems().addAll("Please Select", "Car", "Motorbike");
        vehType.setValue("Please Select");
        
        noOfDoors.getItems().addAll("Please Select", 2, 3, 4, 5);
        noOfDoors.setValue("Please Select");
        
        noOfSeats.getItems().addAll("Please Select", 2, 3, 4, 5, 6, 7, 8, 9);
        noOfSeats.setValue("Please Select");
        
        fuelType.getItems().addAll("Please Select", "Petrol", "Diesel");
        fuelType.setValue("Please Select");
        
        transmission.getItems().addAll("Please Select", "Manual", "Automatic");
        transmission.setValue("Please Select");
        
        vehType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(vehType.getSelectionModel().getSelectedItem().equals("Motorbike"))
                {
                    noOfDoors.setDisable(true);
                    noOfSeats.setDisable(true);
                    transmission.setDisable(true);
                }
                else
                {
                    noOfDoors.setDisable(false);
                    noOfSeats.setDisable(false);
                    transmission.setDisable(false);
                }
            }
        });
    } 
}
