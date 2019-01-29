package com.lixin.sftp;

import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.*;
import com.lixin.sftp.constant.SFTPConstants;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class SftpUtils {
//    private static Session session = null;
//    private static Channel channel = null;

//    private static final Logger LOG = Logger.getLogger(SFTPChannel.class.getName());

    public static ChannelSftp getChannel(String host, int port, String username, String privateKey, int timeout) throws JSchException {
        JSch jsch = new JSch(); // 创建JSch对象
        jsch.addIdentity(privateKey);
        Session session = jsch.getSession(username, host, port); // 根据用户名，主机ip，端口获取一个Session对象
//        if (ftpPassword != null) {
//            session.setPassword(ftpPassword); // 设置密码
//        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        System.out.println("session connected");
//        LOG.debug("Session connected.");

//        LOG.debug("Opening Channel.");
        Channel channel = session.openChannel("sftp"); // 打开SFTP通道
        System.out.println("open sftp channel");
        channel.connect(); // 建立SFTP通道的连接
//        LOG.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
//                + ", returning: " + channel);
        System.out.println("sftp channel connected");
        return (ChannelSftp) channel;
    }

//    public void closeChannel() throws Exception {
//        if (channel != null) {
//            channel.disconnect();
//        }
//        if (session != null) {
//            session.disconnect();
//        }
//    }

    public static void main(String[] args) {
        //sftp -oIdentityFile=/Users/lixin/.ssh/baidu_id_rsa -oPort=2222  instloantest@outer.sftp.baidu.com
        try {
            String privateKey = "/Users/lixin/.ssh/baidu_id_rsa";
            ChannelSftp channel = getChannel("outer.sftp.baidu.com", 2222, "instloantest", privateKey, 30000);
            channel.cd("download");
            String filename = "20181109.md5";
            SftpATTRS attr = channel.stat(filename);

            boolean blk = attr.isBlk();
            System.out.println(blk);
//        long fileSize = attr.getSize();
            String dst = "/Users/lixin/ftp/" + filename;
            channel.get(filename, dst); // 代码段1
        } catch (JSchException e) {
            System.out.println("jschException");
            e.printStackTrace();
        } catch (SftpException e) {
            System.out.println("SftpException");
            e.printStackTrace();
        }

    }
}
