package dao;

import db.Db;
import model.Comercial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComercialDAO {

    //Insertar un comercial
    private final String INSERT = "INSERT INTO comercial (id_comercial, nombre, apellido) VALUES (?,?,?)";

    //Listar todos los comerciales
    private final String SELECT_ALL = "SELECT * FROM comercial";

    //Buscar comercial por ID
    private final String SELECT_ID = "SELECT * FROM comercial WHERE id_comercial = ?";

    //Eliminar comercial por ID
    private final String DELETE_ID = "DELETE FROM comercial WHERE id_comercial = ?";

    public void insert(Comercial c) throws SQLException {

        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, c.getId());
            ps.setString(2,c.getNombre());
            ps.setString(3,c.getApellido());

            ps.execute();
        }

    }

    public void delete(int id) throws SQLException{
        try(Connection con = Db.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_ID)){

            ps.setInt(1, id);
            ps.execute();
        }
    }

    public List<Comercial> findAll() throws SQLException{

        List<Comercial> listaComerciales = new ArrayList<>();

        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                Comercial c = new Comercial(
                        rs.getInt("id_comercial"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );

                listaComerciales.add(c);
            }
        }
        return listaComerciales;
    }

    public Comercial findId (int id) throws SQLException{
        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ID)){

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){
                    return new Comercial(
                      rs.getInt("id_comercial"),
                      rs.getString("nombre"),
                      rs.getString("apellido")
                    );
                }
                return null;
            }

        }

    }


}
