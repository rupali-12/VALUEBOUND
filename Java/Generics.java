public class Generics<T> {
    private T value;

    Generics(T value) {
        this.value = value;
    }

    public <U> void display(U element) {
        System.out.println(element);
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Generics<Integer> g = new Generics<>(124);

        g.display("hello");
        g.display(442);

    }

}
