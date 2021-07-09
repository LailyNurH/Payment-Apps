package com.laily.responsimp3.data;

import com.laily.responsimp3.R;
import com.laily.responsimp3.model.Shoes;

import java.util.ArrayList;

public class ShoesData {
    private  static String [] name = {
            "Air Max Pegasus 37",
            "Nike Cosmic Unity",
            "Nike React Live",
            "Air Max 90 FlyEase",
            "Air Max 270",
            "Air Max 270 React SE",
            "Jordan MA2",
            "Nike React Art3mis"
    };
    private static  String [] rating = {
            "3.1",
            "3.6",
            "3.1",
            "4.3",
            "4.1",
            "3.9",
            "3.5",
            "4.5",
    };
    private static String [] price = {
            "$ 9,995",
            "$ 13,495",
            "$ 10,295",
            "$ 10,295",
            "$ 13,995",
            "$ 14,495",
            "$ 7,495",
            "$ 9,295"
    };
    private static String [] type={
            "Women's Running Shoes",
            "Men's  Basketball Shoes",
            "Men's Shoes",
            "Men's Sneakers",
            "Men's Shoes",
            "Men's Shoes",
            "Kid's Shoes",
            "Women's Shoes"
    };
    private  static  int [] image = {
            R.drawable.airpegasus37,
            R.drawable.cosmicunity,
            R.drawable.customnikereactlive,
            R.drawable.airmax90flyease,
            R.drawable.airmax270,
            R.drawable.airmax270reactse,
            R.drawable.jordanma2,
            R.drawable.reactart3mis
    };
    public static ArrayList <Shoes> getListData(){
        ArrayList<Shoes> list = new ArrayList<>();
        for (int position = 0 ; position < name.length; position++){
            Shoes shoes = new Shoes();
            shoes.setRating(rating[position]);
            shoes.setShoesname(name[position]);
            shoes.setPrice(price[position]);
            shoes.setType(type[position]);
            shoes.setImage(image[position]);
            list.add(shoes);
        }
        return list;
    }
}
