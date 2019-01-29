package util;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class TarUtils {
    private static void archiveFile(File file, TarArchiveOutputStream taos) throws Exception {

        TarArchiveEntry tae = new TarArchiveEntry(file);
        tae.setSize(file.length());//大小
        tae.setName(file.getName());//不设置会默认全路径
        taos.putArchiveEntry(tae);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        int count;
        byte data[] = new byte[1024];
        while ((count = bis.read(data, 0, 1024)) != -1) {
            taos.write(data, 0, count);
        }
        bis.close();

        taos.closeArchiveEntry();
    }

    private static void dearchive(String destPath, TarArchiveInputStream tais) throws Exception {

        TarArchiveEntry tae = null;
        while ((tae = tais.getNextTarEntry()) != null) {

            String dir = destPath + File.separator + tae.getName();//tar档中文件
            File dirFile = new File(dir);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dirFile));

            int count;
            byte data[] = new byte[1024];
            while ((count = tais.read(data, 0, 1024)) != -1) {
                bos.write(data, 0, count);
            }

            bos.close();
        }
    }

    public static void main(String[] args) {
        String basePath = "/Users/lixin/Desktop/result/";
        String destPath = "/Users/lixin/Desktop/fapiao/";
        File file = new File(basePath + "20190117.md5");
        System.out.println(file.getName());

        //压缩
        try {
            TarArchiveOutputStream taos = new TarArchiveOutputStream(new FileOutputStream(new File(basePath + "test.tar")));
            archiveFile(new File(basePath + "水杯.pdf"), taos);
            archiveFile(new File(basePath + "吃的.pdf"), taos);
            archiveFile(new File(basePath + "酸奶.pdf"), taos);
            archiveFile(new File(basePath + "大白兔.pdf"), taos);
            archiveFile(new File(basePath + "吃的2.pdf"), taos);
            System.out.println("压缩成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //解压
        try {
            TarArchiveInputStream tais = new TarArchiveInputStream(new FileInputStream(new File(basePath + "test.tar")));
            dearchive(destPath , tais);
            tais.close();
            System.out.println("解压成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) throws IOException {
//        File filePath = new File("/Users/lixin/ftp");
//        if (filePath.exists()) {
//            FileUtils.deleteDirectory(filePath);
//
//        }
//    }

}
