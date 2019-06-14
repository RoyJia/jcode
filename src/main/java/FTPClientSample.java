import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPClientSample {

    public static void main(String[] args) {
        FTPProperties ftpProperties = new FTPProperties();
        FTPClient ftpClient = new FTPClient();
        
        ftpClient.setControlEncoding("utf-8");
        try {
            int reply;
            ftpClient.connect(ftpProperties.getHost(), ftpProperties.getPort());
            ftpClient.login(ftpProperties.getUserName(), ftpProperties.getPassword());

            reply = ftpClient.getReplyCode();
            if(FTPReply.isPositiveCompletion(reply)) {
                log.info("ftp connection success! host: " + ftpProperties.getHost() + ", username: " + ftpProperties.getUserName());
            } else {
                log.error("ftp连接失败: " + ftpClient.getReplyString());
                ftpClient.disconnect();
            }

        } catch (Exception e) {
            log.error("ftp连接失败", e);
            ftpClient.disconnect();
        }
    }
}