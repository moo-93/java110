// AOP : 다양한 AOP 설정 방법
package ex11.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    // app-context-?.xml 파일을 확인하라!
    // 
    
    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-3.xml");
                //new AnnotationConfigApplicationContext(AppConfig.class);

        //이 시점에서 IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); // ---> MethodFilter.invoke() ---> original.add();
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();
    }
    
    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("==============================");

        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        System.out.println("------------------------------");
    }
}
