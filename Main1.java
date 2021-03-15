package FileWrFileR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main1 {
    public static void main(String[] args) {
        GameProgress first = new GameProgress(10, 3, 2, 101);
        GameProgress second = new GameProgress(15, 4, 3, 151);
        GameProgress third = new GameProgress(60, 12, 12, 2589);
        ArrayList<String> list = new ArrayList<>();
        list.add("D://Games//savegames//save1.dat");
        list.add("D://Games//savegames//save2.dat");
        list.add("D://Games//savegames//save3.dat");

        save(list.get(0), first);
        save(list.get(1), second);
        save(list.get(2), third);

        zipFiles("D://Games//savegames//zip_savegames.zip", list, "save");



        File dir = new File("D://Games//savegames");
        if (dir.isDirectory()) {
            for(File file : dir.listFiles()) {
                if (file.getName().equals("zip_savegames.zip")) {
                    continue;
                } else {
                    file.delete();
                }
            }
        }
    }


    public static void save(String str, GameProgress game) {

        try (FileOutputStream fos = new FileOutputStream(str);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void zipFiles(String zip, ArrayList<String> list, String nameSave) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zip));
        ) {
            for (int i = 0; i < list.size(); i++) {
                try (FileInputStream fis1 = new FileInputStream(list.get(i))) {
                    ZipEntry entry1 = new ZipEntry(nameSave + i + ".dat");
                    zout.putNextEntry(entry1);
                    byte[] buffer1 = new byte[fis1.available()];
                    fis1.read(buffer1);
                    zout.write(buffer1);
                    zout.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
