import java.nio.file.*;

public class PathTest {
    static public void main(String[] args){
        Path p1 = Paths.get("c:/abc/xyz");

        //few methods
        System.out.println(p1.isAbsolute()); 
        System.out.println(p1.getParent());
        System.out.println(p1.getFileName());
        System.out.println(p1.getName(0)); //0th index dosent count root dir
    }
}
