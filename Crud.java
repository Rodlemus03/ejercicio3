import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.mysql.cj.protocol.Resultset;

public class Crud {
    public void Create(double ancho, double largo, double altura, boolean aereo, String tipo, boolean ocupado,String tabla) {
        ConexionBD con = new ConexionBD();
        con.Conexion();
        Connection dbConnection = con.getConnection();

        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO "+tabla
                + "(ancho,largo,altura,aereo,tipo,ocupado) VALUES"
                + "(?,?,?,?,?,?)";

        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setDouble(1, ancho);
            preparedStatement.setDouble(2, largo);
            preparedStatement.setDouble(3, altura);
            preparedStatement.setBoolean(4, aereo);
            preparedStatement.setString(5, tipo);
            preparedStatement.setBoolean(6, ocupado);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Registro guardado correctamente");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
    public void CreateCarro(String marca, String placa, String color, int modelo) {
        ConexionBD con = new ConexionBD();
        con.Conexion();
        Connection dbConnection = con.getConnection();

        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO carro"
                + "(marca, placa, color, modelo, hora) VALUES"
                + "(?,?,?,?,?)";

        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            Date tiempo=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1_str = sdf.format(tiempo);
            preparedStatement.setString(1, marca);
            preparedStatement.setString(2, placa);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, modelo);
            preparedStatement.setString(5, fecha1_str);


            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Registro guardado correctamente");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public void readDisponibles() {
        int contador=0;
        try {
            
            ConexionBD con = new ConexionBD();
            con.Conexion();
            Connection dbconection=con.getConnection();
            PreparedStatement consulta=dbconection.prepareStatement("SELECT * FROM estacionamiento WHERE ocupado=?");
            consulta.setBoolean(1, false);
            ResultSet rs=consulta.executeQuery();
            System.out.println("Si hay parqueo");
            while(rs.next()){
                int id;
                boolean aereo;
                id=rs.getInt("id");
                aereo=rs.getBoolean("aereo");
                System.out.println("El parqueo: "+id+", esta disponible ");
                if(aereo){
                    System.out.println("y es aereo: ");
                }else{
                    System.out.println("y no es aereo");
                }
                contador+=1;

            }
            System.out.println("En total hay: "+contador+" parqueos");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int disponiblesCantidad() {
        int contador=0;
        int[] lista;
        try {
            
            ConexionBD con = new ConexionBD();
            con.Conexion();
            Connection dbconection=con.getConnection();
            PreparedStatement consulta=dbconection.prepareStatement("SELECT * FROM estacionamiento WHERE ocupado=?");
            consulta.setBoolean(1, false);
            ResultSet rs=consulta.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt("id");
                contador+=1;

            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return contador;

    }
    public void readOcupados() {
        int contador=0;
        try {
            
            ConexionBD con = new ConexionBD();
            con.Conexion();
            Connection dbconection=con.getConnection();
            PreparedStatement consulta=dbconection.prepareStatement("SELECT * FROM estacionamiento WHERE ocupado=?");
            consulta.setInt(1, 1);
            ResultSet rs=consulta.executeQuery();
            
            System.out.println("Parqueos ocupados: ");
            while(rs.next()){
                int id;
                boolean aereo;
                id=rs.getInt("id");
                aereo=rs.getBoolean("aereo");
                System.out.println("Ocupado id: "+id);
                contador+=1;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void Modificar(int idMod){
        try {
            
            ConexionBD con = new ConexionBD();
            con.Conexion();
            Connection dbconection=con.getConnection();
            Statement st=dbconection.createStatement();
            st.executeUpdate("UPDATE estacionamiento SET ocupado= '"+ 0 +"'WHERE id='"+idMod+"'");

            System.out.println("Modificado correctamente ");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int cantidadRegistrosOcupado() {
        int contador=0;
        try {
            
            ConexionBD con = new ConexionBD();
            con.Conexion();
            Connection dbconection=con.getConnection();
            PreparedStatement consulta=dbconection.prepareStatement("SELECT * FROM estacionamiento WHERE ocupado=?");
            consulta.setInt(1, 1);
            ResultSet rs=consulta.executeQuery();
            
            System.out.println("Parqueos ocupados: ");
            while(rs.next()){
                
                contador+=1;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }return contador;
    }
}