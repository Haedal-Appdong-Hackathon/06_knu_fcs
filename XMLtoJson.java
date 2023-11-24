package com.example.infybuzz;

import org.json.XML;

public class XMLtoJava {
    public static void main(String[] args){
        String xmlStr = "you_need_to_add_here_xmlfile";

        JSONObjext json = XML.toJSONObject(xmlstr);
        System.out.println(json);
    }
}
