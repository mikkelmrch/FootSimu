
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
    
    public Club(String name, int year){
        this.clubName = name;
        this.year = year;
        this.id = UUID.randomUUID();
        this.players = new ArrayList<UUID>();
        //this.manager = new Manager();
        PersonFactory.CLUBS.add(this);
    }
    
    public void addPlayerToClub(Player p){
        if(this.players.size() <= 28){
            this.players.add(p.getID());
        } else {
            System.out.println("The limit of a total of 28 players in a club has been reached.");
        }
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
