/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.museomanager;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import com.mycompany.managedb.ManageMuseos;
import com.mycompany.museomanager.database.MmMuseos;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ANTONY JOSUE
 */
public class MainWindowController implements Initializable {

    @FXML
    private AnchorPane apMuseo;
    @FXML
    private AnchorPane apRooms;
    @FXML
    private AnchorPane apCollections;
    @FXML
    private AnchorPane apSpecies;
    @FXML
    private AnchorPane apThemes;
    @FXML
    private AnchorPane apPrices;
    @FXML
    private AnchorPane apCommissions;
    @FXML
    private AnchorPane apSellTickets;
    @FXML
    private AnchorPane apValidateTickets;
    @FXML
    private AnchorPane apRateRoom;
    @FXML
    private AnchorPane apGenerateReport;

    private List<AnchorPane> windows;

    private List<Button> buttonList;
    @FXML
    private Button btnMuseos;
    @FXML
    private Button btnRooms;
    @FXML
    private Button btnCollections;
    @FXML
    private Button btnSpecies;
    @FXML
    private Button btnThemes;
    @FXML
    private Button btnPrices;
    @FXML
    private Button btnCommissions;
    @FXML
    private Button bntSellTickets;
    @FXML
    private Button btnValidateTickets;
    @FXML
    private Button btnRateRoom;
    @FXML
    private Button btnGenerateReport;
    @FXML
    private TableView<MmMuseos> tbvMuseum;
    @FXML
    private TextField tfMuseumName;
    @FXML
    private Button btnAddMuseum;
    @FXML
    private ComboBox<?> cbTypeMuseum;
    @FXML
    private TextField tfLocation;
    @FXML
    private TextField tfURLWeb;
    @FXML
    private DatePicker dpDateMuseum;
    @FXML
    private Button btnUpdateMuseum;
    @FXML
    private Button btnDeleteMuseum;
    @FXML
    private TextField tfSearchMuseum;
    @FXML
    private Button btnSearchMuseo;
    @FXML
    private Label lbMiniTitle;
    @FXML
    private Label lbMainTitle;
    //gestion del primer anchorpane y base de datos
    private ManageMuseos connectionMuseum; 
    private MmMuseos currentMuseum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        windows = Arrays.asList(
                apMuseo,
                apRooms,
                apCollections,
                apSpecies,
                apThemes,
                apPrices,
                apCommissions,
                apSellTickets,
                apValidateTickets,
                apRateRoom,
                apGenerateReport
        );
        buttonList = Arrays.asList(
                btnMuseos,
                btnRooms,
                btnCollections,
                btnSpecies,
                btnThemes,
                btnPrices,
                btnCommissions,
                bntSellTickets,
                btnValidateTickets,
                btnRateRoom,
                btnGenerateReport
        );
        for (int i = 0; i < buttonList.size(); i++) {
            final int index = i;
            buttonList.get(i).setOnAction(event -> showWindow(windows.get(index)));
        }

        //lambada para asignar funciones a los botones mas rapido
        btnAddMuseum.setOnAction(e -> addMuseum());
        btnUpdateMuseum.setOnAction(e -> updateMuseum());
        btnDeleteMuseum.setOnAction(e -> deleteMuseum());
        btnSearchMuseo.setOnAction(e -> searchMuseums());
    }

    private void showWindow(AnchorPane selected) {
        for (AnchorPane i : windows) {
            i.setVisible(false);
            if (selected == i) {
                i.setVisible(true);
                i.toFront();
            }
        }
    }

    private void addMuseum() {
    }

    private void updateMuseum() {
    }

    private void deleteMuseum() {
    }

    private void readMuseums() {
    }

    private void searchMuseums() {
    }
    
    

}
