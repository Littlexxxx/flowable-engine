package cn.zswltech.preserver.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ImportResource(locations = {"classpath*:spring/*.xml"})
@RestController
@SpringBootApplication(scanBasePackages = {"cn.zswltech","cn.zswl","cn.tongdun"})
public class PreserverApplication {

    @RequestMapping({"/ok", "/ok.html"})
    @ResponseBody
    public String ok() {
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(PreserverApplication.class, args);
    }


}