package app.database;

import java.io.*;

public class FileConnectionManager<T> implements FileHandler<T> {

    private final File file;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream inputStream;

    public FileConnectionManager(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void close() throws IOException {
        if (this.objectOutputStream != null) {
            objectOutputStream.close();
        }
        if (this.inputStream != null) {
            inputStream.close();
        }
    }

    @Override
    public void save(T data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
        this.objectOutputStream.writeObject(data);
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        this.inputStream = new ObjectInputStream(fileInputStream);
        return this.inputStream.readObject();
    }
}
