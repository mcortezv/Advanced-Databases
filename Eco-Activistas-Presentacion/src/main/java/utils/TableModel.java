package utils;
import models.Activista;
import models.Cliente;
import models.Problema;
import models.ProblemaActivista;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class TableModel {

    public static DefaultTableModel listToTableModelActivistas(List<Activista> activistas) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nombre");
        columnNames.add("Telefono");
        columnNames.add("Fecha Ingreso");
        Vector<Vector<Object>> data = new Vector<>();
        for (Activista activista : activistas) {
            Vector<Object> row = new Vector<>();
            row.add(activista.getIdActivista());
            row.add(activista.getNombre());
            row.add(activista.getTelefono());
            row.add(activista.getFchIngreso());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelClientes(List<Cliente> clientes) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nombre");
        columnNames.add("Direccion");
        columnNames.add("Telefonos");

        Vector<Vector<Object>> data = new Vector<>();
        for (Cliente cliente : clientes) {
            Vector<Object> row = new Vector<>();
            row.add(cliente.getIdCliente());
            row.add(cliente.getNombre());
            row.add(cliente.getDireccion());
            row.add(cliente.getTelefonos());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModelProblemas(List<Problema> problemas) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Fecha Inicio");
        columnNames.add("Fecha Fin");
        columnNames.add("Estado");
        columnNames.add("ID Cliente");
        Vector<Vector<Object>> data = new Vector<>();
        for (Problema problema : problemas) {
            Vector<Object> row = new Vector<>();
            row.add(problema.getIdProblema());
            row.add(problema.getFchIni());
            row.add(problema.getFchFin());
            row.add(problema.getEstado());
            row.add(problema.getIdCliente());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public static DefaultTableModel listToTableModeProblemasActivistas(List<ProblemaActivista> problemaActivistas) {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID Problema");
        columnNames.add("ID Activista");
        Vector<Vector<Object>> data = new Vector<>();
        for (ProblemaActivista problemaActivista : problemaActivistas) {
            Vector<Object> row = new Vector<>();
            row.add(problemaActivista.getIdProblema());
            row.add(problemaActivista.getIdActivista());
            data.add(row);
        }
        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

}
