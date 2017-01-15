package util;

import java.text.DecimalFormat;

/**
 * Created by paulodichone on 2/28/15.
 */
public class Utils {


    public static String formatNumber( int value) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;
    }
}
