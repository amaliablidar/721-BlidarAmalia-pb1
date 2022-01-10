package com.company;

import com.company.controller.Controller;
import com.company.model.Offert;
import com.company.repository.OffertenRepo;

import java.awt.desktop.OpenFilesEvent;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        OffertenRepo offertenRepo=new OffertenRepo();
        List<Offert> offertList= new ArrayList<>();
        offertList=offertenRepo.readFromFile("/Users/amaliablidar/IdeaProjects/demo/demo1/exercitiul1-BlidarAmalia-721-1/src/com/company/offerten.txt","&");
	    for(Offert offert:offertList){
            System.out.println(offert.getId());
        }

        Controller controller = new Controller();
        List<Offert> sortedList = new ArrayList<>();
        sortedList=controller.sortedListByPreis(offertList);
        for(Offert offert:sortedList){
            System.out.println(offert.getPreis());
        }

        offertenRepo.writeToFile(offertList,"/Users/amaliablidar/IdeaProjects/demo/demo1/exercitiul1-BlidarAmalia-721-1/src/com/company/offertensortiert.txt","&");
        // /Users/amaliablidar/IdeaProjects/demo/demo1/exercitiul1-BlidarAmalia-721-1/src/com/company


        //offertenRepo.writeToFile(controller.haufistenAngezeigtOrt(offertList),"/Users/amaliablidar/IdeaProjects/demo/demo1/exercitiul1-BlidarAmalia-721-1/src/com/company/statistik.txt","&");
    }
}
