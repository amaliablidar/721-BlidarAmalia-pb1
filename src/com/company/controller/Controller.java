package com.company.controller;

import com.company.model.Offert;
import com.company.model.Ort;

import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    public float preisMitMehrWertsTeuer(Offert offert){
        float preis=0;
        preis=offert.getPreis()+(offert.getMehrwertsteuer()/100)*offert.getPreis();
        return preis;
    }

    public List<Offert> sortedListByPreis(List<Offert> offertList){

        for(Offert offert:offertList){
            offert.setPreis(preisMitMehrWertsTeuer(offert));
        }
        List<Offert> sortedList=new ArrayList<>();
        sortedList= offertList.stream().sorted(Comparator.comparing(Offert::getPreis)).collect(Collectors.toList());
        Collections.reverse(sortedList);
        return sortedList;
    }
    public Map<String,Integer> haufistenAngezeigtOrt(List<Offert> offertList){
        int zurich=0;
        int thurgau=0;
        int stGallen=0;
        for(Offert offert:offertList) {
            if (offert.getOrt() == Ort.Zürich)
                zurich += offert.getPreis();
            if(offert.getOrt()==Ort.Thurgau)
                thurgau+=offert.getPreis();
            if(offert.getOrt()==Ort.StGallen)
                stGallen+=offert.getPreis();
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("Zurich",zurich);
        result.put("Thurgau",thurgau);
        result.put("StGallen",stGallen);
        return result;
    }
}
