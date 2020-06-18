//JS 问题如何解决? console.log(),debugger,排除法
$(function () {
    doLoadPageUI();
    debugger
    doGetObjects();
    $(".input-group-btn").on("click",".btn-search",doQueryObjects)
        .on("click",".btn-delete",doDeleteObjects);
    //thead全选操作
    //.on("click","#checkAll",doChangeTbodayCheckBoxState);
    $("#checkAll").change(doChangeTbodayCheckBoxState);
    //tbody复选框点击事件绑定
    $("#tbodyId").on("change","input:checkbox",doChangeTheadCheckBoxState);
});
//如果点击了tbody的元素 那么选中所有的内容进行遍历 看是否有取消的复选框 就改变 thead的全选操作
function doChangeTheadCheckBoxState() {
    //1.定义一个初始状态 为true
    var flag = true;
    //2.获得所有tbody中的checkbox对象并与flag变量的初始状态进行逻辑与操作
    $("#tbodyId input:checkbox").each(function () {
            flag=flag&&$(this).prop("checked");
        }
    );
    //3.修改thead中checkbox状态
    $("#checkAll").prop("checked",flag);
}
//进行全选操作实现 处理thead中checkbox全选操作事件
function doChangeTbodayCheckBoxState(){
    //1.获取head中checkbox对象的状态
    var flag = $(this).prop("checked");
    //2.修改tbody中checkbox对象状态
    $("#tbodyId input:checkbox").prop("checked",flag);
}

//获取选中id的记录
function doGetCheckedIds() {
    //1.定义数组
    var ids=[];
    //2.迭代所有选中的checkbox对象,并获取value属性值,然后存储到数组
    // $("#tbodyId input[type=checkbox]").each(function () {
    // 	if($(this).prop("cheked"))ids.push($(this).val());
    // })

    $("#tbodyId input:checkbox:checked").each(function () {
        ids.push($(this).val());
    })
    return ids;
}

//定义日志删除方法
function doDeleteObjects() {
    debugger
    var url = "log/doDeleteObjects";
    var ids = doGetCheckedIds();
    var params={
        ids:ids.toString()
    }
    if (ids.length==0){
        alert("请选中后再做删除")
        return;
    }
    if (! confirm("确定删除吗!"))return;
    //4.定义移步请求操作   done 是执行查询成功后执行的方法   fail 如果ajax请求 失败可以利用前端 fail 进行显示信息
    $.post(url,params).done(doHandleDeleteResult).fail(function () {
        $("#tbodyId").html("服务端在维护中,稍等片刻再进行查询")
    });
}
//删除后进行回调函数 并对页面进行刷新
function doHandleDeleteResult(result){
    debugger
    if (result.state==1){
        alert(result.message)
        var pageCurrent = $("#pageId").data("pageCurrent");
        var pageCount = $("#pageId").data("pageCount");
        var checked = $("#checkAll").prop("checked");
        console.log(checked);
        if (pageCurrent==pageCount&&checked&&pageCount>1){
            pageCurrent--;
            $("#pageId").data("pageCurrent",pageCurrent);
        }
        doGetObjects();
    }else{
        alert(result.message)
    }
}

//根据用户名搜索日志信息
function doQueryObjects() {
    //为什么要在此位置初始化pageCurrent的值为1?  因为可能从第三页查询 可是查到了  但是 因为页码值原因 无法显示到查询的记录
    //数据查询时页码的初始位置也应该是第一页
    $("#pageId").data("pageCurrent",1)
    //为什么要调用doGetObjects函数？
    //重用js代码，简化jS代码编写。
    doGetObjects();
}


//通过此函数异步加载日志信息
function doGetObjects() {
    debugger
    //以为 做了全选之后发现点击下一页 全选按钮 还存在 所以初始化一下flag状态
    $("#checkAll").prop("checked",false);
    //2.定义请求url
    var url = "log/doFindPageObjects";
    //? 请问data函数的含义是什么？(从指定元素上获取绑定的数据)
    //此数据会在何时进行绑定？(setPagination,doQueryObjects)
    //1.定义请求参数
    //1.2接收当前页码值 如果为空就 设置为 1 首页
    var pageCurrent = $("#pageId").data("pageCurrent");
    if (!pageCurrent)pageCurrent=1;
    var params = {"pageCurrent":pageCurrent};
    //为什么此位置要获取查询参数的值?
    //一种冗余的应用方法，目的时让此函数在查询时可以重用。
    var username = $("#searchNameId").val();
    //如下语句的含义是什么？动态在json格式的js对象中添加key/value,
    if (username)params.username=username;
    //3.发送异步请求并处理想结果    这个是正确写法			不要加小括号() 加了会立即执行不会等客户端返回
    //$.getJSON(url,params,doHandleQueryResult)  $.getJSON(url,params,doHandleQueryResult())
    $.getJSON(url,params,doHandleQueryResult);
    function doHandleQueryResult(result){
        console.log("result",result)
        if (result.state == 1){//正常数据
            doSetTableBodyRows((result.data.records));//处理返回结果
            doSetPagination(result.data);//处理页码值问题
        }else {
            //alert(result.message);
            //因为删除最后一页的原因 会 不刷新页面 就直接用下面方法 直接替换 tbody内容
            $("#tbodyId").html(`<tr><td colspan="7">${result.message}</td></tr>`)
        }
    }
}

//创建单页显示日志信息
function doSetTableBodyRows(datas) {
    debugger
    var tBody = $("#tbodyId");
    tBody.empty();
    // for (var i = 0;data.length>i;i++) {
    //  	tBody.append(doCreateTds(data[i]));
    // }
    //下面这个循环没有上面的性能好  vari的作用域 不严谨  可以在外界能拿到
    // 可以用let i 描述  const 是描述常量不可以修改 优势结构简单
    // for(var i in data){
    // 	tBody.append(doCreateTds(data[i]));
    // }
    datas.forEach(data=>tBody.append(doCreateTds(data)));
    //data.foeEach(item=>console.log(item));  //item 的作用域也是当前方法内可以用
}
//创建单行记录方法
function doCreateTds(data) {
    return `<tr><td><input type="checkbox" class="cBox" name="cItem" value=${data.id}></td>
			<td>${data.username}</td>
			<td>${data.operation}</td>
			<td>${data.method}</td>
			<td>${data.params}</td>
			<td>${data.ip}</td>
			<td>${data.time}</td>
			</tr>`;
}