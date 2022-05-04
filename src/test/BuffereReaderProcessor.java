package test;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BuffereReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
