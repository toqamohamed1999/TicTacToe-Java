/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monica
 */
public class recordLogic {
      public void createFile(String fileName) {
        try {
            String path = "C:" + File.separator + "TicTacToe" + File.separator + fileName;
            // Use relative path for Unix systems
            File file = new File(path);
            file.getParentFile().mkdirs();
            if (file.createNewFile()) {
                System.out.println("File creation successfull");
            } else {
                System.out.println("Error while creating File, file already exists in specified path");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public List<String> readFile(String path) {
        BufferedReader reader;
        List<String> gameSteps=new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
                gameSteps.add(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return gameSteps;

    }

    public void writeFile(String str, String fileName) {
        String path = "C:" + File.separator + "TicTacToe" + File.separator + fileName;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.append("\n"+str);

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[] getAllFiles(String dirPath) {
        //Creating a File object for directory
        File directoryPath = new File(dirPath);
        //List of all files and directories
        String files[] = directoryPath.list();
        System.out.println("List of files and directories in the specified directory:\n");
        return files;
    }
}
