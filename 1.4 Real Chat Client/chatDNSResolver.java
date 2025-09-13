// DNS Resolver
// Original Program by: GeeksforGeeks staff
// Edited by: Henry Smith
// Started: 10/12/2025
// Finished: 10/12/2025

import java.net.*;
import java.util.Scanner;

public class chatDNSResolver {
    public static void main(String[] args) {
        String domainName;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Type your domain name below!");
        domainName = scanner.nextLine();
        scanner.close();
        try {
            InetAddress ipAddress = InetAddress.getByName(domainName);
            System.out.println(" ");
            System.out.println("Server Info for "+ domainName);
            System.out.println("IP Address: "+ ipAddress.getHostAddress());
            System.out.println("[Default] Port Number: 12345");
            System.out.println(" ");
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}