(function ($) {
    $.fn.formatCurrency = function(money) {
        return money.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    }
})(jQuery);