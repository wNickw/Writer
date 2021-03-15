package FileWrFileR;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Begin {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        File dirSrc = new File("D://Games", "src");
        exit(dirSrc, builder);
        File dirRes = new File("D://Games", "res");
        exit(dirRes, builder);
        File dirSaveGames = new File("D://Games", "savegames");
        exit(dirSaveGames, builder);
        File dirTemp = new File("D://Games", "temp");
        exit(dirTemp, builder);

        File dirMain = new File("D://Games//src", "main");
        exit(dirMain, builder);
        File dirTest = new File ("D://Games//src", "test");
        exit(dirTest, builder);

        File dirMainJava = new File("D://Games//src//main", "Main.java");
        createFile(dirMainJava, builder);
        File dirUtilsJava = new File("D://Games//src//main", "Utils.java");
        createFile(dirUtilsJava, builder);

        File dirDrawables = new File("D://Games//res", "drawables");
        exit(dirDrawables, builder);
        File dirVectors = new File("D://Games//res", "vectors");
        exit(dirVectors, builder);
        File dirIcons = new File("D://Games//res", "icons");
        exit(dirIcons, builder);

        File dirTempTxt = new File("D://Games//temp", "temp.txt");
        createFile(dirTempTxt, builder);

        System.out.println(builder);


        try(FileWriter wr = new FileWriter("D://Games//temp//temp.txt", false)) {
            wr.write(String.valueOf(builder));
            wr.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public static void exit(File file, StringBuilder builder) {
        if(file.mkdir()) {
            builder.append("Каталог создан " + file + "; " + "\n");
        }
    }

    public static void createFile(File file, StringBuilder builder) {
        try {
            if (file.createNewFile()) {
                builder.append("Файл был создан " + file + "; " + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}