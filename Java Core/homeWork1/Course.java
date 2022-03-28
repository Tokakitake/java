package homeWork1;

public class Course {

    public Lane[] lanes;

    public Course(Lane[] lanes) {
        this.lanes = lanes;
    }

    static class Lane {
        int distance;

        public Lane(int distance) {
            this.distance = distance;

        }

        public String run(Member member) {
            if(member.getDistance() >= distance) {
                return " Участник: " + member.getName() +
                       ", Возраст: " + member.getAge() +
                       ", пробежал дистанцию " + distance +
                       "м.";
            }
            else {
                return " Участник: " + member.getName() +
                        ", Возраст: " + member.getAge() +
                        ", не может пробежать " + distance +
                        " м.";
            }
        }
    }
}
