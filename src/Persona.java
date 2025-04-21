import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getDocumento(){
        return documento;
    }

    public Boolean adoptarPerro(Perro perro){
        if(perrosAdoptados.size() < 3){
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande(){
        if(perrosAdoptados.isEmpty()) return null;
        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    public String toString(){
        String resultado = "Nombre: "+ nombre + " "+ apellido + ", Edad: "+ edad + ", Documento: "+ documento + "\nPerros Adoptados: ";
        for (Perro p : perrosAdoptados){
            resultado += " - " + p + "\n";
    }
        return resultado;
    }

}
