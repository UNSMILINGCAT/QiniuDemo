package com.ycwh.demo.chapter4;

import com.ycwh.demo.chapter4.POJO.ArkDinosaur;

import java.util.List;

public interface ArkDinosaurMapper
{
    public List<ArkDinosaur> select();

    public void insert(ArkDinosaur arkDinosaur);

    public void upDate(ArkDinosaur arkDinosaur);
}
