package bcorona_ftoloza.backendMySql_levelUpGamer.util;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//generador de id String 24 length + fecha hoy(PRACTICA LA IDEA DEL PROFESOR EN ID STRING)
public class Util {
    private static final String CARACTERES="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM=new SecureRandom();

    public String generarID(){
        StringBuilder sb=new StringBuilder(24);

        for(int x=0; x<24; x++){
            int index = RANDOM.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(index));
        }

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return sb.toString() + fecha;
    }
}
