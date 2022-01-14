/**
 * Java level 1 HomeWork 5
 * @author Muratov Nail
 * @version 26.12.2021
 */

class HomeWork5 {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Max Payn", "Cop", "Payn@mail.com", "001", 5000, 44),
                new Employee("Rudolf Konevkiy", "Trainee", "Konevkiy@mail.com", "002", 2500, 25),
                new Employee("Andrey Nelyubov", "Lead", "Nelyubov@mail.com", "003", 5000, 56),
                new Employee("Svetlana Altunina", "Engineer", "Altunina@mail.com", "004", 3500, 40),
                new Employee("Nataliya Nikulina", "trainee", "Nikulina@mail.com", "005", 2500, 20),
                new Employee("Oleg Mecheryakov", "Engineer", "Mecheryakov@mail.com", "006", 3500, 39),
                new Employee("Olga Nelyubova", "trainee", "Nelyubova@mail.com", "007", 2500, 22)
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private String post;
    private String email;
    private String phone;
    private int pay;
    private int age;

    public Employee(String name, String post, String email, String phone, int pay, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.pay = pay;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return (name + "\n Post:" + post + "\n Email:" + email + "\n Phone:" + phone + "\n Payment:" + pay + "\n Age:" + age);
    }
}