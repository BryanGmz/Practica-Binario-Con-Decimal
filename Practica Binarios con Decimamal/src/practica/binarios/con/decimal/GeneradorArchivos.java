/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.binarios.con.decimal;;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author bryan
 */
public class GeneradorArchivos {
    
    private static GeneradorArchivos generadorArchivos;
    public static final String PARSER = "-parser";
    public static final String SYM = "sym.java";
    //Constantes para generar archivos del analizador lexico y sintactico de las estructuras: lienzos, colores, tiempo
    public static final String PATH_FLEX = "src/practica/binarios/con/decimal/Lexico.flex";
    public static final String PATH_CUP = "src/practica/binarios/con/decimal/Sintax.cup";
    public static final String PATH_SYM = "src/practica/binarios/con/decimal/sym.java";
    public static final String PATH_SINTAX = "src/practica/binarios/con/decimal/Sintax.java";
    public static final String NOMBRE_SINTAX = "Sintax";
    public static final String NOMBRE_CLASE_SINTAX = "Sintax.java";
    
    private GeneradorArchivos() {}

    public static GeneradorArchivos getGeneradorArchivos() {
        if (generadorArchivos == null) {
            generadorArchivos = new GeneradorArchivos();
        } 
        return generadorArchivos;
    }
    
    public void genearar(String rutaFlex, String rutaCup, String rutaSym, String rutaSintaxJava, String nombreSintax, String nombreClase) throws Exception {
        String[] rutaSintactico = {PARSER, nombreSintax, rutaCup};
        generador(rutaFlex, rutaSintactico, rutaSym, SYM, rutaSintaxJava, nombreClase);
    }
    
    private void generador(String rutaLexicoProyecto, String[] rutaSintax, String rutaSymTXT, String nombreSym, String rutaSint, String nombreSin) throws IOException, Exception{
        File archivo;
        archivo = new File(rutaLexicoProyecto);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintax);
        Path rutaSym = Paths.get(rutaSymTXT);
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(nombreSym), 
                Paths.get(rutaSymTXT)
        );
        Path rutaSin = Paths.get(rutaSint);
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(nombreSin), 
                Paths.get(rutaSint)
        );
    }
}
