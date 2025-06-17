/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.museomanager;
//#region imports

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.mycompany.managedb.ManageCardAndCommissions;
import com.mycompany.managedb.ManageMuseos;
import com.mycompany.managedb.ManageRatingBoard;
import com.mycompany.managedb.ManageRooms;
import com.mycompany.managedb.ManageSalesAndRooms;
import com.mycompany.managedb.ManageSellTickets;
import com.mycompany.managedb.ManageSpecies;
import com.mycompany.managedb.ManageThemes;
import com.mycompany.managedb.ManagerColletions;
import com.mycompany.managedb.ManagerTicketPrice;
import com.mycompany.museomanager.database.MmColecciones;
import com.mycompany.museomanager.database.MmEspecies;
import com.mycompany.museomanager.database.MmMuseos;
import com.mycompany.museomanager.database.MmPrecioDeEntradas;
import com.mycompany.museomanager.database.MmSalas;
import com.mycompany.museomanager.database.MmTarjetaYComisiones;
import com.mycompany.museomanager.database.MmTematica;
import com.mycompany.museomanager.database.MmVentaDeEntradas;
import com.mycompany.museomanager.database.MmVentasYSalas;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//#endregion
/**
 * FXML Controller class
 *
 * @author ANTONY JOSUE
 */
public class MainWindowController implements Initializable {
    //#region Variables

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
    private Button btnExit;
    @FXML
    private ComboBox<String> cbTypeMuseum;
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

