
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/*
 * The league class contains an overview of all Club's performances throughout a season.
 */

/**
 *
 * @author mikkelmoerch
 */
public class League {
    private ArrayList<Match> results = new ArrayList<>();
    //private Date season;
    private ArrayList<UUID> clubPerformances = new ArrayList<>();
    
    public ArrayList<Match> getResults(){
        return this.results;
    }
    
    public ArrayList<UUID> getCPList(){
        return this.clubPerformances;
    }
    
    public ClubPerformance getCP(UUID id){
        for(int i = 0; i < PersonFactory.CLUBS.size(); i++){
            if((PersonFactory.CLUBS.get(i).getClubPerformance().getID()).equals(id)){
                return PersonFactory.CLUBS.get(i).getClubPerformance();
            }
        }
        return null;
    }
    
    public void addMatch(Match m){
        // Add to arrayList of matches
        results.add(m);
        // Add to CP list if they're not already added
        if(!checkHomeCPList(m)){
            clubPerformances.add(m.getHomeClub().getClubPerformance().getID());
        }
        if(!checkAwayCPList(m)){
            clubPerformances.add(m.getAwayClub().getClubPerformance().getID());
        }
    }
    
    public boolean checkHomeCPList(Match m){
        ArrayList<UUID> list = getCPList();
        if(list.size() == 0){
            return false;
        } else {

            for(int i = 0; i < list.size(); i++){
                if(m.getHomeClub().getClubPerformance().getID().equals(list.get(i))){
                    //System.out.println("The ID of the home side: " + m.getHomeClub().getClubPerformance().getID());
                    return true;
                }
            }
        }
        System.out.println("The ID of the home side: " + m.getHomeClub().getClubPerformance().getID());
        return false;
    }
    
    public boolean checkAwayCPList(Match m){
        ArrayList<UUID> list = getCPList();
        
        if(list.size() == 0){
            return false;
        } else {
            for(int i = 0; i < list.size(); i++){
                if(m.getAwayClub().getClubPerformance().getID().equals(list.get(i))){
                        return true;
                }
            }
        }
        return false;
    }

}
