
import java.time.Duration;
/*
 * The Match class contains information about a match between two clubs.
 */

/**
 *
 * @author mikkelmoerch
 */
public class Match {
    
    private Club home;
    private Club away;
    private double homeRating;
    private double awayRating;
    private boolean isPlayed = false;
    
    private double randomFactor;
    
    private int homeGoals;
    private int awayGoals;
    
    /** It probably must be adressed as chance of creating a chance per 10th minut */
    private double homeChancesEveryTenth;
    private double awayChancesEveryTenth;
    
    private double homeChanceOfScoring;
    private double awayChanceOfScoring;
    
    public Match(Club home, Club away){
        this.home = home;
        this.away = away;
        this.homeRating = home.getTeamRating();
        this.awayRating = away.getTeamRating();
    }
    
    public void setHome(Club club){
        this.home = club;
    }
    
    public void setAway(Club club){
        this.away = club;
    }
    
    public String getHomeName(){
        return this.home.getName();
    }
    
    public String getAwayName(){
        return this.away.getName();
    }
    
    public Club getHomeClub(){
        return this.home;
    }
    
    public Club getAwayClub(){
        return this.away;
    }
    
    public double getHomeRating(){
        return this.homeRating;
    }
    
    public double getAwayRating(){
        return this.awayRating;
    }
    
    public int getHomeGoals(){
        return this.homeGoals;
    }
    
    public int getAwayGoals(){
        return this.awayGoals;
    }
    
    public String getScore(){
        String score = getHomeGoals() + " - " + getAwayGoals();
        return score;
    }
    
    public boolean homeIsBetter(){
        return (this.homeRating > this.awayRating);
    }
    
    public double overallTeamEvaluation(){
        double percentageBetter = 0;
        
        if(this.homeRating > this.awayRating){
            percentageBetter = (this.homeRating / this.awayRating);
        } else if(this.awayRating > this.homeRating){
            percentageBetter = (this.awayRating / this.homeRating);
        } else {
            percentageBetter = 1;
        }
        return percentageBetter;
    }
    
    public void amountOfChancesCreated(){
        /** Random factor which is above 0 and less than 1 */
        randomFactor = Math.random();
        
        /** If the better team has an overall rating that's 9 percentage larger than
         * the other team, its random factor of creating a chance will be increased
         * by 9 percentage of its original value.
         */
        
        if(homeIsBetter()){
            // Home
            randomFactor = (randomFactor * overallTeamEvaluation());
            this.homeChancesEveryTenth = randomFactor;
            //System.out.println("Chances every 10th minute for "+ getHomeName() + " is " + this.homeChancesEveryTenth);
            // Away
            this.awayChancesEveryTenth = Math.random();
            //System.out.println("Chances every 10th minute for "+ getAwayName() + " is " + this.awayChancesEveryTenth);
            //System.out.println("-------------------------------------------------");
        } else {
            // Away
            randomFactor = (randomFactor * overallTeamEvaluation());
            this.awayChancesEveryTenth = randomFactor;
            //System.out.println("Chances every 10th minute for "+ getAwayName() + " is " + this.awayChancesEveryTenth);
            // Home
            this.homeChancesEveryTenth = Math.random();
            //System.out.println("Chances every 10th minute for "+ getHomeName() + " is " + this.homeChancesEveryTenth);
            //System.out.println("-------------------------------------------------");
        }
    }
    
    public void chanceOfScoring(){
        /** Random factor which is above 0 and less than 1 */
        randomFactor = Math.random();
        
        if(homeIsBetter()){
            // Difference in rating
            randomFactor = (randomFactor * overallTeamEvaluation());
            this.homeChanceOfScoring = randomFactor;
            this.awayChanceOfScoring = Math.random();
            //System.out.println(getAwayName()+"'s chance of scoring is " + (this.awayChanceOfScoring));
            //System.out.println(getHomeName()+"'s chance of scoring is " + (this.homeChanceOfScoring));
                if(this.homeChanceOfScoring > 0.85){
                    this.homeGoals = this.homeGoals + 1;
                    //System.out.println(getHomeName() + " has scored. It's " + getHomeGoals() + " - " + getAwayGoals());
                }
                if(this.awayChanceOfScoring > 0.85){
                    this.awayGoals = this.awayGoals + 1;
                    //System.out.println(getAwayName() + " has scored. It's " + getHomeGoals() + " - " + getAwayGoals());
                }
        } else {
            randomFactor = (randomFactor * overallTeamEvaluation());
            this.awayChanceOfScoring = randomFactor;
            this.homeChanceOfScoring = Math.random();
            //System.out.println(getAwayName()+"'s chance of scoring is " + (this.awayChanceOfScoring));
            //System.out.println(getHomeName()+"'s chance of scoring is " + (this.homeChanceOfScoring));
                if(this.awayChanceOfScoring > 0.85){
                    this.awayGoals = this.awayGoals + 1;
                    //System.out.println(getAwayName() + " has scored. It's " + getHomeGoals() + " - " + getAwayGoals());
                }
                if(this.homeChanceOfScoring > 0.85){
                    this.homeGoals = this.homeGoals + 1;
                    //System.out.println(getHomeName() + " has scored. It's " + getHomeGoals() + " - " + getAwayGoals());
                }
        }
    }
    
    public void matchIsPlayed(){
        this.isPlayed = true;
    }
    
    public void informClubPerformance(){
        if(this.isPlayed){
            
            // if Home side has won
            if(getHomeGoals() > getAwayGoals()){
                // Add to wins and losses
                getHomeClub().getClubPerformance().hasWon();
                getAwayClub().getClubPerformance().hasLost();
                
            // if Away side has won
            } else if(getAwayGoals() > getHomeGoals()){
                // Add to wins and losses
                getHomeClub().getClubPerformance().hasLost();
                getAwayClub().getClubPerformance().hasWon();
                
            // if Match was drawn
            } else {
                // Add to wins and losses
                getHomeClub().getClubPerformance().hasDrawn();
                getAwayClub().getClubPerformance().hasDrawn();
            }
            // Add to goal scores
            getHomeClub().getClubPerformance().setGoalsScored(this.getHomeGoals());
            getAwayClub().getClubPerformance().setGoalsScored(this.getAwayGoals());
            // Add to goal scored against
            getHomeClub().getClubPerformance().setGoalsAgainst(this.getAwayGoals());
            getAwayClub().getClubPerformance().setGoalsAgainst(this.getHomeGoals());
            // Add to games played
            getHomeClub().getClubPerformance().setGP();
            getAwayClub().getClubPerformance().setGP();
        }
    }
    
}