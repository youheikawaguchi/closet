$(function() {
    $('#menu h1').on('click', function() {
        $(this).next('ul').slideToggle();
        $(this).closest('li').siblings().find('ul').slideUp();

        /*
         * .closest('li')→ クリックされた要素から一番近いli要素に対して、操作
         * .siblings()→ 同じ階層の要素をすべて取得
         * .find('ul')→ 子要素のulを取得
         * .slideUp()→ 下から上に上がりながら非表示
         */
    });

    //$("ul.category2").click(function () {
    //$(this).next('ul').slideToggle();
    //});


    $(".categoryX").on("click", function() {
        var val = $(this).text();
        var selected = $('.category_spanX').text();
        if(val != selected){
            $('.category_spanY').text("");
        }
        $('.category_spanX').text(val);
    });

    $(".categoryY").on("click", function() {
        var val = $(this).text();
        $('.category_spanY').text("(" + val +")");


    });

    $(".seasonP").on("click", function() {
        var val = $(this).text();
        $('.season_span').text(val);
    });
});


