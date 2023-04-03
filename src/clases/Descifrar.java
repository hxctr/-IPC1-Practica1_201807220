package clases;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.Scanner;


public class Descifrar {
    //--------------------------
    String guardarLinea;
    String[] spliteado;

    //--------------------------

    //--------------------------
    static int[][] guardarNxM;
    //--------------------------
    static Integer p;
    static String[] AquiGuardoCaracteresSinComa;
    static Integer[] AquiGuardoElCasteo;
    static Integer[][] res = new Integer[0][0];
    String texto;

    public void generarCantColumns() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ruta de la primer matriz");
        String ruta = sc.next();
        int cantColumnas = 0;

        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            guardarLinea = br.readLine();
            spliteado = guardarLinea.split(",");
            cantColumnas = spliteado.length;
            System.out.println("La cantidad de columnas es: " + cantColumnas);
            generarCantFilas(ruta, cantColumnas);
        } catch (Exception e) {
            System.out.println("El archivo no existe");
        }


    }

    public void generarCantFilas(String ruta, int cantColumnas) {

        String cadena;
        int cantFilas = 0;


        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);


            while ((br.readLine()) != null) {
                cantFilas++;
            }
            br.close();
            System.out.println("La cantidad de filas es: " + cantFilas);
        } catch (Exception e) {
            System.out.println("El archivo no existe");
        }

        leerArchivo1(ruta, cantColumnas, cantFilas);

    }


    public void leerArchivo1(String ruta, int cantColumnas, int cantFilas) {//Archivo con matriz NxM
        int c = 0, f = 0;

        guardarNxM = new int[cantFilas][cantColumnas];

        File file = new File(ruta);

        try {
            Scanner lecutra = new Scanner(file);
            while (lecutra.hasNextLine()) {
                String linea = lecutra.nextLine();
                if (cantColumnas > 1) {
                    for (int i = 0; i < cantColumnas - 1; i++) {
                        int quitacoma = linea.indexOf(",");
                        String numero = linea.substring(0, quitacoma);
                        linea = linea.substring(quitacoma + 1, linea.length());
                        guardarNxM[f][c] = Integer.parseInt(numero);
                        c++;

                        if (linea.contains(",")) {

                        } else {
                            guardarNxM[f][c] = Integer.parseInt(linea);
                        }
                    }
                    c = 0;
                    f++;
                } else {
                    String leelo = linea;

                    for (int i = 0; i < cantColumnas; i++) {
                        guardarNxM[f][c] = Integer.parseInt(leelo);
                        f++;
                    }
                }

            }
            lecutra.close();
            generarCantColumns2();

        } catch (Exception e) {
            System.out.println("No existe");
        }


    }

    public void generarCantColumns2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ruta de la segunda matriz");
        String ruta2 = sc.next();
        int cantColumnas2 = 0;

        try {
            FileReader fr = new FileReader(ruta2);
            BufferedReader br = new BufferedReader(fr);

            guardarLinea = br.readLine();
            spliteado = guardarLinea.split(",");
            cantColumnas2 = spliteado.length;
            System.out.println("La cantidad de columnas es: " + cantColumnas2);
            generarCantFilas2(ruta2, cantColumnas2);
        } catch (Exception e) {
            System.out.println("El archivo no existe");
        }


    }


    public void generarCantFilas2(String ruta2, int cantColumnas2) {

        String cadena;
        int cantFilas2 = 0;


        try {
            FileReader fr = new FileReader(ruta2);
            BufferedReader br = new BufferedReader(fr);


            while ((br.readLine()) != null) {
                cantFilas2++;
            }
            br.close();
            System.out.println("La cantidad de filas es: " + cantFilas2);
            leerArchivo2(ruta2, cantColumnas2, cantFilas2);
        } catch (Exception e) {
            System.out.println("El archivo no existe");
        }


    }


    String linea;
    String[] temp;
    Integer[] numbers;
    static Integer[][] resultado;


    public void leerArchivo2(String ruta2, int cantColumnas2, int cantFilas2) {


        if (cantColumnas2 != cantFilas2) {
            System.out.println("La matriz del archivo no es del tipo NxN");
        } else {


            Integer f = 0;
            temp = new String[cantFilas2];
            numbers = new Integer[cantFilas2];
            resultado = new Integer[cantFilas2][cantFilas2];

            try {

                FileReader fr = new FileReader(ruta2);
                BufferedReader br = new BufferedReader(fr);

                while ((linea = br.readLine()) != null) {

                    temp = linea.split(",");
                    for (int j = 0; j < temp.length; j++) {
                        numbers[j] = Integer.parseInt(temp[j]);
                        resultado[f][j] = numbers[j];
                    }
                    f++;
                }
                br.close();
                casteoPrimerArchivo(guardarNxM);
            } catch (Exception e) {

            }
        }


        /*int determinante = determinanteMatriz(resultado, cantFilas2);
        System.out.println("El determinante es: "+determinante);*/

        //En caso de ser necesario quitar todos los comments


    }


    static double[][] casteo1;

    public static void casteoPrimerArchivo(int[][] guardarNxM) {

        casteo1 = new double[guardarNxM.length][guardarNxM[0].length];

        for (int i = 0; i < casteo1.length; i++) {
            for (int j = 0; j < casteo1[i].length; j++) {
                casteo1[i][j] = guardarNxM[i][j];
            }
        }
        casteoSegundoArchivo(resultado);
    }

    static double[][] casteo2;
    public static void casteoSegundoArchivo(Integer[][] resultado) {

        casteo2 = new double[resultado.length][resultado.length];

        for (int i = 0; i < casteo2.length; i++) {
            for (int j = 0; j < casteo2[i].length; j++) {
                casteo2[i][j] = resultado[i][j];
            }
        }

        matrizInversa(casteo2);
        multi(nmatriz, casteo1);


    }


    static double[][] nmatriz;


    public static double[][] matrizInversa(double[][] resultado) {
        double det = 1 / determinante(resultado);
        nmatriz = matrizAdjunta(resultado);
        multiplicarMatriz(det, nmatriz);
        return nmatriz;
    }

    public static void multiplicarMatriz(double n, double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] *= n;
            }
        }
    }

    public static double[][] matrizAdjunta(double[][] matriz) {
        return matrizTranspuesta(matrizCofactores(matriz));
    }

    public static double[][] matrizCofactores(double[][] matriz) {
        double[][] nm = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                double[][] det = new double[matriz.length - 1][matriz.length - 1];
                double detValor;
                for (int k = 0; k < matriz.length; k++) {
                    if (k != i) {
                        for (int l = 0; l < matriz.length; l++) {
                            if (l != j) {
                                int indice1 = k < i ? k : k - 1;
                                int indice2 = l < j ? l : l - 1;
                                det[indice1][indice2] = matriz[k][l];
                            }
                        }
                    }
                }
                detValor = determinante(det);
                nm[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
            }
        }
        return nm;
    }

    public static double[][] matrizTranspuesta(double[][] matriz) {
        double[][] nuevam = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                nuevam[i][j] = matriz[j][i];
            }
        }
        return nuevam;
    }

    public static double determinante(double[][] matriz) {
        double det;
        if (matriz.length == 2) {
            det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
            return det;
        }
        double suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            double[][] nm = new double[matriz.length - 1][matriz.length - 1];
            for (int j = 0; j < matriz.length; j++) {
                if (j != i) {
                    for (int k = 1; k < matriz.length; k++) {
                        int indice = -1;
                        if (j < i) {
                            indice = j;
                        } else if (j > i) {
                            indice = j - 1;
                        }
                        nm[indice][k - 1] = matriz[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                suma += matriz[i][0] * determinante(nm);
            } else {
                suma -= matriz[i][0] * determinante(nm);
            }
        }
        return suma;
    }

    static double[][] multiply;
    public static void multi(double[][] nmatriz, double[][] casteo1) {

        multiply = new double[nmatriz.length][casteo1[0].length];

        if (nmatriz[0].length == casteo1.length) {
            for (int i = 0; i < nmatriz.length; i++) {
                for (int j = 0; j < casteo1[0].length; j++) {
                    for (int k = 0; k < nmatriz[0].length; k++) {

                        multiply[i][j] += nmatriz[i][k] * casteo1[k][j];

                    }
                }
            }

            System.out.println("\n");
            casteoMatrizResultante(multiply);



        } else {
            System.out.println("Este else");
            ;
        }


    }

    static int[][] casteoTotal;

    public static void casteoMatrizResultante(double[][] multiply) {


        casteoTotal = new int[multiply.length][multiply[0].length];

        for (int i = 0; i < casteoTotal.length; i++) {
            for (int j = 0; j < casteoTotal[i].length; j++) {
                casteoTotal[i][j] = (int) multiply[i][j];
            }
        }
        casteoAChart(casteoTotal);

    }

    static char[][] ascii;
    public static void casteoAChart(int[][] casteoTotal) {
        char[][] ascii = new char[casteoTotal.length][casteoTotal[0].length];

        for (int i = 0; i < casteoTotal.length; i++) {
            for (int j = 0; j < casteoTotal[i].length; j++) {
                ascii[i][j] = (char) casteoTotal[i][j];
            }
        }
        System.out.println("******************************MATRIX******************************");
        System.out.println("Mensaje descifrado es:");
        for (int i = 0; i < ascii.length; i++) {
            for (int j = 0; j < ascii[i].length; j++) {
                System.out.print(ascii[i][j] + "");
            }
        }
        System.out.println("\n******************************************************************");
        System.out.println("");
        reporteDescifrar(guardarNxM,resultado,casteo1,casteo2,nmatriz,multiply,casteoTotal,ascii);




    }

    public static void reporteDescifrar(int[][] guardarNxM, Integer[][] resultado, double[][] casteo1, double[][] casteo2, double[][] nmatriz, double[][] multiply, int[][] casteoTotal, char[][] ascii){



        Scanner sc = new Scanner(System.in);
        System.out.print("Digite la ruta y el nombre del reporte: ");
        String rutaReporte2 = sc.nextLine();

        try {

            FileWriter archivo2 = new FileWriter(rutaReporte2);

            archivo2.write("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<meta charset=\"utf-8\" />\n"
                    + "<title>Descifrar</title>\n"
                    +"<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" media=\"all\">"
                    + "</head>"
                    + "<body bgcolor=\"turquoise\">"
                    + " <h1 align=\"center\">Reporte de Descifrar</h1>\n"
                    + "<hr>\n"
                    + "<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>La matriz NxM del primer archivo era</h2>\n");

            archivo2.write("<table>\n");
            for (int i = 0; i < guardarNxM.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < guardarNxM[i].length; j++) {
                    archivo2.write("<th>" + guardarNxM[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>La matriz NxN del segundo archivo era</h2>\n");


            //---------------------------------------------------

            archivo2.write("<table>\n");
            for (int i = 0; i < resultado.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < resultado[i].length; j++) {
                    archivo2.write("<th>" + resultado[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");


            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>El casteo de int a double para la matriz NxM del primer archivo quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < casteo1.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < casteo1[i].length; j++) {
                    archivo2.write("<th>" + casteo1[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");


            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>El casteo de Integer a double para la matriz NxN del segundo archivo quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < casteo2.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < casteo2[i].length; j++) {
                    archivo2.write("<th>" + casteo2[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");




            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>La matriz inversa de la matriz NxN quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < nmatriz.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < nmatriz[i].length; j++) {
                    archivo2.write("<th>" + nmatriz[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");



            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>La matriz resultante de la multplicacion de NxN * NxM quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < multiply.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < multiply[i].length; j++) {
                    archivo2.write("<th>" + multiply[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");



            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>El casteo de double a int para la matriz resultante quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < casteoTotal.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < casteoTotal[i].length; j++) {
                    archivo2.write("<th>" + casteoTotal[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");





            //---------------------------------------------------


            archivo2.write("<hr>\n"
                    + "<h2 style=\"color:#0946D9\";>El casteo de int a char para obtener los caracteres en una matriz quedo como</h2>\n");


            archivo2.write("<table>\n");
            for (int i = 0; i < ascii.length; i++) {
                archivo2.write("<tr>\n");
                for (int j = 0; j < ascii[i].length; j++) {
                    archivo2.write("<th>" + ascii[i][j] + "</th>\n");
                }
                archivo2.write("</tr>\n");
            }
            archivo2.write("</table>\n");









            archivo2.write("</body>\n"
                    + "</html>\n");
            archivo2.close();
            System.out.println("*****Reporte creado con exito*****");
            System.out.println("\n");
        } catch (IOException e) {
            System.out.println("Algo salio mal");
        }







    }



    public static void printMatriz(double[][] mat) {//Metodo para imprimir la matriz transpuesta
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("|" + mat[i][j] + "|");
            }

            System.out.println();
        }
    }










}













