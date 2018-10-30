// 메서드 호출 앞 또는 뒤에 코드 붙이기 : 프록시를 패턴을 적용하여 처리하기
package ex11.step2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test02 {

    public static void main(String[] args) {

        // HashMap의 프록시 만들기
        // => Map 인터페이스를 구현한다.
        // => 기존의 HashMap, Hashtable 클래스의 코드를 손대지 않고,
        //    특정 메서드에 새 기능을 추가하는 방법이다.
        class MyMapProxy implements Map<String,Object> {
            Map<String,Object> original;

            public MyMapProxy(Map<String,Object> original) {
                this.original = original;
            }

            public int size() {
                return original.size();
            }

            public boolean isEmpty() {
                return original.isEmpty();
            }

            public boolean containsKey(Object key) {
                return original.containsKey(key);
            }

            public boolean containsValue(Object value) {
                return original.containsValue(value);
            }

            public Object get(Object key) {
                return original.get(((String)key).toLowerCase());
            }

            public Object put(String key, Object value) {
                return original.put(key.toLowerCase(), value);
            }

            public Object remove(Object key) {
                return original.remove(key);
            }

            public void putAll(Map<? extends String, ? extends Object> m) {
                original.putAll(m);
            }

            public void clear() {
                original.clear();
            }

            public Set<String> keySet() {
                return original.keySet();
            }

            public Collection<Object> values() {
                return original.values();
            }

            public Set<Entry<String, Object>> entrySet() {
                return original.entrySet();
            }

            public boolean equals(Object o) {
                return original.equals(o);
            }

            public int hashCode() {
                return original.hashCode();
            }

        }

        HashMap<String,Object> original = new HashMap<>();
        
        // 프록시도 Map이기 때문에 일반 맵처럼 사용한다.
        Map<String,Object> map = new MyMapProxy(original);

        map.put("name", "홍길동");
        map.put("Name", "임꺽정");
        map.put("naMe", "유관순");

        System.out.println(map.get("name"));
        System.out.println(map.get("Name"));
        System.out.println(map.get("naMe"));
        
        // 메서드가 많은 클래스에 대해 프록시 클래스를 만들 때, 
        // 오버라이딩 하기 번거롭다.
        // 해결책!
        // => 자동으로 Proxy 클래스를 만들기!
    }
}








