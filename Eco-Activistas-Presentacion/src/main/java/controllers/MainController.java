package controllers;

public class MainController {
    private ActivistaController activistaController;
    private ClienteController clienteController;
    private ProblemaActivistaController problemaActivistaController;
    private ProblemaController problemaController;

    public MainController(){
        activistaController = new ActivistaController();
        clienteController = new ClienteController();
        problemaActivistaController = new ProblemaActivistaController();
        problemaController = new ProblemaController();
    }

    public ActivistaController getActivistaController() {
        return activistaController;
    }

    public void setActivistaController(ActivistaController activistaController) {
        this.activistaController = activistaController;
    }

    public ClienteController getClienteController() {
        return clienteController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public ProblemaActivistaController getProblemaActivistaController() {
        return problemaActivistaController;
    }

    public void setProblemaActivistaController(ProblemaActivistaController problemaActivistaController) {
        this.problemaActivistaController = problemaActivistaController;
    }

    public ProblemaController getProblemaController() {
        return problemaController;
    }

    public void setProblemaController(ProblemaController problemaController) {
        this.problemaController = problemaController;
    }
}
