/* 
Error filled file created by
Kimg@techtrepacademy.com
for my java class to learn troubleshooting on
*/

//H:  Made By: Kim Gross (Kimg@techtrepacademy.com)
//H:  Creation Date: N/A
//H:  Modified By : Henry Smith
//H:  Modification Date: 4/9/2025

public class error { 
    public static void main(String[] args) {

        //H: Prints out "hello everybody" and "am I doing this correctly?" into the terminal. 
        System.out.println("hello everybody");
        System.out.println("am I doing this correctly");

        //H: Creates a loop that counts from 0 to 10, and prints out when the number is equal to zero, and when it is not equal to zero.
        for (int i=0; i<10; i++){
            System.out.println("the number i is "+i);
        }

        for (int i=0; i>=10; i++){
            System.out.println("the new number i is " + i);
            if (i == 0){
                System.out.println("i is equal to zero");
            } else {
                System.out.println("i is not equal to zero");
            }
        }

        //what other errors can I put into a source code file?

        //H: "You can make a lot more errors with this code, such as more capitalization issues or the use of incorrect parenthesis types."
        //H: - Henry Smith :)
    }
}
