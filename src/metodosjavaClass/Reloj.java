package metodosjavaClass;

import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;

public class Reloj  {

    //private Label mostrarHora;

    /*public Reloj(Label mostrarHora) {
        this.mostrarHora = mostrarHora;
    }*/

    /*public void ejecutarReloj(Label mostrarHora) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Date dat = new Date();
                        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                        System.out.println(formatoHora.format(dat));
                        mostrarHora.setText(formatoHora.format(dat));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            });
    }*/
    //@Override
    public void ejecutarReloj(Label mostrarHora) {
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Platform.runLater(() -> {
                    while (true) {
                        Date dat = new Date();
                        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                        System.out.println(formatoHora.format(dat));
                        mostrarHora.setText(formatoHora.format(dat));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                });
                return null;
            }

        };
        new Thread(task).start();
    }

}
