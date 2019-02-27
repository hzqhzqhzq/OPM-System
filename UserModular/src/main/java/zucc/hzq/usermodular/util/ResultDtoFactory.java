package zucc.hzq.usermodular.util;

/**
 * @Auther: 何圳青
 * @Date: Created in 19:27 2019/1/28
 * @Description:
 * @Modified By:
 */
public final class ResultDtoFactory {
    private static String ackCode ="1";
    private static String notAckCode ="0";
    private static String sqlErrorCode ="2";
    private static String serviceErrorCode ="3";

    public  static ResultDto toAck(String msg) {
        return toAck(msg, null);
    }
    public  static ResultDto toAck(String msg, Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(ackCode);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }

    public static ResultDto toNack(String msg) {
        return toNack(msg, null);
    }
    public static ResultDto toNack(String msg, Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(notAckCode);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }




    public static ResultDto toSQLError(String msg) {
        return toSQLError(msg, null);
    }
    public static ResultDto toSQLError(String msg, Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(sqlErrorCode);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }

    public static ResultDto toServiceError(String msg) {
        return toServiceError(msg, null);
    }
    public static ResultDto toServiceError(String msg, Object data) {
        ResultDto dto = new ResultDto();
        dto.setCode(serviceErrorCode);
        dto.setMessage(msg);
        dto.setData(data);
        return dto;
    }
}
