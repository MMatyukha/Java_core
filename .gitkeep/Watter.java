public class Watter extends Obstacle {
    private int dist;

    public Watter(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(dist);
    }
}
