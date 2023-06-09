package dev.ahmed;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ahmed Bughra
 * @create 2023-06-10  12:57 AM
 *
 * This method can automatically add a number prefix to the file name.
 * "I developed this method because I download YouTube videos from a
 *          YouTube playlist and these videos don't have a number prefix in their file names,
 *          so I want to sort them and add a sequential number prefix to each video file.
 * */
public class TestAddNumberPrefix {


    public static void renameFilesByModifiedDate(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return;
        }
        File[] files = folder.listFiles();
        Arrays.sort(files, Comparator.comparing(File::lastModified));
        int count = 1;
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            String filename = file.getName();
            String extension = "";
            int dotIndex = filename.lastIndexOf('.');
            if (dotIndex >= 0) {
                extension = filename.substring(dotIndex);
                filename = filename.substring(0, dotIndex);
            }
            String newFilename = String.format("%03d_%s%s", count, filename, extension);
            File newFile = new File(folder, newFilename);
            file.renameTo(newFile);
            System.out.println("Renamed " + file.getName() + " to " + newFilename);
            count++;
        }
    }




//    public static void renameFilesByCreateDate(String folderPath) {
//        File folder = new File(folderPath);
//        if (!folder.exists() || !folder.isDirectory()) {
//            System.out.println("Invalid folder path: " + folderPath);
//            return;
//        }
//        File[] files = folder.listFiles();
//        Arrays.sort(files, Comparator.comparing(File::lastModified));
//        int count = 1;
//        for (File file : files) {
//            if (!file.isFile()) {
//                continue;
//            }
//            String filename = file.getName();
//            String extension = "";
//            int dotIndex = filename.lastIndexOf('.');
//            if (dotIndex >= 0) {
//                extension = filename.substring(dotIndex);
//                filename = filename.substring(0, dotIndex);
//            }
//            String newFilename = String.format("%03d_%s%s", count, filename, extension);
//            File newFile = new File(folder, newFilename);
//            file.renameTo(newFile);
//            System.out.println("Renamed " + file.getName() + " to " + newFilename);
//            count++;
//        }
//    }


    @Test
    public void testRenameFilesByCreateDate() {
        String folderPath = "D:\\0 Tonguc\\4.SinifTurkce2021-2022";
        renameFilesByModifiedDate(folderPath);
    }
}
