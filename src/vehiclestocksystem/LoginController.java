/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestocksystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label incorrectMessage;
    
    public void changeToHome(ActionEvent event) throws IOException
    {
        Parent home = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homeScene = new Scene(home);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homeScene);
        window.show();
    }
    
    public void changeToAdd(ActionEvent event) throws IOException
    {
        if(username.getText().equals("admin") && password.getText().equals("password"))
        {
            Parent addVehicle = FXMLLoader.load(getClass().getResource("AddVehicle.fxml"));
            Scene addVehicleScene = new Scene(addVehicle);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(addVehicleScene);
            window.show();  
        }
        else
        {
            this.incorrectMessage.setText("Incorrect Username or Password Entered, try again.");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        incorrectMessage.setText("");
    }    
    
}
