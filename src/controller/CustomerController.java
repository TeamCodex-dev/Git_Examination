package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {

    @FXML
    private JFXTextField txtCustId;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtName;

    @FXML
    void custIDOnAction(ActionEvent event) {

    }

    String name = txtName.getText();
    String nic = txtNic.getText();
    String address = txtAddress.getText();
    String contact = txtContact.getText();

    @FXML
    void saveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO(name, address, contact, nic);
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Customer values (?,?,?,?)");
        stm.setString(1, customerDTO.getName());
        stm.setString(2, customerDTO.getAddress());
        stm.setString(3, customerDTO.getMobileNumber());
        stm.setObject(4, customerDTO.getNic());
        if (stm.executeUpdate() > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again!", ButtonType.OK).show();
        }
    }

    @FXML
    void tctContactOnAction(ActionEvent event) {

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtNicOnAction(ActionEvent event) {

    }

}
