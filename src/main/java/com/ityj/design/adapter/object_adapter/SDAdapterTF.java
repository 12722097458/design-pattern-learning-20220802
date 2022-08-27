package com.ityj.design.adapter.object_adapter;

import lombok.Data;

@Data
public class SDAdapterTF extends SDCardImpl {

    private TFCardImpl tfCard;

    public SDAdapterTF(TFCardImpl tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readData() {
        return tfCard.readData();
    }

    @Override
    public void writeData(String data) {
        tfCard.writeData(data);
    }
}
