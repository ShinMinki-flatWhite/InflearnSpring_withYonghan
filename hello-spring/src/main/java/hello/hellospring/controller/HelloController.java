package hello.hellospring.controller;

import hello.hellospring.DAO.SampleObjectVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello (Model model){
        model.addAttribute("data", "this is a attributeValue of attributeName('data')" );
        return "sample";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";

    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString (@RequestParam("stringParam") String param){
        return "@ResponseBody -> HttpMessageConverter -> StringHttpMessageConverter_출력 : " + param;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public SampleObjectVo helloApi (@RequestParam("paramName") String paramName, @RequestParam("paramAge") int paramAge ){
        SampleObjectVo object = new SampleObjectVo();
        object.setName(paramName);
        object.setAge(paramAge);
        return object;
    }

}

