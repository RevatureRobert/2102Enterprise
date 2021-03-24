package dev.enterprise.intro;

/**
 *                  everywhere          subclasses          package             inside class
 *  public              X                   X                   X                   X
 *  protected           O                   X                   X                   X
 *  default             O                   O                   X                   X
 *  private             O                   O                   O                   X
 */
public class Person {
    int age;
    String firstName;
    String lastName;

    public final void talk(){
        System.out.println("hey im saying something");
    }

    public void moveBox(Object box){

    }


    Person(){

    }
    public static void main(String[] args) {
        Person p = new Person();
        p.age=17;
        p.talk();
    }


}
