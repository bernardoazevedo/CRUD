package Main;

import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("-=-=- Cadastro de produtos -=-=-");

        View prodView = new View();
        Controller prodController = new Controller(prodView);

        prodView.menu(prodController);
    }
}
