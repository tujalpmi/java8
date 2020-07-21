package examples.ejemplo1;

import examples.ejemplo1.Libro;
import examples.ejemplo2.Gasto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {

        Libro l1 = new Libro("El señor de los anillos", 1000);
        Libro l2 = new Libro("La fundacion", 500);
        Libro l3 = new Libro("El caliz de fuego", 600);

        //Map<String, BookingPax> paxPerReference = new HashMap<>();
        //Set<String> packages = new HashSet<>();
        //   ArrayList<InternetAddress> inetAddresses = new ArrayList<>();
        //List<Object> fileContents = new ArrayList<>();
        // List<EntitySchedule> entitySchedulesRemove = new ArrayList<>();
        Set<Libro> libros = new HashSet<>();
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

        //Acabamos de instanciar tres objetos ,vamos a añadir todos a un stream y recorrerlo
        //utilizando el método forEach.
        Stream<Libro> st = Stream.of(l1, l2, l3);
        st.forEach((l) -> System.out.println(l.getTitulo()));
        System.out.println("from stream........................");
        libros.stream().forEach(libro -> System.out.println(libro.getTitulo()));

        //En muchas ocaciones no queremos simplemente imprimir un resultado sino que lo que
        //queremos es convertir el Stream a un tipo de dato para su posterior gestión .
//convertir el stream a un array con el método toArray()
        Stream<Libro> st4 = Stream.of(l1, l2, l3);
        System.out.println("from array.......................");
        Libro[] arrayLibro = st4.toArray(Libro[]::new);
        for (int i = 0; i < arrayLibro.length; i++) {
            System.out.println(arrayLibro[i].getPaginas());
        }
        /**De igual forma que podemos convertir el Stream a un array, podemos usar los Java Stream
         Collectors y convertir nuestro stream a una Lista o Conjunto , utilizando la clase Collectors
         y su método toList() o toSet().**/
        System.out.println("List<Libro>.......................");
        Stream<Libro> st2 = Stream.of(l1, l2, l3);
        List<Libro> lista = st2.collect(Collectors.toList());
        for (Libro l : lista) {
            System.out.println(l.getTitulo());
        }

        Stream<Libro> st3 = Stream.of(l1, l2, l3);
        System.out.println("Set<Libro>.......................");
        Set<Libro> listaSet = st3.collect(Collectors.toSet());
        for (Libro l : listaSet) {
            System.out.println(l.getTitulo());
        }
//Acabamos de usar dos de los métodos fundamentales de Collectors para generar Sets y List
//a partir de un Stream.

        //Los Java Stream collectors nos permiten realizar operaciones más complejas con poco
        //código . Por ejemplo podemos obligar a que todos los títulos de los Libros se impriman en
        //una única linea usando el método joining de la clase Collectors.
        System.out.println("joining.......................");
        Stream<Libro> st5 = Stream.of(l1, l2, l3);
        String resultado = st5.map((l) -> l.getTitulo()).collect(Collectors.joining(","));
        System.out.println(resultado);
//Podemos complicarlo más y sumar todas las páginas de los libros utilizando el método
//reducing de Collectors.
        System.out.println("reducing......................");
        Stream<Libro> st6 = Stream.of(l1, l2, l3);
        Optional<Integer> resultado3 = st6.map(l ->
                l.getPaginas()).collect(Collectors.reducing(Integer::sum));
        System.out.println(resultado3.get());
        //Hay muchas opciones pero la clase Collectors es una de las indispensables a la hora de
        //trabajar con Streams y transformarlos.


    }
}