package homeWork1;

/**
 * Java Core HomeWork 1
 * @author Muratov Nail
 * @version 14.01.2022
 */

public class Main {

    public static void main(String[] args) {

        Member[] members = {
                new Member("Василий", 20, 200),
                new Member("Витя", 18, 500),
                new Member("Макс", 18, 30),
                new Member("Алекс", 17, 1200)
        };

        Course.Lane[] courses = {
                new Course.Lane(30),
                new Course.Lane(200),
                new Course.Lane(500),
                new Course.Lane(1200)
        };

        Team hope = new Team("Hope", members);
        Course allLanes = new Course(courses);

        //отобразить всех участников команды
        System.out.println("Команда " + hope.getTeamName());
        hope.allMembers();

        //отобразить кто пробежал, а кто нет
        for (int i = 0; i < allLanes.lanes.length; i++) {
            System.out.println("");
            for(int j = 0; j < hope.roster.length; j++) {
                System.out.println(allLanes.lanes[i].run(hope.roster[j]));
            }
        }
    }
}
