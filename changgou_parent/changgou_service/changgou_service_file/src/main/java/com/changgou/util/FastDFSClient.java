package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FastDFSClient {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    /***
     * 初始化加载FastDFS的TrackerServer配置
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            logger.error("FastDFS Client Init Fail!", e);
        }
    }

    private static String trackerUrl;

    /**
     * 文件上传
     *
     * @param fastDFSFile
     * @return
     * @throws Exception
     */
    public static String[] upload(FastDFSFile fastDFSFile) throws Exception {
        //获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", fastDFSFile.getAuthor());

        //1、创建要给Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //2、通过TrackerClient访问TrackerServer服务，获取链接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //3、通过TrackerServer的链接信息获得Storage的链接信息，创建StorageClient对象存储Storage的链接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        //4、通过StorageClient访问Storage，实现文件上传，并且获取文件上传后的存储信息
        /***
         * 文件上传
         * 1)文件字节数组
         * 2)文件扩展名
         * 3)文件作者
         */
        return storageClient.upload_appender_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);

    }

    /**
     * 文件下载
     *
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName) throws Exception {
        //1、创建要给Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //2、通过TrackerClient访问TrackerServer服务，获取链接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //3、通过TrackerServer的链接信息获得Storage的链接信息，创建StorageClient对象存储Storage的链接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        byte[] ins = storageClient.download_file(groupName, remoteFileName);

        return new ByteArrayInputStream(ins);
    }

    /***
     * 文件删除
     *
     * @param groupName
     * @param remoteFileName
     * @throws Exception
     */
    public static void deleteFile(String groupName, String remoteFileName) throws Exception {
        //1、创建要给Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //2、通过TrackerClient访问TrackerServer服务，获取链接信息
        TrackerServer trackerServer = trackerClient.getConnection();

        //3、通过TrackerServer的_链接信息获得Storage的链接信息，创建StorageClient对象存储Storage的链接信息
        StorageClient storageClient = new StorageClient(trackerServer, null);

        storageClient.delete_file(groupName, remoteFileName);
    }

    /***
     * 获取Storage组
     * @param groupName
     * @return
     * @throws IOException
     */
    public static StorageServer[] getStoreStorages(String groupName) throws IOException {
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //获取TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Storage组
        return trackerClient.getStoreStorages(trackerServer, groupName);
    }

    /***
     * 获取Storage信息,IP和端口
     * @param groupName
     * @param remoteFileName
     * @return
     * @throws IOException
     */
    public static ServerInfo[] getFetchStorages(String groupName,String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    /***
     * 获取Tracker服务地址
     * @return
     * @throws IOException
     */
    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }

    /***
     * 获取Storage客户端
     * @return
     * @throws IOException
     */
    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return  storageClient;
    }

    /***
     * 获取Tracker
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return  trackerServer;
    }

    /**
     * 将下载的文件写入磁盘
     * @throws Exception
     */
    private static void writeToServer() throws Exception{
        //1、文件下载
        InputStream is = downFile("group1","M00/00/00/wKjIgF7fjECEHtyLAAAAAJhcs8Y51..png");
        //2、将文件写入本地磁盘
        FileOutputStream fos = new FileOutputStream("D:/1.png");
        //3、定义一个缓冲区
        byte[] buffer = new byte[1024];
        while(is.read(buffer)!=-1){
            fos.write(buffer);
        }
        fos.flush();
        fos.close();
        is.close();
    }

    public static void main(String[] args) {
        try {
            writeToServer();
//            deleteFile("group1","M00/00/00/wKjIgF7fjECEHtyLAAAAAJhcs8Y51..png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
