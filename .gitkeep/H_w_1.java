public class H_w_1 {
    public static void main(String[] args) {

        Course course = new Course(new Cross(300), new Wall(2),
                new Cross(800), new Watter(5));

        Team team = new Team("Team_team", new Horse("Fran"), new Cat("Tom"),
                new Horse("Snikers"), new Dog("Linda"));



        course.doIt(team);

        System.out.println("\n===== RESULTS =====\n");
        team.showResults();
        System.out.println();

    }
}
