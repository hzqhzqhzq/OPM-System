package zucc.hzq.musicmodular.service;

import zucc.hzq.musicmodular.domain.MusicCommentDto;
import zucc.hzq.musicmodular.util.ResultDto;

/**
 * @Auther: 何圳青
 * @Date: Created in 22:04 2019/2/26
 * @Description:
 * @Modified By:
 */
public interface MusicCommentService {

    public ResultDto getMusicCommentByMusicId(int songId);

    public ResultDto saveComment(MusicCommentDto musicCommentDto);

    public ResultDto deleteComment(int commentId);

}
