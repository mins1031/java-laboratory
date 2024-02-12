package java_lab.inheritance.inheritance2;

public class ExtendsMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물");
        Mammal mammal = new Mammal("포유류");
        Bird bird = new Bird("조류");
        Whale whale = new Whale("고래");
        Bat bat = new Bat("박쥐");
        Sparrow sparrow = new Sparrow("참새");
        Penguin penguin = new Penguin("팽귄");

        animal.showMe();
        mammal.showMe();
        bird.showMe();
        whale.showMe();
        bat.showMe();
        sparrow.showMe();
        penguin.showMe();
    }
}
