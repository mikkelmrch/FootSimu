
import java.time.Duration;
import java.util.ArrayList;
import java.util.UUID;
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
        this.homeRating = home.getTeamRatingWithMorale();
        this.awayRating = away.getTeamRatingWithMorale();
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
    
    public void updatePlayerMorale(Club winner, Club looser){
        
        int winnerDifferenceInRatingToOpponent = winner.getTeamRating() - looser.getTeamRating();
        int looserDifferenceInRatingToOpponent = looser.getTeamRating() - winner.getTeamRating();
        
        for(UUID id : home.getPlayers()){
            Player p = (Player )winner.getPersonByID(id);
            p.increaseMorale(winnerDifferenceInRatingToOpponent);
        }
        
        for(UUID id : looser.getPlayers()){
            Player p = (Player)looser.getPersonByID(id);
            p.decreaseMorale(looserDifferenceInRatingToOpponent);
        }
    }
    
    public void updatePlayerMoraleAfterDraw(Club home, Club away){
        int differenceInRating = home.getTeamRating() - away.getTeamRating();
        
        // If the home side is 30 or more rating points better than away
        if(differenceInRating > 29){
            for(UUID id : home.getPlayers()){
                // decrease home side morale slightly
                Player p = (Player) home.getPersonByID(id);
                p.decreaseMorale(-30);
            }
            for(UUID id : away.getPlayers()){
                // And increase away side morale slightly
                Player p = (Player) away.getPersonByID(id);
                p.increaseMorale(30);
            }
          // If the away side is 30 or more rating points better than away
        } else if(differenceInRating < -29){
            // decrease away side morale slightly
            for(UUID id : away.getPlayers()){
                Player p = (Player) away.getPersonByID(id);
                p.decreaseMorale(-30);
            }
            // and increase home side morale slightly 
            for(UUID id : home.getPlayers()){
                Player p = (Player) home.getPersonByID(id);
                p.increaseMorale(30);
            }
        }
        
        
    }
    
    public void informClubPerformance(){
        if(this.isPlayed){
            
            // if Home side has won
            if(getHomeGoals() > getAwayGoals()){
                // Add to wins and losses
                getHomeClub().getClubPerformance(Factory.seasonCount).hasWon();
                getAwayClub().getClubPerformance(Factory.seasonCount).hasLost();
                
                // Increase home club's players' morale, decrease away club's players' morale.
                updatePlayerMorale(getHomeClub(), getAwayClub());
                
            // if Away side has won
            } else if(getAwayGoals() > getHomeGoals()){
                // Add to wins and losses
                getHomeClub().getClubPerformance(Factory.seasonCount).hasLost();
                getAwayClub().getClubPerformance(Factory.seasonCount).hasWon();
                
                // Increase away club's players' morale, decrease home club's players' morale.
                updatePlayerMorale(getAwayClub(), getHomeClub());
                
            // if Match was drawn
            } else {
                // Add to wins and losses
                getHomeClub().getClubPerformance(Factory.seasonCount).hasDrawn();
                getAwayClub().getClubPerformance(Factory.seasonCount).hasDrawn();
            }
            // Add to goal scores
            getHomeClub().getClubPerformance(Factory.seasonCount).setGoalsScored(this.getHomeGoals());
            getAwayClub().getClubPerformance(Factory.seasonCount).setGoalsScored(this.getAwayGoals());
            // Add to goal scored against
            getHomeClub().getClubPerformance(Factory.seasonCount).setGoalsAgainst(this.getAwayGoals());
            getAwayClub().getClubPerformance(Factory.seasonCount).setGoalsAgainst(this.getHomeGoals());
            // Add to games played
            getHomeClub().getClubPerformance(Factory.seasonCount).setGP();
            getAwayClub().getClubPerformance(Factory.seasonCount).setGP();
        }
    }
    
}