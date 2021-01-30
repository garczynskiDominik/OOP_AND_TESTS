package edu.domgie.sda.generics.basics;

public class FootballTeam extends Team{
    private TeamLevel teamLevel;

    public FootballTeam(String name, TeamLevel teamLevel) {
        //
        this(name);
        this.teamLevel = teamLevel;
    }

    public FootballTeam(String name) {
        super(name);
    }
}
