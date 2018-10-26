/* @RequestMapping 다루기 : URL 다루기 
 * 
 */

package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test08 {
    
    @RequestMapping(value="/ex02/test08/m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test08.m1()";
    }
    
    @RequestMapping(value="/ex02/test08/m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test08.m2()";
    }
}