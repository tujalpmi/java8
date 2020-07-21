package examples.ForEachConsumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Principal4 {
    public static void main(String[] args) {

        ArrayList<Persona> milista = new ArrayList<Persona>();
        milista.add(new Persona("Miguel"));
        milista.add(new Persona("Alicia"));
        for (Persona p : milista) {
            System.out.println(p.getName());
        }

//Esta operación la podemos realizar de similar forma utilizando el método
// forEach de Java 8 que las colecciones soportan a través del interface
// Iterable. Así pues el nuevo código sería :
        milista.forEach(new Consumer<Persona>() {
            @Override
            public void accept(final Persona persona) {
                System.out.println(persona.getName());
            }
        });

    }


    }


