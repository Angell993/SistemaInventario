package metodosjavaClass;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {

    public String fecha() {
        Calendar c = new GregorianCalendar();
        String pantalla;
        String dia, mes, annio;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        annio = Integer.toString(c.get(Calendar.YEAR));

        if (Integer.parseInt(dia) <= 9) {
            dia = (0 + dia);
        }
        if (Integer.parseInt(mes) <= 9) {
            mes = (0 + mes);
        }

        return pantalla = (dia + "/" + mes + "/" + annio);
    }

}
