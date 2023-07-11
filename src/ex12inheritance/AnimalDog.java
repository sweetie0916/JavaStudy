package ex12inheritance;

public class AnimalDog extends Animal {
   String dogKind;
   String name;
   
   public void bark() {
      System.out.println("이름이 "+ name +"이고 종(포유류)이 " + dogKind +"인 강아지가 짖는다.");
   }
   
   public void showDog() {
      System.out.println("dogKind = "+ dogKind);
      System.out.println("name = "+ name);
   }
   
   public AnimalDog(String species, int age, String gender, String dogKind, String name) {
      super(species, age, gender);
      this.dogKind = dogKind;
      this.name = name;
   }
   
}