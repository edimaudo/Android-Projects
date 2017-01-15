package Utils;

import java.text.DecimalFormat;

/**
 * Created by edima on 2016-07-05.
 */
public class utils {

    public static String formatNumber(int value){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);
        return formatted;
    }
}
