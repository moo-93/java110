// 메서드 호출 앞 또는 뒤에 코드 붙이기 : 프록시를 패턴을 적용하여 처리하기
package ex11.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {

    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                //new ClassPathXmlApplicationContext("ex11/step1/app-context.xml");
                new AnnotationConfigApplicationContext(AppConfig.class);


        //이 시점에서 IoC 컨테이너에 들어있는 객체의 목록 출력하기
        AppConfig.printObjectList(iocContainer);
        
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); // ---> MethodFilter.invoke() ---> original.add();
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();
    }
}









