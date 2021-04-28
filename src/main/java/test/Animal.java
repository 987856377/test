package test;

public class Animal {
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
        {
            System.out.println("Cat构造代码块");
        }

        static {
            System.out.println("Cat静态代码块");
        }

        public Cat() {
            System.out.println("Cat构造方法");
        }

        public static void main(String[] args) {
            Animal animal = new Cat();
            System.out.println("---------------");
            Cat cat = new Cat();
        }
    }
}
