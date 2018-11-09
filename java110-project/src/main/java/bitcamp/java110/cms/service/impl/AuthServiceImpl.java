package bitcamp.java110.cms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    //필드에 설정하면 setter 를 만들 필요가 없음
    @Autowired MemberDao memberDao;
    @Autowired ManagerDao managerDao;
    @Autowired StudentDao studentDao;
    @Autowired TeacherDao teacherDao;

    @Override
    public Member getMember(
            String email, String password, String memberType) {

        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

        if (memberType.equals("manager")) {
            return managerDao.findByEmailPassword(params);

        } else if (memberType.equals("student")) {
            return studentDao.findByEmailPassword(params);

        } else if (memberType.equals("teacher")) {
            return teacherDao.findByEmailPassword(params);

        } else {
            return null;
        }
    }

    @Override
    public Member getFacebookMember(
            String type, String accessToken) {

        // Facebook의 Graph API 실행하기
        // => HTTP 요청을 할 때 스프링에서 제공하는 RestTemplate을 사용하라!
        RestTemplate restTemplate = new RestTemplate();

        /*
         HashMap<String,String> vars = new HashMap<>();
         vars.put("v1", accessToken);
         vars.put("v2","id,name,email");
         */

        // 원격 서버에서 보낸 JSON 문자열을 Map 객체로 자동 변환하려면
        // JSON 문자열을 처리하는 라이브러리를 추가해 둬야 한다.
        // 따로 코드를 추가할 필요 없다.
        // => Gson 또는 Jackson 라이브러리
        @SuppressWarnings("rawtypes")
        Map response = restTemplate.getForObject(
                "https://graph.facebook.com/v3.2/me?access_token={v1}&fields={v2}",
                Map.class,
                accessToken,
                "id,name,email");
        // vars); // 개별값 대신 맵으로 한번에 넣을 수 있다.
        System.out.println(response);

        // Facebook 사용자의 이메일로 현재 서버의 사용자 정보를 찾는다.
        Member member = null;
        if (type.equals("manager")) {
            member = managerDao.findByEmail(response.get("email").toString());

        } else if (type.equals("student")) {
            member =studentDao.findByEmail(response.get("email").toString());

        } else if (type.equals("teacher")) {
            member = teacherDao.findByEmail(response.get("email").toString());
        }
        
        Member newbie = createMember(type,
                response.get("email").toString(),
                response.get("name").toString(),
                "1111");
        
        memberDao.insert(newbie);

        // 현재 서버에 가입되어 있다면
        if(member != null)
            return member;
        
        // 현재 서버에 가입하지 않았다면,
        // 페이스북 기본정보를 가지고 자동으로 회원등록 한다.
        if (type.equals("manager")) {
            ((Manager)newbie).setPosition("미정");
            managerDao.insert((Manager)newbie);
        } else if (type.equals("student")) {
            ((Student)newbie).setSchool("미정");
            ((Student)newbie).setWorking(false);
            studentDao.insert((Student)newbie);
        } else if (type.equals("teacher")) {
            ((Teacher)newbie).setPay(0);
            ((Teacher)newbie).setSubjects("미정");
            teacherDao.insert((Teacher)newbie);
        }
        return newbie;
    }
    
    private Member createMember(
            String type, String email, String name, String password) {
        Member mem = null;
        if (type.equals("manager")) {
            mem = new Manager();
        } else if (type.equals("student")) {
            mem = new Student();
        } else if (type.equals("teacher")) {
            mem = new Teacher();
        }
        
        mem.setEmail(email);
        mem.setName(name);
        mem.setPassword(password);
        
        return mem;
    }
}










