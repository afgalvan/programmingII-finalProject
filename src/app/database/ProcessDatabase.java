package app.database;

import app.models.Process;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProcessDatabase {

    private final File file;

    public ProcessDatabase(String filePath) {
        this.file = new File(filePath);
    }

    public ProcessDatabase() {
        this.file = new File("Process.obj");
    }

    public void save(Map<Long, Process> repository) {
        ObjectOutputStream outputStream = null;
        try {
            FileOutputStream writer = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(writer);
            outputStream.writeObject(repository);
        } catch (IOException error) {
            throw new NullPointerException("Fail writing on the file.");
        } finally {
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public LinkedHashMap<Long, Process> read() {
        if (file.exists()) {
            ObjectInputStream inputStream = null;
            try {
                FileInputStream reader = new FileInputStream(file);
                inputStream = new ObjectInputStream(reader);

                return (LinkedHashMap<Long, Process>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException error) {
                System.out.println("Fail");
                return null;
            } finally {
                try {
                    assert inputStream != null;
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return null;
        }
    }
}
