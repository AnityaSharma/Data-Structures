package OOPS.FirstLec;

public class Innerclass {
    static class test{
        String name;

        public test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        test ani = new test("anitya");
        test ani1 = new test("anityaaaaa");
        System.out.println(ani);
        System.out.println(ani1);
    }
}
