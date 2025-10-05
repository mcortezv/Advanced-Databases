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
    private Button btnCreateTutor;
    private Button btnReadTutor;
    private Button btnUpdateTutor;
    private Button btnDeleteTutor;
    private TablePanel tablePanel;
    private MainController controller;

    public ActivistaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnCreateTutor = new Button("Agregar Activista");
        btnReadTutor = new Button("Buscar Activista");
        btnUpdateTutor = new Button("Actualizar Activista");
        btnDeleteTutor = new Button("Eliminar Activista");
        tablePanel = new TablePanel();
        btnCreateTutor.setPreferredSize(new Dimension(230, 40));
        btnReadTutor.setPreferredSize(new Dimension(230, 40));
        btnUpdateTutor.setPreferredSize(new Dimension(230, 40));
        btnDeleteTutor.setPreferredSize(new Dimension(230, 40));

        btnCreateTutor.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnReadTutor.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnUpdateTutor.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();

        });

        btnDeleteTutor.addActionListener(e -> {
            new ActivistaFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateTutor);
        leftPanel.add(btnReadTutor);
        leftPanel.add(btnUpdateTutor);
        leftPanel.add(btnDeleteTutor);
        rightPanel.add(tablePanel);
    }

    public void updateTable(){
        tablePanel.setFullModel(TableModel.listToTableModelActivistas(controller.getActivistaController().listarActivistas()));
    }
}
