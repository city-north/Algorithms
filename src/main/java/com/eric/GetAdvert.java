package com.eric;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen 2017/11/8
 */
public class GetAdvert {


    public static void main(String[] args) {
        for(int i=1;i<=100000;i++){
            test(i,10,3,5);
        }
    }
    public static void test(Integer pageNum,Integer pageSize,int gap,int listSize){
        //第几页  //每页数据的个数 //每gap条数据插播一套广告
        List<advert> adverts = new ArrayList<advert>();
        for(int i = 1;i<=listSize;i++){        //10条广告循环
            advert advert = new advert();
            advert.setUrl("第"+(i)+"条广告");
            adverts.add(advert);
        }
        int addSize = pageSize/gap; //每页AddSize条广告
        System.out.println("每页"+addSize+"条广告");
        int startIndex = (pageNum - 1) * addSize;
        int endIndex =  pageNum * addSize;
        List<advert> showAdd;
        int advertSize = adverts.size();
        if(endIndex>advertSize&&startIndex>advertSize){
            //开始大于广告数组长度，结束大于广告数组长度
            endIndex = endIndex%advertSize;
            startIndex = startIndex%advertSize;
            if(startIndex > endIndex){  //开始大于结束
                showAdd = adverts.subList(startIndex,advertSize);
                showAdd.addAll(adverts.subList(0, endIndex));
            }else {
                showAdd = adverts.subList(startIndex,endIndex);
            }
        }else if(endIndex>advertSize&&!(startIndex>advertSize)){
            endIndex = endIndex%advertSize;
            showAdd = adverts.subList(startIndex,advertSize);
            showAdd.addAll(adverts.subList(0, endIndex));
        }else {
            showAdd = adverts.subList(startIndex,endIndex);
        }
        System.out.println("第"+pageNum+"页");
        System.out.println(showAdd);
    }
    @Test
    public void text(){
        boolean b = returnTest();
        System.out.println(b);
    }
    public boolean returnTest()
    {
        try
        {
            return true;
        }
        catch (Exception e)
        {

        }
        finally
        {
            return false;
        }
    }
}
