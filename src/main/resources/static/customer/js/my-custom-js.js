function showCartQuantity() {
    $.ajax({
        type: "GET",
        url: "/cart/get-count",
        success: function (response) {
            //alert(response[0]);
            $('#cart_quantity').html(response);
        }
    });
}

function showIndex() {
    var divs = document.querySelectorAll('.create_index');
    for (var i = 0; i < divs.length; ++i) {
        divs[i].innerHTML = i + 1;
    }
}