package ejercicio_sumar;

import java.sql.*;

public class Sumador {

    double op1;
    double op2;
    double result;
    Connection cn;
    Statement st;

    void suma() {
        result = op1 + op2;

    }

    public Connection subir() {
        String url = "jdbc:mysql://localhost:3306/sumavirtual";
        String usuario = "root";
        String clave = "mysql2017";

        Connection conexion;
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion exitosa");

            String cadena = "INSERT INTO suma(Num1,Num2,Resultado) VALUES (" + op1 + "," + op2 + "," + result + ")";

            Statement sentencia;
            sentencia = conexion.createStatement();

            sentencia.execute(cadena);
        } catch (SQLException ex) {
            System.out.println("No conecto");
        }
        return null;
    }

}
