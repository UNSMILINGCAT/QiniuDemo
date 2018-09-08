package com.ycwh.demo.chapter4;

import com.ycwh.demo.chapter4.POJO.ArkDinosaur;
import com.ycwh.demo.chapter4.POJO.ArkDinosaurColumn;

import java.util.List;

public interface ArkDinosaurMapper
{
    public List<ArkDinosaur> select();

    public ArkDinosaur[] selectColumn(ArkDinosaurColumn column);

    public void insert(ArkDinosaur arkDinosaur);

    public void upDate(ArkDinosaur arkDinosaur);
}
