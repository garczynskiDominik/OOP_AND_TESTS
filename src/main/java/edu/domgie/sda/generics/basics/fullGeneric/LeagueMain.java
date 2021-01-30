package edu.domgie.sda.generics.basics.fullGeneric;

import edu.domgie.sda.generics.basics.FootballTeam;
import edu.domgie.sda.generics.basics.Team;
import edu.domgie.sda.generics.basics.TeamLevel;
import edu.domgie.sda.generics.basics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League league = new League("Pirmiera");
        Team team1 = new FootballTeam("FC Barcelona");
        Team team2 = new FootballTeam("Atlrtico");
        Team team3 = new FootballTeam("Real");
        Team team4 = new FootballTeam("Valencia");
        team1.setPoints(20);
        team2.setPoints(25);
        team3.setPoints(28);
        team4.setPoints(29);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);
        league.printTable();
        System.out.println("- ---  - - - - -- - - - - - - -");
        Team team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        league.addTeam(team5);
        team5.setPoints(27);
        league.printTable();
    }
}
