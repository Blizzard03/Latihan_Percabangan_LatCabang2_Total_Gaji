/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package latihan_percabangan_latcabang2_total_gaji.Main_Class;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mariq
 */
public class Latihan_Percabangan_LatCabang2_Total_Gaji extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/latihan_percabangan_latcabang2_total_gaji/FXML/FXML_UI.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Total Gaji");
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
