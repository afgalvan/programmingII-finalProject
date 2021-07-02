package app.database;

import java.io.*;

/**
 * A class that manages the connection between a file and a Java program.
 */
class FileConnector implements FileConnection {

    private final File file;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    public FileConnector(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Opens the specified file in the constructor.
     *
     * @throws IOException if any error occurs while opening the file.
     */
    @Override
    public void open() throws IOException {
        this.fileOutputStream = new FileOutputStream(file);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }

    /**
     * Closes the connection between the program and the file.
     *
     * @throws IOException if any error occurs while closing the file.
     */
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

    /**
     * Saves the given object to the file specified.
     *
     * @param data the {@code Object} to be saved.
     * @throws IOException if any error occurs while saving the object.
     */
    @Override
    public void save(Object data) throws IOException {
        if (this.fileOutputStream == null || this.objectOutputStream == null) {
            throw new IOException("File not opened");
        }

        this.objectOutputStream.writeObject(data);
    }

    /**
     * Read the contents of the file specified in constructor.
     *
     * @return the {@code Object} read from the file.
     * @throws IOException            if any error occurs while reading the file.
     * @throws ClassNotFoundException if couldn't load the class.
     */
    @Override
    public Object read() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            return null;
        }
        this.fileInputStream = new FileInputStream(file);
        this.objectInputStream = new ObjectInputStream(fileInputStream);
        return this.objectInputStream.readObject();
    }

    /**
     * Delete the associated file.
     *
     * @return if was deleted.
     */
    @Override
    public boolean delete() {
        return this.file.delete();
    }
}
