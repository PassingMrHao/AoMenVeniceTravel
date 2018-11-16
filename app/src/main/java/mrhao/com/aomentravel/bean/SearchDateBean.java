package mrhao.com.aomentravel.bean;

import java.util.ArrayList;
import java.util.List;

public class SearchDateBean {

    List<String> list = new ArrayList<>();
    List<String> imglist = new ArrayList<>();
    List<String> desclist = new ArrayList<>();
    List<Integer> travelId = new ArrayList<>();

    @Override
    public String toString() {
        return "SearchDateBean{" +
                "list=" + list +
                ", imglist=" + imglist +
                ", desclist=" + desclist +
                ", travelId=" + travelId +
                '}';
    }

    public List<Integer> getTravelId() {
        return travelId;
    }

    public void setTravelId(List<Integer> travelId) {
        this.travelId = travelId;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getImglist() {
        return imglist;
    }

    public void setImglist(List<String> imglist) {
        this.imglist = imglist;
    }

    public List<String> getDesclist() {
        return desclist;
    }

    public void setDesclist(List<String> desclist) {
        this.desclist = desclist;
    }
}

