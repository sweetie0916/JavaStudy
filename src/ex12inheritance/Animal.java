package ex12inheritance;
 
public class Animal {
   String species;
   int age;
   String gender;
   
   public void showAnimal() {
      System.out.println("species = "+ species);
      System.out.println("age = "+ age);
      System.out.println("gender = "+ gender);
   }
   public Animal(String species, int age, String gender) {
      this.species = species;
      this.age = age;
      this.gender = gender;
   }
}