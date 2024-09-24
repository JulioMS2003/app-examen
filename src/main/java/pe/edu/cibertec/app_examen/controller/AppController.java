package pe.edu.cibertec.app_examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.app_examen.service.AppService;

import java.io.IOException;

@Controller
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping("/crear-archivo-5s")
    public String createFileWithDelay5s() throws IOException, InterruptedException {
        appService.crearArchivo5s();
        return "Archivo con demora de 5 segundos creado";
    }

    @GetMapping("/crear-archivo-7s")
    public String createFileWithDelay7s() throws IOException, InterruptedException {
        appService.crearArchivo7s();
        return "Archivo con demora de 7 segundos creado";
    }

    @GetMapping("/crear-archivo-10s")
    public String createFileWithDelay10s() throws IOException, InterruptedException {
        appService.crearArchivo10s();
        return "Archivo con demora de 10 segundos creado";
    }

}
