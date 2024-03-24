package utilidades;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.swing.*;
import java.io.ByteArrayOutputStream;

public class Qr {

    public void generarQr_pro(String cod_producto, String nombre, String cod_provee) {
        String textoCombinado = " CODIGO: " + cod_producto + " || NOMBRE: " + nombre + " || PROOVEEDOR: " + cod_provee;
        ByteArrayOutputStream out = QRCode.from(textoCombinado).to(ImageType.PNG).stream();
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        JOptionPane.showMessageDialog(null, imageIcon, "Código QR", JOptionPane.PLAIN_MESSAGE);
    }

    public void generarQr_fac(String id, String cliente, String ci, String total) {
        String textoCombinado = "ID: "+id+" || CLIENTE: " + cliente + " || CI: " + ci + " || TOTAL: " + total;
        ByteArrayOutputStream out = QRCode.from(textoCombinado).to(ImageType.PNG).stream();
        ImageIcon imageIcon = new ImageIcon(out.toByteArray());
        JOptionPane.showMessageDialog(null, imageIcon, "Código QR", JOptionPane.PLAIN_MESSAGE);
    }
}
