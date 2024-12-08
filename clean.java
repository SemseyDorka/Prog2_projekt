import java.io.File;

public class clean {
    public static void main(String[] args) {
            if(args.length!=1)
        {
            System.out.println("The number of  arguments should be 1");
            System.exit(1);
        }
        
        File root = new File(args[0]);

        if (!root.exists() || !root.isDirectory()) {
            System.out.println("Invalid directory: " + args[0]);
            System.exit(1);
        }

        deleteHtmlFiles(root);
    }
    public static void deleteHtmlFiles(File directory) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                deleteHtmlFiles(file);
            } else if (file.isFile() && file.getName().endsWith(".html")) {
                if (file.delete()) {
                    System.out.println("Deleted: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed to delete: " + file.getAbsolutePath());
                }
            }
        }
    }
    
}
