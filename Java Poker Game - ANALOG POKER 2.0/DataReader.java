import java.io.*;

public class DataReader {
    public static void main(String[] args) {

        File sDirect = new File("gameData.txt");

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
        while (true) {
            try {
                Object obj = ois.readObject();
                if (obj instanceof cardClass) {
                    System.out.println("Object Found " + obj.getClass().getName());
                } else {
                    System.out.println("Unsupported Object Found " + obj.getClass().getName());
                }
            } catch (EOFException e) {
                break;
            }
        }
    } catch (IOException | ClassNotFoundException e4) {
        e4.printStackTrace();
    }
}
}
