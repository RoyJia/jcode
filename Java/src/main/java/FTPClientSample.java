import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPReply;

public class FTPClientSample {

    private static final Logger LOGGER = Logger.getLogger(FTPClientSample.class.getName());

    public static void main(String[] args) throws IOException {
//        FTPProperties ftpProperties = new FTPProperties();
//        FTPClient ftpClient = new FTPClient();
//
//        ftpClient.setControlEncoding("utf-8");
//        try {
//            int reply;
//            ftpClient.connect(ftpProperties.getHost(), ftpProperties.getPort());
//            ftpClient.login(ftpProperties.getUserName(), ftpProperties.getPassword());
//
//            reply = ftpClient.getReplyCode();
//            if(FTPReply.isPositiveCompletion(reply)) {
//                LOGGER.info("ftp connection success! host: " + ftpProperties.getHost() + ", username: " + ftpProperties.getUserName());
//            } else {
//                LOGGER.log(Level.SEVERE, "ftp连接失败: " + ftpClient.getReplyString());
//                ftpClient.disconnect();
//            }
//
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "ftp连接失败", e);
//            ftpClient.disconnect();
//        }
    }
}