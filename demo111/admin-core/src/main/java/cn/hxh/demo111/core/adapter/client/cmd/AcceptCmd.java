package cn.hxh.demo111.core.adapter.client.cmd;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: xinhao.hu
 * @date: 2022/2/14 3:47 下午
 * @description:
 **/
@Data
public class AcceptCmd {
    private String id;

    private MultipartFile file;
}
