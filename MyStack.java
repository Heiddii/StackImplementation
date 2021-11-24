import java.util.ArrayList;
import java.util.Scanner;

public class MyStack<E> implements StackInterface<E>{

    ArrayList<E> array = new ArrayList<E>();

    private static final int MAX_SIZE = 15; //Arbitrary value since ArrayList has a very large cap. Changeable.
    private int top = -1;

    public void push(E j) throws StackFullException{
        if (isFull()){
            throw new StackFullException("Stack is already full!");
        }
        else {
            array.add(j);
            top++;
        }
    }

    public void pop() throws StackEmptyException{
        if (isEmpty()){
            throw new StackEmptyException("Stack is empty!");
        }
        else {
            array.remove(top);
            top--;
        }
    }

    public E top() throws StackEmptyException{
        if (isEmpty()){
            throw new StackEmptyException("Stack is empty!");
        }
        else {
            return array.get(top);
        }
    }

    public boolean isEmpty(){
        return top == -1; //returns true if top == -1
    }
    public boolean isFull(){
        return top == MAX_SIZE;
    }
    public int size(){
        System.out.println("Current stack: " + array); // May delete this line
        return array.size();
    }

    // Sample Test Usage
    // May remove for Actvity 4
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        MyStack<Character> charArray = new MyStack<>();

        boolean exit = false;
        int choice;
        char a;

        do{
            System.out.println("\t(1) - Push\n" +
                    "\t(2) - Pop\n" +
                    "\t(3) - Top\n" +
                    "\t(4) - Size\n" +
                    "\n\t[0] - Exit program\n");
            System.out.print("Enter a number: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter a character: ");
                    a = scanner.next().charAt(0);
                    charArray.push(a);
                    break;
                case 2:
                    charArray.pop();
                    break;
                case 3:
                    System.out.println("Top Index: " + charArray.top());
                    break;
                case 4:
                    System.out.println("Size: " + charArray.size());
                    break;
                case 0:
                    exit = true;
                default:
                    break;
            }

            System.out.print("\nPress any key to continue...\n");
            new Scanner(System.in).nextLine();

        }while(!exit);

        System.exit(1);
    }
}
