/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;
import models.EmpleadoDAO;
import models.Empleado;
import models.Empleado.Estatus;
import java.time.LocalDate;

/**
 *
 * @author Cotez, Manuel;
 */
public class JPAEmpresa {

    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();

        // Insertar empleados
        Empleado empleado1 = new Empleado("Manuel Cortez", "manuel.cortez@gmail.com",
                15000.0, Estatus.ACTIVO, LocalDate.of(2023, 5, 10));
        Empleado empleado2 = new Empleado("Sebastian Escalante", "sebastian.escalante@gmail.com",
                20000.0, Estatus.ACTIVO, LocalDate.of(2022, 3, 15));

        dao.insertar(empleado1);
        dao.insertar(empleado2);

        // Listar empleados
        System.out.println("\n--- Lista de empleados ---");
        for (Empleado empleado : dao.listar()) {
            System.out.println(empleado);
        }

        // Modificar empleado
        empleado1.setSalario(16000.0);
        dao.actualizar(empleado1);

        System.out.println("\n--- Despues de actualizar ---");
        for (Empleado empleado : dao.listar()) {
            System.out.println(empleado);
        }

        // Aumentar salario
        dao.aumentarSalario(empleado2.getId(), 10.0);

        System.out.println("\n--- Despues de aumento de salario ---");
        for (Empleado empleado : dao.listar()) {
            System.out.println(empleado);
        }

        // Eliminar empleado
        dao.eliminar(empleado2.getId());

        System.out.println("\n--- Despues de eliminar ---");
        for (Empleado empleado : dao.listar()) {
            System.out.println(empleado);
        }
    }
}

