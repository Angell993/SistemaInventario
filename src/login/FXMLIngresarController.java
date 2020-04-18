package Login;

import java.io.IOException;
import java.net.URL;
import conexionbasedatos.MetodosDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static metodosjavaClass.VentanaRootPane.closeVentana;
import sistemaInventarioControladorVistas.FXMLSistemaInventarioController;

public class FXMLIngresarController implements Initializable {

    @FXML
    private Label error;
    @FXML
    private TextField usuario;
    @FXML
    private TextField password;
    @FXML
    private Button entrar;

    @FXML
    private void ingresarSistema(ActionEvent event) {
        if (usuario.getText().isEmpty() && password.getText().isEmpty()) {
            error.setText("Contraseña o Usuario incorrecto!");
            usuario.getStyleClass().add("error-ingresar");
            password.getStyleClass().add("error-ingresar");
        } else if (usuario.getText().isEmpty()) {
            error.setText("Usuario incorrecto!");
            usuario.getStyleClass().add("error-ingresar");
        } else if (password.getText().isEmpty()) {
            error.setText("Contraseña incorrecto!");
            password.getStyleClass().add("error-ingresar");
        } else {
            //sistemaInventario(event);

            recuperarUser(event);
        }

    }

    @FXML
    private void salirSistema(ActionEvent event) {
        //Con esto cerramos la ventana.
        closeVentana(event);
    }

    private void recuperarUser(ActionEvent event) {
        try {
            try {
                System.out.println("Ingresando al sistema");
                String sql = "select * from login";
                MetodosDB consulta = new MetodosDB();
                ResultSet datos = consulta.consultarTablas(sql);
                int user = Integer.parseInt(usuario.getText());

                while (datos.next()) {
                    int id = datos.getInt("id_Empleado");
                    String pass = datos.getString("password");
                    if (id == user && password.getText().equals(pass)) {
                        sistemaInventario(event);
                    } else {
                        error.setText("Contraseña o Usuario incorrecto!");
                        usuario.getStyleClass().add("error-ingresar");
                        password.getStyleClass().add("error-ingresar");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLIngresarController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException e) {
            error.setText("Contraseña o Usuario incorrecto!");
        }
    }

    private void sistemaInventario(ActionEvent event) {
        try {

            System.out.println("[********** Bienvenido al Sistema **********]");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sistemaInventarioControladorVistas/FXMLSistemaInventario.fxml"));
            Parent root = loader.load();
            //Hacemos una instancia del controlador del Sistema de Inventario o el controlador que deseamos enviar el parametro.
            FXMLSistemaInventarioController system = loader.getController();
            system.recibirIdentificador(Integer.parseInt(usuario.getText()));

            Stage stage = new Stage();
            Scene scene_page = new Scene(root);
            stage.setTitle("INVENTARIO");
            stage.getIcons().add(new Image(getClass().getResource("/imagenes/iconoInventario.png").toExternalForm()));
            Stage mystage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene_page);
            stage.show();
            // mystage cierra el metodoshibernate
            mystage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLIngresarController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
