package com.ycwh.root;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

public class QiniuManagerSupport implements QiniuManager
{
    private Configuration cfg;//配置类
    private String bucket;//上传的空间名
    private Auth auth;

    /**
     * 构造方法，根据传入的accessKey，secretKey和bucket进行一些初始化
     *
     * @param accessKey
     * @param secretKey
     * @param bucket
     */
    public QiniuManagerSupport(String accessKey, String secretKey, String bucket)
    {
        setAuth(accessKey, secretKey);
        setBucket(bucket);
    }

    /**
     * 配置{@link Configuration}
     *
     * @param zone
     */
    public void setCfg(Zone zone)
    {
        if (cfg != null)
        {
            cfg.zone = zone;
        } else
        {
            cfg = new Configuration(zone);
        }
    }

    /**
     * 返回{@link Configuration}
     *
     * @return
     */
    public Configuration getCfg()
    {
        return cfg;
    }

    /**
     * 通过传入的accessKey和secreKey来获取到Auth对象
     *
     * @param accessKey
     * @param secretKey
     * @return
     */
    private void setAuth(String accessKey, String secretKey)
    {
        auth = Auth.create(accessKey, secretKey);
    }

    /**
     * 返回一个Auth对象
     *
     * @return
     */
    public Auth getAuth()
    {
        if (auth == null)
        {
            return null;
        } else
        {
            return auth;
        }
    }

    /**
     * 更改空间
     *
     * @param bucket 空间名称
     */
    public void setBucket(String bucket)
    {
        if (bucket != null)
            this.bucket = bucket;
    }

    /**
     * 获取当前所在的空间
     *
     * @return
     */
    public String getBucket()
    {
        return bucket;
    }
}