    @FXML
    private TextField tfNameCollection;
    @FXML
    private TableView<MmColecciones> tbvCollections;
    @FXML
    private TableColumn<MmColecciones, Integer> clmIdCollection;
    @FXML
    private TableColumn<MmColecciones, MmSalas> clmIdRoomCollection;
    @FXML
    private TableColumn<MmColecciones, String> clmNameCollection;
    @FXML
    private TableColumn<MmColecciones, Integer> clmCenturyCollection;
    @FXML
    private TableColumn<MmColecciones, String> clmDescriptionCollection;
    @FXML
    private Button btnAddCollection;
    @FXML
    private ComboBox<MmSalas> cbIdRoom;
    @FXML
    private Spinner<Integer> spnCentury;
    @FXML
    private TextArea taDescriptionCollection;
    @FXML
    private Button btnUpdateCollection;
    @FXML
    private Button btnDeleteCollections;
    @FXML
    private Button btnSearchCollection;
    @FXML
    private TextField tfSearchCollection;
    @FXML
    private TextField tfNameScientist;
    @FXML
    private Button btnAddSpecie;
    @FXML
    private TableColumn<MmEspecies, Integer> clmIdSpecie;
    @FXML
    private TableColumn<MmEspecies, MmColecciones> clmIdCollectionSpecie;
    @FXML
    private TableColumn<MmEspecies, String> clmNameScientistSpecie;
    @FXML
    private TableColumn<MmEspecies, String> clmNameCommonSpecie;
    @FXML
    private TableColumn<MmEspecies, Date> clmExpirationDateSpecie;
    @FXML
    private TableColumn<MmEspecies, String> clmEpochSpecie;
    @FXML
    private TableColumn<MmEspecies, Integer> clmWeightSpecie;
    @FXML
    private TableColumn<MmEspecies, Integer> clmSizeSpecie;
    @FXML
    private TableColumn<MmEspecies, String> clmcharacteristicSpecie;
    @FXML
    private ComboBox<MmColecciones> cbIdCollectionsSpecies;
    @FXML
    private TextField tfNameCommon;
    @FXML
    private DatePicker dtpExpirationDate;
    @FXML
    private TextField tfEpoch;
    @FXML
    private TextArea taCharacteristicSpecie;
    @FXML
    private Spinner<Integer> spnSizeSpecie;
    @FXML
    private Spinner<Integer> spnWeigthSpecie;
    @FXML
    private Button btnUpdateSpecie;
    @FXML
    private Button btnDeleteSpecie;
    @FXML
    private TextField tfSearchSpecie;
    @FXML
    private Button btnSearchSpecie;
    @FXML
    private ComboBox<MmSalas> cbIdRoomTheme;
    @FXML
    private TextField tfNameTheme;
    @FXML
    private TextArea taCharacteristicTheme;
    @FXML
    private Button btnAddTheme;
    @FXML
    private Button btnUpdateTheme;
    @FXML
    private Button btnDeleteTheme;
    @FXML
    private TextField tfSearchTheme;
    @FXML
    private Button btnSearchTheme;
    @FXML
    private TableView<MmTematica> tbvThemes;
    @FXML
    private TableColumn<MmTematica, Integer> clmIdTheme;
    @FXML
    private TableColumn<MmTematica, MmSalas> clmIdRoomTheme;
    @FXML
    private TableColumn<MmTematica, String> clmNameTheme;
    @FXML
    private TableColumn<MmTematica, String> clmEpochTheme;
    @FXML
    private TableColumn<MmTematica, String> clmCharacteristicTheme;
    @FXML
    private TextField tfEpochTheme;
    @FXML
    private TextField tfCostMondayFridayPrice;
    @FXML
    private TextField tfCostSaturdaySundayPrice;
    @FXML
    private ComboBox<MmMuseos> cbIdMuseumPrice;
    @FXML
    private Button bntAddPrice;
    @FXML
    private Button btnUpdatePrice;
    @FXML
    private Button btnDeletePricce;
    @FXML
    private TextField tfSearchPrice;
    @FXML
    private Button btnSearchPrice;
    @FXML
    private TableView<MmPrecioDeEntradas> tbvPrices;
    @FXML
    private TableColumn<MmPrecioDeEntradas, Integer> clmIdPrice;
    @FXML
    private TableColumn<MmPrecioDeEntradas, MmMuseos> clmIdMuseumPrice;
    @FXML
    private TableColumn<MmPrecioDeEntradas, Integer> clmCostMondayFridayPrice;
    @FXML
    private TableColumn<MmPrecioDeEntradas, Integer> clmCostSaturdaySundayPrice;
    @FXML
    private ComboBox<String> cbTypeCard;
    @FXML
    private ComboBox<MmMuseos> cbIdMuseumCommission;
    @FXML
    private TextField tfCommission;
    @FXML
    private TextField tfSearchCommission;
    @FXML
    private Button btnAddCommission;
    @FXML
    private Button btnUpdateCommission;
    @FXML
    private Button btnDeleteCommission;
    @FXML
    private Button btnSearchCommission;
    @FXML
    private TableView<MmTarjetaYComisiones> tbvCommissions;
    @FXML
    private TableColumn<MmTarjetaYComisiones, Integer> clmCommission;
    @FXML
    private TableColumn<MmTarjetaYComisiones, Integer> clmTypeCardCommission;
    @FXML
    private TableColumn<MmTarjetaYComisiones, Integer> clmIdMuseumCommission;
    @FXML
    private TextField tfNameVisitorSellTicket;
    @FXML
    private ComboBox<String> cbTypeCredicCardSellTicket;
    @FXML
    private Label lbCurrentDate;
    @FXML
    private ComboBox<MmMuseos> cbMuseumsSellTicket;
    @FXML
    private DatePicker dpDateSellTicket;
    @FXML
    private TableView<MmVentaDeEntradas> tbvSellTickets;
    @FXML
    private TableColumn<MmVentaDeEntradas, MmMuseos> clmNameMuseumSellTicket;
    @FXML
    private TableColumn<MmVentaDeEntradas, MmSalas> clmNameRoomSellTicket;
    @FXML
    private TableColumn<MmVentaDeEntradas, Date> clmDateVisitSellTicket;
    @FXML
    private TableColumn<MmVentaDeEntradas, Integer> clmPriceSellTicket;
    @FXML
    private ComboBox<MmSalas> cbRoomsSellTicket;
    @FXML
    private Button btnAddRoomSellTicket;
    @FXML
    private TextField lbSubTotalSellTicket;
    @FXML
    private TextField lbCommissionSellTicket;
    @FXML
    private TextField lbTotalPaySellTicket;
    @FXML
    private Button btnSellTicket;
    @FXML
    private Button btnReadQRCodeValidateTicket;
    @FXML
    private Label lbDateValidateTicket;
    @FXML
    private TableView<MmVentasYSalas> tbvValidateTickets;
    @FXML
    private TableColumn<MmVentasYSalas, MmSalas> clmRoomsValidateTicket;
    @FXML
    private TableColumn<MmVentasYSalas, String> clmRateSellTicket;
    @FXML
    private Label lbDateRateRoom;
    @FXML
    private ImageView ivRateRoom;
    @FXML
    private Button btnNextRateRoom;
    @FXML
    private Button btnBackRateRoom;
    @FXML
    private Label lbStartsRateRoom;
    @FXML
    private TextArea taRateRoom;
    @FXML
    private Spinner<Integer> spnStartsRateRoom;
    @FXML
    private TextField tfNameRoomRateRoom;
    @FXML
    private TextArea taDescriptionRateRoom;
    @FXML
    private ComboBox<String> cbGenerateReport;
    @FXML
    private Button btnDownloadReport;
    @FXML
    private TableView<MmEspecies> tbvSpecies;
    @FXML
    private TableView<MmSalas> tbvRooms;
    @FXML
    private TableColumn<MmSalas, Integer> clmIdRoom;
    @FXML
    private TableColumn<MmSalas, MmMuseos> clmIdMuseumRoom;
    @FXML
    private TableColumn<MmSalas, MmSalas> clmNameRoom;
    @FXML
    private TableColumn<MmSalas, String> clmTypeRoom;
    @FXML
    private TableColumn<MmSalas, String> clmDescriptionRoom;
    @FXML
    private Button btnSearchRoom;
    @FXML
    private TextField tfNameRoom;
    @FXML
    private ComboBox<MmMuseos> cbIdMuseumRoom;
    @FXML
    private ComboBox<String> cbTypeRoom;
    @FXML
    private TextArea taDescriptionRoom;
    @FXML
    private TextField tfSearchRoom;
    @FXML
    private Button btnAddRoom;
    @FXML
    private Button btnUpdateRoom;
    @FXML
    private Button btnDeleteRoom;
    @FXML
    private TableColumn<MmMuseos, Integer> clmIdMuseum;
    @FXML
    private TableColumn<MmMuseos, String> clmNameMuseum;
    @FXML
    private TableColumn<MmMuseos, String> clmTypeMuseum;
    @FXML
    private TableColumn<MmMuseos, String> clmLocateMuseum;
    @FXML
    private TableColumn<MmMuseos, String> clmURLMuseum;
    @FXML
    private TableColumn<MmMuseos, Date> clmFundationMuseum;
    //#endregion

    //#region Constants
    private static final List<String> TYPE_MUSEUMS = List.of("Arte", "Historia");
    private static final List<String> TYPE_ROOMS = List.of("Tematica", "Coleccion");
    private static final List<String> TYPE_CREDIC_CARD = List.of("Visa", "MasterCarad");

    //#endregion
    
