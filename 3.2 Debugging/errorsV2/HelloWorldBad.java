//H:  Made By: Kim Gross (Kimg@techtrepacademy.com)
//H:  Creation Date: N/A
//H:  Modified By : Henry Smith
//H:  Modification Date: 4/9/2025

class HelloWorldBad {
    public static void main(String[] args) {

        //H: Prints the value of the "i" variable as it increases inside a loop.
        for (int i=0;i<25;i++) {
            System.out.println("the value of i is "+i);
            if (i==1) {
                System.out.println("i is equal to 1");
            }
        }    
    }
}