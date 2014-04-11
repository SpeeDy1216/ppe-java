package DAO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class ParticipantsDAO<T>{

	public abstract void AllParticipants(String file, String delimiter) throws IOException;
	
	public abstract void afficher() throws IOException;
	
}
