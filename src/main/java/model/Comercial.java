package model;

public class Comercial {

    private Integer id;
    private String nombre;
    private String apellido;

    public Comercial(){}
    public Comercial(Integer id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    @Override public String toString() {
        return "Comercial{id=%d, nombre='%s', apellido='%s'}".formatted(id, nombre, apellido);
    }

}
