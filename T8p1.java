/*
Práctica threads 02
Desarrollar un programa que reciba a través de sus argumentos una lista de archivos de texto
y cuente cuantas líneas tiene el archivo, así como el total de líneas para todos los archivos.
Crear un thread para procesar cada archivo considerando los siguientes casos:
1. Obtener el tiempo que tarda en contar las líneas utilizando Counter.java para acumular el total de líneas
en los archivos.
2. Obtener el tiempo que tarda en contar las líneas utilizando SynchronizedCounter.java para acumular el total
de líneas en los archivos.
 */

import java.io.*;

public class T8p1 implements Runnable{
    private FileReader fl = null;
    private BufferedReader in = null;
    private String name;

    public T8p1(String name) {
        this.name = name;
        try {
            fl = new FileReader(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        in = new BufferedReader(fl);
    }

    @Override
    public void run() {
        int contadorLineas = 0;
        String linea = null;
        long t1 = System.currentTimeMillis();
        while (true) {
            try {
                if (!((linea = in.readLine()) != null))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            contadorLineas++;
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(Thread.currentThread().getName());
        System.out.println(" "+name);
        System.out.println("Número de líneas: "+contadorLineas);
    }
}
