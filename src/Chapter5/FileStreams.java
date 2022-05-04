package Chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileStreams {
    public static void main(String[] args) {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/Users/eugeneheynike/Desktop/data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            System.out.println("Couldn't open file. Probaly wrong path name");
            
        }
        System.out.println(uniqueWords);
    }
}
