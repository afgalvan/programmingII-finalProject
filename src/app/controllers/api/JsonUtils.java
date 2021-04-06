package app.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class to perform certain functions to manipulate json files using the jackson library.
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = getDefaultObjectMapper();
    }

    /**
     * Create the Object to manipulate json.
     *
     * @return An js object mapper.
     */
    private static ObjectMapper getDefaultObjectMapper() {
        return new ObjectMapper();
    }

    /**
     * Read all lines of a file from a given path.
     *
     * @param src Path to the file.
     * @return A string with the content of all the file.
     */
    public static String readFile(String src) {
        try {
            return new String(Files.readAllBytes(Paths.get(src)));
        } catch (IOException ignore) {
            return "";
        }
    }

    /**
     * Convert a string to a manipulable json node.
     *
     * @param jsonString A string with the content of the json to be parsed.
     * @return A JsonNode to be manipulated.
     */
    public static JsonNode parse(String jsonString) {
        try {
            return objectMapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
