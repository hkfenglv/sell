package com.fenglv.sell.util;

import com.fenglv.sell.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo vo = new ResultVo();
        vo.setData(object);
        vo.setCode(200);
        vo.setMsg("成功");
        return vo;
    }

    public static ResultVo success(){
        return success(null);
    }

    public  static ResultVo error(Integer errorCode,String msg){
        ResultVo vo = new ResultVo();
        vo.setCode(errorCode);
        vo.setMsg(msg);
        return vo;
    }

    public  static ResultVo error(String msg){
        return error(-100,msg);
    }
}
