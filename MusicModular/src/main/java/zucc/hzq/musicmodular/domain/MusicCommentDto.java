package zucc.hzq.musicmodular.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 何圳青
 * @Date: Created in 17:44 2019/2/26
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "music_comment")
public class MusicCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentsId;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "to_user_id", nullable = false)
    private int toUserId;
    @Column(name = "to_user_name", nullable = false)
    private String toUserName;
    @Column(name = "music_id", nullable = false)
    private int musicId;
    @Column(name = "comments", nullable = false)
    private String comments;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
    @Column(name = "delete_time", nullable = false)
    private Date deleteTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
