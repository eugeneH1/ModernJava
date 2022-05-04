package Chapter5;

import java.util.Properties;
import java.util.stream.Stream;

public class NullStreams {
    public static void main(String[] args) {
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        Properties props = System.getProperties();
        props.list(System.out);
    }
}
