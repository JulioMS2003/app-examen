package pe.edu.cibertec.app_examen.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class AppService {

    private void crearArchivoAleatorio(String fileName) throws IOException {
        Random random = new Random();
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Numero Aleatorio: " + random.nextInt(1000));
        writer.close();
        System.out.println("Archivo creado: " + fileName);
    }

    public void crearArchivo5s() throws IOException, InterruptedException{
        TimeUnit.SECONDS.sleep(5);
        crearArchivoAleatorio("file5.txt");
    }

    public void crearArchivo7s() throws IOException, InterruptedException{
        TimeUnit.SECONDS.sleep(7);
        crearArchivoAleatorio("file7.txt");
    }

    public void crearArchivo10s() throws IOException, InterruptedException{
        TimeUnit.SECONDS.sleep(10);
        crearArchivoAleatorio("file10.txt");
    }

}
