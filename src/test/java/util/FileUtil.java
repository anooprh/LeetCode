package util;

import java.io.*;

public class FileUtil {
    public static String getSourceFileContents(File solutionFile) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(solutionFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }

    public static File getSourceFile(String testFileCannonicalName){
        String Source_File_Prefix = "src/main/java/";
        return new File(Source_File_Prefix + testFileCannonicalName.
                replaceAll("\\.", File.separator).
                replaceAll("Test", ".java"));
    }

}
