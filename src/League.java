
import java.util.ArrayList;
import java.util.Collections;
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
    private UUID id = UUID.randomUUID();
    private ArrayList<Match> results = new ArrayList<>();
    //private Date season;
    private ArrayList<UUID> clubPerformances = new ArrayList<>();
    
    public League(){
        
    }
    
    public ArrayList<Match> getResults(){
        return this.results;
    }
    
    public ArrayList<UUID> getCPList(){
        return this.clubPerformances;
    }
    
    public ClubPerformance getCP(UUID id){
        for(int i = 0; i < Factory.CLUBS.size(); i++){
            if((Factory.CLUBS.get(i).getClubPerformance(Factory.seasonCount).getID()).equals(id)){
                return Factory.CLUBS.get(i).getClubPerformance(Factory.seasonCount);
            }
        }
        return null;
    }
    
    public void addMatch(Match m){
        // Add to arrayList of matches
        results.add(m);
        // Add to CP list if they're not already added
        if(!checkHomeCPList(m)){
            clubPerformances.add(m.getHomeClub().getClubPerformance(Factory.seasonCount).getID());
        }
        if(!checkAwayCPList(m)){
            clubPerformances.add(m.getAwayClub().getClubPerformance(Factory.seasonCount).getID());
        }
    }
    
    /**
     * Checks if the home side of a match has been added to the list of ClubPerformances 
     * @param m The match that has been played
     * @return TRUE if the club already has been added
     */
    public boolean checkHomeCPList(Match m){
        ArrayList<UUID> list = getCPList();
        if(list.size() == 0){
            return false;
        } else {

            for(int i = 0; i < list.size(); i++){
                if(m.getHomeClub().getClubPerformance(Factory.seasonCount).getID().equals(list.get(i))){
                    //System.out.println("The ID of the home side: " + m.getHomeClub().getClubPerformance().getID());
                    return true;
                }
            }
        }
        System.out.println("The ID of the home side: " + m.getHomeClub().getClubPerformance(Factory.seasonCount).getID());
        return false;
    }
    
    /**
     * Checks if the away side of a match has been added to the list of ClubPerformances.
     * @param m The match that has been played.
     * @return TRUE if the club already has been added to the list.
     */
    public boolean checkAwayCPList(Match m){
        ArrayList<UUID> list = getCPList();
        
        if(list.size() == 0){
            return false;
        } else {
            for(int i = 0; i < list.size(); i++){
                if(m.getAwayClub().getClubPerformance(Factory.seasonCount).getID().equals(list.get(i))){
                        return true;
                }
            }
        }
        return false;
    }

    public ArrayList<ClubPerformance> getSortedPlayerList(ArrayList<ClubPerformance> list){
            // Clone the current list of scouting sessions
            ArrayList<ClubPerformance> clonedList = (ArrayList<ClubPerformance>)list.clone();

            // Perform the actual sorting of the list, based on date
            Collections.sort(clonedList);

            // Return the sorted list
            return clonedList;
    }
    
    public UUID getID(){
        return this.id;
    }
}
