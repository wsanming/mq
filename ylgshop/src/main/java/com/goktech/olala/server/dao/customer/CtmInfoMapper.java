package com.goktech.olala.server.dao.customer;

import com.goktech.olala.core.req.ReqCtmInfo;
import com.goktech.olala.core.resp.RespCtmInfo;
import com.goktech.olala.server.dao.customer.sql.CtmInfoSql;
import com.goktech.olala.server.pojo.customer.CtmInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CtmInfoMapper {

    /**
     * 根据客户信息主键删除
     *
     * @param customerInfId
     * @return
     */
    int deleteByPrimaryKey(Long customerInfId) throws Exception;

    /**
     * 伪删除操作
     *
     * @param customerInfId
     * @return
     * @throws Exception
     */
    @Update("UPDATE C_CUSTOMER_INFO SET CUSTOMER_STATUS = 0,IS_DEL = ${isDel} WHERE CUSTOMER_INF_ID = #{customerInfId}")
    int updateIsDelById(@Param("customerInfId") Long customerInfId, @Param("isDel") int isDel) throws Exception;

    /**
     * 添加客户信息
     *
     * @param record
     * @return
     */
    int insert(CtmInfo record) throws Exception;

    /**
     * 根据客户信息主键ID查询
     *
     * @param customerInfId
     * @return
     */
    CtmInfo selectByPrimaryKey(Long customerInfId) throws Exception;

    /**
     * 查询所有有效客户信息
     *
     * @return
     */
    List<CtmInfo> selectAll() throws Exception;

    /**
     * 根据客户信息主键ID更新客户信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(CtmInfo record) throws Exception;

    /**
     * 绑定查询条件查询客户信息
     *
     * @param record
     * @return
     */
    @SelectProvider(type= CtmInfoSql.class, method = "selectCtmInfoByParam")
    List<RespCtmInfo> selectByExample(ReqCtmInfo record) throws Exception;

    @Update("UPDATE C_CUSTOMER_INFO SET CUSTOMER_STATUS = ${customerStatus} WHERE CUSTOMER_INF_ID = #{customerInfId}")
    int updateStatus(@Param("customerInfId") Long customerInfId, @Param("customerStatus") Integer customerStatus) throws Exception;

//    @InsertProvider(type= CtmInfoSql.class, method = "addCtmInfoByParam")
//    @Options(useGeneratedKeys = true, keyProperty = "customerInfId", keyColumn = "CUSTOMER_INF_ID")
    int insertByExample(CtmInfo record) throws Exception;

    /*根据随机生成id查询信息*/
    CtmInfo selectByCtmId(String customerId) throws Exception;

    @Select("<script>"+
            "SELECT INFO.CUSTOMER_ID customerId,INFO.CUSTOMER_NAME customerName, INFO.REAL_NAME realName,INFO.USER_MOBILE userMobile,INFO.EMAIL " +
            "FROM C_CUSTOMER_INFO INFO "
            +"<where>"
                +"<if test=\"mobile != null and mobile != '' \">"
                    +" AND INFO.CUSTOMER_NAME = #{mobile}"
                +"</if>"
                +"<if test=\"email != null and email != '' \">"
                    +" AND INFO.CUSTOMER_NAME = #{email}"
                +"</if>"
            + "</where>"
            +"</script>")
    RespCtmInfo selectByAccount(@Param("mobile") String mobile, @Param("email") String email) throws Exception;

}