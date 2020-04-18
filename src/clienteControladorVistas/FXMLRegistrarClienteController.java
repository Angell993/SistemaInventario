package clienteControladorVistas;

import conexionbasedatos.MetodosDB;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import provinciasCiudades.Municipios;
import provinciasCiudades.Provincias;

public class FXMLRegistrarClienteController implements Initializable {

    @FXML
    private TextField identificador, dni_nie, nombre, apellidos;
    @FXML
    private TextField telefono, codpostal, pais, direccion, email, numeroEmpleado;
    @FXML
    private ComboBox<Provincias> comboProvincia;
    @FXML
    private ComboBox<Municipios> comboCiudad;

    private final MetodosDB consultasdb = new MetodosDB();
    private ObservableList<Provincias> listaProvincias;
    private ObservableList<Municipios> listaCiudades;

    private void comboProvincia() {
        try {
            listaProvincias = FXCollections.observableArrayList();
            String sql = "select * from provincias";
            ResultSet datos = consultasdb.consultarTablaEspania(sql);
            while (datos.next()) {
                listaProvincias.add(new Provincias(datos.getInt("Id_provincia"), datos.getString("provincia")));
            }
            System.out.println(Arrays.toString(listaProvincias.toArray()));
            comboProvincia.setItems(listaProvincias);
            System.out.println("Se termino de cargar el comboBox 1");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(FXMLRegistrarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void seleccionarID(ActionEvent event) {
        int id = comboProvincia.getSelectionModel().getSelectedItem().getIdProvincia();
        comboCiudades(id);
    }

    private void comboCiudades(int codg) {
        try {
            listaCiudades = FXCollections.observableArrayList();
            String sql = "select * from municipios where provincia = " + codg;
            ResultSet datos = consultasdb.consultarTablaEspania(sql);
            while (datos.next()) {
                listaCiudades.add(new Municipios(datos.getInt("Id_municipios"), datos.getInt("provincia"), datos.getString("municipio")));
            }
            System.out.println(Arrays.toString(listaCiudades.toArray()));
            comboCiudad.setItems(listaCiudades);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRegistrarClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboProvincia();

    }

}
