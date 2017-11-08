package com.eric;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen 2017/11/8
 */
public class GetAdvert {


    public static void main(String[] args) {
        List<advert> adverts = new ArrayList<advert>();
        for(int i = 0;i<10;i++){        //10条广告循环
            advert advert = new advert();
            advert.setUrl("第"+i+"条广告");
            adverts.add(advert);
        }
        int pageNum =7;    //第几页
        int pageSize = 10;  //每页数据的个数
        int gap =3;        //每gap条数据插播一套广告
        int addSize = pageSize/gap; //每页AddSize条广告
        System.out.println("每页"+addSize+"条广告");
        int startIndex = (pageNum - 1) * addSize;
        int endIndex =  pageNum * addSize;
        List<advert> showAdd;
        if(endIndex>adverts.size()){
            if(startIndex > adverts.size()){
                startIndex  = startIndex -adverts.size();
                showAdd = adverts.subList(startIndex,startIndex+addSize);

            }else {
                showAdd = adverts.subList(startIndex,adverts.size());
                endIndex=endIndex-adverts.size();
                List<advert> adverts1 = adverts.subList(0, endIndex);
                showAdd.addAll(adverts1);
            }
        }else {
            showAdd = adverts.subList(startIndex,endIndex);
        }

        System.out.println("第"+pageNum+"页");
        System.out.println(showAdd);
    }
}
