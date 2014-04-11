package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import file.Personne;

public class CsvParticipantsDAO extends ParticipantsDAO<Personne>{
	static String temp[];
	static ArrayList<Personne> participants = new ArrayList<Personne>();
	static Personne value = null;
	
	public void AllParticipants(String file, String delimiter) throws IOException{
		try{
			String line = null;
			StringTokenizer strTocken = null;
			BufferedReader bufferReader;
			int lineID;
			
			//Ouverture du fichier
			bufferReader = new BufferedReader(new FileReader(file));
			
			while((line=bufferReader.readLine()) != null){
				lineID = 0;
				
				strTocken = new StringTokenizer(line,delimiter);
				while(strTocken.hasMoreElements()){
					temp[lineID] = strTocken.nextToken();
					lineID++;
				}
				value = new Personne(temp[0], temp[1], temp[2], temp[3]);
				participants.add(value);
			}
		}
		catch(SecurityException e){
			System.out.println(e.toString());
		}
	}
	
	public void afficher() throws IOException{
		System.out.println(participants.toString());
	}
}
