
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
public class Player implements Comparable<Player> {
    private int age;
    private String firstName;
    private String lastName;
    private Club club;
    private UUID id;
    
    public Player(int age, String firstname, String lastname, Club club){
        this.age = age;
        this.firstName = firstname;
        this.lastName = lastname;
        this.club = club;
        this.id = UUID.randomUUID();
    }
    
    public Player(String firstname, String lastname){
        this.age = 1;
        this.firstName = firstname;
        this.lastName = lastname;
        this.club = null;
        this.id = UUID.randomUUID();
    }
    
    public UUID getID(){
        return this.id;
    }
    
    public String getName(){
        return this.firstName+" "+this.lastName;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public int compareTo(Player p){
        return this.getName().compareTo(p.getName());
    }
}
