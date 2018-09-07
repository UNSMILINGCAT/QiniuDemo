package com.ycwh.demo.chapter4;

import com.ycwh.demo.chapter4.POJO.Dinosaur;

import java.util.List;

public interface DinosaurMapper
{
    public List<Dinosaur> selectAll();

    public void insert(Dinosaur dinosaur);
}
