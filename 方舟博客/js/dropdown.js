$(function () {
    $(".select p").click(function (e) {
        $(".select").toggleClass('open');
        e.stopPropagation();
    });

    $(".content .select ul li").click(function (e) {
        var _this = $(this);
        $(".select > p").text(_this.attr('data-value'));
        _this.addClass("Selected").siblings().removeClass("Selected");
        $(".select").removeClass("open");
        e.stopPropagation();
    });

    $(document).on('click', function () {
        $(".select").removeClass("open");
    })

});