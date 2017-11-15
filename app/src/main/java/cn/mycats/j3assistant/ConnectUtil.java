package cn.mycats.j3assistant;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Xavier on 2017/11/15.
 */

public class ConnectUtil {
    public static boolean  checkConnect(){
        InetSocketAddress localInetSocketAddress = new InetSocketAddress("121.14.64.23", 3724);
        Socket localSocket = new Socket();
        try {
            localSocket.connect(localInetSocketAddress, 500);
            localSocket.close();
            return true;
        } catch (IOException localIOException) {
            return false;
        }
    }
}
