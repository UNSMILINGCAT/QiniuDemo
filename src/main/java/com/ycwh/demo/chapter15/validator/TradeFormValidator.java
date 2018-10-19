package com.ycwh.demo.chapter15.validator;


import com.ycwh.pojo.TradeForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TradeFormValidator implements Validator
{
    /**
     * 判断当前验证器是否用于验证Class类型的POJO
     *
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass)
    {
        return TradeForm.class.equals(aClass);
    }

    /**
     * 检验POJO的合法性
     *
     * @param o
     * @param errors
     */
    @Override
    public void validate(Object o, Errors errors)
    {
        TradeForm tradeForm= (TradeForm) o;
        double dis=tradeForm.getAmount()-(tradeForm.getPrice()*tradeForm.getQuantity());
        if(Math.abs(dis)>0.01){
            errors.rejectValue("amount",null,"交易金额与购买数量和价格不匹配");
        }
    }
}
