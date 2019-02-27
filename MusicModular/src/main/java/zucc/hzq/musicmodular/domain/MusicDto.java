package zucc.hzq.musicmodular.domain;

import javafx.scene.chart.PieChart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: 何圳青
 * @Date: Created in 10:33 2019/2/26
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "song_info")
public class MusicDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;
    @Column(name = "song_name", nullable = false)
    private String songName;
    @Column(name = "author_id", nullable = false)
    private int authorId;
    @Column(name = "author_name", nullable = false)
    private String authorName;
    @Column(name = "collection", nullable = false)
    private int collection;
    @Column(name = "dislike", nullable = true)
    private int dislike;
    @Column(name = "song_url", nullable = true)
    private String songUrl;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    @Column(name = "update_time", nullable = true)
    private Date updateTime;
    @Column(name = "delete_time", nullable = true)
    private Date deleteTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
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
