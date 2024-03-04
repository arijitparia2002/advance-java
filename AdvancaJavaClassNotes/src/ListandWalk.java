

import java.nio.file.*;
import java.util.stream.*;

class ListandWalk {
    public static void main(String[] args) throws Exception {
        String path = "./FileHandle";

        Stream<Path> files = Files.walk(Paths.get(path));
        files.forEach(p -> System.out.println(p));
        files.close();

    }
}
