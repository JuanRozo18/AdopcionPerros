import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Persona> personas = new ArrayList<>();
    static List<Perro> perrosDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menu de Adopcion -----");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver personas Disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar perro mas viejo");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Documento: ");
                    String documento = scanner.nextLine();

                    personas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada...");
                }
                case 2 -> {
                    System.out.println("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Raza: ");
                    String raza = scanner.nextLine();
                    System.out.println("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Tamaño: ");
                    String tamaño = scanner.nextLine();

                    perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamaño));
                    System.out.println("Perro registrado...");
                }
                case 3 -> {
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                        return;
                    }
                    for (Persona p : personas) {
                        System.out.println(p);
                    }
                }
                case 4 -> {
                    if (perrosDisponibles.isEmpty()) {
                        System.out.println("No hay perros disponibles.");
                        return;
                    }
                    for (Perro p : perrosDisponibles) {
                        System.out.println(p);
                    }
                }
                case 5 -> {
                    System.out.print("Documento de la persona: ");
                    String documento = scanner.nextLine();
                    Persona persona = buscarPersona(documento);
                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        return;
                    }

                    System.out.print("Placa del perro: ");
                    String placa = scanner.nextLine();
                    Perro perro = buscarPerro(placa);
                    if (perro == null) {
                        System.out.println("Perro no disponible.");
                        return;
                    }

                    if (persona.adoptarPerro(perro)) {
                        perrosDisponibles.remove(perro);
                        System.out.println("Adopción realizada con éxito.");
                    } else {
                        System.out.println("Esta persona ya ha adoptado 3 perros.");
                    }
                }
                case 6 -> {
                    System.out.print("Documento de la persona: ");
                    String documento = scanner.nextLine();
                    Persona persona = buscarPersona(documento);
                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        return;
                    }
                    Perro mayor = persona.perroMasGrande();
                    if (mayor == null) {
                        System.out.println("Esta persona no ha adoptado ningún perro.");
                    } else {
                        System.out.println("El perro más viejo es: " + mayor);
                    }
                }

                static Persona buscarPersona (String documento){
                    for (Persona p : personas) {
                        if (p.getDocumento().equalsIgnoreCase(documento)) {
                            return p;
                        }
                    }
                    return null;
                }

                static Perro buscarPerro (String placa){
                    for (Perro p : perrosDisponibles) {
                        if (p.getPlaca().equalsIgnoreCase(placa)) {
                            return p;
                        }
                    }
                    return null;
                }
            }
            case 7 -> {
                System.out.println("Saliendo...");
            }
        }
    }
}
