package pe.edu.cibertec.app_examen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.app_examen.remote.service.AppService;
import pe.edu.cibertec.app_examen.service.AppArchivoService;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RequiredArgsConstructor
@RestController
public class AppController {
    private final AppArchivoService appArchivoService;

    @GetMapping("/crear-archivos")
    public String crearArchivos() throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<String> resultado =
                appArchivoService.crearArchivosAleatorios();
        return resultado.get();
}

}