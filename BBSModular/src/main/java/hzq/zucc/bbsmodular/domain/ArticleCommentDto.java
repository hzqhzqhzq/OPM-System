package hzq.zucc.bbsmodular.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 何圳青
 * @Date: Created in 16:05 2019/3/4
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "article_comment")
public class ArticleCommentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    @Column(name = "article_id", nullable = false)
    private int articleId;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "comment", nullable = false)
    private String comment;
    @Column(name = "to_user_id", nullable = false)
    private int toUserId;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
    @Column(name = "delete_time", nullable = false)
    private Date deleteTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}
