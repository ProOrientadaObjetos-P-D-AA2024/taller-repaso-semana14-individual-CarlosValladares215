package VIEW;

import CONTROLER.ProcesarEstudiantes;
import MODEL.Estudiante;
import java.util.ArrayList;
import java.util.Scanner;

public class TestEstudiantes {

    public static void main(String[] args) {
        ProcesarEstudiantes procesadorE = new ProcesarEstudiantes();
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("Seleccione con un numero la opcion que se requiera ejecutar");
            System.out.println("1. Insertar nuevo estudiante");
            System.out.println("2. Presentar Lista de Estudiantes");
            System.out.println("3. Actualizar datos por cedula");
            System.out.println("4. Borrar Estudiante");
            System.out.println("5. Cerrar Base de Datos");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ingrese el nombre del nuevo estudiante");
                    String nom = sc.nextLine();
                    System.out.println("Digite la nota en su primer parcial");
                    int notaP1 = sc.nextInt();
                    System.out.println("Digite la nota en su segundo parcial");
                    int notaP2 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese el numero de cedula del estudiante llamado " + nom);
                    String ced = sc.nextLine();

                    Estudiante est = new Estudiante(ced,nom, notaP1, notaP2);
                    procesadorE.setLstEstudiantes(est);
                    
                    procesadorE.insertarEstudiante(est);
                    System.out.println("El estudiante " + nom + " ha sido agregado a la base de datos.");
                    break;
                case 2:
                    ArrayList<Estudiante> lstEst = procesadorE.getLstEstudiantes();
                    for (Estudiante est1 : lstEst) {
                        System.out.println(est1);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la cedula del estudiante a reestablecer datos");
                    String cedulaKey = sc.nextLine();

                    for (int i = 0; i < procesadorE.getLstEstudiantes().size(); i++) {
                        Estudiante estu = procesadorE.getLstEstudiantes().get(i);
                        if (estu.getCedula().equals(cedulaKey)) {
                            System.out.println("Ingrese el nuevo nombre");
                            String nNombre = sc.nextLine();
                            System.out.println("Digite la nueva nota del parcial 1");
                            int nNota1 = sc.nextInt();
                            System.out.println("Digite la nueva nota del parcial 2");
                            int nNota2 = sc.nextInt();
                            sc.nextLine();
                            procesadorE.obtenerLstEstudiantes().get(i).nombre = nNombre;
                            procesadorE.obtenerLstEstudiantes().get(i).nota1 = nNota1;
                            procesadorE.obtenerLstEstudiantes().get(i).nota2 = nNota2;
                            procesadorE.calculoPromedios();
                            procesadorE.calculoEstados();
                            procesadorE.actualizarEstudiante(estu);
                            System.out.println("El estudiante con cedula" + procesadorE.obtenerLstEstudiantes().get(i).cedula + "ha sido actualizado en la base de datos.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la cedula del estudiante a eliminar de la base de datos");
                    String cedulaKeyD = sc.nextLine();
                    for (int i = 0; i < procesadorE.getLstEstudiantes().size(); i++) {
                        Estudiante estu = procesadorE.getLstEstudiantes().get(i);
                        if (estu.getCedula().equals(cedulaKeyD)) {
                            procesadorE.borrarEstudiante(estu);
                        }
                    }
                case 5:
                    System.out.println("Base de Datos Cerrada");
                    break;
                default:
                    System.out.println("Vuelva a intentarlo");
            }

        } while (5 != op);
    }
}
