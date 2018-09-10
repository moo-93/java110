package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 에노테이션 유지 정책
 * CLASS : 컴파일 한 후에도 .class 파일에 남겨둔다. 단, 실행할 때는 참조할 수 없다.
 *          Reflection API로 클래스파일에서 에노테이션 정보를 추출 할 수 없다.
 * SOURCE : 컴파일 할 때 제거된다. 즉 .class 파일에 남겨 두지 않는다.
 * RUNTIME : 컴파일 한 후에도 .class 파일에 남겨둔다 . 실행할 때도 참조할 수 있다.
 *            Reflection API로 클래스에서 에노테이션 정보를 추출할 수 있다.
 */

@Retention(RetentionPolicy.RUNTIME) 
public @interface Component {
    /*String name; ->field
     * setName(String name)-> property
     * getName(String name)-> property
     * 
     * Annotation에서는 필드이름을 가진 proterty
     */
    String value() default ""; //value라는 이름으로 값을 지정해야하나 빈문자로 지정하려면 default ""로지정한다
    
}