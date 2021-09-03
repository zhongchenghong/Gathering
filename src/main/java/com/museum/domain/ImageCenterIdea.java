package com.museum.domain;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class ImageCenterIdea {
    private  Integer id;
    private Integer state;
    private Integer grantId;
    private  String centerIdea;
    private   String  content;
}
