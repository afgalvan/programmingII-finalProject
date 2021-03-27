package app.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Json {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = getDefaultObjectMapper();
    }

    /**
     *
     * @return
     */
    private static ObjectMapper getDefaultObjectMapper() {
        return new ObjectMapper();
    }

    /**
     *
     * @param src
     * @return
     */
    private static String readFile(String src) {
        try {
            return new String(Files.readAllBytes(Paths.get(src)));
        } catch (IOException ignore) {
            return "";
        }
    }

    /**
     *
     * @param src
     * @return
     */
    public static JsonNode parse(String src) {
        try {
            return objectMapper.readTree(readFile(src));
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
