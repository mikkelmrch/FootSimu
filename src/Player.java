
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
public class Player extends Person implements Comparable<Player> {

    /**
     * Eventually player stats as instance variables:
     * 
     * Basic:
     * String position
     * String footed
     * int height
     * int weight
     * 
     * Technical:
     * int finishing
     * int passing
     * int crossing
     */
    
    /** attacking **/
    int shooting;
    int passing;
    
    /** defending **/
    int marking;
    int tackling;
    
    /** physical **/
    int pace;
    int strength;
    int stamina;
    
    String position;
    
   /**
    * 
    * @param age
    * @param firstname
    * @param surname
    * @param club 
    */
    public Player(int age, String firstname, String surname, Club club){
        super(age, firstname, surname, club);
    }
    
    public Player(String firstname, String lastname){
        super(firstname, lastname);
    }
    
    @Override
    public int compareTo(Player p){
        return this.getName().compareTo(p.getName());
    }
}
