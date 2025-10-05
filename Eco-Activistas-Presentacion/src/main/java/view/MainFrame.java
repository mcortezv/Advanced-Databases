/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controllers.MainController;
import view.panels.*;
import view.styles.Button;
import view.styles.Style;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private Button btnClientes;
    private Button btnActivistas;
    private Button btnProblemasActivistas;
    private Button btnProblemas;
    private Button btnInUse;
    private MainPanel mainPanel;
    private JPanel centralPanel;
    private NorthPanel northPanel;
    private ClientePanel estudiantePanel;
    private ActivistaPanel tutorPanel;
    private ProblemaActivistaPanel horarioPanel;
    private ProblemaPanel materiaPanel;
    private final MainController mainController;

    public MainFrame(MainController mainController) {
        this.mainController = mainController;
        startComponents();
        setTitle("EcoActivistas");
        setSize(1200, 720);
        setJMenuBar(menuBar);
        add(centralPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void startComponents() {
        menuBar = new JMenuBar();
        btnClientes = new Button("Clientes");
        btnActivistas = new Button("Activistas");
        btnProblemasActivistas = new Button("Problemas Activistas");
        btnProblemas = new Button("Problemas");
        mainPanel = new MainPanel();
        northPanel = new NorthPanel();

        centralPanel = new JPanel();
        centralPanel.add(mainPanel);
        centralPanel.setBackground(Style.PANEL_COLOR);
        add(centralPanel, BorderLayout.CENTER);

        estudiantePanel = new ClientePanel(this, northPanel, mainController);
        tutorPanel = new ActivistaPanel(this, northPanel, mainController);
        horarioPanel = new ProblemaActivistaPanel(this, northPanel , mainController);
        materiaPanel = new ProblemaPanel(this, northPanel , mainController);

        add(northPanel, BorderLayout.NORTH);
        northPanel.add(btnClientes);
        northPanel.add(btnActivistas);
        northPanel.add(btnProblemasActivistas);
        northPanel.add(btnProblemas);

        btnClientes.setPreferredSize(new Dimension(160, 40));
        btnActivistas.setPreferredSize(new Dimension(160, 40));
        btnProblemasActivistas.setPreferredSize(new Dimension(200, 40));
        btnProblemas.setPreferredSize(new Dimension(160, 40));
        btnClientes.addActionListener(e -> {
            estudiantePanel.updateTable();
            showPanel(estudiantePanel);
        });
        btnClientes.addActionListener(e -> {
            btnInUse = btnClientes;
            northPanel.setInUseButton(btnInUse);
        });

        btnActivistas.addActionListener(e -> {
            tutorPanel.updateTable();
            showPanel(tutorPanel);
        });
        btnActivistas.addActionListener(e -> {
            btnInUse = btnActivistas;
            northPanel.setInUseButton(btnInUse);
        });

        btnProblemasActivistas.addActionListener(e -> {
            horarioPanel.updateTable();
            showPanel(horarioPanel);
        });
        btnProblemasActivistas.addActionListener(e -> {
            btnInUse = btnProblemasActivistas;
            northPanel.setInUseButton(btnInUse);
        });

        btnProblemas.addActionListener(e -> {
            materiaPanel.updateTable();
            showPanel(materiaPanel);
        });
        btnProblemas.addActionListener(e -> {
            btnInUse = btnProblemas;
            northPanel.setInUseButton(btnInUse);
        });
    }

    private void showPanel(JPanel nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(nuevoPanel, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }

    public MainPanel getMainPanel(){
        return mainPanel;
    }

}
