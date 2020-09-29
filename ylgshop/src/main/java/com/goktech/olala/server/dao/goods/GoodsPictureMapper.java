package com.goktech.olala.server.dao.goods;

import com.goktech.olala.core.req.ReqPicture;
import com.goktech.olala.core.resp.RespPictureVo;
import com.goktech.olala.server.pojo.goods.GoodsPicture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsPictureMapper {
    int deleteByPrimaryKey(Long pictureId) throws Exception;

    @Delete("DELETE FROM G_PICTURE WHERE RELATION_ID = #{relationId} AND RELATION_TYPE = #{relationType}")
    int deleteByRelation(@Param("relationId") String relationId, @Param("relationType") Integer relationType) throws Exception;

    int insertByExample(GoodsPicture record) throws Exception;

    GoodsPicture selectByPrimaryKey(Long pictureId) throws Exception;

    @Select("<script>"
            + "SELECT PICTURE.PICTURE_ID pictureId, PICTURE.PICTURE_TITLE pictureTitle, PICTURE.PREF_TITLE prefTitle, PICTURE.KEYWORDS, PICTURE.RELATION_ID relationId, PICTURE.PIC_CATEGORY picCategory," +
            " PICTURE.RELATION_TYPE relationType, PICTURE.AUTHOR, PICTURE.SOURCE, PICTURE.IS_ALLOW_COMMENT isAllowComment, PICTURE.THUMB_IMG thumbImg, PICTURE.REAL_IMG realImg, PICTURE.ORIGINAL_IMG originalImg," +
            " PICTURE.LINK_URL linkUrl, PICTURE.WIDTH, PICTURE.HEIGHT, PICTURE.SORT_ORL sortOrl, PICTURE.STATUS, PICTURE.DEPLOY_TIME deployTime, PICTURE.OUTLINE_TIME outlineTime, PICTURE.IS_MASTER isMaster," +
            " PICTURE.CREATE_TIME createTime, PICTURE.CREATE_BY createBy, PICTURE.UPDATE_TIME updateTime, PICTURE.UPDATE_BY updateBy, PICTURE.ABSTRACTS, PICTURE.PIC_DESC picDesc," +
            " CONCAT(PICTURE.PICTURE_ID,',',PICTURE.PICTURE_TITLE,',',PICTURE.REAL_IMG) pictureInfo "
            + "FROM G_PICTURE PICTURE"
            + "<where>"
                + "<if test=\"reqPicture.pictureId != null\">"
                    + " AND PICTURE.PICTURE_ID = #{reqPicture.pictureId}"
                + "</if>"
                + "<if test=\"reqPicture.pictureTitle != null and reqPicture.pictureTitle != ''\">"
                    + " AND PICTURE.PICTURE_TITLE LIKE '%${reqPicture.pictureTitle}%'"
                + "</if>"
                + "<if test=\"reqPicture.relationId != null and reqPicture.relationId != '' \">"
                    + " AND PICTURE.RELATION_ID = #{reqPicture.relationId}"
                + "</if>"
                + "<if test=\"reqPicture.relationType != null\">"
                    + " AND PICTURE.RELATION_TYPE = #{reqPicture.relationType}"
                + "</if>"
                + "<if test=\"reqPicture.status != null\">"
                    + " AND PICTURE.STATUS = #{reqPicture.status}"
                + "</if>"
                + "<if test=\"reqPicture.isMaster != null\">"
                    + " AND PICTURE.IS_MASTER = #{reqPicture.isMaster}"
                + "</if>"
            + "</where>"
            + " ORDER BY PICTURE.UPDATE_TIME DESC"
            + "</script>")
    List<RespPictureVo> selectByExample(@Param("reqPicture") ReqPicture reqPicture) throws Exception;

    int updateByPrimaryKey(GoodsPicture record) throws Exception;

    @Update("UPDATE G_PICTURE SET STATUS = #{status} WHERE PICTURE_ID = #{pictureId}")
    int updateStatusById(@Param("pictureId") Long pictureId, @Param("status") Integer status) throws Exception;
}