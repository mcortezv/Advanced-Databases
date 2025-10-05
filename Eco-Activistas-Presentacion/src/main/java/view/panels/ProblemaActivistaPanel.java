/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.ProblemaActivistaFormDialog;
import view.styles.Button;
import view.styles.Panel;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ProblemaActivistaPanel extends Panel {
    private Button btnAgregarProblemaActivista;
    private Button btnBuscarProblemaActivista;
    private Button btnEliminarProblemaActivista;
    private TablePanel tablePanel;
    private MainController controller;

    public ProblemaActivistaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnAgregarProblemaActivista =  new Button("Agregar Problema Activista");
        btnBuscarProblemaActivista =  new Button("Busar Problema Activista");
        btnEliminarProblemaActivista =  new Button("Eliminar Problema Activista");
        tablePanel = new TablePanel();
        btnAgregarProblemaActivista.setPreferredSize(new Dimension(260, 40));
        btnBuscarProblemaActivista.setPreferredSize(new Dimension(260, 40));
        btnEliminarProblemaActivista.setPreferredSize(new Dimension(260, 40));

        btnAgregarProblemaActivista.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnBuscarProblemaActivista.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnEliminarProblemaActivista.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnAgregarProblemaActivista);
        leftPanel.add(btnBuscarProblemaActivista);
        leftPanel.add(btnEliminarProblemaActivista);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModeProblemasActivistas(controller.getProblemaActivistaController().listarRelaciones()));
    }
}
