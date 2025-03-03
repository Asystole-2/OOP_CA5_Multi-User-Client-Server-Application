package BussinessObjects;

public class menuOptions {

    private final  String[] options = {
            " Display all Entities",
            " Exit\n"};

    public void menuOptions() {
      System.out.println("\n Cinema Info");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s\n", i + 1, options[i]);
        }
        System.out.print("Enter your choice: ");

    };
}
