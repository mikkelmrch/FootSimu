import java.util.Random;
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
    
    /** Morale: how happy and in-form a player is currently. 
     * Has an index at 100. That is, when a player's morale index is above 100,
     * it has a positive impact on his performance through his overall skill 
     * level and similarly when below 60 a negative impact.
     * 
     * A player gets a morale boost when winning a match and experiences a fall
     * in morale when loosing a match.  
     * 
     * No change when a match is drawn. However, this could be changed:
     *  - Expectations to a match could be introduced.
     *  - Determining the favourite to win by comparing overall ratings.
     *  - Thus, a clear favourite could loss morale points if they do manage to win.
     *    And an underdog could gain morale points if they do not loss to a clear favourite.
     *  - Also, a favourite gains little to nothing if he wins. And a clear underdog looses
     *    only little if he does lose. 
     */ 
    final double moraleIndex = 100;
    double morale = 100;
    
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
        this.shooting = new Random().nextInt(9);
        this.passing = new Random().nextInt(9);
        this.marking = new Random().nextInt(9);
        this.tackling = new Random().nextInt(9);
        this.pace = new Random().nextInt(9);
        this.strength = new Random().nextInt(9);
        this.stamina = new Random().nextInt(9);
    }
    
    public int getOverallRating(){
        int overall = 0;
        overall = getShooting()+getPassing()+getMarking()+getTackling()+getPace()+getStrength()+getStamina();
        return overall;
    }
    
    public double getOverallRatingWithMorale(){
                double overall = 0;
        overall = getShooting()+getPassing()+getMarking()+getTackling()+getPace()+getStrength()+getStamina();
        
        /** This has to be moved as we do not want the impact by the morale to be displayed. */
        //Impact by Player's morale
        double index = getMorale()/this.moraleIndex;
        overall = overall * index;
        
        return overall;
    }
    
    public int getOffensiveRating(){
        int off = 0;
        off = getShooting()+getPassing();
        return off;
    }
    
    public int getDefensiveRating(){
        int def = 0;
        def = getMarking()+getTackling();
        return def;
    }
    
    public int getShooting(){
        return this.shooting;
    }
    
    public int getPassing(){
        return this.passing;
    }
    
    public int getMarking(){
        return this.marking;
    }
    
    public int getTackling(){
        return this.tackling;
    }
    
    public int getPace(){
        return this.pace;
    }
    
    public int getStrength(){
        return this.strength;
    }
    
    public int getStamina(){
        return this.stamina;
    }
    
    public double getMorale(){
        return this.morale;
    }
    
    public void increaseMorale(){
        // Morale can't be above 110
        if(getMorale() < 110){
        this.morale = 1.01 * this.morale;
        }
    }
    
    public void decreaseMorale(){
        // Morale can't be below 90
        if(getMorale() > 90){
        this.morale = 0.99 * this.morale;
        }
    }
    
    @Override
    public int compareTo(Player p){
        return this.getName().compareTo(p.getName());
    }
}
