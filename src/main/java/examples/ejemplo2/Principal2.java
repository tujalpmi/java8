package examples.ejemplo2;

import examples.ejemplo1.Libro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal2 {
    public static void main(String[] args) {



//Vamos a construir un ejemplo sencillo. Supongamos que tenemos una lista de gastos de viaje
// diarios y la empresa se hará cargo de todos ellos. Eso sí , si una vez sumado
// a los gastos el IVA el importe supera los 100 euros la empresa no lo pagará ya
// que considerará que nos hemos excedido en lo que gastamos en un día

        ArrayList<Gasto> listaGastos= new ArrayList<Gasto>();
        listaGastos.add(new Gasto("A",80));
        listaGastos.add(new Gasto("B",50));
        listaGastos.add(new Gasto("C",70));
        listaGastos.add(new Gasto("D",95));
        double totalPago=0;
        for (Gasto g:listaGastos) {
            if (g.getImporte()*1.21<100) {
                totalPago=totalPago+ g.getImporte()*1.21;
            }
        }
        System.out.println(totalPago);


        double resultado2=listaGastos.stream()
                .mapToDouble(gasto->gasto.getImporte()*1.21)
                .filter(gasto->gasto<100)
                .sum();

        System.out.println(resultado2);

        //hemos usado en este nuevo código un stream y lo hemos dividido en tres pasos:
        //
        //Sumamos el IVA a cada uno de nuestros gastos
        //Filtramos aquellos gastos que se pasan del tope
        //Sumamos los que restan
    }
}