    //#region DB
    private ManageMuseos connectionMuseum;
    private ManageRooms connectionRoom;
    private ManagerColletions connectionCollection;
    private ManageSpecies connectionSpecies;
    private ManageThemes connectionThemes;
    private ManagerTicketPrice connectionTicketPrice;
    private ManageCardAndCommissions connectionCardAndCommission;
    private ManageSellTickets connectionSellTickets;
    private ManageSalesAndRooms connectionSalesAndRooms;
    private ManageRatingBoard connectionRatingBoard;

    private MmMuseos currentMuseum;
    private MmSalas currentRoom;
    private MmColecciones currentCollection;
    private MmEspecies currentSpecie;
    private MmTematica currentTheme;
    private MmPrecioDeEntradas currentPrice;
    private MmTarjetaYComisiones currentCommission;
    //#endregion

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //#region Crea lista de botones y pantallas
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

            buttonList.get(i).setOnAction(event -> {
                String title = buttonList.get(index).getText();
                showWindow(windows.get(index), title);
            });
        }
        //#endregion

        setTablesInformation();
        setSpinners();

        //#region btn Funciones labadas
        //lambada para asignar funciones a los botones mas rapido
        btnAddMuseum.setOnAction(e -> addMuseum());
        btnUpdateMuseum.setOnAction(e -> updateMuseum());
        btnDeleteMuseum.setOnAction(e -> deleteMuseum());
        btnSearchMuseo.setOnAction(e -> searchMuseums());
        btnExit.setOnAction(e -> exitProgram());
        btnAddRoom.setOnAction(e -> addRoom());
        btnUpdateRoom.setOnAction(e -> updateRoom());
        btnDeleteRoom.setOnAction(e -> deleteRoom());
        btnSearchRoom.setOnAction(e -> searchRoom());
        btnAddCollection.setOnAction(e -> addCollection());
        btnUpdateCollection.setOnAction(e -> updateCollection());
        btnDeleteCollections.setOnAction(e -> deleteCollection());
        btnSearchCollection.setOnAction(e -> searchCollection());
        btnAddSpecie.setOnAction(e -> addSpecie());
        btnUpdateSpecie.setOnAction(e -> updateSpecie());
        btnDeleteSpecie.setOnAction(e -> deleteSpecie());
        btnSearchSpecie.setOnAction(e -> searchSpecie());
        btnAddTheme.setOnAction(e -> addTheme());
        btnUpdateTheme.setOnAction(e -> updateTheme());
        btnDeleteTheme.setOnAction(e -> deleteTheme());
        btnSearchTheme.setOnAction(e -> searchTheme());
        bntAddPrice.setOnAction(e -> addPrice());
        btnUpdatePrice.setOnAction(e -> updatePrice());
        btnDeletePricce.setOnAction(e -> deletePrice()); 
        btnSearchPrice.setOnAction(e -> searchPrice());
        btnAddCommission.setOnAction(e -> addCommission());
        btnUpdateCommission.setOnAction(e -> updateCommission());
        btnDeleteCommission.setOnAction(e -> deleteCommission());
        btnSearchCommission.setOnAction(e -> searchCommission());
        //#endregion
    }

