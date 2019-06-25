$(function() {
    $('#open').on('click', function() {
        $('#overlay, #modalWindow').fadeIn();
    });

    $('#close').on('click', function() {
        $('#overlay, #modalWindow').fadeOut();
    });

    locateCenter();
    $(window).resize(locateCenter);

    function locateCenter() {
        var w = $(window).width();
        var h = $(window).height();

        var cw = $('#modalWindow').outerWidth();
        var ch = $('#modalWindow').outerHeight();

        $('#modalWindow').css({
            'left': ((w - cw) / 2) + 'px',
            'top': ((h - ch) / 2) + 'px'
        });
    }
});