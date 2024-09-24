package pe.edu.cibertec.app_examen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.app_examen.remote.service.AppService;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AppArchivoService {

    private final AppService appService;

    public CompletableFuture<String> crearArchivoAleatorio() {
        CompletableFuture<Void> tarea1 = CompletableFuture.runAsync(() -> {
            try {
                appService.crearArchivo5s();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error creando archivo de 5 segundos: " + e.getMessage());
            }
        });

        CompletableFuture<Void> tarea2 = CompletableFuture.runAsync(() -> {
            try {
                appService.crearArchivo7s();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error creando archivo de 7 segundos: " + e.getMessage());
            }
        });

        CompletableFuture<Void> tarea3 = CompletableFuture.runAsync(() -> {
            try {
                appService.crearArchivo10s();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error creando archivo de 10 segundos: " + e.getMessage());
            }
        });

        // allOf = UNIR QUE TODAS LAS TAREAS TERMINEN CORRECTAMENTE
        return CompletableFuture.allOf(tarea1, tarea2, tarea3)
                .thenApply(result -> "Todos los archivos han sido creados exitosamente.")
                .exceptionally(ex -> "Error al ejecutar tareas: " + ex.getMessage());
    }
}