package DAO;

import file.Collocation;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import file.Colloque;
import java.util.ArrayList;

public abstract class ColloqueDAO extends dao<Colloque> {

    public Colloque find(long id) {
        Colloque p = new Colloque();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM colloque WHERE num_col = " + id);

            if (result.first()) {
                p = new Colloque(id, result.getString("intitule"),
                        result.getString("date_debut"),
                        result.getInt("nb_part_max"),
                        result.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public Colloque create(Colloque obj) {
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT num_col from colloque as num_col");
            if (result.first()) {
                long id = result.getLong("num_col");
                PreparedStatement prepare = this.connect.prepareStatement(
                        "INSERT INTO colloque (intitule,date_debut,nb_part_max,description) VALUES(?,?,?,?)");
                prepare.setString(1, obj.getIntitule());
                prepare.setString(2, obj.getDate_debut());
                prepare.setInt(3, obj.getNb_de_part());
                prepare.setString(4, obj.getDescription());

                prepare.executeUpdate();
                obj = this.find(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public Colloque update(Colloque obj) {
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                            "UPDATE colloque SET intitule = '" + obj.getIntitule() + "'" + " WHERE num_col= " + obj.getNum_col());

            obj = this.find(obj.getNum_col());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public void delete(Colloque obj) {
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM colloque WHERE num_col = " + obj.getNum_col());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Colloque> getAll() {
        ArrayList<Colloque> lesCollocations = new ArrayList();
        try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM colloque");
            while (result.next()) {
                long num = result.getInt("num_col");
                String intitule = result.getString("intitule");
                String dateDebut = result.getString("date_debut");
                int nb = result.getInt("nb_part_max");
                String description = result.getString("description");
                lesCollocations.add(new Colloque(num, intitule, dateDebut, nb, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesCollocations;
    }
}
