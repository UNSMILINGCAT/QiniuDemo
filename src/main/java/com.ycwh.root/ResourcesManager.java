package com.ycwh.root;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;

import java.io.File;
import java.util.ArrayList;

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
     * 同账号下进行文件移动,但位于同空间时，则相当于重命名
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

    /**
     * 复制文件
     *
     * @param fromeFileKey
     * @param toFileKey
     * @return
     */
    public boolean copyFile(String fromeFileKey, String toFileKey)
    {
        return copyFile(getBucket(), fromeFileKey, getBucket(), toFileKey);
    }

    /**
     * 复制文件
     *
     * @param fromeBucket
     * @param fromeFileKey
     * @param toBucket
     * @param toFileKey
     * @return
     */
    public boolean copyFile(String fromeBucket, String fromeFileKey, String toBucket, String toFileKey)
    {
        try
        {
            getBucketManager().copy(fromeBucket, fromeFileKey, toBucket, toFileKey);
        } catch (QiniuException qe)
        {
            System.err.println(qe.code());
            return false;
        }
        return true;
    }

    /**
     * 删除空间文件
     *
     * @param key
     * @return
     */
    public String removeFile(String key)
    {
        return removeFile(getBucket(), key);
    }

    /**
     * 删除空间的文件
     *
     * @param bucket
     * @param key
     * @return
     */
    public String removeFile(String bucket, String key)
    {
        try
        {
            getBucketManager().delete(bucket, key);
        } catch (QiniuException qe)
        {
            System.err.println(qe.code());
            System.err.println(qe.response.toString());
            return null;
        }
        return key;
    }

    /**
     * 获取空间文件列表
     *
     * @param bucket
     * @param prefix
     * @param limit
     * @param delimiter
     * @return
     */
    public BucketManager.FileListIterator getFileListIterator(String bucket, String prefix, int limit, String
            delimiter)
    {
        return getBucketManager().createFileListIterator(bucket, prefix, limit, delimiter);
    }

    /**
     * 返回包含了文件信息的文件列表
     *
     * @return
     */
    public ArrayList<FileInfo> getFileInfo()
    {
        return getFileInfo(getBucket(), "", 1000, "");
    }

    /**
     * 返回包含了文件信息的文件列表{@link ArrayList}<{@link FileInfo}>
     *
     * @param bucket
     * @param prefix
     * @param limit
     * @param delimiter
     * @return
     */
    public ArrayList<FileInfo> getFileInfo(String bucket, String prefix, int limit, String delimiter)
    {
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        BucketManager.FileListIterator fileListIterator = getFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext())
        {
            FileInfo[] infos = fileListIterator.next();
            for (FileInfo info : infos)
            {
                arrayList.add(info);
            }
        }
        return arrayList;
    }

    /**
     * 抓取网络资源到空间
     *
     * @param remoteSrcUrl
     * @param key
     * @return
     */
    public FetchRet putRemoteFile(String remoteSrcUrl, String key)
    {
        return putRemoteFile(remoteSrcUrl, getBucket(), key);
    }

    /**
     * 抓取网络资源到空间
     *
     * @param remoteSrcUrl
     * @param bucket
     * @param key
     * @return
     */
    public FetchRet putRemoteFile(String remoteSrcUrl, String bucket, String key)
    {
        FetchRet fetchRet = null;
        try
        {
            fetchRet = getBucketManager().fetch(remoteSrcUrl, bucket, key);
        } catch (QiniuException qe)
        {
            qe.printStackTrace();
            return null;
        }
        return fetchRet;
    }
}
