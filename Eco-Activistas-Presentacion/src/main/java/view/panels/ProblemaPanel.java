/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.ProblemaFormDialog;
import view.styles.Button;
import view.styles.Panel;

import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ProblemaPanel extends Panel {
    private Button btnAgregarProblema;
    private Button btnBuscarProblema;
    private Button btnActualizarProblema;
    private Button btnEliminarProblema;
    private TablePanel tablePanel;
    private MainController controller;

    public ProblemaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnAgregarProblema =  new Button("Agregar Problema");
        btnBuscarProblema =  new Button("Buscar Problema");
        btnActualizarProblema =  new Button("Actualizar Problema");
        btnEliminarProblema =  new Button("Eliminar Problema");
        tablePanel = new TablePanel();
        btnAgregarProblema.setPreferredSize(new Dimension(230, 40));
        btnBuscarProblema.setPreferredSize(new Dimension(230, 40));
        btnActualizarProblema.setPreferredSize(new Dimension(230, 40));
        btnEliminarProblema.setPreferredSize(new Dimension(230, 40));

        btnAgregarProblema.addActionListener(e -> {
            new ProblemaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnBuscarProblema.addActionListener(e -> {
            new ProblemaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnActualizarProblema.addActionListener(e -> {
            new ProblemaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });

        btnEliminarProblema.addActionListener(e -> {
            new ProblemaFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnAgregarProblema);
        leftPanel.add(btnBuscarProblema);
        leftPanel.add(btnActualizarProblema);
        leftPanel.add(btnEliminarProblema);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelProblemas(controller.getProblemaController().listarProblemas()));
    }
}
