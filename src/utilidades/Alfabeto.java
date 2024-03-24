package utilidades;

public class Alfabeto {
    public String cambio(String s) {
        return s.replaceAll("\'", "\\^");
    }
    
    public String devolver(String s) {
        return s.replaceAll("\\^", "\'");
    }
}
