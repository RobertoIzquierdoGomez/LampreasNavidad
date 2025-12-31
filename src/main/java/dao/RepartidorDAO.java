package dao;

import db.Db;
import model.Repartidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {


    //Insertar un repartidor
    private final String INSERT = "INSERT INTO repartidor (id_repartidor, nombre, apellido) VALUES (?,?,?)";

    //Listar todos los repartidores
    private final String SELECT_ALL = "SELECT * FROM repartidor";

    //Buscar repartidor por ID
    private final String SELECT_ID = "SELECT * FROM repartidor WHERE id_repartidor = ?";

    //Eliminar repartidor por ID
    private final String DELETE_ID = "DELETE FROM repartidor WHERE id_repartidor = ?";

    public void insert(Repartidor r) throws SQLException {

        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, r.getId());
            ps.setString(2,r.getNombre());
            ps.setString(3,r.getApellido());

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

    public List<Repartidor> findAll() throws SQLException{

        List<Repartidor> listaRepartidores = new ArrayList<>();

        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                Repartidor c = new Repartidor(
                        rs.getInt("id_repartidor"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );

                listaRepartidores.add(c);
            }
        }
        return listaRepartidores;
    }

    public Repartidor findId (int id) throws SQLException{
        try(Connection con = Db.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_ID)){

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){
                    return new Repartidor(
                            rs.getInt("id_repartidor"),
                            rs.getString("nombre"),
                            rs.getString("apellido")
                    );
                }
                return null;
            }

        }

    }


}
