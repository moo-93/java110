package bitcamp.java110.cms.util;

public interface List<T> {
    void add(T t);
    T get(int index);
    T remove(int index);
    int size();
    // 인터페이스에서의 default 메서드의 목적
    // => 규칙을 추가하면 기존 클래스들이 영향을 받는다.
    // => 즉 기존 클래스들은 새로 추가한 메서드를 반드시 구현해야 한다.
    // => 기존 클래스들에 영향을 주지 않게 해주는 문법
    default void insert(int index, T obj) {
        // 인터페이스의 메서드는 규칙이다.
        // 하위 호환을 위해서 메서드를 추가
        // 실제 많은 작업을 처리하게 구현해선 안된다.
        // 구현 클래스들의 영향을 끼치지 않게하는 정도로만 작성해야한다.
        // 규칙에 있어서 강제성이 떨어진다.
    }
}
