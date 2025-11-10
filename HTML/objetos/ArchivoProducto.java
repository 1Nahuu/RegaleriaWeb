package objetos;

import java.io.*;

public class ArchivoProducto {
    public static void escribirEnArchivo(Producto producto, String rutaArchivo) {
        try {
            // Crear la carpeta "archivos" si no existe
            File carpeta = new File("archivos");
            if (!carpeta.exists()) {
                if (carpeta.mkdir()) {
                   // System.out.println("Carpeta 'archivos' creada.");
                } else {
                    //System.out.println("No se pudo crear la carpeta 'archivos'.");
                    return; // Salir si no se puede crear la carpeta
                }
            } else {
                //System.out.println("La carpeta 'archivos' ya existe.");
            }

            // Verificar si el producto ya existe
            if (productoYaExiste(producto.getNombre(), rutaArchivo)) {
                System.out.println("El producto '" + producto.getNombre() + "' ya existe en el archivo. No se puede agregar.");
                return; // Salir si el producto ya existe
            }

            // Escribir en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) { // 'true' para agregar sin sobrescribir
                writer.write("Nombre: " + producto.getNombre() + "\n");
                writer.write("Cantidad: " + producto.getCantidad() + "\n");
                writer.write("Precio: " + producto.getPrecio() + "\n");
                writer.write("-----------------------------\n");
                //System.out.println("Datos escritos en el archivo: " + rutaArchivo);
            }
        } catch (IOException e) {
            //System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    // Método para verificar si un producto ya existe en el archivo
    private static boolean productoYaExiste(String nombreProducto, String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return false; // Si el archivo no existe, el producto no puede existir
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Nombre: " + nombreProducto)) {
                    return true; // Producto encontrado
                }
                // Saltar las siguientes líneas de cantidad y precio para buscar el nombre
                reader.readLine(); // Cantidad
                reader.readLine(); // Precio
                reader.readLine(); // Línea separadora
            }
        } catch (IOException e) {
           // System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

        return false; // Producto no encontrado
    }

    public static void borrarContenidoYEscribirEnArchivo(Producto producto, String rutaArchivo) {
        try {
            // Abrir el archivo en modo de sobrescritura para borrar su contenido
            try (FileWriter writer = new FileWriter(rutaArchivo, false)) { // 'false' para sobrescribir
                // No escribimos nada para borrar el contenido
                System.out.println("Contenido del archivo borrado: " + rutaArchivo);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al borrar el contenido del archivo.");
            e.printStackTrace();
        }


    }

    public static void eliminarElementoArchivo(String rutaArchivo, String nombreProducto) {
        File archivoOriginal = new File(rutaArchivo);
        File archivoTemporal = new File("archivos/temp.txt"); // Archivo temporal

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            boolean encontrado = false;

            while ((linea = reader.readLine()) != null) {
                // Verificamos si la línea contiene el nombre del producto a eliminar
                if (linea.contains("Nombre: " + nombreProducto)) {
                    encontrado = true; // Producto encontrado
                    // Saltamos las siguientes 3 líneas que corresponden al producto
                    reader.readLine(); // Cantidad
                    reader.readLine(); // Precio
                    reader.readLine(); // Línea separadora
                    continue; // Continuamos con la siguiente iteración
                }
                // Escribimos las líneas que no son del producto a eliminar
                writer.write(linea);
                writer.newLine();
            }

            // Verificamos si encontramos el producto
            if (encontrado) {
                System.out.println("Producto '" + nombreProducto + "' eliminado del archivo.");
            } else {
                System.out.println("Producto '" + nombreProducto + "' no encontrado en el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al eliminar el producto.");
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        if (archivoOriginal.delete()) {
            archivoTemporal.renameTo(archivoOriginal);
        }
    }


}