//#region Function Crud
    
    //#region Crud Museum
    private void addMuseum() {
        connectionMuseum = new ManageMuseos();
        MmMuseos item = new MmMuseos();
        item.setNombreDelMuseo(tfMuseumName.getText());
        item.setTipoDeMuseo(cbTypeMuseum.getValue());
        item.setUbicacion(tfLocation.getText());
        item.setUrlDelSitioWeb(tfURLWeb.getText());
        LocalDate dateValue = dpDateMuseum.getValue();
        Date date = Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
        item.setFechaDeFundacion(date);
        try {
            connectionMuseum.add(item);
            showAlertMessage("El Museo fue Agregado correctamente");
            connectionMuseum.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionMuseum.close();
        }

    }

    private void updateMuseum() {
        connectionMuseum = new ManageMuseos();
        /* mas adelante tal vez agrege una nueva funcion
        if (currentMuseum == null) {
            currentMuseum = tbvMuseum.getSelectionModel().getSelectedItem();
        }*/
        if (currentMuseum != null) {
            currentMuseum.setNombreDelMuseo(tfMuseumName.getText());
            currentMuseum.setTipoDeMuseo(cbTypeMuseum.getValue());
            currentMuseum.setUbicacion(tfLocation.getText());
            currentMuseum.setUrlDelSitioWeb(tfURLWeb.getText());
            LocalDate dateValue = dpDateMuseum.getValue();
            Date date = Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
            currentMuseum.setFechaDeFundacion(date);
            try {
                connectionMuseum.update(currentMuseum);
                showAlertMessage("El Museo fue Actualizado correctamente");
                connectionMuseum.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionMuseum.close();
            }
        } else {
            showAlertMessage("Seleccione un Museo");
            connectionMuseum.close();
        }

    }

    private void deleteMuseum() {
        connectionMuseum = new ManageMuseos();
        if (currentMuseum == null) {
            currentMuseum = tbvMuseum.getSelectionModel().getSelectedItem();
        }
        if (currentMuseum != null) {
            try {
                connectionMuseum.delete(currentMuseum.getId());
                showAlertMessage("El Museo fue eliminado correctamente");
                connectionMuseum.close();
                clearSpaces();
                setTablesInformation();

            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionMuseum.close();
            }
        } else {
            showAlertMessage("Seleccione un Museo");
            connectionMuseum.close();
        }
    }

    private void searchMuseums() {
        connectionMuseum = new ManageMuseos();
        String idValue = tfSearchMuseum.getText().trim();
        if (idValue.isEmpty()) {
            showAlertMessage("Ingrese el ID");
            return;
        }
        try {
            BigDecimal id = new BigDecimal(idValue);
            MmMuseos museum = connectionMuseum.search(id);
            if (museum != null) {
                tfMuseumName.setText(museum.getNombreDelMuseo());
                cbTypeMuseum.setValue(museum.getTipoDeMuseo());
                tfLocation.setText(museum.getUbicacion());
                tfURLWeb.setText(museum.getUrlDelSitioWeb());
                Date date = museum.getFechaDeFundacion();
                LocalDate dateValue = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                dpDateMuseum.setValue(dateValue);
                currentMuseum = museum;

            } else {
                showAlertMessage("No se encontro el valor. ");
                connectionMuseum.close();
            }

        } catch (Exception e) {
            showAlertMessage("Error" + e.getMessage());
            connectionMuseum.close();

        }
    }
    //#endregion

    //#region Crud Room
    private void addRoom() {
        connectionRoom = new ManageRooms();
        MmSalas item = new MmSalas();
        item.setNombreDeSala(tfNameRoom.getText());
        item.setTipoDeSala(cbTypeRoom.getValue());
        item.setDescripcion(taDescriptionRoom.getText());
        item.setIdMuseo(cbIdMuseumRoom.getValue());
        try {
            connectionRoom.add(item);
            showAlertMessage("La Sala fue agregada correctamente");
            connectionRoom.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionRoom.close();
        }
    }

    private void updateRoom() {
        connectionRoom = new ManageRooms();
        if (currentRoom != null) {
            currentRoom.setNombreDeSala(tfNameRoom.getText());
            currentRoom.setTipoDeSala(cbTypeRoom.getValue());
            currentRoom.setDescripcion(taDescriptionRoom.getText());
            currentRoom.setIdMuseo(cbIdMuseumRoom.getValue());
            try {
                connectionRoom.update(currentRoom);
                showAlertMessage("La Sala fue actualizada correctamente");
                connectionRoom.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionRoom.close();
            }
        } else {
            showAlertMessage("Seleccione una Sala");
            connectionRoom.close();
        }
    }

    private void deleteRoom() {
        connectionRoom = new ManageRooms();
        if (currentRoom == null) {
            currentRoom = tbvRooms.getSelectionModel().getSelectedItem();
        }
        if (currentRoom != null) {
            try {
                connectionRoom.delete(currentRoom.getId());
                showAlertMessage("La Sala fue eliminada correctamente");
                connectionRoom.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionRoom.close();
            }
        } else {
            showAlertMessage("Seleccione una Sala");
            connectionRoom.close();
        }
    }

    private void searchRoom() {
        connectionRoom = new ManageRooms();
        String idValue = tfSearchRoom.getText().trim();
        if (idValue.isEmpty()) {
            showAlertMessage("Ingrese el ID");
            return;
        }
        try {
            BigDecimal id = new BigDecimal(idValue);
            MmSalas room = connectionRoom.search(id);
            if (room != null) {
                tfNameRoom.setText(room.getNombreDeSala());
                cbTypeRoom.setValue(room.getTipoDeSala());
                taDescriptionRoom.setText(room.getDescripcion());
                cbIdMuseumRoom.setValue(room.getIdMuseo());
                currentRoom = room;
            } else {
                showAlertMessage("No se encontró la Sala.");
                connectionRoom.close();
            }
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionRoom.close();
        }
    }

    //#endregion
    
    //#region Crud Collections
    private void addCollection() {
        connectionCollection = new ManagerColletions();
        MmColecciones item = new MmColecciones();
        item.setNombreDeColeccion(tfNameCollection.getText());
        item.setDescripcion(taDescriptionCollection.getText());
        item.setSiglo(BigInteger.valueOf(spnCentury.getValue()));
        item.setIdSala(cbIdRoom.getValue());

        try {
            connectionCollection.add(item);
            showAlertMessage("La colección fue agregada correctamente");
            connectionCollection.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionCollection.close();
        }
    }

    private void updateCollection() {
        connectionCollection = new ManagerColletions();
        if (currentCollection != null) {
            currentCollection.setNombreDeColeccion(tfNameCollection.getText());
            currentCollection.setDescripcion(taDescriptionCollection.getText());
            currentCollection.setSiglo(BigInteger.valueOf(spnCentury.getValue()));
            currentCollection.setIdSala(cbIdRoom.getValue());

            try {
                connectionCollection.update(currentCollection);
                showAlertMessage("La colección fue actualizada correctamente");
                connectionCollection.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionCollection.close();
            }
        } else {
            showAlertMessage("Seleccione una colección");
            connectionCollection.close();
        }
    }

    private void deleteCollection() {
        connectionCollection = new ManagerColletions();
        if (currentCollection == null) {
            currentCollection = tbvCollections.getSelectionModel().getSelectedItem();
        }
        if (currentCollection != null) {
            try {
                connectionCollection.delete(currentCollection.getId());
                showAlertMessage("La colección fue eliminada correctamente");
                connectionCollection.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionCollection.close();
            }
        } else {
            showAlertMessage("Seleccione una colección");
            connectionCollection.close();
        }
    }

    private void searchCollection() {
        connectionCollection = new ManagerColletions();
        String idValue = tfSearchCollection.getText().trim();
        if (idValue.isEmpty()) {
            showAlertMessage("Ingrese el ID");
            return;
        }
        try {
            BigDecimal id = new BigDecimal(idValue);
            MmColecciones collection = connectionCollection.search(id);
            if (collection != null) {
                tfNameCollection.setText(collection.getNombreDeColeccion());
                taDescriptionCollection.setText(collection.getDescripcion());
                spnCentury.getValueFactory().setValue(collection.getSiglo().intValueExact());
                cbIdRoom.setValue(collection.getIdSala());
                currentCollection = collection;
            } else {
                showAlertMessage("No se encontró la colección.");
                connectionCollection.close();
            }
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionCollection.close();
        }
    }
