package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Controller 클래스는 @Controller를 붙인다.
public class HelloController {

    @GetMapping("hello")  //Get 방식
    public String hello(Model model){ //Model은 Spring에서 만들어 준다.
        //Model에 data: Hello!!! 로 넣는다.
        model.addAttribute("data", "Hello!!!");
        System.out.println();
        return "hello"; //Model을 resources/templates/hello.html로 보낸다.
    }

    //required false하면 name이 안들어와도 에러가 뜨지 않음. 기본은 True
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model){
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  //Http의 Response의 Body 부분에 Data를 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        //View 이런 거 없이 문자가 그대로 HTTP의 Response의 Body에 담겨서 보내진다.
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody  //객체 반환 시 Json으로 보내짐.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        //Alt+Ins 누르면 Getter Setter 자동 완성 뜸.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
