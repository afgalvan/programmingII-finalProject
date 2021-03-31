package test.controllers.api;

import static org.junit.Assert.assertEquals;

import app.controllers.api.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class JsonUtilsTest {

    private String rawText;

    public void getText(String path) {
        this.rawText = JsonUtils.readFile(path);
    }

    @Before
    public void setupTest() {
        getText("./src/../.ecrc");
    }

    @Test
    public void readFileTest() {
        assertEquals(
            "{\n" +
            "    \"verbose\": false,\n" +
            "    \"ignore_defaults\": false,\n" +
            "    \"exclude\": [\"LICENSE\", \"\\\\.md$\", \"package.json\", \".idea/**\"],\n" +
            "    \"spaces_after_tabs\": false,\n" +
            "    \"disable\": {\n" +
            "        \"end_of_line\": false,\n" +
            "        \"trim_trailing_whitespace\": false,\n" +
            "        \"insert_final_newline\": false,\n" +
            "        \"indentation\": false\n" +
            "    }\n" +
            "}\n" +
            "\n",
            this.rawText
        );
    }

    @Test
    public void parseJsonTest() {
        JsonNode jsonNode = Objects.requireNonNull(
            JsonUtils.parse(this.rawText)
        );

        assertEquals("false", jsonNode.get("verbose").toString());
        assertEquals("false", jsonNode.get("ignore_defaults").toString());
        assertEquals("\"LICENSE\"", jsonNode.get("exclude").get(0).toString());
        assertEquals(
            "false",
            jsonNode.get("disable").get("indentation").toString()
        );
    }

    @Test(expected = NullPointerException.class)
    public void invalidParses() {
        JsonNode jsonNode = Objects.requireNonNull(
            JsonUtils.parse(this.rawText)
        );
        String invalidField = jsonNode.get("bro").toString();
    }
}
