package barcode;

import com.onbarcode.barcode.Code128;
import com.onbarcode.barcode.IBarcode;
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ly Tan loi
 */
public class BarcodeCreating {

    public static String codeCreate(String code) throws Exception {
        Code128 barcode = new Code128();

        /*
	   Code 128 Valid data char set:
	        all 128 ASCII characters (Char from 0 to 127)
         */
        barcode.setData(code);

        barcode.setProcessTilde(false);

        // Code 128 Unit of Measure, pixel, cm, or inch
        barcode.setUom(IBarcode.UOM_PIXEL);
        // Code 128 barcode bar module width (X) in pixel
        barcode.setX(3f);
        // Code 128 barcode bar module height (Y) in pixel
        barcode.setY(75f);

        // barcode image margins
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);

        // barcode image resolution in dpi
        barcode.setResolution(72);

        // disply barcode encoding data below the barcode
        barcode.setShowText(true);
        // barcode encoding data font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        // space between barcode and barcode encoding data
        barcode.setTextMargin(6);

        //  barcode displaying angle
        barcode.setRotate(IBarcode.ROTATE_0);
        String url = "D:\\"+code+".gif";
        barcode.drawBarcode(url);
        return url;
    }
}
