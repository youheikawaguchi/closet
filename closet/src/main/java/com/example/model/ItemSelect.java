package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ItemSelect {

    // セレクトボックスの値を保持するクラス

    private List<Category> categoryList;
    private List<SubCategory> subCategoryList;
    private List<Season> seasonList;
    private List<Color> colorList;

}
