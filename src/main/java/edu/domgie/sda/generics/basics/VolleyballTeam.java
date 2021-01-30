package edu.domgie.sda.generics.basics;

public class VolleyballTeam extends Team{
    private  TeamLevel teamLevel;

    public VolleyballTeam(String name, TeamLevel teamLevel) {
        super(name);
        this.teamLevel = teamLevel;
    }

    public TeamLevel getTeamLevel() {
        return teamLevel;
    }

    @Override
    public String getName() {
        return "Siatkarska druzyna: "+ super.getName();
    }
}
