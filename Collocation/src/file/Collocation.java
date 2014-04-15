package file;

import java.io.IOException;
import java.sql.Date;

import DAO.ColloqueDAO;
import DAO.CsvParticipantsDAO;
import DAO.ParticipantsDAO;
import DAO.dao;
import file.FrameCollocation;
import java.util.ArrayList;

public class Collocation {

    public static ArrayList<Personne> lesPersonnes = new ArrayList<Personne>();
    public static ArrayList<Colloque> lesCollocations = new ArrayList<Colloque>();

    public static void main(String[] args) throws IOException {
		//TEST 1
		/*dao<Colloque> colDao = new ColloqueDAO();
		
         System.out.println(colDao.find(1));
		
         Colloque p = new Colloque();

         //Recherche
         p.setIntitule("Test");
         p.setDate_debut(Date.valueOf("1994-11-11"));
         colDao.create(p);
         System.out.println(colDao.find(2));
		
         //Modification
         p.setIntitule("test2");
         p.setNum_col(2);
         colDao.update(p);
         System.out.println(colDao.find(2));
		
         //Suppression
         p.setNum_col(8);
         colDao.delete(p);*/

        new FrameCollocation().setVisible(true);
    }
}
