package com.bjpowernode.util;

import java.io.*;

public class FileUtils {

    public static boolean save2File(String fname, byte[] msg) {
        OutputStream fos = null;
        try{
            File file = new File(fname);
            File parent = file.getParentFile();
            boolean bool;
            if ((!parent.exists()) &&
                    (!parent.mkdirs())) {
                return false;
            }
            fos = new FileOutputStream(file);
            fos.write(msg);
            fos.flush();
            return true;
        }catch (FileNotFoundException e){
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        finally{
            if (fos != null) {
                try{
                    fos.close();
                }catch (IOException e) {}
            }
        }
    }
}
