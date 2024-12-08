import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
    public String path;
    public List<String> children;
    public List<String> files;

    public Directory(String path) {
        this.path = path;
        this.files = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public static List<Directory> getDirectories(File directory) {
        List<Directory> result = new ArrayList<>();

        if (directory == null || !directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directory);
            System.exit(1);
            return result;
        }

        Directory currentDir = new Directory(directory.getPath());

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    currentDir.files.add(file.getName());
                } else if (file.isDirectory()) {
                    currentDir.children.add(file.getName());
                }
            }

            result.add(currentDir);

            for (File file : files) {
                if (file.isDirectory()) {
                    result.addAll(getDirectories(file));
                }
            }
        }

        return result;
    }
    public String getNameDir()
    {
        File dir=new File(this.path);
        String name=dir.getName();
        return name;
    }
}