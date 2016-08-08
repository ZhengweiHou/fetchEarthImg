package util;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class Util {
	/**
	 * ���ƶ�URL�ļ����浽�����ļ�
	 * @param destUrl   Ŀ��url��ַ
	 * @param filePath	�ļ�·��
	 */
	public static void saveToFile(String destUrl,String filePath) {    
        FileOutputStream fos = null;    
        BufferedInputStream bis = null;    
        HttpURLConnection httpUrl = null;    
        URL url = null;    
        int BUFFER_SIZE = 1024*1024;    
        byte[] buf = new byte[BUFFER_SIZE];    
        int size = 0;    
        try {    
            url = new URL(destUrl);    
            httpUrl = (HttpURLConnection) url.openConnection();    
            httpUrl.connect();    
            bis = new BufferedInputStream(httpUrl.getInputStream());    
            fos = new FileOutputStream(filePath);    
            while ((size = bis.read(buf)) != -1) {     
                fos.write(buf, 0, size);    
            }    
            fos.flush();    
        } catch (IOException e) {    
        } catch (ClassCastException e) {    
        } finally {    
            try {    
                fos.close();    
                bis.close();    
                httpUrl.disconnect();    
            } catch (IOException e) {    
            } catch (NullPointerException e) {    
            }    
        }    
    }    
}