//#endregion

    //#region Crud Species
    private void addSpecie() {
        connectionSpecies = new ManageSpecies();
        MmEspecies item = new MmEspecies();
        item.setNombreComun(tfNameCommon.getText());
        item.setNombreCientifico(tfNameScientist.getText());
        item.setEpoca(tfEpoch.getText());
        LocalDate dateValue = dtpExpirationDate.getValue();
        Date date = Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
        item.setFechaDeExtincion(date);
        item.setPeso(BigInteger.valueOf(spnWeigthSpecie.getValue()));
        item.setTamaño(BigInteger.valueOf(spnSizeSpecie.getValue()));
        item.setCaracteristicas(taCharacteristicSpecie.getText());
        item.setIdColeccion(cbIdCollectionsSpecies.getValue());

        try {
            connectionSpecies.add(item);
            showAlertMessage("La especie fue agregada correctamente");
            connectionSpecies.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionSpecies.close();
        }
    }

    private void updateSpecie() {
        connectionSpecies = new ManageSpecies();
        if (currentSpecie != null) {
            currentSpecie.setNombreComun(tfNameCommon.getText());
            currentSpecie.setNombreCientifico(tfNameScientist.getText());
            currentSpecie.setEpoca(tfEpoch.getText());
            currentSpecie.setPeso(BigInteger.valueOf(spnWeigthSpecie.getValue()));
            currentSpecie.setTamaño(BigInteger.valueOf(spnSizeSpecie.getValue()));
            LocalDate dateValue = dtpExpirationDate.getValue();
            Date date = Date.from(dateValue.atStartOfDay(ZoneId.systemDefault()).toInstant());
            currentSpecie.setFechaDeExtincion(date);
            currentSpecie.setCaracteristicas(taCharacteristicSpecie.getText());
            currentSpecie.setIdColeccion(cbIdCollectionsSpecies.getValue());

            try {
                connectionSpecies.update(currentSpecie);
                showAlertMessage("La especie fue actualizada correctamente");
                connectionSpecies.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionSpecies.close();
            }
        } else {
            showAlertMessage("Seleccione una especie");
            connectionSpecies.close();
        }
    }

    private void deleteSpecie() {
        connectionSpecies = new ManageSpecies();
        if (currentSpecie == null) {
            currentSpecie = tbvSpecies.getSelectionModel().getSelectedItem();
        }
        if (currentSpecie != null) {
            try {
                connectionSpecies.delete(currentSpecie.getId());
                showAlertMessage("La especie fue eliminada correctamente");
                connectionSpecies.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionSpecies.close();
            }
        } else {
            showAlertMessage("Seleccione una especie");
            connectionSpecies.close();
        }
    }

    private void searchSpecie() {
        connectionSpecies = new ManageSpecies();
        String idValue = tfSearchSpecie.getText().trim();
        if (idValue.isEmpty()) {
            showAlertMessage("Ingrese el ID");
            return;
        }
        try {
            BigDecimal id = new BigDecimal(idValue);
            MmEspecies especie = connectionSpecies.search(id);
            if (especie != null) {
                tfNameCommon.setText(especie.getNombreComun());
                tfNameScientist.setText(especie.getNombreCientifico());
                tfEpoch.setText(especie.getEpoca());
                Date date = especie.getFechaDeExtincion();
                LocalDate dateValue = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                dtpExpirationDate.setValue(dateValue);
                spnWeigthSpecie.getValueFactory().setValue(especie.getPeso().intValueExact());
                spnSizeSpecie.getValueFactory().setValue(especie.getTamaño().intValueExact());
                taCharacteristicSpecie.setText(especie.getCaracteristicas());
                cbIdCollectionsSpecies.setValue(especie.getIdColeccion());
                currentSpecie = especie;
            } else {
                showAlertMessage("No se encontró la especie.");
                connectionSpecies.close();
            }
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionSpecies.close();
        }
    }

//#endregion
    
    //#region Crud Themes
    private void addTheme() {
        connectionThemes = new ManageThemes();
        MmTematica item = new MmTematica();
        item.setNombreDeLaTematica(tfNameTheme.getText());
        item.setEpoca(tfEpochTheme.getText());
        item.setCaracteristicas(taCharacteristicTheme.getText());
        item.setIdSala(cbIdRoomTheme.getValue());

        try {
            connectionThemes.add(item);
            showAlertMessage("La temática fue agregada correctamente");
            connectionThemes.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionThemes.close();
        }
    }

    private void updateTheme() {
        connectionThemes = new ManageThemes();
        if (currentTheme != null) {
            currentTheme.setNombreDeLaTematica(tfNameTheme.getText());
            currentTheme.setEpoca(tfEpochTheme.getText());
            currentTheme.setCaracteristicas(taCharacteristicTheme.getText());
            currentTheme.setIdSala(cbIdRoomTheme.getValue());

            try {
                connectionThemes.update(currentTheme);
                showAlertMessage("La temática fue actualizada correctamente");
                connectionThemes.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionThemes.close();
            }
        } else {
            showAlertMessage("Seleccione una temática");
            connectionThemes.close();
        }
    }

    private void deleteTheme() {
        connectionThemes = new ManageThemes();
        if (currentTheme == null) {
            currentTheme = tbvThemes.getSelectionModel().getSelectedItem();
        }
        if (currentTheme != null) {
            try {
                connectionThemes.delete(currentTheme.getId());
                showAlertMessage("La temática fue eliminada correctamente");
                connectionThemes.close();
                clearSpaces();
                setTablesInformation();
            } catch (Exception e) {
                showAlertMessage("Error: " + e.getMessage());
                connectionThemes.close();
            }
        } else {
            showAlertMessage("Seleccione una temática");
            connectionThemes.close();
        }
    }

    private void searchTheme() {
        connectionThemes = new ManageThemes();
        String idValue = tfSearchTheme.getText().trim();
        if (idValue.isEmpty()) {
            showAlertMessage("Ingrese el ID");
            return;
        }
        try {
            BigDecimal id = new BigDecimal(idValue);
            MmTematica theme = connectionThemes.search(id);
            if (theme != null) {
                tfNameTheme.setText(theme.getNombreDeLaTematica());
                tfEpochTheme.setText(theme.getEpoca());
                taCharacteristicTheme.setText(theme.getCaracteristicas());
                cbIdRoomTheme.setValue(theme.getIdSala());
                currentTheme = theme;
            } else {
                showAlertMessage("No se encontró la temática.");
            }
            connectionThemes.close();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionThemes.close();
        }
    }

