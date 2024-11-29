package gerardo.sn.DemoCrudConApi.controller;

//public class UsuarioController {
//}
import gerardo.sn.DemoCrudConApi.model.Usuario;
import gerardo.sn.DemoCrudConApi.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
@RestController
@RequestMapping("/api")
public class UsuarioController implements CommandLineRunner {

    private final UsuarioService usuarioService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
//endpoint
    @GetMapping("/mostrarDatos")
    public ResponseEntity<List<Usuario>> mostrarDatosApi() {
        List<Usuario> usuariosDTO = usuarioService.obtenerUsuarios();
        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }
//consola
    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("1. Ingresar datos");
            System.out.println("2. Mostrar datos");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void ingresarDatos() {
        System.out.print("Ingrese el nombre del socio: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese si el socio está habilitado para ingresar (true/false): ");
        boolean habilitadoParaIngresar = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Ingrese la fecha hasta la que el socio está habilitado (yyyy-MM-dd): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate habilitadoHastaLaFechaDate = LocalDate.parse(scanner.nextLine(), formatter);
        // Convertir habilitadoHastaLaFecha a String
        String habilitadoHastaLaFecha = habilitadoHastaLaFechaDate.format(formatter);
//        String habilitadoHastaLaFecha = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, habilitadoParaIngresar, habilitadoHastaLaFecha);
        usuarioService.guardarUsuario(usuario);
        System.out.println("Socio ingresado con éxito");
    }

    private void mostrarDatos() {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        System.out.println("\nDatos de los socios:");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Habilitado para ingresar: " + (usuario.isHabilitadoParaIngresar() ? "Sí" : "No"));
            System.out.println("Habilitado hasta la fecha: " + usuario.getHabilitadoHastaLaFecha());
            System.out.println();
        }
    }
}