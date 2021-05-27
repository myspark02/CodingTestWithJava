package codingwithscpark.fileio;

import java.nio.file.*;
import java.io.*;

public class FileInfo {
    public static void main(String[] args) {
        Path workingDirectory = Paths.get("myfile.txt");
        System.out.println(workingDirectory.toAbsolutePath());

        File dir = new File("./");
        String[] fileNames = dir.list();
        System.out.println("현재 폴더 절대 경로 : " + dir.getAbsolutePath());
        for (String fileName : fileNames) {
            File file = new File (dir, fileName);
            System.out.printf("이름:%s, 디렉토리(%b), 파일(%b)\n", 
                    file.getName(), file.isDirectory(), file.isFile());
        }
        System.out.println();
    }
}
