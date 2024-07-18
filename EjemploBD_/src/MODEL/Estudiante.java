
package MODEL;

public class Estudiante {
    public String cedula;
    public String nombre;
    public int nota1;
    public int nota2;
    public int promedio;
    public String estado;

    public Estudiante(String cedula, String nombre, int nota1, int nota2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public Estudiante(String cedula, String nombre, int nota1, int nota2, int promedio, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.promedio = promedio;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" +  "cedula=" + cedula +"nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", promedio=" + promedio + ", estado=" + estado +  "'}'" ;
    }
}
