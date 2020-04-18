package sistemaInventarioControladorVistas;

import calculadoraControladorVista.FXMLCalculadoraController;
import conexionbasedatos.MetodosDB;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import metodosjavaClass.Fecha;
import metodosjavaClass.Reloj;
import metodosjavaClass.VentanaRootPane;

public class FXMLSistemaInventarioController extends Thread implements Initializable {

    //Label mostrar el nombre del empleado en el label
    @FXML
    private Label identificador, fecha;
    @FXML
    private Label horaTieme;

    //Mostrar por pantalla en anchorPane
    @FXML
    private AnchorPane rootPane, cabezeraRootPane;
    @FXML
    private AnchorPane root;
    @FXML
    private String ruta;
    private final VentanaRootPane visualizarInterfaz = new VentanaRootPane();
    private FXMLLoader loader;

    @FXML
    private void registrarCliente(ActionEvent event) throws IOException {
        ruta = "/clienteControladorVistas/FXMLRegistrarCliente.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void modificarEliminarCliente(ActionEvent event) {
        ruta = "/clienteControladorVistas/FXMLModificarEliminarCliente.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void registrarVentas(ActionEvent event) {
        ruta = "/ventasControladorVistas/FXMLRegistrarVenta.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void registrarArticulo(ActionEvent event) {
        ruta = "/articuloControladorVistas/FXMLRegistrarArticulo.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void modificarEliminarArticulo(ActionEvent event) {
        ruta = "/articuloControladorVistas/FXMLModificarEliminarArticulo.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void registrarEmpleado(ActionEvent event) {
        ruta = "/empleadoControladoresVista/FXMLRegistrarEmpleado.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void modificarEliminarEmpleado(ActionEvent event) {
        ruta = "/empleadoControladoresVista/FXMLModificarEliminarEmpleado.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void registrarProveedor(ActionEvent event) {
        ruta = "/proveedorControladorVistas/FXMLRegistrarProveedor.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void modificarEliminarProveedor(ActionEvent event) {
        ruta = "/proveedorControladorVistas/FXMLModificarEliminarProveedor.fxml";
        visualizarInterfaz.mostarVentana(ruta, rootPane);
    }

    @FXML
    private void calculadora(ActionEvent event) {

        System.out.println("------------ Inicializando calculadora ------------");
        loader = new FXMLLoader(getClass().getResource("/calculadoraControladorVista/FXMLCalculadora.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLSistemaInventarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLCalculadoraController calculadora = loader.getController();
        Scene scene_page = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Calculadora");
        //Con el Modality.APPLICATION_MODAL nos permite que hasta que no terminemos con la ventana que se abre
        //no dejara que utilize la otra ventana. 
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        Stage mystage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene_page);
        stage.showAndWait();

    }

    public void recibirIdentificador(int user) {
        Fecha fh = new Fecha();
        try {
            String empleado = null;
            String sql = "Select nombre, apellidos from empleado where CodigoEmpleado = " + user;
            MetodosDB ingresar = new MetodosDB();
            ResultSet datos = ingresar.consultarTablas(sql);
            while (datos.next()) {
                empleado = (datos.getString("Nombre") + " " + datos.getString("Apellidos"));
            }

            //Le mostramos por pantalla el empleado, la fecha y la hora
            identificador.setText(empleado);
            fecha.setText(fh.fecha());
            //ejecutarReloj(horaTieme);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSistemaInventarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /*Reloj reloj = new Reloj();
            reloj.ejecutarReloj(horaTieme);*/
    }
    
    
    // Metodo para mostrar hora pero no muestra pero si se ejecuta el hilo pero cuando queremos hacer otro cosa en la ventada
    //no nos deja no lo se porque
    public void ejecutarReloj(Label mostrarHora) {
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> {
                    try {
                        while (true) {

                            Date dat = new Date();
                            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                            //System.out.println(formatoHora.format(dat));
                            mostrarHora.setText(formatoHora.format(dat));

                            Thread.sleep(1000);

                        }
                    } catch (InterruptedException e) {
                    }
                });
                return null;
            }

        };
        new Thread(task).start();
    }
}
