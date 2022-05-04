package Chapter3;

public class Apple {
    int weight;
    Color color = Color.GREEN;
    Apple(){}
    Apple(int weight) {
        this.weight = weight;
    }

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
