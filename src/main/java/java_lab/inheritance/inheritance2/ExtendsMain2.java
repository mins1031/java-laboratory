package java_lab.inheritance.inheritance2;

public class ExtendsMain2 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물");
        Animal mammal = new Mammal("포유류");
        Animal bird = new Bird("조류");
        Animal whale = new Whale("고래");
        Animal bat = new Bat("박쥐");
        Animal sparrow = new Sparrow("참새");
        Animal penguin = new Penguin("팽귄");

        animal.showMe();
        mammal.showMe();
        bird.showMe();
        whale.showMe();
        bat.showMe();
        sparrow.showMe();
        penguin.showMe();
    }
}
