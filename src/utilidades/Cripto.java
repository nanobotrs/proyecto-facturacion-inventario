package utilidades;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cripto {

    private final String ALGORITMO = "AES/ECB/PKCS5Padding";
    private final String CLAVE_SECRETA = "clave secreta";
    private final byte[] CLAVE_SECRETA_BYTES = Arrays.copyOf(CLAVE_SECRETA.getBytes(StandardCharsets.UTF_8), 16);
    private final Key CLAVE = new SecretKeySpec(CLAVE_SECRETA_BYTES, "AES");

    public String encriptar(String texto) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, CLAVE);
        byte[] textoEncriptado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    public String desencriptar(String textoEncriptado) throws Exception {
        byte[] textoEncriptadoBytes = Base64.getDecoder().decode(textoEncriptado);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, CLAVE);
        byte[] textoDesencriptadoBytes = cipher.doFinal(textoEncriptadoBytes);
        return new String(textoDesencriptadoBytes, StandardCharsets.UTF_8);
    }
    
}
