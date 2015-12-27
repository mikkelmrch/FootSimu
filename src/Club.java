import java.util.ArrayList;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Club {
    private ArrayList<UUID> players;
    private String clubName;
    private int year;
    private UUID manager;
    private UUID id;
    private ClubPerformance season;
    private TeamLineUp lineup;
    
    /**
     * Consider employing a new class 'TeamLineup' aggregated into Club, which
     * among other holds attributes that has to do with preparations for a match:
     * 
     * private ArrayList<UUID> firstXI;
     * private ArrayList<UUID> substitutes;
     * private String tactics;
     * private String formation;
     * 
     */
    
    public Club(String name, int year){
        this.clubName = name;
        this.year = year;
        this.id = UUID.randomUUID();
        this.players = new ArrayList<UUID>();
        this.season = new ClubPerformance(this);
        this.lineup = new TeamLineUp();
        PersonFactory.CLUBS.add(this);
    }
    
    public void addPlayerToClub(Player p){
        if(this.players.size() <= 28){
            this.players.add(p.getID());
        } else {
            System.out.println("The limit of a total of 28 players in a club has been reached.");
        }
    }
    
    public int getTeamRating(){
        int overall = 0;
            for(UUID id : players){
                Player p = (Player) getPersonByID(id);
                overall = overall + p.getOverallRating();
            }
        return overall;
    }
    
    public int getTeamOffensiveRating(){
        int overall = 0;
            for(UUID id : players){
                Player p = (Player) getPersonByID(id);
                overall = overall + p.getOffensiveRating();
            }
        return overall;
    }
    
    public int getTeamDefensiveRating(){
        int overall = 0;
            for(UUID id : players){
                Player p = (Player) getPersonByID(id);
                overall = overall + p.getDefensiveRating();
            }
        return overall;
    }
    
    public Person getPersonByID(UUID id){
        for(Person person : PersonFactory.PERSONS){
            if(person.getID().equals(id)){
                return person;
            }
        }
        return null;
    }
    
    public ClubPerformance getClubPerformance(){
        return this.season;
    }
    
    public TeamLineUp getLineUp(){
        return this.lineup;
    }
    
    public String getName(){
        return this.clubName;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public UUID getID(){
        return this.id;
    }
    
    public ArrayList<UUID> getPlayers(){
        return this.players;
    }
    
    public UUID getManagerID(){
        return this.manager;
    }
    
    public void setManager(UUID m){
        this.manager = m;
    }
}
