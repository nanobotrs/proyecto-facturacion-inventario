package utilidades;

import almacen.Almacen;
import dataBase.MetodosSQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import vista.FrmLogin;
import vista.FrmMenu;

public class Controles {

    public void controlarLogin(MetodosSQL mSQL, Almacen almacen, String txtUsuario, String pwdClave, FrmLogin frmLogin) {
        FrmMenu frmMenu = new FrmMenu(almacen, mSQL);
        int cont = 0;
        for (int i = 0; i < almacen.getlUsuarios().size(); i++) {
            if (!almacen.getlUsuarios().get(i).getUsuario().equals(txtUsuario) || almacen.getlUsuarios().get(i).getEstado() == 3) {
                cont++;
            }
            if (almacen.getlUsuarios().get(i).getUsuario().equals(txtUsuario)
                    && almacen.getlUsuarios().get(i).getEstado() < 3) { //"usuarios", "usuario", txtUsuario.getText()) == null
                if (almacen.getlUsuarios().get(i).getClave().equals(pwdClave)) {
                    mSQL.updateInt("usuarios", "estado", 0, "usuario", txtUsuario);
                    controlarPermisos(almacen, frmMenu, almacen.getlUsuarios().get(i));
                    frmLogin.dispose();
                    frmMenu.dispose();
                    frmMenu.setVisible(true);
                    frmMenu.setAlmacen(almacen);
                    frmMenu.setmSQL(mSQL);
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                    almacen.getlUsuarios().get(i).setEstado(almacen.getlUsuarios().get(i).getEstado() + 1);
                    mSQL.updateInt("usuarios", "estado", almacen.getlUsuarios().get(i).getEstado(), "usuario", txtUsuario);
                }
            }
        }
        if (cont == almacen.getlUsuarios().size()) {
            JOptionPane.showMessageDialog(null, "El usuario no existe o está bloqueado");
        }
    }

    public void controlarPermisos(Almacen almacen, FrmMenu m, Usuarios u) {
        if (u.getProductos() == 1) {
            m.opProductos.setVisible(false);
        }
        if (u.getClientes() == 1) {
            m.opClientes.setVisible(false);
        }
        if (u.getProveedores() == 1) {
            m.opProveedores.setVisible(false);
        }
        if (u.getFacturas() == 1) {
            m.opFacturas.setVisible(false);
        }
        if (u.getCompras() == 1) {
            m.opCompras.setVisible(false);
        }
        if (u.getKardex() == 1) {
            m.opKardex.setVisible(false);
        }
        if (u.getProvincias() == 1) {
            m.opProvincias.setVisible(false);
        }
        if (u.getCiudades() == 1) {
            m.opCiudades.setVisible(false);
        }
        if (u.getListaVentas() == 1) {
            m.oplVentas.setVisible(false);
        }
        if (u.getListaCompras() == 1) {
            m.oplCompras.setVisible(false);
        }
        if (u.getGestionUsuarios() == 1) {
            m.opGestionU.setVisible(false);
        }
        if (u.getCreacionUsuarios() == 1) {
            m.opNuevoUsuario.setVisible(false);
        }
    }

    // Metodo para verificar un RUC
    public boolean validarRUC(String ruc) {
        boolean validacion = false;
        // Verificar que la cédula tenga 10 dígitos
        if (ruc == null || ruc.length() != 13) {
            validacion = false;
        } else {
            // Extraer los primeros 9 dígitos de la cédula
            String digitos = ruc.substring(0, 9);
            // Calcular el dígito verificador
            int suma = 0;
            int mult = 2;
            for (int i = digitos.length() - 1; i >= 0; i--) {
                int digito = Character.getNumericValue(digitos.charAt(i));
                int producto = digito * mult;
                if (producto >= 10) {
                    producto -= 9;
                }
                suma += producto;
                mult = (mult == 2) ? 1 : 2;
            }
            int verificador = (10 - (suma % 10)) % 10;
            // Verificar que el último dígito de la cédula sea igual al dígito verificador
            int ultimoDigito = Character.getNumericValue(ruc.charAt(9));
            validacion = (ultimoDigito == verificador);
            if (validacion) {
                if (ruc.charAt(10) == '0' && ruc.charAt(11) == '0') {
                    if (ruc.charAt(12) == '1' || ruc.charAt(12) == '2' || ruc.charAt(12) == '3') {
                        validacion = true;
                    } else {
                        validacion = false;
                    }
                } else {
                    validacion = false;
                }
            }
        }
        return validacion;
    }

