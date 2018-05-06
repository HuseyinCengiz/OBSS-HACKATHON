package com.example.huseyincengiz.obsswatering.Models;

import com.example.huseyincengiz.obsswatering.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HuseyinCengiz on 5.05.2018.
 */

public class DataBank {

    private static final int COUNTER=2000;

    public static ArrayList<Sebze> getData() {
        ArrayList<Sebze> datas = new ArrayList<>();
        HashMap<String, Integer> resimler = new HashMap<>();



        resimler.put("Domates", R.drawable.thumb_domates);
        resimler.put("Biber", R.drawable.thumb_biber);
        resimler.put("Patlıcan", R.drawable.thumb_patlican);
        resimler.put("Marul", R.drawable.thumb_marul);
        int i=0;
        for (String key : resimler.keySet()) {
            Sebze sebze=new Sebze(key,resimler.get(key),((i*COUNTER)+100),(COUNTER+(COUNTER*i)),3);
            datas.add(sebze);
            i++;
        }
        return datas;
    }
}
