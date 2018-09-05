package com.ycwh.demo.chapter3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 映射文件的具体实现
 */
public class RoleMapperImp implements RoleMapper
{
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession = null;
    private static RoleMapperImp roleMapperImp;

    /**
     * 获取唯一实例
     *
     * @return
     */
    public static RoleMapperImp instance()
    {
        if (roleMapperImp == null)
        {
            roleMapperImp = new RoleMapperImp();
        }
        return roleMapperImp;
    }

    /**
     * 单例模式，初始化SqlSessionFactory工厂
     */
    private RoleMapperImp()
    {
        sqlSessionFactory = BuildSqlSessionFactory.getSqlSessionFactory();
    }

    /**
     * 打开SqlSession会话
     */
    private void openSession()
    {
        sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public int insertRole(Role role)
    {
        int i;
        try
        {
            i = getRoleMapper().insertRole(role);
        } finally
        {
            if (sqlSession != null)
            {
                sqlSession.close();
            }
        }
        return i;
    }

    @Override
    public int deleteRole(Long id)
    {
        return 0;
    }

    @Override
    public int updateRole(Role role)
    {
        return 0;
    }

    @Override
    public Role getRole(Long id)
    {
        return getRoleMapper().getRole(id);
    }

    @Override
    public List<Role> findRoles(String roleName)
    {
        return null;
    }

    private RoleMapper getRoleMapper()
    {
        if (sqlSession == null)
        {
            openSession();
        }
        return sqlSession.getMapper(RoleMapper.class);
    }
}
