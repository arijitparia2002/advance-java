

import java.nio.file.*;

public class FileHandleCopyMove {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("./dummy/dummy.txt");
        Path p2 = Paths.get("./dummy1/dummykacopy");

        //create the directories and files
        
        // Files.createDirectories(p1);
        // Files.createFile(p1.resolve("dummy.txt"));
        // Files.createDirectories(p2);
        // Files.createFile(p2.resolve("dummy2.txt"));
        Files.deleteIfExists(p1);
        Files.deleteIfExists(p2);

        // Files.copy(p1, p2);
    }
}