//#endregion
    
    //#region Crud Prices

private void addPrice() {
    connectionTicketPrice = new ManagerTicketPrice();
    MmPrecioDeEntradas item = new MmPrecioDeEntradas();

    try {
        item.setCostoLunVier(BigInteger.valueOf(Integer.parseInt(tfCostMondayFridayPrice.getText())));
        item.setCostoSabDom(BigInteger.valueOf(Integer.parseInt(tfCostSaturdaySundayPrice.getText())));
        item.setIdMuseo(cbIdMuseumPrice.getValue());

        connectionTicketPrice.add(item);
        showAlertMessage("Precio agregado correctamente");
        connectionTicketPrice.close();
        clearSpaces();
        setTablesInformation();
    } catch (Exception e) {
        showAlertMessage("Error: " + e.getMessage());
        connectionTicketPrice.close();
    }
}

private void updatePrice() {
    connectionTicketPrice = new ManagerTicketPrice();
    if (currentPrice != null) {
        try {
            currentPrice.setCostoLunVier(BigInteger.valueOf(Integer.parseInt(tfCostMondayFridayPrice.getText())));
            currentPrice.setCostoSabDom(BigInteger.valueOf(Integer.parseInt(tfCostSaturdaySundayPrice.getText())));
            currentPrice.setIdMuseo(cbIdMuseumPrice.getValue());

            connectionTicketPrice.update(currentPrice);
            showAlertMessage("Precio actualizado correctamente");
            connectionTicketPrice.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionTicketPrice.close();
        }
    } else {
        showAlertMessage("Seleccione un precio");
        connectionTicketPrice.close();
    }
}

private void deletePrice() {
    connectionTicketPrice = new ManagerTicketPrice();
    if (currentPrice == null) {
        currentPrice = tbvPrices.getSelectionModel().getSelectedItem();
    }

    if (currentPrice != null) {
        try {
            connectionTicketPrice.delete(currentPrice.getId());
            showAlertMessage("Precio eliminado correctamente");
            connectionTicketPrice.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionTicketPrice.close();
        }
    } else {
        showAlertMessage("Seleccione un precio");
        connectionTicketPrice.close();
    }
}

private void searchPrice() {
    connectionTicketPrice = new ManagerTicketPrice();
    String idValue = tfSearchPrice.getText().trim();

    if (idValue.isEmpty()) {
        showAlertMessage("Ingrese el ID");
        return;
    }

    try {
        BigDecimal id = new BigDecimal(idValue);
        MmPrecioDeEntradas price = connectionTicketPrice.search(id);
        if (price != null) {
            tfCostMondayFridayPrice.setText(String.valueOf(price.getCostoLunVier()));
            tfCostSaturdaySundayPrice.setText(String.valueOf(price.getCostoSabDom()));
            cbIdMuseumPrice.setValue(price.getIdMuseo());
            currentPrice = price;
        } else {
            showAlertMessage("No se encontró el precio.");
        }
        connectionTicketPrice.close();
    } catch (Exception e) {
        showAlertMessage("Error: " + e.getMessage());
        connectionTicketPrice.close();
    }
}

//#endregion

    //#region Crud Commissions

private void addCommission() {
    connectionCardAndCommission = new ManageCardAndCommissions();
    MmTarjetaYComisiones item = new MmTarjetaYComisiones();

    try {
        item.setTipoDeTarjeta(cbTypeCard.getValue());
        item.setComision(BigInteger.valueOf(Integer.parseInt(tfCommission.getText())));
        item.setIdMuseo(cbIdMuseumCommission.getValue());

        connectionCardAndCommission.add(item);
        showAlertMessage("Comisión agregada correctamente");
        connectionCardAndCommission.close();
        clearSpaces();
        setTablesInformation();
    } catch (Exception e) {
        showAlertMessage("Error: " + e.getMessage());
        connectionCardAndCommission.close();
    }
}

private void updateCommission() {
    connectionCardAndCommission = new ManageCardAndCommissions();
    if (currentCommission != null) {
        try {
            currentCommission.setTipoDeTarjeta(cbTypeCard.getValue());
            currentCommission.setComision(BigInteger.valueOf(Integer.parseInt(tfCommission.getText())));
            currentCommission.setIdMuseo(cbIdMuseumCommission.getValue());

            connectionCardAndCommission.update(currentCommission);
            showAlertMessage("Comisión actualizada correctamente");
            connectionCardAndCommission.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionCardAndCommission.close();
        }
    } else {
        showAlertMessage("Seleccione una comisión");
        connectionCardAndCommission.close();
    }
}

