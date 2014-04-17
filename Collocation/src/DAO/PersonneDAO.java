package DAO;

import file.Collocation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import file.Personne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonneDAO extends dao<Personne> {

    public ArrayList<Personne> findAll() {
        Personne p = new Personne();
        ArrayList<Personne> t = new ArrayList<Personne>();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM personne");

            while (result.next()) {
                p = new Personne(result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("date_naiss"));
                t.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public Personne findPersonne(String nom, String prenom){
        Personne p = new Personne();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM personne WHERE nom = '" + nom + "' AND prenom ='" + prenom+"'");

            if (result.first()) {
                p = new Personne(result.getInt("num_pers"), 
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("date_naiss"),
                        result.getString("email"),
                        result.getString("organisation"),
                        result.getString("observations"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }
    
    public Personne find(long id) {
        Personne p = new Personne();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM personne WHERE num_pers = " + id);

            if (result.first()) {
                p = new Personne(id, result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("date_naiss"),
                        result.getString("email"),
                        result.getString("organisation"),
                        result.getString("observations"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public Personne create(Personne obj) {
        try {
            PreparedStatement statement = null;
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT num_pers from personne as num_pers");
            if (result.first()) {
                long id = result.getLong("num_pers");

                PreparedStatement prepare = this.connect.prepareStatement(
                        "INSERT INTO personne(nom,prenom,date_naiss,email,organisation,observations) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
                java.util.Date d = format.parse(obj.getDate_naiss());
                long longDate = d.getTime();
                java.sql.Date sqlDate;
                sqlDate = new java.sql.Date(longDate);

                prepare.setString(1, obj.getNom());
                prepare.setString(2, obj.getPrenom());
                prepare.setDate(3, sqlDate);
                prepare.setString(4, obj.getEmail());
                prepare.setString(5, obj.getOrganisation());
                prepare.setString(6, obj.getObservations());

                prepare.executeUpdate();

                ResultSet num = prepare.getGeneratedKeys();
                while (result.next()) {
                    obj.setNum_pers(result.getInt(1));

                }
                obj = this.find(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

    public Personne update(Personne obj) {
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                            "UPDATE personne SET nom = '" + obj.getNom() + "'" + " WHERE num_pers= " + obj.getNum_pers());

            obj = this.find(obj.getNum_pers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public void delete(Personne obj) {
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM personne WHERE num_pers = " + obj.getNum_pers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Personne> getAll() {
        ArrayList<Personne> lesPersonnes = new ArrayList();

        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM personne");
            while (result.next()) {
                long nump = result.getLong("num_pers");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String dateNaiss = result.getString("date_naiss");
                String mail = result.getString("email");
                String organisation = result.getString("organisation");
                String observations = result.getString("observations");
                lesPersonnes.add(new Personne(nump, nom, prenom, dateNaiss, mail, organisation, observations));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        lesPersonnes.add(new Personne());
        return lesPersonnes;
    }
}
