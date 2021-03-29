package map;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        KeyValueStructure<Integer, String> keyValueStructure = new HashKeyValueStructure<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Insert");
            System.out.println("2. Retrieve");
            System.out.println("3. Display current state");
            System.out.println("choice (^C to exit):");

            String i = scanner.next();
            if(!i.contains("C")) {
                if (Integer.parseInt(i) == 1) {
                    System.out.println("Enter key: ");
                    int key = scanner.nextInt();
                    System.out.println("Enter value: ");
                    String value = scanner.next();
                    keyValueStructure.insert(key, value);
                } else if (Integer.parseInt(i) == 2) {
                    System.out.println("Enter key: ");
                    Integer key = scanner.nextInt();
                    System.out.println("value: " + keyValueStructure.retrieve(key));
                } else if (Integer.parseInt(i) == 3) {
                    keyValueStructure.display();
                }
            }else if(i.equals("^C")){
                System.out.println("bye!!");
                System.exit(-1);
            }
            System.out.println("----------------------------------------------------------------------------");
        }

    }
}
