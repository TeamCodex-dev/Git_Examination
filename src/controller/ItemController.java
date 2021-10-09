package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.ItemDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemController {

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtCode;

    String name = txtName.getText();
    String code = txtCode.getText();

    @FXML
    void saveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        ItemDTO itemDTO = new ItemDTO(code, name);
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Item values (?,?)");
        stm.setString(1, itemDTO.getName());
        stm.setString(2, itemDTO.getCode());

        if (stm.executeUpdate() > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved!", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again!", ButtonType.OK).show();
        }
    }

}
