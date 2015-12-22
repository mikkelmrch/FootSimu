
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
    private UUID id;
    
    public Club(String name, int year){
        this.clubName = name;
        this.year = year;
        this.id = UUID.randomUUID();
        this.players = new ArrayList<UUID>();
        PlayerFactory.CLUBS.add(this);
    }
    
    public void addPlayerToClub(Player p){
        this.players.add(p.getID());
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
}
