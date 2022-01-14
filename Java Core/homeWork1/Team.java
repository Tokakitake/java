package homeWork1;

public class Team {

    private final String teamName;
    public Member[] roster;

    public Team(String teamName, Member[] roster) {
        this.roster = roster;
        this.teamName = teamName;
    }

    public void allMembers() {
           for (int i = 0; i < roster.length; i++) {
               System.out.println("Участник: " + roster[i].getName() +
                                  " возраст: " + roster[i].getAge() +
                                  " метровка: " + roster[i].getDistance() +
                                  "м.");
           }
    }

    public String getTeamName() {
        return teamName;
    }
}
