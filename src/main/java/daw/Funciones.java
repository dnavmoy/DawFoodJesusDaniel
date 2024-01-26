/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Funciones {

    public static boolean pasarelaPago(Carrito carrito) {

        boolean correcto = true;

        do {
            String[] menuPago =  {"SALIR", "PAGAR"};
            int respuesta = metodosTpv.respuestaBoton(menuPago);
            switch (respuesta) {
                case 0 ->
                    correcto = false;

                case 1 -> {
                    int numTarjeta = metodosTpv.respuestaJopt("Intoduce tarjeta");
                    for (int i = 0; i < tarjetas().size(); i++) {

                        if (numTarjeta == tarjetas().get(i).getNumTarjeta()) {
                            System.out.println("Tarjeta correcta, comprobando saldo.....");
                                
                            
                            if (tarjetas().get(i).getSaldo() >= Pruebas.sacarTotal(carrito)) {

                                tarjetas().get(i).setSaldo(tarjetas().get(i).getSaldo() - Pruebas.sacarTotal(carrito));

                                correcto = false;
                                JOptionPane.showMessageDialog(null, "Pago Correcto");
                            }
                        } 
                    }
                }
            }

        } while (correcto);

        return correcto;
    }

    public static ArrayList<Tarjeta> tarjetas() {

        Tarjeta t1 = new Tarjeta(1234, 123, new Date(2025, 12, 30), 1);
        Tarjeta t2 = new Tarjeta(4321, 321, new Date(2024, 12, 30), 200);
        Tarjeta t3 = new Tarjeta(1357, 135, new Date(2026, 12, 30), 12000);

        ArrayList<Tarjeta> listaTarjeta = new ArrayList();

        listaTarjeta.add(t1);
        listaTarjeta.add(t2);
        listaTarjeta.add(t3);

        return listaTarjeta;

    }

}
