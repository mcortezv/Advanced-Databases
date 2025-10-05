/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;
import DAO.SuperHeroeDAO;
import interfaces.ISuperHeroeDAO;
import models.IdentidadSecreta;
import models.SuperHeroe;
import models.Universo;

import java.util.List;

/**
 *
 * @author Laboratorios
 */
public class JPASuperHeroe {

    public static void main(String[] args) {
        ISuperHeroeDAO dao = new SuperHeroeDAO();

        SuperHeroe batman = new SuperHeroe("Batman",
                Universo.DC,
                new IdentidadSecreta("Bruce Wayne", "Gotham", "Empresario"),
                "Soy Batman");

        SuperHeroe ironMan = new SuperHeroe("IronMan",
                Universo.MARVEL,
                new IdentidadSecreta("Tony Stark", "New York", "Filantropo"),
                "J.A.R.V.I.S. estas ahi?");

        SuperHeroe thor = new SuperHeroe("Thor",
                Universo.MARVEL,
                new IdentidadSecreta("Thor Odinson", "Asgard", "Dios"),
                "Soy Thor Hijo de Odin");

        dao.insertar(batman);
        dao.insertar(ironMan);
        dao.insertar(thor);

        System.out.println("Lista Inicial de SuperHeroes: ");
        List<SuperHeroe> superHeroes = dao.listar();
        for (SuperHeroe e: superHeroes){
            System.out.println(e);
        }

        SuperHeroe ironManBD = dao.buscar(batman.getId());
        ironManBD.setIdentidadSecreta(new IdentidadSecreta("Manuel", "San Jose", "Mecanico"));
        dao.actualizar(ironManBD);

        System.out.println("Lista Actualizada de SuperHeroes: ");
        List<SuperHeroe> superHeroesBD = dao.listar();
        for (SuperHeroe e: superHeroes){
            System.out.println(e);
        }

        dao.eliminar(batman.getId());

        System.out.println("Lista Sin Batman");
        List<SuperHeroe> superHeroesSinBatman = dao.listar();
        for (SuperHeroe e: superHeroes){
            System.out.println(e);
        }
    }
}
