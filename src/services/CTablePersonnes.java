/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import BDD.CBDD;
import BDD.CParametresStockageBDD;
import entites.CPersonne;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Damien
 */
public class CTablePersonnes {

    CBDD bdd;

    public int insererPersonne(CPersonne personne) {
        int res = -1;
        if (bdd.connecter()) {
            String requete = "INSERT INTO `coordonnees` (`Nom`, `Prenom`) "
                    + "VALUES ('"
                    + personne.getNom() + "', '"
                    + personne.getPrenom() + "')";

            res = bdd.executerRequeteUpdate(requete);
            bdd.deconnecter();
        } else {
            System.out.println("Connexion KO");
        }
        return res;
    }

    public CPersonne lirePersonne(int id) {

        if (bdd.connecter()) {
            String requete = "Select * from coordonnees where id=" + id;
            ResultSet rs = bdd.executerRequeteQuery(requete);
            try {
                if (rs.next()) {
                    CPersonne personne = new CPersonne();
                    personne.setId(rs.getInt("id"));
                    personne.setNom(rs.getString("Nom"));
                    personne.setPrenom(rs.getString("Prenom"));
                    return personne;
                } else {
                    System.err.println("C'est vide.");
                    JOptionPane.showMessageDialog(null, "C'est Vide.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CTablePersonnes.class.getName()).log(Level.SEVERE, null, ex);
            }
            bdd.deconnecter();
        }
        return null;
    }

    public static void main(String[] args) {
        CTablePersonnes table = new CTablePersonnes();
        table.bdd = new CBDD(new CParametresStockageBDD("parametresBdd.properties"));

//        CPersonne unePersonne = new CPersonne();
//        unePersonne.setNom("Franky");
//        unePersonne.setPrenom("Victor");
//
//        table.insererPersonne(unePersonne);
        System.out.println(table.lirePersonne(3));

    }
}
