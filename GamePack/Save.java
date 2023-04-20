package GamePack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Save {
    public static void save(Game g, String fileName){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(g);
            System.out.println("Game saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Game load(String fileName){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Game g;
            g = (Game) inputStream.readObject();
            g.ihm = new IHM();
            System.out.println("Game loaded");
            return g;
        } catch (IOException | ClassNotFoundException e) {
            Game g = new Game(1);
            e.printStackTrace();
            return g;
        }
    }
}
