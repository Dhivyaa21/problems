import java.util.Objects;

public class Basics {
    public static void main(String[] args) {
        A a = new A();
        a.x = 1;
        a.y = 2;
        A a1 = a;
        a1.x = 3;
        a1.y = 4;
        A a2 = new A();
        a2.x = 3;
        a2.y = 4;
        System.out.println(a1 == a);
        System.out.println(a1.equals(a2));
        System.out.println(a.x + " " + a.y);

        String s = "hello";
        s = "hey";
        System.out.println(s);
    }
}

class A {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return x == a.x &&
                y == a.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
