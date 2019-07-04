package com.example.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Data
public class ItemForm {

    // アイテム登録時にユーザーの入力内容を格納するクラス

    private MultipartFile picture;
    private Integer categoryId;
    private Integer subCategoryId;
    private Integer seasonId;
    private Integer colorId;
    private String memo;
    
    private Integer itemId;

}
