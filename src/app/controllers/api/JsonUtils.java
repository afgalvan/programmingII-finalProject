package app.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = getDefaultObjectMapper();
    }

    /**
     * @return
     */
    private static ObjectMapper getDefaultObjectMapper() {
        return new ObjectMapper();
    }

    /**
     * @param src
     * @return
     */
    public static String readFile(String src) {
        try {
            return new String(Files.readAllBytes(Paths.get(src)));
        } catch (IOException ignore) {
            return "";
        }
    }

    /**
     * @param jsonString
     * @return
     */
    public static JsonNode parse(String jsonString) {
        try {
            return objectMapper.readTree(jsonString);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
