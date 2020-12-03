package DAO;

import jdbcUtil.jdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * DAO是对数据库进行增删改查的类
 * 这是一个DAO基类，使用了泛型，所以可以用于任意对象的数据库的增删改查
 */
public class DAO<T> {

    private QueryRunner queryRunner =new QueryRunner();

    private Class<T> clazz;

    public DAO() {
        Type superClass = getClass().getGenericSuperclass();
        if(superClass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType)superClass;

            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if(typeArgs != null && typeArgs.length > 0){
                if(typeArgs[0] instanceof Class)
                    clazz = (Class<T>) typeArgs[0];
            }
        }
    }

    /**
     * 执行增删改操作，传入sql语句和参数
     * @param sql
     * @param args
     */
    public void updata(String sql, Object...args){
        Connection connection = null;
        try{
            connection = jdbcUtil.getConnection();
            queryRunner.execute(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(connection);
        }
    }

    /**
     * 查询一条数据
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql, Object...args){
        Connection connection = null;
        try{
            connection = jdbcUtil.getConnection();
//            queryRunner.execute(connection,sql,args);
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 获取所有符合条件的数据条目
     * @param sql
     * @param args
     * @return
     */
    public List<T> getAll(String sql, Object...args){
        Connection connection = null;
        try{
            connection = jdbcUtil.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回符合条件的某条数据条目的某个参数
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql, Object...args){
        Connection connection = null;
        try{
            connection = jdbcUtil.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler<>(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtil.releaseConnection(connection);
        }
        return null;
    }


}
