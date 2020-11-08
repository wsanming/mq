$(function () {
    //全部删除
    $("#deleteAll_btn").on("click",function () {
        $("input[name='check_Id']:checked").each(function() {
            var shopCartId = $(this).val();
            $.ajax({
                type: "POST",
                url: "/olalashop/orderCartApi/removeShopCart.do",
                dataType: "json",
                async: "true",
                data: {
                    "shopCartId": shopCartId
                },
                success: function (data) {
                    $("#shop-cart_content").empty();
                }
            })
        });
    })

    //全部收藏
    $("#deleteAll_btn").on("click",function () {
        $("input[name='check_Id']:checked").each(function() {
            var shopCartId = $(this).val();
            var collectId = $("#collectId_"+shopCartId).val();
            var status = $("#isCollect_"+shopCartId).val();
            var isCollect;
            if(Number(status) == 1) isCollect=0;
            else isCollect=1;

            $.ajax({
                type: "POST",
                url: "/olalashop/goodsIndexApi/saveCollect.do",
                dataType: "json",
                async: "true",
                data:{
                    "collectId": collectId,
                    "isCancel": isCollect
                },
                success:function (data) {
                },
                error:function (data) {

                }
            })
            if(Number(status) == 1){
                $("#isCancel_"+shopCartId).val(0);
                $("#collect_btn_"+shopCartId).text("已收藏");
            }else if(Number(status) == 0){
                $("#isCancel_"+shopCartId).val(1);
                $("#collect_btn_"+shopCartId).text("移入收藏夹");
            }
        });
    })

    //购物车选中事件计算金额
    $("input[name='check_Id']").change(function () {
        account();
    });

    //全选和全不选
    $("#J_SelectAllCbx2").change(function () {
        var totalPrice = 0;
        var count = 0;
        var isChecked=$("#J_SelectAllCbx2").is(':checked');
        //获取所有checkbox组成的数组
        var checkedArrs=$("input[name='check_Id']");
        //判断是全选还是反选
        if(isChecked){
            checkedArrs.each(function(){
                $(this).prop('checked',true);
                var shopCartId = $(this).val();
                var price = $("#price_"+shopCartId).val();
                var amount = $("#amount_"+shopCartId).val();
                count += Number(amount);
                totalPrice += Number(price)*Number(amount);
            });
            $("#J_SelectedItemsCount").text(count);
            $("#J_Total").text(totalPrice);
        }else{
            checkedArrs.each(function(){
                $(this).removeAttr('checked',false);
            });
            $("#J_SelectedItemsCount").text(0);
            $("#J_Total").text(0);
        }
    });

})

//逐条删除
function deleteShopCart(shopCartId){
    $.ajax({
        type: "POST",
        url: "/olalashop/orderCartApi/removeShopCart.do",
        dataType: "json",
        async: "true",
        data: {
            "shopCartId": shopCartId
        },
        success: function (data) {
            $("#item_"+shopCartId).remove();
        }
    })
    window.location.href="/olalashop/orderCartApi/queryAllShopCart.do";
}

//逐个收藏
function addCollect(shopCartId){
    var collectId = $("#collectId_"+shopCartId).val();
    var status = $("#isCollect_"+shopCartId).val();
    var isCollect;
    if(Number(status) == 1) isCollect=0;
    else isCollect=1;
    $.ajax({
        type: "POST",
        url: "/olalashop/goodsIndexApi/saveCollect.do",
        dataType: "json",
        async: "true",
        data:{
            "collectId": collectId,
            "isCancel": isCollect
        },
        success:function (data) {
        },
        error:function (data) {

        }
    })
    if(Number(status) == 1){
        $("#isCancel_"+shopCartId).val(0);
        $("#collect_btn_"+shopCartId).text("已收藏");
    }else if(Number(status) == 0){
        $("#isCancel_"+shopCartId).val(1);
        $("#collect_btn_"+shopCartId).text("移入收藏夹");
    }
}

/*购物车结算*/
function settleOrder() {
    var shopCartIdArr = "";
    var amountArr = "";
    $("input[name='check_Id']:checked").each(function() {
        var shopCartId = $(this).val();
        var amount = $("#amount_"+shopCartId).val();
        shopCartIdArr += shopCartId + ",";
        amountArr += amount + ",";
    });
    if(shopCartIdArr == ""){
        alert("请选择需要结算的商品！");
        return;
    }
    window.location.href = "/olalashop/orderApi/settleShopCart.do?shopCartIdArr="+shopCartIdArr+"&amountArr="+amountArr;
}

//加减数量
function resetAmount(shopCartId, method) {
    var amount = $("#amount_"+shopCartId).val();
    if(method == "-" && amount > 1){
        $("#amount_"+shopCartId).val(Number(amount)-1);
    }else if(method == "+"){
        $("#amount_"+shopCartId).val(Number(amount)+1);
    }
    account();
    return;
}

//统计金额和数量
function account() {
    var totalPrice = 0;
    var count = 0;
    $("input[name='check_Id']").each(function(){
        var shopCartId = $(this).val();
        var isChecked=$(this).is(':checked');
        if(isChecked){
            var price = $("#price_"+shopCartId).val();
            var amount = $("#amount_"+shopCartId).val();
            count += Number(amount);
            totalPrice += Number(price)*Number(amount);
        }
    });
    $("#J_SelectedItemsCount").text(count);
    $("#J_Total").text(totalPrice);
}
