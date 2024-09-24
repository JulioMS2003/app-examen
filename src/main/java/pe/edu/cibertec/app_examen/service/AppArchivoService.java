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

    public CompletableFuture<String> crearArchivosAleatorios() throws IOException, InterruptedException {
        CompletableFuture<Void> tarea1 = appService.crearArchivo5s();
        CompletableFuture<Void> tarea2 = appService.crearArchivo7s();
        CompletableFuture<Void> tarea3 = appService.crearArchivo10s();

        return CompletableFuture.allOf(tarea1, tarea2, tarea3)
                .thenApply(result -> "Todos los archivos han sido creados exitosamente.")
                .exceptionally(ex -> {
                    Throwable cause = ex.getCause() != null ? ex.getCause() : ex;
                    return "Error al ejecutar tareas: " + cause.getMessage();
         });
}
}