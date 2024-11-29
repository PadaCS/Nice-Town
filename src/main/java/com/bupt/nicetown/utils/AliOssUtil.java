package com.bupt.nicetown.utils;
import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

public class AliOssUtil {
    private static final String END_POINT = "https://oss-cn-beijing.aliyuncs.com";
    private static final String ACCESS_KEYID = "LTAI5tCFj7BE41PL4XUJXSaS";
    private static final String ACCESS_KEY_SECRET = "ncTIZeEF4eIu0Lj33d2DrnGK4yfixi";
    private static final String BUCKET_NAME = "nice-town";

    public static String UploadFile(String objectName, InputStream stream) throws Exception {
        OSS ossClient = new OSSClient(END_POINT, ACCESS_KEYID, ACCESS_KEY_SECRET);
        String url = "";
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, stream);

            // 上传
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            url = "https://" + BUCKET_NAME + "." + END_POINT.substring(END_POINT.lastIndexOf("/")+1) + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}

