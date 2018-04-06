package resourceTest;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest {

    private String getResource(String filename) throws URISyntaxException, IOException {
        URL resource = getClass().getResource(filename);
        assertNotNull(resource);

        URI uri = resource.toURI();
        System.out.println(uri);
        return new String(Files.readAllBytes(Paths.get(uri)));
    }

    @Test
    public void test() throws Exception {
        String content = getResource("/resourceTest/test.txt");
        assertEquals("hello", content);
    }
}