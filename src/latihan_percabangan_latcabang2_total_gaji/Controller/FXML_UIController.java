/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihan_percabangan_latcabang2_total_gaji.Controller;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import latihan_percabangan_latcabang2_total_gaji.Models.latihan_cabang2_total_gaji;

/**
 *
 * @author mariq
 */
public class FXML_UIController implements Initializable {

    //Models
    latihan_cabang2_total_gaji mdl = new latihan_cabang2_total_gaji();

    // //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    @FXML
    private TextField txtlama;
    @FXML
    private TextField txttotal;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private ComboBox<String> cmbdepartemen;
    @FXML
    private ComboBox<String> chbjabatan;
    @FXML
    private ListView<String> lstgolongan;
    @FXML
    private ListView<String> lstdomisili;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Departemen
        cmbdepartemen.setItems(
                FXCollections.observableArrayList(
                        "Designer",
                        "Teknisi",
                        "Data Analis",
                        "Keamanan Cyber"
                )
        );

        //Jabatan
        chbjabatan.setItems(
                FXCollections.observableArrayList(
                        "Staff",
                        "Supervisisor",
                        "Manager",
                        "Direktur"
                )
        );

        //Golongan
        lstgolongan.setItems(
                FXCollections.observableArrayList(
                        "III-A",
                        "III-B",
                        "IV-A"
                )
        );

        //Domisili
        lstdomisili.setItems(
                FXCollections.observableArrayList(
                        "Jakarta",
                        "Aceh",
                        "Bandung",
                        "Makasar",
                        "Denpasar"
                )
        );
    }

    @FXML
    private void hitungklik(ActionEvent event) {
        mdl.setLama_Kerja(
                Integer.parseInt(
                        txtlama.getText()
                )
        );
        mdl.setDepartement(
                cmbdepartemen.getSelectionModel()
                        .selectedIndexProperty()
                        .intValue()
        );
        mdl.setJabatan(
                chbjabatan.getSelectionModel()
                        .selectedIndexProperty().intValue()
        );
        mdl.setGolongan(
                lstgolongan.getSelectionModel()
                        .selectedIndexProperty()
                        .intValue());
        mdl.setDomisili(lstdomisili.getSelectionModel()
                .selectedIndexProperty()
                .intValue());

        int Upah;
        switch (mdl.getDepartement()) {
            case 0: {
                Upah = 4500000;
                break;
            }
            case 1: {
                Upah = 3500000;
                break;
            }
            case 2: {
                Upah = 5750000;
                break;
            }
            case 3: {
                Upah = 6750000;
                break;
            }
            default: {
                Upah = 0;
            }
        }

        int UpahPokok;
        switch (mdl.getJabatan()) {
            case 0: {
                UpahPokok = 2000000;
                break;
            }
            case 1: {
                UpahPokok = 300000;
                break;
            }
            case 2: {
                UpahPokok = 8000000;
                break;
            }
            case 3: {
                UpahPokok = 10000000;
                break;
            }
            default: {
                UpahPokok = 0;
            }
        }

        int tunjangan;

        switch (mdl.getGolongan()) {
            case 0: {
                tunjangan = 5000000;
                break;
            }
            case 1: {
                tunjangan = 100000;
                break;

            }
            case 2: {
                tunjangan = 2000000;
                break;
            }

            default: {
                tunjangan = 0;
            }
        }

        int bonus;
        switch (mdl.getDomisili()) {
            case 0: {
                bonus = 200000;
                break;
            }
            default: {
                bonus = 0;
            }
        }
        int totals = (Upah + UpahPokok + tunjangan + bonus) * mdl.getLama_Kerja();
        double total_salary = totals;
        txttotal.setText(formater.format(total_salary));

    }

    @FXML
    private void hapusklik(ActionEvent event) {
        cmbdepartemen.setValue("");
        chbjabatan.valueProperty().set(null);
        lstgolongan.getSelectionModel().clearSelection();
        lstdomisili.getSelectionModel().clearSelection();
        txtlama.setText("");
        txttotal.setText("");
        txtlama.requestFocus();

    }

    @FXML
    private void keluarklik(ActionEvent event) {
        System.exit(0);
    }

}
