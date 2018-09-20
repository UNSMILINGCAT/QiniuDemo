package com.ycwh.root;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

import java.util.ResourceBundle;

public class QiniuManagerSupport implements QiniuManager
{
    private Configuration cfg;//配置类
    private String bucket;//上传的空间名
    private Auth auth;
    private ResourceBundle resourceBundle;

    /**
     * 构造方法，根据传入的accessKey，secretKey和bucket进行一些初始化
     *
     * @param key
     */
    public QiniuManagerSupport(String key)
    {
        resourceBundle = ResourceBundle.getBundle(key);
        setAuth(resourceBundle.getString("accessKey"), resourceBundle.getString("secretKey"));
        setBucket(resourceBundle.getString("bucket"));
    }

    /**
     * 返回配置文件的绑定类
     * @return
     */
    public ResourceBundle getResourceBundle()
    {
        return resourceBundle;
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
