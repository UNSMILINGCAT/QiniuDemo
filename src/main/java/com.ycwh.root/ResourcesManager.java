package com.ycwh.root;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;

public class ResourcesManager extends QiniuManagerSupport
{
    private BucketManager bucketManager;

    /**
     * 构造方法，根据传入的accessKey，secretKey和bucket进行一些初始化
     *
     * @param accessKey
     * @param secretKey
     * @param bucket
     */
    public ResourcesManager(String accessKey, String secretKey, String bucket)
    {
        super(accessKey, secretKey, bucket);
        setCfg(Zone.zone0());
    }

    /**
     * 返回空间的管理对象{@link BucketManager}
     *
     * @return
     */
    public BucketManager getBucketManager()
    {
        if (bucketManager == null)
        {
            bucketManager = new BucketManager(getAuth(), getCfg());
        }
        return bucketManager;
    }

    /**
     * 返回文件的信息类{@link FileInfo}
     *
     * @param fileName
     * @return
     */
    public FileInfo getFileInfo(String fileName)
    {
        try
        {
            return getBucketManager().stat(getBucket(), fileName);
        } catch (QiniuException e)
        {
            System.err.println(e.response.toString());
        }
        return null;
    }

    /**
     * 修改文件的类型
     *
     * @param key         文件名
     * @param newMimeType 新类型
     * @return
     */
    public boolean modifyFileType(String key, String newMimeType)
    {
        try
        {
            getBucketManager().changeMime(getBucket(), key, newMimeType);
        } catch (QiniuException e)
        {
            System.err.println(e.response.toString());
            return false;
        }
        return true;
    }

    /**
     * 同账号下的同一空间进行文件移动
     *
     * @param fromeFileKey
     * @param toFileKey
     * @return
     */
    public boolean moveFile(String fromeFileKey, String toFileKey)
    {
        return moveFile(getBucket(), fromeFileKey, getBucket(), toFileKey, false);
    }

    /**
     * 同一账号下进行移动
     *
     * @param fromeBucket  源空间
     * @param fromeFileKey 源文件
     * @param toBucket     目标空间
     * @param toFileKey    目标文件
     * @param force        强行覆盖同名文件
     * @return
     * @throws QiniuException
     */
    public boolean moveFile(String fromeBucket, String fromeFileKey, String toBucket, String toFileKey, boolean force)
    {
        try
        {
            getBucketManager().move(fromeBucket, fromeFileKey, toBucket, toFileKey, force);
        } catch (QiniuException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