private void deleteCommission() {
    connectionCardAndCommission = new ManageCardAndCommissions();
    if (currentCommission == null) {
        currentCommission = tbvCommissions.getSelectionModel().getSelectedItem();
    }

    if (currentCommission != null) {
        try {
            connectionCardAndCommission.delete(currentCommission.getId());
            showAlertMessage("Comisión eliminada correctamente");
            connectionCardAndCommission.close();
            clearSpaces();
            setTablesInformation();
        } catch (Exception e) {
            showAlertMessage("Error: " + e.getMessage());
            connectionCardAndCommission.close();
        }
    } else {
        showAlertMessage("Seleccione una comisión");
        connectionCardAndCommission.close();
    }
}

private void searchCommission() {
    connectionCardAndCommission = new ManageCardAndCommissions();
    String idValue = tfSearchCommission.getText().trim();

    if (idValue.isEmpty()) {
        showAlertMessage("Ingrese el ID");
        return;
    }

    try {
        BigDecimal id = new BigDecimal(idValue);
        MmTarjetaYComisiones commission = connectionCardAndCommission.search(id);
        if (commission != null) {
            cbTypeCard.setValue(commission.getTipoDeTarjeta());
            tfCommission.setText(String.valueOf(commission.getComision()));
            cbIdMuseumCommission.setValue(commission.getIdMuseo());
            currentCommission = commission;
        } else {
            showAlertMessage("No se encontró la comisión.");
        }
        connectionCardAndCommission.close();
    } catch (Exception e) {
        showAlertMessage("Error: " + e.getMessage());
        connectionCardAndCommission.close();
    }
}

//#endregion




