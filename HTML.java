
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HTML {

    public String path;
    public List<String> subs;
    public List<String> imgs;

    public HTML(String path, List<String> subs, List<String> imgs) {
        this.path = path;
        this.subs = subs;
        this.imgs = imgs;
    }

    public void generateStartPage(String root) {
        String file = this.path + File.separator + root + ".html";
        String htmList = ("<!DOCTYPE html>\r\n"
                + //
                "<html lang=\"en\">\r\n"
                + //
                "<head>\r\n"
                + //
                "    <meta charset=\"UTF-8\">\r\n"
                + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + //
                "    <title>Start page</title>\r\n"
                + //
                "</head>\r\n"
                + //
                "<body>\r\n"
                + //
                "    <h1>Start page</h1>\r\n"
                + //
                "    <hr>\r\n"
                + //
                "    <h2>Directories</h2>\r\n"
                + //
                "    <ul>\r\n"
                + //
                "***"
                + //
                "      </ul>\r\n"
                + //
                "    <hr>\r\n"
                + //
                "    <h2>Images</h2>\r\n"
                + //
                "    <ul>\r\n"
                + //
                "---"
                + //
                "      </ul>\r\n"
                + //
                "</body>\r\n"
                + //
                "</html>");

        htmList = htmList.replace("***", generateDirList());
        htmList = htmList.replace("---", generateImgList());
        List<String> temp = new ArrayList<>();
        temp.add(htmList);
        fileUtils.Writelines(temp, file);
        System.out.println("Start page " + root + ".html generated ");
    }

    public String generateDirList() {
        String li_subs = "";

        for (String sub : subs) {
            li_subs += "<li><a href='/" + path + "/" + sub + "/" + sub + ".html'>" + sub + "</a></li>\n";
        }
        return li_subs;
    }

    public List<String> image_files(String... n) {
        List<String> image_types = new ArrayList<>();
        image_types.addAll(Arrays.asList(n));
        return image_types;
    }

    public String generateImgList() {
        String li_imgs = "";
        for (String img : imgs) {
            if (image_files("jpeg", "jpg", "png", "gif", "bmp").contains(img.substring(img.length() - 3, img.length()))) {
                li_imgs += "<li><a href='" + img.substring(0, img.length() - 4) + ".html'>" + img + "</a></li>\n";

            }
        }
        return li_imgs;
    }

    public List<String> generateImgList_names() {
        List<String> imageNames = new ArrayList<>();
        String li_imgs = "";
        for (String img : imgs) {
            if (image_files("jpeg", "jpg", "png", "gif", "bmp").contains(img.substring(img.length() - 3, img.length()))) {
                li_imgs = img.substring(0, img.length() - 4) + ".html";
                imageNames.add(li_imgs);

            }
        }
        return imageNames;
    }

    public List<String> generateImgList_Fullnames() {
        List<String> imageNames = new ArrayList<>();
        for (String img : imgs) {
            if (image_files("jpeg", "jpg", "png", "gif", "bmp").contains(img.substring(img.length() - 3, img.length()))) {
                imageNames.add(img);
            }
        }
        return imageNames;

    }

    public void generateSubpage(String args0, String root) {
        String text = "<!DOCTYPE html>\r\n"
                + //
                "<html lang=\"en\">\r\n"
                + //
                "<head>\r\n"
                + //
                "    <meta charset=\"UTF-8\">\r\n"
                + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + //
                "    <title>Document</title>\r\n"
                + //
                "</head>\r\n"
                + //
                "<body>\r\n"
                + //
                "    <h1> <a href=\"!!!\">Start page</a></h1>\r\n"
                + //index page
                "    <hr>\r\n"
                + //
                "    <h2>Directories</h2>\r\n"
                + //
                "    <ul>\r\n"
                + //
                "***\r\n"
                + //parent mappa << String[] str=path.split("\");
                "???\r\n"
                + //al mappák 
                "\r\n"
                + //
                "      </ul>\r\n"
                + //
                "    <hr>\r\n"
                + //
                "    <h2>Images</h2>\r\n"
                + //
                "    <ul>\r\n"
                + //
                "---\r\n"
                + //
                "      </ul>\r\n"
                + //
                "</body>\r\n"
                + //
                "</html>";
        Path currentPath = Path.of(this.path);
        Path parentPath = currentPath.getParent();

        // Generate parent link
        String parentLink = "";
        if (parentPath != null) {
            String parentName = parentPath.getFileName().toString();
            parentLink = "<li><a href='/" + parentPath + "/" + parentName + ".html'><<</a></li>";
        }
        text = text.replace("***", parentLink);

        // Generate directory and image lists
        text = text.replace("!!!", "/" + args0 + "/" + root + ".html");
        text = text.replace("???", generateDirList());
        text = text.replace("---", generateImgList());

        String fileName = currentPath.getFileName() + ".html";
        Path outputFile = currentPath.resolve(fileName);
        List<String> temp = new ArrayList<>();
        temp.add(text);
        fileUtils.Writelines(temp, outputFile.toString());
        System.out.println("Sub page " + fileName + " generated ");

    }

    public void generateImagePage(String args0, String root) {
        List<String> images = generateImgList_Fullnames();
        List<String> imgHTML=generateImgList_names();
        String text = "<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Document</title>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "    <h1> <a href=\"/???.html\">Start page</a></h1>\r\n"
                + "    <hr>\r\n"
                + "    <a href=\"***.html\">^^</a> \r\n"
                + "    <br>\r\n"
                + "    <a href=\"previous\"><<</a> <h2>picture1</h2> <a href=\"next\">>></a> \r\n"
                + "    <br>\r\n"
                + "    <a href=\"next\">\r\n"
                + "        <img src=\"picture1\" alt=\"landscape01\" width=\"600\" height=\"600\">\r\n"
                + "      </a>\r\n"
                + "</body>\r\n"
                + "</html>";

        text = text.replace("???", args0 + "/" + root);
        Path currentPath = Path.of(this.path);
        String parentPage = currentPath.getFileName() + "";
        text = text.replace("***", parentPage);

        for (int i = 0; i < images.size(); i++) {
            String text1=text;
            String currentImage = imgHTML.get(i);
            String previousPage = i > 0 ? imgHTML.get(i-1) : currentImage;
            String nextPage = i < images.size() - 1 ? imgHTML.get(i+1) : currentImage;

            text1 = text.replace("picture1", images.get(i)).replace("previous", previousPage).replace("next", nextPage);

            Path outputFile = currentPath.resolve(currentImage);

            List<String> temp = new ArrayList<>();
            temp.add(text1);
            fileUtils.Writelines(temp, outputFile.toString());
            System.out.println("Html page containing "+images.get(i)+" generated ("+currentImage+")");
        }
    }

}
