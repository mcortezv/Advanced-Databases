/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.ActivistaFormDialog;
import view.styles.Button;
import view.styles.Panel;

import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ActivistaPanel extends Panel {
    private Button btnAgregarActivista;
    private Button btnBuscarActivista;
    private Button btnActualizarActivista;
    private Button btnEliminarActivista;
    private TablePanel tablePanel;
    private MainController controller;

    public ActivistaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnAgregarActivista = new Button("Agregar Activista");
        btnBuscarActivista = new Button("Buscar Activista");
        btnActualizarActivista = new Button("Actualizar Activista");
        btnEliminarActivista = new Button("Eliminar Activista");
        tablePanel = new TablePanel();
        btnAgregarActivista.setPreferredSize(new Dimension(230, 40));
        btnBuscarActivista.setPreferredSize(new Dimension(230, 40));
        btnActualizarActivista.setPreferredSize(new Dimension(230, 40));
        btnEliminarActivista.setPreferredSize(new Dimension(230, 40));

        btnAgregarActivista.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnBuscarActivista.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnActualizarActivista.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();

        });

        btnEliminarActivista.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnAgregarActivista);
        leftPanel.add(btnBuscarActivista);
        leftPanel.add(btnActualizarActivista);
        leftPanel.add(btnEliminarActivista);
        rightPanel.add(tablePanel);
    }

    public void updateTable(){
        tablePanel.setFullModel(TableModel.listToTableModelActivistas(controller.getActivistaController().listarActivistas()));
    }
}
