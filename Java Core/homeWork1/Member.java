package homeWork1;

public class Member {

    private final int distance;
    private final String name;
    private final int age;

    public Member(String name, int age, int distance) {
        this.name = name;
        this.age = age;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
