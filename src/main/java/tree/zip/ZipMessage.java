package tree.zip;

import lombok.Data;

import java.util.Map;

/**
 * 压缩结果信息.
 *
 * @author: dragonhht
 * @Date: 2019-11-8
 */
@Data
public class ZipMessage {
    /** 编码后的字节. */
    private byte[] bytes;
    /** 编码表. */
    private Map<Byte, String> codeMap;
    /** 最后一位编码长度。 */
    private int lastLen;
}
