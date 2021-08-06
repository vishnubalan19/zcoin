package com.zcoinapplication.transaction;

public class CoinConversion {
    private float coin;
    private float conversionRate;
    private int coinConversionId;
    public void setCoin(float coin) {
        this.coin = coin;
    }

    public void setConversionRate(float conversionRate){
        this.conversionRate = conversionRate;
    }

    public void setCoinConversionId(int coinConversionId) {
        this.coinConversionId = coinConversionId;
    }

    public float getCoin() {
        return coin;
    }

    public float getConversionRate() {
        return conversionRate;
    }

    public int getCoinConversionId() {
        return coinConversionId;
    }
}
