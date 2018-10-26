/* @PathVariable 사용법
 */
package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ex02.Car;

@Controller
@RequestMapping("ex03/test24")
public class Test24 {

    // 테스트:
    //      http://localhost:8888/app/ex03/test24/car/detail?no=100
    
    @RequestMapping("car/detail")
    public String m1(
            int no,
            Model model) throws Exception{

        // 이 request handler가 호출될 때
        // 해당 DBMS 해당 번호의 차 정보를 가져온다고 가정하자!
        Car car = new Car();
        car.setNo(100);
        car.setModel("소나타");
        car.setMaker("현재자동차");
        car.setAuto(true);
        
        model.addAttribute(car);

        return "ex03/Test24";
    }
    
    // 테스트:
    //      http://localhost:8888/app/ex03/test24/car/200
    
    @RequestMapping("car/{no}/{auto}")
    public String m2(
            @PathVariable int no,
            @PathVariable boolean auto,
            Model model) throws Exception{

        Car car = new Car();
        car.setNo(200);
        car.setModel("아반떼");
        car.setMaker("현재자동차");
        car.setAuto(auto);
        
        model.addAttribute(car);

        return "ex03/Test24";
    }
}