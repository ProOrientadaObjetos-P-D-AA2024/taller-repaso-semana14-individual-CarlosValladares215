
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConeccionDB {
    public Connection concDB;
    public ArrayList<Estudiante> lstEstudiantes;
    public String msj;
    
     public void establecerConexion() {

        try {
            String url = "jdbc:sqlite:DB/dbTest1.db";
            concDB = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setConcDB(String url) {
        try {
            this.concDB = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public ArrayList<Estudiante> getLstEstudiantes() {
        lstEstudiantes = new ArrayList<>();
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                ResultSet resultSet = statement.executeQuery("Select * from Estudiante");
                while (resultSet.next()) {
                    lstEstudiantes.add(new Estudiante(
                            resultSet.getString("cedula"),
                            resultSet.getString("nombre"),
                            resultSet.getInt("nota_1"),
                            resultSet.getInt("nota_2"),
                            resultSet.getInt("promedio"),
                            resultSet.getString("estado")));
                }
            
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
        return lstEstudiantes;
    }

     public void insertarEstudiante(Estudiante estudiante) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strInsertEst = String.format("INSERT INTO Estudiante(cedula, nombreEst, nota1, nota2, promedio, estado) "
                        + "values('%s','%s', %d, %d, %d, '%s')",estudiante.cedula, estudiante.nombre, estudiante.nota1,
                        estudiante.nota2, estudiante.promedio, estudiante.estado);
                statement.executeUpdate(strInsertEst);
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strUpdateEst = String.format("UPDATE Estudiante SET "
                        + "nombre = '%s', "
                        + "nota_1 = %d, "
                        + "nota_2 = %d, "
                        + "promedio = %d "
                        + "estado = '%s', "
                        + "WHERE cedula = '%s'",
                        estudiante.nombre, estudiante.nota1, estudiante.nota2,estudiante.promedio,estudiante.estado, estudiante.cedula);
                statement.executeUpdate(strUpdateEst);
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }

    public void borrarEstudiante(Estudiante estudiante) {
        try {
            establecerConexion();
            try (Statement statement = concDB.createStatement()) {
                String strInsertEst = String.format("delete from Estudiante where cedula='%s'", estudiante.cedula);
                statement.executeUpdate(strInsertEst);
            }
        } catch (SQLException sqlException) {
            this.msj = sqlException.getMessage();
        }
    }
}
