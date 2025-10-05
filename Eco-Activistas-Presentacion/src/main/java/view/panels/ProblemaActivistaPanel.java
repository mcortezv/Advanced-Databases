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
    private Button btnCreateHorario;
    private Button btnReadHorario;
    private Button btnDeleteHorario;
    private TablePanel tablePanel;
    private MainController controller;

    public ProblemaActivistaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnCreateHorario =  new Button("Agregar Problema Activista");
        btnReadHorario =  new Button("Busar Problema Activista");
        btnDeleteHorario =  new Button("Eliminar Problema Activista");
        tablePanel = new TablePanel();
        btnCreateHorario.setPreferredSize(new Dimension(260, 40));
        btnReadHorario.setPreferredSize(new Dimension(260, 40));
        btnDeleteHorario.setPreferredSize(new Dimension(260, 40));

        btnCreateHorario.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnReadHorario.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnDeleteHorario.addActionListener(e -> {
            new ProblemaActivistaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateHorario);
        leftPanel.add(btnReadHorario);
        leftPanel.add(btnDeleteHorario);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModeProblemasActivistas(controller.getProblemaActivistaController().listarRelaciones()));
    }
}
