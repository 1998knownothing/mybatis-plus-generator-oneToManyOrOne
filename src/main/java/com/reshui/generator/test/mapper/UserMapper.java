package com.reshui.generator.test.mapper;


import com.reshui.generator.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuye
 * @since 2021-08-28
 */
public interface UserMapper extends BaseMapper<User> {

    //@ResultMap(value="projectAuditRecordDtoMap")



    @Select("select \n" +
            "a.parid,a.pid,a.pnode,a.audit_status,a.sender,\n" +
            "b.realname as sender_name,\n" +
            "a.send_time,a.uploaded_files,a.auditor,\n" +
            "c.realname as auditor_name,\n" +
            "a.audit_time,a.audit_report\n" +
            " FROM\n" +
            "project_audit_record a LEFT JOIN userinfo b on a.sender=b.\"UID\"\n" +
            "LEFT JOIN userinfo c on a.auditor=c.\"UID\" where a.pid=#{pid} order by parid asc")
    @Results(id="projectAuditRecordDtoMap", value={
            @Result(column="parid", property="parid", id=true),
            @Result(column="pid", property="pid"),
            @Result(column="pnode", property="pnode"),
            @Result(column="audit_status", property="auditStatus"),
            @Result(column="sender", property="senderId"),
            @Result(column="sender_name", property="senderName"),
            @Result(column="send_time", property="sendTime"),
            @Result(column="uploaded_files", property="uploadedFiles"),
            @Result(column="auditor", property="auditorId"),
            @Result(column="auditor_name", property="auditorName"),
            @Result(column="auditor_time", property="auditorTime"),
            @Result(column="auditor_report", property="auditorReport"),
    })
    List<User> queryProjectAuditRecords(@Param("pid")String  pid);


    @Select({"<script>",
            "select * from (select A.*,rownum rn from (select * from EVALUATION_INDEX",
            "<where> ",
            "<if test='ename!=null'>",
            "ENAME= #{ename} ",
            "</if>",
            "<if test='description!=null'>",
            "AND description like '%${description}%' ",
            "</if>",
            "<if test='category!=null'>",
            "AND CATEGORY= #{category} ",
            "</if>",
            "<if test='importance!=null'>",
            "AND IMPORTANCE = #{importance}",
            "</if>",
            "</where> ",
            "order by eid desc )A  where rownum  &lt;=to_number(#{end}) ) where rn &gt;=to_number(#{start})",
            "</script>"})
    List<Object> queryAllEvaluationIndex(@Param("ename") String ename,
                                         @Param("description") String description,
                                         @Param("category") String category,
                                         @Param("importance") String importance,
                                         @Param("start") int start, @Param("end") int end);


    @Delete({"<script>",
            "delete EVALUATION_INDEX where eid in",
            " ( ",
            "<foreach collection=\"eids\" item=\"eid\" index=\"index\" separator=\",\">",
            "#{eid}",
            "</foreach>",
            " )",
            "</script>"})
    int  deleteEvaluationIndex(@Param("eids") List<BigDecimal> eids);
}
