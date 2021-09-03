package com.museum.util;

import com.museum.domain.PictureOVVoide;
import lombok.Data;

@Data
public class WangEditor {

    private Integer errno; //错误代码，0 表示没有错误。
    private PictureOVVoide data; //已上传的图片路径


    public WangEditor(PictureOVVoide data) {
        super();
        this.errno = 0;
        this.data = data;
    }

}

