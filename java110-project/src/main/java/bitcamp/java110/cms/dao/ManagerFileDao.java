package bitcamp.java110.cms.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFileDao implements ManagerDao{
    private List<Manager> list = new ArrayList<>();

    public ManagerFileDao() {
        File file = new File("data/manager.dat");

        try (BufferedReader in = 
                new BufferedReader(new FileReader(file))){

            while(true) {
                String line = in.readLine();
                if(line==null)
                    break;
                String []values = line.split(",");

                Manager m = new Manager();
                m.setName(values[0]);
                m.setEmail(values[1]);
                m.setPassword(values[2]);
                m.setTel(values[3]);
                m.setPosition(values[4]);
            }   
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void save() {
        File file = new File("data/manager.dat");

        try (BufferedWriter out = 
                new BufferedWriter(new FileWriter(file))){

            for(Manager m : list) {
                out.write(
                        String.format("%s %s %s %s %s",
                                m.getName()
                                ,m.getEmail()
                                ,m.getPassword()
                                ,m.getTel()
                                ,m.getPosition()));
            }
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int insert(Manager manager) {
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findAll() {
        return list;

    }

    public Manager findByEmail(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
