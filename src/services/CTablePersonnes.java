/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BDD.CBDD;
import entites.CPersonne;

/**
 *
 * @author Damien
 */
public class CTablePersonnes {

    CBDD bdd;
    
    public void insererPersonne(CPersonne personne){
    String requete = "INSERT INTO `coordonnées` (`Nom`, `Prénom`) VALUES ('"+ personne.getNom() +"', '')";
    }
}
