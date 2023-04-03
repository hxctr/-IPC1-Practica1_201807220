package clases;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


public class Principal {


    static char[][] AquiAlmacenoLosCaracteresDelTexto;
    static int[][] AquiGuardoLosCaracteresConvertidosAascii;
    //--------------------------------------------------------------------------------------------------------------
    static String ruta;//Ruta del .txt
    static String cadena;
    static FileReader fr;
    static BufferedReader br;
    static Integer p;
    static String[] AquiGuardoCaracteresSinComa;
    static Integer[] AquiGuardoElCasteo;
    static Integer[][] res = new Integer[0][0];
    //Las variables de arriba son para todos los try and catch que validan los archivos


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        Descifrar mensajero = new Descifrar();


        while (flag) {
            String opcion;


            System.out.println("******* Digite una opcion *******");
            System.out.println("***        1. Cifrar          *** ");
            System.out.println("***        2. Descifrar       ***");
            System.out.println("***        3. Gauss-Jordan    ***");
            System.out.println("***        4. Salir           ***");
            System.out.println("*********************************");
            System.out.print("[OPCION]: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    System.out.println("****cifrando***");
                    matrizAscii();

                    break;
                case "2":
                    System.out.println("***Descifrando***");
                    mensajero.generarCantColumns();
                    break;
                case "3":
                    System.out.println("Gauss-Jordan...");
                    break;
                case "4":
                    System.out.println("***Salida Exitosa***");
                    flag = false;
                    break;
                default:
                    System.out.println("la opcion ingresada no es valida");


            }


        }


    }


    static String textoIngresado;

    //------------------------------------------------------------------------------------------------------------------
    public static void matrizAscii() {
        //Las variables de abajo son para todos los if que validan los multiplos
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un texto: ");
        textoIngresado = sc.nextLine();


        int longitudTexto = textoIngresado.length();

        if (longitudTexto % 3 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[3][longitudTexto / 3];
            AquiGuardoLosCaracteresConvertidosAascii = new int[3][longitudTexto / 3];

            for (int i = 0; i < 3; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 3; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 3)) + j);
                }
            }


            //De aqui para abajo trato de rellenar la matriz con ascii

            for (int i = 0; i < 3; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 3; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 3)) + j);
                }
            }


            leerArchivo(3);

        } else if (longitudTexto % 4 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[4][longitudTexto / 4];
            AquiGuardoLosCaracteresConvertidosAascii = new int[4][longitudTexto / 4];

            for (int i = 0; i < 4; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 4; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 4)) + j);
                }
            }

            /*System.out.println("en el if de 4");*/


            for (int i = 0; i < 4; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 4; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 4)) + j);
                }
            }

            leerArchivo(4);

        } else if (longitudTexto % 5 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[5][longitudTexto / 5];
            AquiGuardoLosCaracteresConvertidosAascii = new int[5][longitudTexto / 5];

            for (int i = 0; i < 5; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 5; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 5)) + j);
                }
            }

            /*System.out.println("en el if de 5");*/

            for (int i = 0; i < 5; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 5; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 5)) + j);
                }
            }
            leerArchivo(5);

        } else if (longitudTexto % 7 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[7][longitudTexto / 7];
            AquiGuardoLosCaracteresConvertidosAascii = new int[7][longitudTexto / 7];

            for (int i = 0; i < 7; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 7; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 7)) + j);
                }
            }

            /*System.out.println("en el if de 7");*/

            for (int i = 0; i < 7; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 7; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 7)) + j);
                }
            }
            leerArchivo(7);

        } else if (longitudTexto % 11 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[11][longitudTexto / 11];
            AquiGuardoLosCaracteresConvertidosAascii = new int[11][longitudTexto / 11];

            for (int i = 0; i < 11; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 11; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 11)) + j);
                }
            }

            /*System.out.println("en el if de 11");*/

            for (int i = 0; i < 11; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 11; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 11)) + j);
                }
            }
            leerArchivo(11);

        } else if (longitudTexto % 13 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[13][longitudTexto / 13];
            AquiGuardoLosCaracteresConvertidosAascii = new int[13][longitudTexto / 13];

            for (int i = 0; i < 13; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 13; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 13)) + j);
                }
            }

            /*System.out.println("en el if de 13");*/

            for (int i = 0; i < 13; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 13; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 13)) + j);
                }
            }
            leerArchivo(13);

        } else if (longitudTexto % 17 == 0) {

            AquiAlmacenoLosCaracteresDelTexto = new char[17][longitudTexto / 17];
            AquiGuardoLosCaracteresConvertidosAascii = new int[17][longitudTexto / 17];

            for (int i = 0; i < 17; i++) {//Ciclo for para rellenar la matriz con caracteres
                for (int j = 0; j < longitudTexto / 17; j++) {
                    AquiAlmacenoLosCaracteresDelTexto[i][j] = textoIngresado.charAt((i * (longitudTexto / 17)) + j);
                }
            }

            /*System.out.println("en el if de 17");*/

            for (int i = 0; i < 17; i++) {//Ciclo for para rellenar la matriz con ascii
                for (int j = 0; j < longitudTexto / 17; j++) {
                    AquiGuardoLosCaracteresConvertidosAascii[i][j] = textoIngresado.charAt((i * (longitudTexto / 17)) + j);
                }
            }
            leerArchivo(17);

        } else {
            System.out.println("La longitud del texto es un numero primo");
            matrizAscii();
        }


    }//Termina el metodo matrizAscii

    //------------------------------------------------------------------------------------------------------------------

    public static void leerArchivo(int matrizNxN) {
        //pidiendo ruta para el .txt
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo de la matriz");
        ruta = sc.next();

        //Try and catch del archivo
        try {
            fr = new FileReader(ruta);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe");
        }

        BufferedReader br;
        br = new BufferedReader(fr);

        p = 0;
        AquiGuardoCaracteresSinComa = new String[matrizNxN];//Arreglo donde se alojaran los caracteres sin las comas
        AquiGuardoElCasteo = new Integer[matrizNxN];//Arreglo que sirve para el casteo de string a entero
        res = new Integer[matrizNxN][matrizNxN];//Matriz resultado donde ya esta alojado
        try {
            while ((cadena = br.readLine()) != null) {//El ciclo se repite hasta que ya no hayan lineas

                AquiGuardoCaracteresSinComa = cadena.split(",");
                for (int j = 0; j < AquiGuardoCaracteresSinComa.length; j++) {
                    AquiGuardoElCasteo[j] = Integer.parseInt(AquiGuardoCaracteresSinComa[j]);
                    res[p][j] = AquiGuardoElCasteo[j];
                }
                p++;
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }


        multiplicarMatrices();


    }

    public static void multiplicarMatrices() {

        int[][] cifradoTotal = new int[res.length][AquiGuardoLosCaracteresConvertidosAascii[0].length];


        try {
            if (res[0].length == AquiGuardoLosCaracteresConvertidosAascii.length) {
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < AquiGuardoLosCaracteresConvertidosAascii[0].length; j++) {
                        for (int k = 0; k < res[0].length; k++) {
                            cifradoTotal[i][j] += res[i][k] * AquiGuardoLosCaracteresConvertidosAascii[k][j];

                        }
                    }
                }
            }
            System.out.println("************************ MATRIX ************************");
            System.out.println("Mensaje cifrado es: ");
            for (int i = 0; i < cifradoTotal.length; i++) {
                for (int z = 0; z < cifradoTotal[i].length; z++) {
                    System.out.print(cifradoTotal[i][z] + " ");
                }
            }
            System.out.println("\n********************************************************");
            System.out.println("\n");
            reporteCifrado(textoIngresado, AquiAlmacenoLosCaracteresDelTexto, AquiGuardoLosCaracteresConvertidosAascii, cifradoTotal, res);


        } catch (NullPointerException e) {
            System.out.println("Las dimensiones de las matrices no son las correctas, por lo tanto no se pueden multiplicar");

        }


    }


    public static void reporteCifrado(String textoIngresado, char[][] AquiAlmacenoLosCaracteresDelTexto, int[][] AquiGuardoLosCaracteresConvertidosAascii, int[][] cifradoTotal, Integer[][] res) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite la ruta y el nombre del reporte: ");
        String rutaReporte = sc.nextLine();

        try {

            FileWriter archivo = new FileWriter(rutaReporte);

            archivo.write("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<meta charset=\"utf-8\" />\n"
                    + "<title>Cifrar</title>\n"
                    + "</head>"
                    +"<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" media=\"all\">"
                    + "<body bgcolor=\"3DA1FF\">"
                    + " <h1 align=\"center\">Reporte de Cifrar</h1>\n"
                    + "<hr>\n"
                    + "<p>Tu texto ingresado fue '<strong>" + textoIngresado + "</strong>'</p>\n"
                    + "<hr>\n"
                    + "<h2 style=\"color:#1F2FE0\";>Tu matriz de caracteres quedo como</h2>\n");

            archivo.write("<table>\n");
            for (int i = 0; i < AquiAlmacenoLosCaracteresDelTexto.length; i++) {
                archivo.write("<tr>\n");
                for (int j = 0; j < AquiAlmacenoLosCaracteresDelTexto[i].length; j++) {
                    archivo.write("<th>" + AquiAlmacenoLosCaracteresDelTexto[i][j] + "</th>\n");
                }
                archivo.write("</tr>\n");
            }
            archivo.write("</table>\n");


            archivo.write("<hr>\n"
                    + "<h2 style=\"color:#1F2FE0\";>Tu matriz de caracteres a ascii quedo como</h2>\n");


            //---------------------------------------------------

            archivo.write("<table>\n");
            for (int i = 0; i < AquiGuardoLosCaracteresConvertidosAascii.length; i++) {
                archivo.write("<tr>\n");
                for (int j = 0; j < AquiGuardoLosCaracteresConvertidosAascii[i].length; j++) {
                    archivo.write("<th>" + AquiGuardoLosCaracteresConvertidosAascii[i][j] + "</th>\n");
                }
                archivo.write("</tr>\n");
            }
            archivo.write("</table>\n");


            //---------------------------------------------------

            archivo.write("<hr>\n"
                    + "<h2 style=\"color:#1F2FE0\";>El cifrado almacenado en una matriz queda </h2>\n");


            archivo.write("<table>\n");
            for (int i = 0; i < cifradoTotal.length; i++) {
                archivo.write("<tr>\n");
                for (int j = 0; j < cifradoTotal[i].length; j++) {
                    archivo.write("<th>" + cifradoTotal[i][j] + "</th>\n");
                }
                archivo.write("</tr>\n");
            }
            archivo.write("</table>\n");


            archivo.write("</body>\n"
                    + "</html>\n");
            archivo.close();
            System.out.println("*****Reporte creado con exito*****");
            System.out.println("\n");
        } catch (IOException e) {
            System.out.println("Algo salio mal");
        }


    }


}