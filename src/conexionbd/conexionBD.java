package conexionbd;

import java.sql.*;

public class conexionBD {

    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection;
    private static Statement st=null;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(servidor,"ad2223", "nervion");
           if (connection!=null){
               st=connection.createStatement();
               System.out.println("Conexion de datos test correcta");
               System.out.println(st.toString());
           }else
               System.out.println("Conexion fallida");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    CREATE TABLE CarmenMartin (
        ID int
        nombre varchar(25)
        apellidos varchar(25)
        edad int
        );
     */


    public void crearTabla(Statement st, String tabla, String[] campos) throws SQLException {
        String sql="CREATE TABLE ad2223." + tabla +"(";

        for (int i = 0; i< campos.length;i++) {
            sql=campos[i];
            if (i<campos.length){
                sql+=",";
            }
        }
        sql+=");";



        //st.executeQuery("CREATE TABLE ad2223.CarmenMartin (ID int, nombre varchar(25), apellidos varchar(25), edad int)");

    }
}
