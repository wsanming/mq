$(function () {
    $(".op_express_delivery_hot>li").click(function () {
        console.log($(this).attr('data-value'));
    });
    $(".pay-list>li").click(function () {
        console.log($(this).attr('data-value'));
    });
    account();
})

//提交订单
function unifiedOrder() {
    var goodsIdArr='',amountArr='',priceArr='',totalPrice=0;
    $("input[name='goodsId']").each(function(){
        var goodsId = $(this).val();
        var price = $("#price_"+goodsId).text();
        var amount = $("#amount_"+goodsId).val();
        goodsIdArr += goodsId+',';
        amountArr += amount+',';
        priceArr += (parseFloat(price)*100)+',';
        totalPrice += parseFloat(price)*100*Number(amount);
    });
    $.ajax({
        type: "POST",
        url: "/olalashop/orderApi/unifiedOrder.do",
        dataType: "json",
        async: "true",
        data: {
            "goodsIdArr": goodsIdArr,
            "amountArr": amountArr,
            "priceArr": priceArr,
            "orderMoney": totalPrice
        },
        success: function (data) {

        }
    })
    window.location.href = '/olalashop/business/home/success.html';
}

//加减数量
function resetAmount(goodsId) {
    var amount = $("#amount_"+goodsId).val();
    if(method == "-" && amount > 1){
        $("#amount_"+goodsId).val(Number(amount)-1);
    }else if(method == "+"){
        $("#amount_"+goodsId).val(Number(amount)+1);
    }
    account();
    return;
}

//统计金额和数量
function account() {
    var totalPrice = 0;
    $("input[name='goodsId']").each(function(){
        var goodsId = $(this).val();
        var price = $("#price_"+goodsId).text();
        var amount = $("#amount_"+goodsId).val();
        var money = Number(price)*Number(amount);
        totalPrice += money;
        $("#pay_sum_"+goodsId).text(money);
    });
    $("#J_ActualFee").text(totalPrice);
    $("#pay_money").text(totalPrice);

}

//新增保存收货地址
function saveAddress(){
    var userName = $("#user-name").val();
    var userPhone = $("#user-phone").val();
    var province = $("#province").val();
    var city = $("#city").val();
    var district = $("#district").val();
    var addrInfo = $("#user-intro").val();

    $.ajax({
        type: "POST",
        url:"/olalashop/cntApi/addConsignee.do",
        dataType: "json",
        data:{
            "user_name":userName,
            "user_phone":userPhone,
            "sheng":province,
            "shi":city,
            "qu":district,
            "user_intro":addrInfo,
        },
        async : true,
        success:function (data) {
            alert("地址添加成功！");
            var $per = $("<div class=\"per-border\"></div>");
            var $liHtml = $("<li class=\"user-addresslist\"></li>>");
            var $divLeft = $("<div class=\"address-left\"></div>");
            var $userDiv = $("<div class=\"user DefaultAddr\"><span class=\"buy-address-detail\"><span class=\"buy-user\">"+userName+" </span><span class=\"buy-phone\">"+userPhone+"</span></span></div>");
            var $addressDiv = $("<div class=\"default-address DefaultAddr\"><span class=\"buy-line-title buy-line-title-type\">收货地址：</span><span class=\"buy--address-detail\"><span class=\"province\">"+province+"</span><span class=\"city\">"+city+"</span><span class=\"dist\">"+district+"</span><span class=\"street\">"+addrInfo+"</span></span></div>");
            var $deftip = $("<ins class=\"deftip hidden\">默认地址</ins>");

            $divLeft.append($userDiv);
            $divLeft.append($addressDiv);
            $divLeft.append($deftip);
            $liHtml.append($divLeft);
            var $divRight = $("<div class=\"address-right\"><span class=\"am-icon-angle-right am-icon-lg\"></span></div><div class=\"clear\"></div>");
            var $addrBtn = $("<div class=\"new-addr-btn\"><a href=\"#\">设为默认</a><span class=\"new-addr-bar\">|</span><a href=\"#\">编辑</a><span class=\"new-addr-bar\">|</span><a href=\"javascript:void(0);\"  onclick=\"delClick(this);\">删除</a></div>");
            $liHtml.append($divRight);
            $liHtml.append($addrBtn);
            $("#address-list-ul").append($per);
            $("#address-list-ul").append($liHtml);

            $("#cancel_btn").click();
        },
        else: function () {

        }
    });

}