package com.ohyoung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ohYoung
 * @date 2022/2/1 21:36
 */
public class Society {

    private String name;

    public static String Advisors = "advisors";
    public static String President = "president";

    private List<Inventor> members = new ArrayList<>();
    private Map officers = new HashMap();

    public List getMembers() {
        return members;
    }

    public Map getOfficers() {
        return officers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMember(String name) {
        boolean found = false;
        for (Inventor inventor : members) {
            if (inventor.getName().equals(name)) {
                found = true;
                break;
            }
        }
        return found;
    }

}
