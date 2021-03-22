package com.example.myjetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;
import java.util.List;

public class BaseketBallViewModel extends ViewModel  {
    private MutableLiveData<Integer> aTeam, bTeam;
    private List<Integer> tmpA,tmpB;
    boolean flag;

    public MutableLiveData<Integer> getaTeam() {
        if (aTeam == null) {
            aTeam = new MutableLiveData<>();
            aTeam.setValue(0);
            tmpA = new LinkedList<>();
            tmpA.add(0);
        }
        return aTeam;
    }

    public void setaTeam(int n) {
        aTeam.setValue(getaTeam().getValue() + n);
        if(n > 0){
            tmpA.add(n);
            flag = true;
        }
    }

    public MutableLiveData<Integer> getbTeam() {
        if (bTeam == null) {
            bTeam = new MutableLiveData<>();
            bTeam.setValue(0);
            tmpB = new LinkedList<>();
            tmpB.add(0);
        }
        return bTeam;

    }

    public void setbTeam(int n) {
        bTeam.setValue(getbTeam().getValue() + n);
        if(n > 0){
            tmpB.add(n);
            flag = true;
        }
    }


    public void undo(){
        //true为A
        if(flag){
            if(tmpA.size() >= 2){
                setaTeam(0-tmpA.get(tmpA.size()-1));
                tmpA.remove(tmpA.size()-1);
            }else {
                setaTeam(0);
                flag = false;
            }
        }else{
            /*.....*/
        }
    }

    public void reset(){
        setaTeam(0);
        setbTeam(0);
        tmpA.clear();
        tmpB.clear();
    }
}