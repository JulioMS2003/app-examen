package pe.edu.cibertec.app_examen.remote.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class AppService {

    private void crearArchivoAleatorio(String fileName) throws IOException {
        Random random = new Random();
        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Numero Aleatorio: " + random.nextInt(1000));
            log.info("Archivo creado: {}", fileName);
        } catch (IOException e) {
            log.error("Error al crear el archivo: {}", fileName, e);
            throw e;
        }
    }

    @Async
    public CompletableFuture <Void> crearArchivo5s() throws IOException, InterruptedException{
        try {
            TimeUnit.SECONDS.sleep(5);
            crearArchivoAleatorio("file5.txt");
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async
    public CompletableFuture <Void> crearArchivo7s() throws IOException, InterruptedException{
        try {
            TimeUnit.SECONDS.sleep(7);
            crearArchivoAleatorio("file7.txt");
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture(null);
    }

    @Async
    public CompletableFuture <Void> crearArchivo10s() throws IOException, InterruptedException{
        try {
            TimeUnit.SECONDS.sleep(10);
            crearArchivoAleatorio("file10.txt");
        }catch (InterruptedException ex){
            ex.printStackTrace();

        }
        return CompletableFuture.completedFuture(null);
    }

}