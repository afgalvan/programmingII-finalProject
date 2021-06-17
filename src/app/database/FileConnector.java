package app.database;

import java.io.*;

class FileConnector implements FileConnection {

    private final File file;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    public FileConnector(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void open() throws IOException {
        this.fileOutputStream = new FileOutputStream(file);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }

    @Override
    public void close() throws IOException {
        if (this.fileOutputStream != null) {
            this.fileOutputStream.close();
        }
        if (this.objectOutputStream != null) {
            this.objectOutputStream.close();
        }
        if (this.fileInputStream != null) {
            this.fileInputStream.close();
        }
        if (this.objectInputStream != null) {
            this.objectInputStream.close();
        }
    }

    @Override
    public void save(Object data) throws IOException {
        if (this.fileOutputStream == null || this.objectOutputStream == null) {
            throw new IOException("File not opened");
        }

        this.objectOutputStream.writeObject(data);
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            return null;
        }
        this.fileInputStream = new FileInputStream(file);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
        return this.objectInputStream.readObject();
    }
}
