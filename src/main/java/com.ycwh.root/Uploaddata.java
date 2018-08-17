package com.ycwh.root;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.StringMap;

/**
 * 上传数据到七牛
 * 单纯上传时只需要{@link Uploaddata}构造方法以及
 * {@link Uploaddata#uploaddata(String, String)}既可
 */
public class Uploaddata extends QiniuManagerSupport
{

    Configuration cfg;//配置类
    private UploadManager uploadManager;
    StringMap putPolicy = null;
    long expirSeconds = 3600;
    private String simUpToken;//采用默认的上传凭证
    private String cusUpToken;//自定义上传凭证

    /**
     * 构造方法，根据传入的accessKey，secretKey和bucket进行一些初始化
     *
     * @param accessKey
     * @param secretKey
     * @param bucket
     */
    public Uploaddata(String accessKey, String secretKey, String bucket)
    {
        super(accessKey, secretKey, bucket);
        setSimUpToken(bucket);
    }

    /**
     * 设置七牛的上传凭证。
     * 当bucket为null时，则不改变空间
     *
     * @param bucket 空间名，可为null
     * @return simUpToken
     */
    public void setSimUpToken(String bucket)
    {
        if (getAuth() != null && bucket == null)
        {
            simUpToken = getAuth().uploadToken(getBucket());
        } else if (getAuth() != null && bucket != null)
        {
            simUpToken = getAuth().uploadToken(bucket);
        }
    }

    /**
     * 获取默认的上传凭证
     *
     * @return
     */
    public String getSimUpToken()
    {
        return simUpToken;
    }

    public UploadManager getUploadManager()
    {
        if (cfg == null)
        {
            cfg = new Configuration(Zone.zone0());
        }
        if (uploadManager == null)
        {
            uploadManager = new UploadManager(cfg);
        }
        return uploadManager;
    }

    /**
     * 上传本地文件到七牛空间，key值为null时，则使用hash值命名
     * ps：同文件hash值相同
     *
     * @param localFile
     * @param key       可为null
     * @return
     */
    public DefaultPutRet uploaddata(String localFile, String key)
    {
        try
        {
            //
            Response response = getUploadManager().put(localFile, key, getSimUpToken());
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException qe)
        {
            Response r = qe.response;
            System.err.println(r.toString());
            try
            {
                System.err.println(r.bodyString());
            } catch (QiniuException ex)
            {
                //ignore
            }
        }
        return null;
    }
}
