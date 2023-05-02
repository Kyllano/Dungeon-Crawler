package GamePack;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;

public class Save {
    private static void save(Game g, String fileName){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Saves/".concat(fileName)))) {
            outputStream.writeObject(g);
            System.out.println("Game saved to Saves/" +fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Game load(String fileName){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Saves/".concat(fileName)))) {
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

    public static void saveGameIHM(IHM ihm, Game game){
        System.out.println("Please input the name of the file to save :");
        String userInput = ihm.input();
        while (userInput.equals("") || userInput.equals("\n")){
            userInput = ihm.input();
            System.out.println("Incorrect filename");
        }

        String filename = userInput;
        save(game, filename);
    }

    public static Game loadGameIHM(IHM ihm){
        System.out.println("Please input the name of the save file to load:");
        
        //Je met pas tout ca dans une fonction différente parce que j'ai besoin de filenames ET de filenamesLenght
        //On prend la liste des fichiers pour l'afficher
        File folder = new File("./Saves");
        File[] files = folder.listFiles();
        //Je suis trop lazy pour implémenter ca avec une List donc je fais avec un tableau à l'ancienne comme en C :D
        String[] filenames = new String[files.length];
        Integer filenamesLenght = 0;
        for (File file : files) {
            if (file.isFile()) {
                filenames[filenamesLenght] = file.getName();
                filenamesLenght ++;
            }
        }
        
        String userInput = ihm.input();
        while (!checkIfSaveFileExists(userInput, filenames, filenamesLenght)){
            userInput = ihm.input();
            System.out.println("File does not exists");
        }

        String filename = userInput;
        Game g = load(filename);

        return g;
    }

    private static Boolean checkIfSaveFileExists(String filenameToCheck, String[] filenames, Integer filenamesLenght){
        for (int i = 0; i < filenamesLenght; i ++){
            if (filenameToCheck.equals(filenames[i])){
                return true;
            }
        }
        return false;
    }
}
