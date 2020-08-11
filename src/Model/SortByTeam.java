package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SortByTeam implements SortingwithStrategyDesignPattern{
	
	private ArrayList<Player> ArraylistPlayer= new ArrayList<Player>();
	private final String playersFileName = "players.txt";
	
	public SortByTeam() {
		readFile();
	}
	
	@Override
	public Player[] SortByString(String x) {
		 Player[] sortByTeam = new Player[ArraylistPlayer.size()];
		 int j=0;
		 for (int i = 0; i < ArraylistPlayer.size(); i++) 
				if(ArraylistPlayer.get(i).getMyTeam().getTeamName().contentEquals(x))
				{
					sortByTeam[j++] = ArraylistPlayer.get(i);
				}
		return sortByTeam;
	}

	@Override
	public Player[] Sort() {
		// TODO Auto-generated method stub
		return null;
	}
	
	void readFile() {
		  try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(playersFileName))) {
			  ArraylistPlayer = (ArrayList<Player>) input.readObject();
		  } catch (Exception e) {
			  ArraylistPlayer = new ArrayList<Player>();
			  }	
	}
}
