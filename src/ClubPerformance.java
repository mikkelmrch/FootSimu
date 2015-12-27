
import java.util.Date;
import java.util.UUID;

/*
 * ClubPerformance is a Club's overview of its performance throughout a season.
 */

/**
 *
 * @author mikkelmoerch
 */
public class ClubPerformance implements Comparable<ClubPerformance> {
    
    private Club club;
    private int season;
    //private Date season;
    private int gamesPlayed = 0;
    private int points = 0;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private int goals = 0;
    private int goalsAgainst = 0;
    private final UUID CPid = UUID.randomUUID();
    
    public ClubPerformance(Club club, int season){
        this.club = club;
        this.season = season;
    }
    
    public Club getClub(){
        return this.club;
    }
    
    public int getGP(){
        return this.gamesPlayed;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public int getWins(){
        return this.wins;
    }
    
    public int getLosses(){
        return this.losses;
    }
    
    public int getDraws(){
        return this.draws;
    }
    
    public int getGoals(){
        return this.goals;
    }
    
    public int getGoalsAgains(){
        return this.goalsAgainst;
    }
    
    public void setGP(){
        this.gamesPlayed = this.gamesPlayed + 1;
    }
    
    public void hasWon(){
        this.wins = this.wins + 1;
        this.points = this.points + 3;
    }
    
    public void hasLost(){
        this.losses = this.losses + 1;
    }
    
    public void hasDrawn(){
        this.draws = this.draws + 1;
        this.points = this.points + 1;
    }
    
    public void setGoalsScored(int g){
        this.goals = this.goals + g;
    }
    
    public void setGoalsAgainst(int g){
        this.goalsAgainst = this.goalsAgainst + g;
    }
    
    public UUID getID(){
        return this.CPid;
    }
    
    @Override
    public int compareTo(ClubPerformance c) {
        return new Integer(c.getPoints()).compareTo(this.getPoints());
    }
}
