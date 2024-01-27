/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Funciones {

    public static boolean pasarelaPago(Carrito carrito) {

        boolean repetir = true;
        boolean correcto = false;

        do {
            String[] menuPago = {"SALIR", "PAGAR"};
            int respuesta = metodosTpv.respuestaBoton(menuPago);
            switch (respuesta) {
                case 0 ->
                    repetir = false;

                case 1 -> {
                    ArrayList<Tarjeta> lista = InicializadorClases.tarjetas();
                    Collections.sort(lista, (k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta()));

                    Tarjeta x = new Tarjeta(metodosTpv.respuestaJopt("introduce numero tarjeta"), 001, LocalDate.now(), 0);
                    int cvvProbar;
                    LocalDate fechaCadProbar;
                    int posicion = Collections.binarySearch(lista,
                            x,
                            ((k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta())));

                    if (posicion >= 0) {
                        boolean cvvFecha = true;

                        do {
                            cvvProbar = metodosTpv.respuestaJopt("introduce Cvv");
                            fechaCadProbar = fechaValida();

                            if (cvvProbar < 0 || cvvProbar > 999) {
                                JOptionPane.showMessageDialog(null, "cvv debe ser de tres cifras");

                            } else {
                                cvvFecha = false;
                            }

                        } while (cvvFecha);

                        if (lista.get(posicion).getSaldo() >= Pruebas.sacarTotal(carrito)) {

                            if (lista.get(posicion).getCvv() == cvvProbar && lista.get(posicion).getFechaVencimiento().equals(fechaCadProbar)) {
                                lista.get(posicion).setSaldo(lista.get(posicion).getSaldo() - Pruebas.sacarTotal(carrito));
                                repetir = false;
                                JOptionPane.showMessageDialog(null, "Pago Correcto");
                                correcto = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "error en cvv o  fecha");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "saldo insuficiente");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "no existe la tarjeta");
                    }

//                        
                }
            }

        } while (repetir);

        return correcto;
    }

    public static LocalDate fechaValida() {
        LocalDate fechaValida = LocalDate.of(1, 1, 1);
        boolean error = true;
        do
        try {
            fechaValida = LocalDate.of(metodosTpv.respuestaJopt("introduce año"), metodosTpv.respuestaJopt("introduce mes"), 30);
            error = false;
        } catch (java.time.DateTimeException jtd) {
            JOptionPane.showMessageDialog(null, "fecha no valida");
        } while (error);
        return fechaValida;
    }
    
    //CREAR METODO CONTRASEÑA
    
    public static String password(){
        char[] arrayChar= {'#','$','%','&','(',')','*','+',',','-','.',':',';','<','=','>','@'};
        Random r = new Random();
        char[] chars=new char[6];
        chars[0]=(char)r.nextInt(97,123);
        chars[1]=(char)r.nextInt(65,91);
        chars[2]=(char) r.nextInt(48,58);
        chars[3]=arrayChar[r.nextInt(arrayChar.length)];
        chars[4]=(char)r.nextInt(33,123);
        chars[5]=(char)r.nextInt(33,123);
        char extra;
        for(int i=0; i<chars.length;i++){
            int posicion1=r.nextInt(chars.length);
            int posicion2=r.nextInt(chars.length);
            extra=chars[posicion1];
            chars[posicion1]=chars[posicion2];
            chars[posicion2]=extra;
        }
        String password=String.valueOf(chars);
        
          return password;     
    }
}
