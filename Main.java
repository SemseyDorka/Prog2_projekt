import java.io.File;
import java.util.List;

public class Main
{

    public static void main(String[] args) {
        if(args.length!=1)
        {
            System.out.println("The number of  arguments should be 1");
            System.exit(1);
        }
        
        File startDirectory = new File(args[0]);
        List<Directory> directories = Directory.getDirectories(startDirectory);
        for(Directory dir:directories)
        {
            System.out.println("Read directory: "+dir.path);
        }
        //Start page:
        Directory root=directories.get(0); 
        directories.remove(0);
        String rootName=root.getNameDir();
        HTML index=new HTML(root.path, root.children, root.files);
      //  System.out.println(root.path);
    // System.out.println(index.generateImgList_names());
     //System.out.println(index.generateImgList_Fullnames());

        index.generateStartPage( rootName);
        index.generateImagePage(args[0], rootName);
        for (Directory dir:directories)
        {

            HTML temp=new HTML(dir.path, dir.children, dir.files);
            System.out.println("the following files were generetated in "+dir.path+": ");
            temp.generateSubpage(args[0],rootName);
            temp.generateImagePage(args[0], rootName);


        }
      

    }

    }