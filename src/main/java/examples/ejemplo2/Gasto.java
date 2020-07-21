package examples.ejemplo2;

public class Gasto {

    String name;
    int gasto;

    public Gasto(String name, int gasto) {
        this.name = name;
        this.gasto = gasto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
    public int getImporte() {
        return gasto;
    }
}
