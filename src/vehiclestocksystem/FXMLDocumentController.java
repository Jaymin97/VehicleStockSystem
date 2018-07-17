/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclestocksystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class FXMLDocumentController implements Initializable {
    
    @FXML private TableView<Car> carTableView;
    @FXML private TableColumn<Car, String> regNoCarColumn; 
    @FXML private TableColumn<Car, String> makeCarColumn; 
    @FXML private TableColumn<Car, String> modelCarColumn;
    @FXML private TableColumn<Car, Integer> mileageCarColumn; 
    @FXML private TableColumn<Car, String> fuelTypeCarColumn;
    @FXML private TableColumn<Car, String> transmissionCarColumn;
    @FXML private TableColumn<Car, Integer> noOfDoorsCarColumn; 
    @FXML private TableColumn<Car, Integer> noOfSeatsCarColumn; 
    @FXML private TableColumn<Car, String> engineSizeCarColumn; 
    @FXML private TableColumn<Car, Double> priceCarColumn;

    @FXML private TableView<Motorbike> motorbikeTableView;
    @FXML private TableColumn<Motorbike, String> regNoMotorbikeColumn; 
    @FXML private TableColumn<Motorbike, String> makeMotorbikeColumn; 
    @FXML private TableColumn<Motorbike, String> modelMotorbikeColumn;
    @FXML private TableColumn<Motorbike, Integer> mileageMotorbikeColumn; 
    @FXML private TableColumn<Motorbike, String> fuelTypeMotorbikeColumn;
    @FXML private TableColumn<Motorbike, String> engineSizeMotorbikeColumn; 
    @FXML private TableColumn<Motorbike, Double> priceMotorbikeColumn;
    
    String carsDir = System.getProperty("user.dir") + "\\cars.csv";
    String motorbikesDir = System.getProperty("user.dir") + "\\motorbikes.csv";
    String delimiter = ",";
    
    public void changeToLogin(ActionEvent event) throws IOException
    {
        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }
    
    public void changeToSell(ActionEvent event) throws IOException
    {
        Parent sellVehicle = FXMLLoader.load(getClass().getResource("SellVehicle.fxml"));
        Scene sellVehicleScene = new Scene(sellVehicle);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sellVehicleScene);
        window.show();
    }
    
    public void addToCar(Car car) throws IOException
    {
        carTableView.getItems().add(car);
        File fileCar = new File("cars.csv");
        try
        {
            FileWriter fw = new FileWriter(fileCar, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(car.getRegistration() + "," + car.getMake() + "," + car.getModel() + "," + car.getMileage() + "," + car.getFuelType() + "," + car.getEngineSize() + "," + car.getPrice() + "," + car.getNumberOfDoors() + "," + car.getNumberOfSeats() + "," + car.getTransmission() + "\n");
            bw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error");
        }           
    }
        
    public void addToMotorbike(Motorbike motorbike)
    {
        motorbikeTableView.getItems().add(motorbike);
        File fileMotorbike = new File("motorbikes.csv");
        try
        {
            FileWriter fw = new FileWriter(fileMotorbike, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(motorbike.getRegistration() + "," + motorbike.getMake() + "," + motorbike.getModel() + "," + motorbike.getMileage() + "," + motorbike.getFuelType() + "," + motorbike.getEngineSize() + "," + motorbike.getPrice() + "\n");
            bw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error");
        }  
    }
    
    public void changeRegNoCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldRegNo = carSelected.getRegistration();
        carSelected.setRegistration(editedCell.getNewValue().toString());
        String newRegNo = carSelected.getRegistration();
        changeCarFileStr(oldRegNo, newRegNo); 
    }
    
    public void changeMakeCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldMake = carSelected.getMake();
        carSelected.setMake(editedCell.getNewValue().toString());
        String newMake = carSelected.getMake();
        changeCarFileStr(oldMake, newMake);
    }
        
    public void changeModelCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldModel = carSelected.getModel();
        carSelected.setModel(editedCell.getNewValue().toString());
        String newModel = carSelected.getModel();
        changeCarFileStr(oldModel, newModel);
    }
            
    public void changeMileageCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        int oldMileage = carSelected.getMileage();
        carSelected.setMileage((int) editedCell.getNewValue());
        int newMileage = carSelected.getMileage();
        changeCarFileInt(oldMileage, newMileage);
    }
                
    public void changeFuelTypeCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldFuelType = carSelected.getFuelType();
        carSelected.setFuelType(editedCell.getNewValue().toString());
        String newFuelType = carSelected.getFuelType();
        changeCarFileStr(oldFuelType, newFuelType);
    }
                    
    public void changeEngineSizeCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldEngineSize = carSelected.getEngineSize();
        carSelected.setEngineSize(editedCell.getNewValue().toString());
        String newEngineSize = carSelected.getEngineSize();
        changeCarFileStr(oldEngineSize, newEngineSize);
    }
    
    public void changePriceCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        double oldPrice = carSelected.getPrice();
        carSelected.setPrice((double) editedCell.getNewValue());
        double newPrice = carSelected.getPrice();
        changeCarFileDouble(oldPrice, newPrice);
    }
        
    public void changeNumberOfDoorsCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        int oldNumberOfDoors = carSelected.getNumberOfDoors();
        carSelected.setNumberOfDoors((int) editedCell.getNewValue());
        int newNumberOfDoors = carSelected.getNumberOfDoors();
        changeCarFileInt(oldNumberOfDoors, newNumberOfDoors);
    }
            
    public void changeNumberOfSeatsCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        int oldNumberOfSeats = carSelected.getNumberOfSeats();
        carSelected.setNumberOfSeats((int) editedCell.getNewValue());
        int newNumberOfSeats = carSelected.getNumberOfSeats();
        changeCarFileInt(oldNumberOfSeats, newNumberOfSeats);
    }
                
    public void changeTransmissionCarColumnEvent(CellEditEvent editedCell)
    {
        Car carSelected = carTableView.getSelectionModel().getSelectedItem();
        String oldTransmission = carSelected.getTransmission();
        carSelected.setTransmission(editedCell.getNewValue().toString());
        String newTransmission = carSelected.getTransmission();
        changeCarFileStr(oldTransmission, newTransmission);
    }
    
    public void changeRegNoMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        String oldRegNo = motorbikeSelected.getRegistration();
        motorbikeSelected.setRegistration(editedCell.getNewValue().toString());
        String newRegNo = motorbikeSelected.getRegistration();
        changeMotorbikeFileStr(oldRegNo, newRegNo);
    }
        
    public void changeMakeMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        String oldMake = motorbikeSelected.getMake();
        motorbikeSelected.setMake(editedCell.getNewValue().toString());
        String newMake = motorbikeSelected.getMake();
        changeMotorbikeFileStr(oldMake, newMake);
    }
            
    public void changeModelMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        String oldModel = motorbikeSelected.getModel();
        motorbikeSelected.setModel(editedCell.getNewValue().toString());
        String newModel = motorbikeSelected.getModel();
        changeMotorbikeFileStr(oldModel, newModel);
    }
                
    public void changeFuelTypeMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        String oldFuelType = motorbikeSelected.getFuelType();
        motorbikeSelected.setFuelType(editedCell.getNewValue().toString());
        String newFuelType = motorbikeSelected.getFuelType();
        changeMotorbikeFileStr(oldFuelType, newFuelType);
    }
                    
    public void changeMileageMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        int oldMileage = motorbikeSelected.getMileage();
        motorbikeSelected.setMileage((int) editedCell.getNewValue());
        int newMileage = motorbikeSelected.getMileage();
        changeMotorbikeFileInt(oldMileage, newMileage);
    }
                        
    public void changeEngineSizeMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        String oldEngineSize = motorbikeSelected.getEngineSize();
        motorbikeSelected.setEngineSize(editedCell.getNewValue().toString());
        String newEngineSize = motorbikeSelected.getEngineSize();
        changeMotorbikeFileStr(oldEngineSize, newEngineSize);
    }
                            
    public void changePriceMotorbikeColumnEvent(CellEditEvent editedCell)
    {
        Motorbike motorbikeSelected = motorbikeTableView.getSelectionModel().getSelectedItem();
        double oldPrice = motorbikeSelected.getPrice();
        motorbikeSelected.setPrice((double) editedCell.getNewValue());
        double newPrice = motorbikeSelected.getPrice();
        changeMotorbikeFileDouble(oldPrice, newPrice);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        regNoCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("registration"));
        makeCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("make"));
        modelCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        mileageCarColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("mileage"));
        fuelTypeCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("fuelType"));
        transmissionCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("transmission"));
        noOfDoorsCarColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numberOfDoors"));
        noOfSeatsCarColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numberOfSeats"));
        engineSizeCarColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("engineSize"));
        priceCarColumn.setCellValueFactory(new PropertyValueFactory<Car, Double>("price"));
        
        regNoMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, String>("registration"));
        makeMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, String>("make"));
        modelMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, String>("model"));
        mileageMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, Integer>("mileage"));
        fuelTypeMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, String>("fuelType"));
        engineSizeMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, String>("engineSize"));
        priceMotorbikeColumn.setCellValueFactory(new PropertyValueFactory<Motorbike, Double>("price"));
        
        carTableView.setEditable(true);
        motorbikeTableView.setEditable(true);
        
        regNoCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        makeCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        modelCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mileageCarColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        fuelTypeCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        transmissionCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        noOfDoorsCarColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        noOfSeatsCarColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        engineSizeCarColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCarColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        
        regNoMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        makeMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        modelMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mileageMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        fuelTypeMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        engineSizeMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceMotorbikeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        
        readCarFile();
        readMotorbikeFile();
    }
    
    private void readCarFile()
    {
        try
        {
            BufferedReader carBr = new BufferedReader(new FileReader(carsDir));
            String carLine;
            while((carLine = carBr.readLine()) != null)
            {
                String[] carFields = carLine.split(delimiter, -1);
                
                Car car = new Car(carFields[0], carFields[1], carFields[2], Integer.parseInt(carFields[3]), carFields[4], carFields[5], Double.parseDouble(carFields[6]), Integer.parseInt(carFields[7]), Integer.parseInt(carFields[8]), carFields[9]);
                carTableView.getItems().add(car);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error");
        }
        catch(ArrayIndexOutOfBoundsException exc)
        {
        }        
    }
    
    private void readMotorbikeFile()
    {
        try
        {
            BufferedReader motorbikeBr = new BufferedReader(new FileReader(motorbikesDir));
            String motorbikeLine;
            while((motorbikeLine = motorbikeBr.readLine()) != null)
            {
                String[] motorbikeFields = motorbikeLine.split(delimiter, -1);
                
                Motorbike motorbike = new Motorbike(motorbikeFields[0], motorbikeFields[1], motorbikeFields[2], Integer.parseInt(motorbikeFields[3]), motorbikeFields[4], motorbikeFields[5], Double.parseDouble(motorbikeFields[6]));
                motorbikeTableView.getItems().add(motorbike);
            }            
        }
        catch(IOException ex)
        {
            System.out.println("Error");
        }
        catch(ArrayIndexOutOfBoundsException exce)
        {
        }        
    }
    
    private void changeCarFileStr(String oldField, String newField)
    {
        try
        {
            File fileCar = new File("cars.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileCar));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(oldField, newField);
            FileWriter fw = new FileWriter("cars.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }        
    }
    
    private void changeCarFileInt(int oldField, int newField)
    {
        try
        {
            File fileCar = new File("cars.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileCar));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(Integer.toString(oldField), Integer.toString(newField));
            FileWriter fw = new FileWriter("cars.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }         
    }
    
    private void changeCarFileDouble(double oldField, double newField)
    {
        try
        {
            File fileCar = new File("cars.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileCar));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(Double.toString(oldField), Double.toString(newField));
            FileWriter fw = new FileWriter("cars.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }         
    }
    
    private void changeMotorbikeFileStr(String oldField, String newField)
    {
        try
        {
            File fileMotorbike = new File("motorbikes.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileMotorbike));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(oldField, newField);
            FileWriter fw = new FileWriter("motorbikes.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }        
    }
    
    private void changeMotorbikeFileInt(int oldField, int newField)
    {
        try
        {
            File fileMotorbike = new File("motorbikes.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileMotorbike));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(Integer.toString(oldField), Integer.toString(newField));
            FileWriter fw = new FileWriter("motorbikes.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }         
    }
    
    private void changeMotorbikeFileDouble(double oldField, double newField)
    {
        try
        {
            File fileMotorbike = new File("motorbikes.csv");
            BufferedReader br = new BufferedReader(new FileReader(fileMotorbike));
            String line = "";
            String oldLine = "";
            while((line = br.readLine()) != null)
            {
                oldLine += line + "\r\n";
            }
            br.close();
            String newLine = oldLine.replace(Double.toString(oldField), Double.toString(newField));
            FileWriter fw = new FileWriter("motorbikes.csv");
            fw.write(newLine);
            fw.close();
        }
        catch(IOException exception)
        {
            System.out.println("Error");
        }         
    }
}
