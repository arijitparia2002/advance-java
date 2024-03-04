import java.nio.file.*;

public class PathTest {
    static public void main(String[] args){
        Path p1 = Paths.get("c:/abc/xyz");

        //few methods
        System.out.println(p1.isAbsolute()); 
        System.out.println(p1.getParent());
        System.out.println(p1.getFileName());
        System.out.println(p1.getName(0)); //0th index dosent count root dir


        // normalize method to resolve the path
        Path p2 = Paths.get("c:/abc/../pqr/./demo.txt"); //["." --> current dir | ".." --> parent dir]
        System.out.println(p2.normalize());

        //resolve method
        System.out.println(p1.resolve(p2)); 
        //if p2 is absolute thenn resolve will give oath of p2
        Path p3 = Paths.get("pqr/../demo.txt"); // if p2 is relative append with p1
        System.out.println(p1.resolve(p3));
        System.out.println(p3.resolve(p1));
    }
}
