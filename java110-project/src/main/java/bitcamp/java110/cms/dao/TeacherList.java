package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Teacher;

public class TeacherList {
    static Teacher[] teachers = new Teacher[5];
    static int teacherIndex = 0;

    public static void add(Teacher teacher) {
        if(teacherIndex == teachers.length) {
            increaseStorage();
        }

        teachers[teacherIndex++] = teacher;
    }

    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length+3];
        for(int i = 0; i< teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }

    public static void remove(int num) {
        if(num < 0 || num >= TeacherList.size()) {
            return;
        }
        for(int i = num; i < teacherIndex - 1; i++) {
            teachers[i] = teachers[i+1];
        }
        teacherIndex--;
    }

    public static int size() {
        return teacherIndex;
    }
    
    public static Teacher get(int num) {
        if(num < 0 || num >= TeacherList.size()) {
            return null;
        }
        return teachers[num];
    }
}
