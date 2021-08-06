package com.zcoinapplication.data;

public enum Data {
    //private static Data data=null;
    /*public static Data getInstance(){
        if(data==null)
            data = new Data();
        return data;
    }*/
    data;
    private static float conversionRate = 0.2f;
    public void setConversionRate(float conversionRate){
        this.conversionRate = conversionRate;
    }
    public float getConversionRate(){
        return conversionRate;
    }
}
