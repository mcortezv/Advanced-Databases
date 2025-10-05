package test;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import controllers.ProblemaActivistaController;
import controllers.ActivistaController;
import controllers.ProblemaController;
import controllers.ClienteController;
import models.*;
import java.util.List;

/**
 * Clase principal de pruebas en las que se generan consultas y
 * verifica que todos los metodos del CRUD funcionan.
 *
 * @author Cortez, Manuel;
 */
public class EcoActivistas {
    public static void main(String[] args) {

        ClienteController clienteCtrl = new ClienteController();
        ActivistaController activistaCtrl = new ActivistaController();
        ProblemaController problemaCtrl = new ProblemaController();
        ProblemaActivistaController paCtrl = new ProblemaActivistaController();

        // ---- CRUD CLIENTE ----
        // Insercion de clientes de prueba en la base de datos
        System.out.println("----- PRUEBAS CLIENTE -----");
        clienteCtrl.agregarCliente("Manuel Cortez", "Calle 123", "52-6441-976008");
        clienteCtrl.agregarCliente("Sebastian Escalante", "Calle 321", "52-6442-674575");
        clienteCtrl.agregarCliente("David Escarcega", "Calle 111", "52-6442-956384");

        // Consulta de todos los clientes registrados
        List<Cliente> clientes = clienteCtrl.listarClientes();
        clientes.forEach(c -> System.out.println(c.getIdCliente() + " - " + c.getNombre()));

        // Se guarda el id del primer cliente para ligarlo a un problema
        int idClienteParaProblema = clientes.get(0).getIdCliente();

        // Consulta filtrada por nombre con streams
        System.out.println("\n----- CONSULTA CLIENTE POR NOMBRE -----");
        clientes.stream().filter(c -> c.getNombre().contains("Ana")).forEach(c ->
                System.out.println("Encontrado: " + c.getIdCliente() + " - " + c.getNombre())
        );

        // ---- CRUD ACTIVISTA ----
        // Insercion de activistas de prueba
        System.out.println("\n----- PRUEBAS ACTIVISTA -----");
        activistaCtrl.agregarActivista("María Lopez", "555-6789", "2023-01-15");
        activistaCtrl.agregarActivista("Carlos Ramirez", "555-9876", "2022-12-01");

        // Consulta de todos los activistas registrados
        List<Activista> activistas = activistaCtrl.listarActivistas();
        activistas.forEach(a -> System.out.println(a.getIdActivista() + " - " + a.getNombre()));

        // Se toma un id de activista para relacionarlo con un problema
        int idActivistaParaRelacion = activistas.get(0).getIdActivista();

        // Consulta de activistas que ingresaron despues de una fecha
        System.out.println("\n----- CONSULTA ACTIVISTA POR FECHA DE INGRESO -----");
        activistas.stream().filter(a -> a.getFchIngreso().compareTo("2023-01-01") >= 0).forEach(a ->
                System.out.println("Ingreso despues de 2023-01-01: " + a.getNombre())
        );

        // ---- CRUD PROBLEMA ----
        // Registro de problemas asociados a un cliente
        System.out.println("\n----- PRUEBAS PROBLEMA -----");
        problemaCtrl.agregarProblema("2023-05-01", "2023-06-01", "pendiente", idClienteParaProblema);
        problemaCtrl.agregarProblema("2023-07-10", null, "pendiente", idClienteParaProblema);

        // Consulta de problemas existentes
        List<Problema> problemas = problemaCtrl.listarProblemas();
        problemas.forEach(p -> System.out.println(p.getIdProblema() + " - Estado: " + p.getEstado()));

        // Se guarda un id de problema para crear una relacion con un activista
        int idProblemaParaRelacion = problemas.get(0).getIdProblema();

        // Consulta de problemas asociados al cliente en prueba
        System.out.println("\n----- CONSULTA PROBLEMAS POR CLIENTE -----");
        problemas.stream().filter(p -> p.getIdCliente() == idClienteParaProblema).forEach(p ->
                System.out.println("Problema del cliente " + idClienteParaProblema + ": " + p.getIdProblema())
        );

        // ---- CRUD RELACION PROBLEMA_ACTIVISTA ----
        // Se asigna un problema a un activista
        System.out.println("\n----- PRUEBAS PROBLEMA_ACTIVISTA -----");
        paCtrl.asignarProblemaActivista(idProblemaParaRelacion, idActivistaParaRelacion);

        // Consulta de todas las relaciones problema-activista
        List<ProblemaActivista> relaciones = paCtrl.listarRelaciones();
        relaciones.forEach(pa -> System.out.println("Problema " + pa.getIdProblema() + " - Activista " + pa.getIdActivista()));

        // Consulta de problemas asignados a un activista especifico
        System.out.println("\n----- CONSULTA PROBLEMAS POR ACTIVISTA -----");
        relaciones.stream().filter(pa -> pa.getIdActivista() == idActivistaParaRelacion).forEach(pa ->
                System.out.println("Activista " + idActivistaParaRelacion + " asignado a problema " + pa.getIdProblema())
        );

        // ---- ACTUALIZACIONES ----
        // Modificacion de registros existentes en cada entidad
        System.out.println("\n----- ACTUALIZACIONES -----");

        clienteCtrl.actualizarCliente(idClienteParaProblema, "Juan P.", "Nueva Dirección 111", "555-0000");
        System.out.println("Cliente actualizado: " + clienteCtrl.obtenerCliente(idClienteParaProblema).getNombre());

        activistaCtrl.actualizarActivista(idActivistaParaRelacion, "María L.", "555-0001", "2023-02-01");
        System.out.println("Activista actualizado: " + activistaCtrl.obtenerActivista(idActivistaParaRelacion).getNombre());

        problemaCtrl.actualizarProblema(idProblemaParaRelacion, "2023-05-01", "2023-06-30", "concluido", idClienteParaProblema);
        System.out.println("Problema actualizado: Estado = " + problemaCtrl.obtenerProblema(idProblemaParaRelacion).getEstado());

        // ---- ELIMINACIONES ----
        // Borrado de las relaciones y registros creados en las pruebas
        System.out.println("\n----- ELIMINACIONES -----");

        paCtrl.eliminarRelacion(idProblemaParaRelacion, idActivistaParaRelacion);
        System.out.println("Relacion ProblemaActivista eliminada");

        problemaCtrl.eliminarProblema(idProblemaParaRelacion);
        System.out.println("Problema eliminado");

        activistaCtrl.eliminarActivista(idActivistaParaRelacion);
        System.out.println("Activista eliminado");

        clienteCtrl.eliminarCliente(idClienteParaProblema);
        System.out.println("Cliente eliminado");
    }
}
