package metodosjavaClass;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemaInventarioControladorVistas.FXMLSistemaInventarioController;

public class VentanaRootPane {
    
    @FXML private AnchorPane root;
    
    public  void mostarVentana(String url, AnchorPane rootPane){
       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            root = loader.load();
            rootPane.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLSistemaInventarioController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public static void closeVentana(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
