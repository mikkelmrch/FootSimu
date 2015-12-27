
import java.util.ArrayList;
import java.util.UUID;

/*
 * The TeamLineUp class has the responsibility of setting a club's lineup to a match. That is, the players that
 * are to play in the match. Also, it contains information about the mentality and formation the club has chosen
 * to go with for a match. 
 */

/**
 * This class makes use of the strategy pattern, as it aggregates a mentality and a formation class, which are 
 * interfaces for different behaviours in regard to the mentality and formation with which a club plays a match.
 * 
 * There are three different mentality behaviors: AttackingMentality, DefensiveMentality and BalancedMentality.
 * And three different formations: fourfourtwo, fourthreethree and fourfiveone.
 * 
 * The implementation of said behaviours has no effect on a match as it is now. The only thing that has been
 * implemented is a print to the console indicating the chosen behaviour.
 */

/**
 *
 * @author mikkelmoerch
 */
public class TeamLineUp {
    
    private ArrayList<UUID> players = new ArrayList<>();
    private Mentality mentality = new BalancedMentality();
    private Formation formation = new fourfourtwo();
    
    private UUID goalkeeper;
    private UUID leftback;
    private ArrayList<UUID> centerBack;
    private UUID rightback;
    
    private UUID leftMid;
    private ArrayList<UUID> centerMids;
    private UUID rightMid;
    
    private ArrayList<UUID> strikers;
    
    public void add(Player p){
        players.add(p.getID());
    }
    
    public void addPlayerToLineup(Player p, String position){
        switch(position){
            case "goalkeeper":
                this.goalkeeper = p.getID();
                break;
            case "leftback":
                this.leftback = p.getID();
                break;
            case "centerBack":
                this.centerBack.add(p.getID());
                break;
            case "rightback":
                this.rightback = p.getID();
                break;
            case "rightMid":
                this.rightMid = p.getID();
                break;
            case "centerMid":
                this.centerMids.add(p.getID());
                break;
            case "leftMid":
                this.leftMid = p.getID();
                break;
            case "strikers":
                this.strikers.add(p.getID());
                break;
            default: System.out.println("Invalid type of position");
            break;
        }
    }
    
    public ArrayList<UUID> getPlayersInLineup(){
        return this.players;
    }
    
    public UUID getGoalie(){
        return this.goalkeeper;
    }
    
    public UUID getLBack(){
        return this.leftback;
    }
    
    public UUID getRBack(){
        return this.rightback;
    }
    
    public UUID getCBack(int index){
        return this.centerBack.get(index);
    }
    
    public UUID getLMid(){
        return this.leftMid;
    }
    
    public UUID getRMid(){
        return this.rightMid;
    }
    
    public UUID getCMid(int index){
        return this.centerMids.get(index);
    }
    
    public UUID getStriker(int index){
        return this.strikers.get(index);
    }
    
    public void setMentality(Mentality newMentality){
        this.mentality = newMentality;
    }
    
    public void setFormation(Formation newFormation){
        this.formation = newFormation;
    }
    
    public void Play(){
        this.formation.PlayWithFormation();
        this.mentality.PlayWithMentality();
    }
}
