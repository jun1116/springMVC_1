package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping({"/hello-basic", "/hello-gogo"})
    public String helloBasic() {
        log.info("hello basic");
        return "ok";
    }
    @GetMapping("hello-basic")
    public String helloBasicGet(){
        log.info("hello-basic-GET");
        return "OK";
    }
    @PostMapping("hello-basic")
    public String helloBasicPost(){
        log.info("hello-basic-POST");
        return "OK";
    }
    @DeleteMapping("hello-basic")
    public String helloBasicDelete(){
        log.info("hello-basic-DELETE");
        return "OK";
    }
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.POST)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "OK";
    }
}
