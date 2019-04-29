package binarytreeimpl;

public class PersonMain {

    public static void main(String[] args) {


        Tree<Person> p = new BST<>();
        p.insertTree(new Person("Adam", 27));
        p.insertTree(new Person("Kevin", 21));
        p.insertTree(new Person("Arnold", 20));
        p.insertTree(new Person("Noel", 34));
        p.insertTree(new Person("Rose", 38));
        p.insertTree(new Person("Joe", 55));
        p.insertTree(new Person("Marko", 68));

        int ageSum = p.getAgeSum();
        System.out.println(ageSum);
    }
}
