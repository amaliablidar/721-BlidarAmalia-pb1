package com.company.repository;

import com.company.model.Offert;
import com.company.model.Ort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OffertenRepo {
    List<Offert> offertList = new ArrayList<>();

    public List<Offert> readFromFile(String fileName, String separator) throws IOException {
        String strCurrentLine;
        Offert offert;
        BufferedReader objReader = new BufferedReader(new FileReader(fileName));
        while ((strCurrentLine = objReader.readLine()) != null) {
            String[] array;
            array = strCurrentLine.split(separator);
            offert = new Offert(Long.parseLong(array[0]),array[1],Float.parseFloat(array[2]),Float.parseFloat(array[3]),array[4], Ort.valueOf(array[5]));
            offertList.add(offert);
        }
        return offertList;
    }

    public void writeToFile (List<Offert> list,String fileName,String separator) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        for (Offert offert : list) {
            myWriter.write(offert.getId()+separator+offert.getUnternehmensname()+separator+offert.getPreis()+separator+offert.getMehrwertsteuer()+separator+offert.getAdresse()+separator+offert.getOrt()+"\n");
        }
        myWriter.close();
    }

}
