package edu.domgie.sda.generics.basics.withBoundarles;

import edu.domgie.sda.generics.basics.FootballTeam;
import edu.domgie.sda.generics.basics.Team;
import edu.domgie.sda.generics.basics.TeamLevel;
import edu.domgie.sda.generics.basics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League<FootballTeam> league = new League("Pirmiera");


        FootballTeam team1 = new FootballTeam("FC Barcelona");
        FootballTeam team2 = new FootballTeam("Atlrtico");
        Team team3 = new FootballTeam("Real");
        Team team4 = new FootballTeam("Valencia");
        team1.setPoints(20);
        team2.setPoints(25);
        team3.setPoints(28);
        team4.setPoints(29);
        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam((FootballTeam) team3);
        league.addTeam((FootballTeam) team4);
        league.printTable();
        System.out.println("- ---  - - - - -- - - - - - - -");
        VolleyballTeam team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        team5.setPoints(27);

//        Team team6 = new VolleyballTeam("Zaksa", TeamLevel.PROFESSIONAL);
//        team6.setPoints(35);
//        league.addTeam((FootballTeam) team6);

        league.printTable();

        System.out.println(team5.getName());
    }
}
