package test;

public class Animal {
    private String name = "animal";
    {
        System.out.println("Animal构造代码块");
    }

    static {
        System.out.println("Animal静态代码块");
    }

    public Animal() {
        System.out.println("Animal构造方法");
    }

    static class Cat extends Animal {
        private String name  = "cat";
        {
            System.out.println("Cat构造代码块");
        }

        static {
            System.out.println("Cat静态代码块");
        }

        public Cat() {
            System.out.println("Cat构造方法");
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", name='" + name + '\'' +
                    "} " + super.toString();
        }

        public static void main(String[] args) {
            Animal animal = new Cat();
            System.out.println("---------------");
            Cat cat = new Cat();
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