    public boolean validarCi(String ruc) {
        boolean validacion;
        // Verificar que la cédula tenga 10 dígitos
        if (ruc == null || ruc.length() != 10) {
            validacion = false;
        } else {
            // Extraer los primeros 9 dígitos de la cédula
            String digitos = ruc.substring(0, 9);
            // Calcular el dígito verificador
            int suma = 0;
            int mult = 2;
            for (int i = digitos.length() - 1; i >= 0; i--) {
                int digito = Character.getNumericValue(digitos.charAt(i));
                int producto = digito * mult;
                if (producto >= 10) {
                    producto -= 9;
                }
                suma += producto;
                mult = (mult == 2) ? 1 : 2;
            }
            int verificador = (10 - (suma % 10)) % 10;
            // Verificar que el último dígito de la cédula sea igual al dígito verificador
            int ultimoDigito = Character.getNumericValue(ruc.charAt(9));
            validacion = (ultimoDigito == verificador);
        }
        return validacion;
    }

    public boolean carateresEspeciales(String s) {
        return s.matches("[0-9a-zA-ZÑñ_.\\sá&éíóúÁÉÍÓÚ\\']+");
    }

    public boolean almenosDos(String s) {
        return s.matches("([A-Za-zÑñá&éí\\'óúÁÉÍÓÚ]+)([\\s]{1})([A-Za-zÑñá&éíó\\'úÁÉÍÓÚ]+)([A-Za-zÑñáé&í\\'óúÁÉÍÓÚ\\s]+)");
    }

    public boolean dosPalabras(String s) {
        return s.matches("([A-Za-z&Ññ\\'áéíóúÁÉÍÓÚ]+)([\\s]{1})([A-Za-z&Ññáéí\\'óúÁÉÍÓÚ]*)");
    }

    public boolean tresPalabras(String s) {
        return s.matches("([A-Za-zÑñáé\\'í&óúÁÉÍÓÚ]+)([\\s]{1})([A-Za-zÑñáé&íóúÁ\\'ÉÍÓÚ]*)([\\s]{1})([A-Za-zÑñáé&íóú\\'ÁÉÍÓÚ]+)");
    }

    public boolean letrasEsp(String s) {
        return s.matches("[ÑñA-Za-z\\sáéíóúÁÉÍÓÚ]+");
    }

    public boolean letrasSinEsp(String s) {
        return s.matches("[ÑñA-Za-záéíóúÁÉÍÓÚ_0-9]+");
    }

    public boolean numeros(String s) {
        return s.matches("[\\d]+");
    }

    public boolean diezDigitos(String s) {
        return s.matches("[\\d]{10}");
    }

    public boolean numerosM(String s) {
        return s.matches("([1-9]{1})([\\d]*)");
    }

    public boolean decimal(String s) {
        return s.matches("([0-9]+)([.]*)([\\d]*)");
    }

    public boolean vacio(String s) {
        return s.isEmpty();
    }

    public boolean validarFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setLenient(false); // Configura el formateador para que no sea tolerante con fechas inválidas
        try {
            formatoFecha.parse(fecha);
            return true; // La fecha es válida
        } catch (ParseException e) {
            return false; // La fecha no es válida
        }
    }

    public String formatFechaString(LocalDateTime d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String f = d.format(formatter);
        return f;
    }

    public LocalDateTime formatFecha(String f) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(f, formatter);
    }
}