//#endregion

    //#region Funciones Generales
    private void showWindow(AnchorPane selected, String name) {
        lbMainTitle.setText(name);
        lbMiniTitle.setText(name);
        for (AnchorPane i : windows) {
            i.setVisible(false);
            if (selected == i) {
                i.setVisible(true);
                i.toFront();
            }
        }
    }

    private void exitProgram() {
        Platform.exit();
    }

    private void setTablesInformation() {
        //Starts Variables of DB
        connectionCardAndCommission = new ManageCardAndCommissions();
        connectionCollection = new ManagerColletions();
        connectionMuseum = new ManageMuseos();
        connectionRatingBoard = new ManageRatingBoard();
        connectionRoom = new ManageRooms();
        connectionSalesAndRooms = new ManageSalesAndRooms();
        connectionSellTickets = new ManageSellTickets();
        connectionSpecies = new ManageSpecies();
        connectionThemes = new ManageThemes();
        connectionTicketPrice = new ManagerTicketPrice();
        //settear cellValueFactory new propertyValueFactoryk(Nombre de la variable de la clase)
        //Museums
        clmIdMuseum.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmNameMuseum.setCellValueFactory(new PropertyValueFactory<>("nombreDelMuseo"));
        clmTypeMuseum.setCellValueFactory(new PropertyValueFactory<>("tipoDeMuseo"));
        clmLocateMuseum.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        clmURLMuseum.setCellValueFactory(new PropertyValueFactory<>("urlDelSitioWeb"));
        clmFundationMuseum.setCellValueFactory(new PropertyValueFactory<>("fechaDeFundacion"));
        List<MmMuseos> tableMuseums = connectionMuseum.read();
        tbvMuseum.setItems(FXCollections.observableArrayList(tableMuseums));

        //Rooms
        clmIdRoom.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmIdMuseumRoom.setCellValueFactory(new PropertyValueFactory<>("idMuseo"));
        clmNameRoom.setCellValueFactory(new PropertyValueFactory<>("nombreDeSala"));
        clmTypeRoom.setCellValueFactory(new PropertyValueFactory<>("tipoDeSala"));
        clmDescriptionRoom.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        List<MmSalas> tableRooms = connectionRoom.read();
        tbvRooms.setItems(FXCollections.observableArrayList(tableRooms));

        //Collections
        clmIdCollection.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmIdRoomCollection.setCellValueFactory(new PropertyValueFactory<>("idSala"));
        clmNameCollection.setCellValueFactory(new PropertyValueFactory<>("nombreDeColeccion"));
        clmCenturyCollection.setCellValueFactory(new PropertyValueFactory<>("siglo"));
        clmDescriptionCollection.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        List<MmColecciones> tableCollections = connectionCollection.read();
        tbvCollections.setItems(FXCollections.observableArrayList(tableCollections));

        //Species
        clmIdSpecie.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmIdCollectionSpecie.setCellValueFactory(new PropertyValueFactory<>("idColeccion"));
        clmNameScientistSpecie.setCellValueFactory(new PropertyValueFactory<>("nombreCientifico"));
        clmNameCommonSpecie.setCellValueFactory(new PropertyValueFactory<>("nombreComun"));
        clmExpirationDateSpecie.setCellValueFactory(new PropertyValueFactory<>("fechaDeExtincion"));
        clmEpochSpecie.setCellValueFactory(new PropertyValueFactory<>("epoca"));
        clmWeightSpecie.setCellValueFactory(new PropertyValueFactory<>("peso"));
        clmSizeSpecie.setCellValueFactory(new PropertyValueFactory<>("tamaño"));
        clmcharacteristicSpecie.setCellValueFactory(new PropertyValueFactory<>("caracteristicas"));
        List<MmEspecies> tableSpecies = connectionSpecies.read();
        tbvSpecies.setItems(FXCollections.observableArrayList(tableSpecies));

        //Themes
        clmIdTheme.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmIdRoomTheme.setCellValueFactory(new PropertyValueFactory<>("idSala"));
        clmNameTheme.setCellValueFactory(new PropertyValueFactory<>("nombreDeLaTematica"));
        clmEpochTheme.setCellValueFactory(new PropertyValueFactory<>("epoca"));
        clmCharacteristicTheme.setCellValueFactory(new PropertyValueFactory<>("caracteristicas"));
        List<MmTematica> tableThemes = connectionThemes.read();
        tbvThemes.setItems(FXCollections.observableArrayList(tableThemes));

        //Prices
        clmIdPrice.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmIdMuseumPrice.setCellValueFactory(new PropertyValueFactory<>("idMuseol"));
        clmCostMondayFridayPrice.setCellValueFactory(new PropertyValueFactory<>("costoLunVier"));
        clmCostSaturdaySundayPrice.setCellValueFactory(new PropertyValueFactory<>("costoSabDom"));
        List<MmPrecioDeEntradas> tablePrices = connectionTicketPrice.read();
        tbvPrices.setItems(FXCollections.observableArrayList(tablePrices));

        //Commissions
        clmIdMuseumCommission.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmTypeCardCommission.setCellValueFactory(new PropertyValueFactory<>("tipoDeTarjeta"));
        clmCommission.setCellValueFactory(new PropertyValueFactory<>("comision"));
        clmIdMuseumCommission.setCellValueFactory(new PropertyValueFactory<>("idMuseo"));
        List<MmTarjetaYComisiones> tableCommissions = connectionCardAndCommission.read();
        tbvCommissions.setItems(FXCollections.observableArrayList(tableCommissions));

        //Comboxes
        cbIdCollectionsSpecies.setItems(FXCollections.observableArrayList(tableCollections));
        cbIdMuseumCommission.setItems(FXCollections.observableArrayList(tableMuseums));
        cbIdMuseumPrice.setItems(FXCollections.observableArrayList(tableMuseums));
        cbIdMuseumRoom.setItems(FXCollections.observableArrayList(tableMuseums));
        cbIdRoomTheme.setItems(FXCollections.observableArrayList(tableRooms));
        cbIdRoom.setItems(FXCollections.observableArrayList(tableRooms));
        cbIdMuseumCommission.setItems(FXCollections.observableArrayList(tableMuseums));
        cbMuseumsSellTicket.setItems(FXCollections.observableArrayList(tableMuseums));
        cbTypeCard.setItems(FXCollections.observableArrayList(TYPE_CREDIC_CARD));
        cbTypeCredicCardSellTicket.setItems(FXCollections.observableArrayList(TYPE_CREDIC_CARD));
        cbTypeMuseum.setItems(FXCollections.observableArrayList(TYPE_MUSEUMS));
        cbTypeRoom.setItems(FXCollections.observableArrayList(TYPE_ROOMS));

        //Close Variables of DB
        connectionCardAndCommission.close();
        connectionCollection.close();
        connectionMuseum.close();
        connectionRatingBoard.close();
        connectionRoom.close();
        connectionSalesAndRooms.close();
        connectionSellTickets.close();
        connectionSpecies.close();
        connectionThemes.close();
        connectionTicketPrice.close();
    }

    private void showAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    private void setSpinners() {
        spnCentury.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0, 1));
        spnWeigthSpecie.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0, 1));
        spnSizeSpecie.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000000, 0, 1));
        spnStartsRateRoom.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0, 1));
    }

    private void clearSpaces() {
        // TextFields
        tfMuseumName.clear();
        tfLocation.clear();
        tfURLWeb.clear();
        tfSearchMuseum.clear();
        tfNameCollection.clear();
        tfSearchCollection.clear();
        tfNameScientist.clear();
        tfNameCommon.clear();
        tfEpoch.clear();
        tfSearchSpecie.clear();
        tfNameTheme.clear();
        tfEpochTheme.clear();
        tfSearchTheme.clear();
        tfCostMondayFridayPrice.clear();
        tfCostSaturdaySundayPrice.clear();
        tfSearchPrice.clear();
        tfCommission.clear();
        tfSearchCommission.clear();
        tfNameVisitorSellTicket.clear();
        lbSubTotalSellTicket.clear();
        lbCommissionSellTicket.clear();
        lbTotalPaySellTicket.clear();
        tfNameRoomRateRoom.clear();
        tfSearchRoom.clear();
        tfNameRoom.clear();

        // TextAreas
        taDescriptionCollection.clear();
        taCharacteristicSpecie.clear();
        taCharacteristicTheme.clear();
        taDescriptionRoom.clear();
        taRateRoom.clear();

        // ComboBoxes
        cbTypeMuseum.setValue(null);
        cbIdRoom.setValue(null);
        cbIdCollectionsSpecies.setValue(null);
        cbIdRoomTheme.setValue(null);
        cbIdMuseumPrice.setValue(null);
        cbTypeCard.setValue(null);
        cbIdMuseumCommission.setValue(null);
        cbTypeCredicCardSellTicket.setValue(null);
        cbMuseumsSellTicket.setValue(null);
        cbRoomsSellTicket.setValue(null);
        cbTypeRoom.setValue(null);
        cbIdMuseumRoom.setValue(null);
        cbGenerateReport.setValue(null);

        // DatePickers
        dpDateMuseum.setValue(null);
        dtpExpirationDate.setValue(null);
        dpDateSellTicket.setValue(null);

        // Spinners
        spnCentury.getValueFactory().setValue(0);
        spnWeigthSpecie.getValueFactory().setValue(0);
        spnSizeSpecie.getValueFactory().setValue(0);
        spnStartsRateRoom.getValueFactory().setValue(0);
    }

    //#endregion
}
