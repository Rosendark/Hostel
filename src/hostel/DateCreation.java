package hostel;

import java.util.Calendar;
import java.util.Date;

public class DateCreation {
    public static Date createDate(int jour, int mois, int annee) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, jour);
        //Ah oui, c'est vrai, les mois vont de 0 à 11
        calendar.set(Calendar.MONTH, mois - 1);
        calendar.set(Calendar.YEAR, annee);
        return calendar.getTime();
    }
}
