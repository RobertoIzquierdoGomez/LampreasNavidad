package model;

public class Repartidor {

    private Integer id;
    private String nombre;
    private String apellido;

    public Repartidor(){}
    public Repartidor(Integer id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    @Override public String toString() {
        return "Repartidor{id=%d, nombre='%s', apellido='%s'}".formatted(id, nombre, apellido);
    }
}
