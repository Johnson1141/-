var haschoose=[];
var waitforchoose=[];
var dayMap=new Map();
dayMap.set("一",1);
dayMap.set("二",2);
dayMap.set("三",3);
dayMap.set("四",4);
dayMap.set("五",5);
var isinit=1;

var week = window.innerWidth > 360 ? ['周一', '周二', '周三', '周四', '周五'] :
    ['一', '二', '三', '四', '五'];
var day = new Date().getDay();
var courseType = [
    [{ index: '1', name: '8:30' }, 1],
    [{ index: '2', name: '9:30' }, 1],
    [{ index: '3', name: '10:30' }, 1],
    [{ index: '4', name: '11:30' }, 1],
    [{ index: '5', name: '12:30' }, 1],
    [{ index: '6', name: '14:30' }, 1],
    [{ index: '7', name: '15:30' }, 1],
    [{ index: '8', name: '16:30' }, 1],
    [{ index: '9', name: '17:30' }, 1],
    [{ index: '10', name: '18:30' }, 1],
    [{ index: '11', name: '19:30' }, 1],
    [{ index: '12', name: '20:30' }, 1],
    [{ index: '13', name: '21:30' }, 1]
];
// 实例化(初始化课表)
var courseList = [];

for (var i = 0; i < 5; i++) {
    courseList[i] = [];
    for (var j = 0; j < 13; j++)
        courseList[i].push('');
};
var xx = new Timetable({
    el: '#coursesTable',
    timetables: courseList,
    week: week,
    timetableType: courseType,
    highlightWeek: day,
    styles: {
        Gheight: 50
    }
});
xx._init();
//{ st: 1, day: 1, len: 3, name: "1111" }
function add(id){
    var  item = id;
    if(xx.addcourse(item)){
        return true;
    }
    return false;
}
function del(id){
    var  item = id;
    if(xx.rmcourse(item)){
        return true;
    }
    return false;
}

layui.use('element', function(){
    var element = layui.element;
});
var table;
var searchtable;
layui.use('table', function(){
    table = layui.table;
    //第一个实例
    table.render({
        elem:"#demo1",
        height: 560,
        url:"/xk/user_course",
        page:false,
        size:"lg",
        cols: [
            [
                { title: '选/退课', width:"15%",  templet: '#check1'}
                ,{field: 'cname', title: '课程名', width:"22%"}
                ,{field: 'tname', title: '教师', width:"18%"}
                ,{field: 'xf', title: '学分', width: "12%"}
                ,{field: 'sksj', title: '时间', width: "20%"}
                ,{field: 'num', title: '人数',width: "13%"}
            ]
        ],
        parseData: function(res){ //res 即为原始返回的数据
            return {
                "code": 0, //解析接口状态
                //"count": res.size() , //解析数据长度
                "data": res //解析数据列表
            };
        },
        done: function(res){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            // res=res.data;
            // for(i in res){
            //     var v=res[i];
            //     haschoose.add({"kh":v["kh"],"gh":v["gh"]});
            // }
            $('.layui-form-switch').click();
            isinit=0;
        }
    });



    searchtable=table.render({
        elem: '#demo'
        ,height: 430
        ,url: '/xk/all_course' //数据接口
        ,page: true
        ,request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        }

        ,parseData: function(res){ //res 即为原始返回的数据
            return {
                "code": 0, //解析接口状态
                "msg": res.message, //解析提示文本

                "count": res.totalElements , //解析数据长度
                "data": res.content //解析数据列表
            };
        }

        ,cols: [
            [
                { title: '加入待选', width:"12%",  templet: '#check0'}
                ,{field: 'kh', title: '课程号', width:"16%"}
                ,{field: 'cname', title: '课程名', width:"22%"}
                ,{field: 'tname', title: '教师', width:"15%"}
                ,{field: 'xf', title: '学分', width: "10%"}
                ,{field: 'sksj', title: '时间', width: "15%"}
                ,{field: 'num', title: '人数',width: "10%"}
            ]
        ],
        done: function () {
            // console.log(table.cache["demo1"]);
        }
    });

});

layui.use('form', function(){
    var form = layui.form;

    form.on('switch', function(data){
        var opSta = data.elem.checked;
        var arr = data.elem.name.split("_");
//0课号 1课名 2选课时间 3工号 4操作 5教师名 6学分 7选课人数 8选课时间
        // if(opSta) console.log("选中");
        // else console.log("没选中");
        var bak=arr[2];
        if(arr[2]!=null){
            var tmp=arr[2].split('&');
            var res=[];
            for (i in tmp){
                var v=tmp[i];
                ctime = v.split(" ");
                var day=dayMap.get(ctime[0]);
                var st = Number(ctime[1].split("-")[0]);
                var ed = Number(ctime[1].split("-")[1]);
                res.push( {"st":st,"day":day,"len":ed-st+1});
            }
            arr[2]=res;
            for(i in arr[2]){
                var v=(arr[2][i]);
                v["name"]= arr[1];
            }
        }
        //分别为课号,课名，时间，工号，操作 0搜索 1待选
        // for(i in arr){
        //     console.log(arr[i]);
        // }
        //如果在搜索课那里 加入 切换页面时在重新加入表格
        console.log({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak});
        if(arr[4]==="0"){
            if(opSta) waitforchoose.push({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak});
            else {
                var tmp = waitforchoose.filter(function (v) {
                    return !isEqual(v,{"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak});
                });
                waitforchoose = tmp;
            }
        }else{//选择课 从没选中开始
            if(opSta) {
                //先加 后发信息 若失败 就撤回
                //先加加看 需要时间和课名
                // { st: 1, day: 1, len: 3, name: "1111" }
                console.log(isinit);
                if(isinit===2){ //如果是待选的 加入 意味着已经有了
                    if(!Oin({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak},haschoose)){
                        data.elem.checked = false;
                        form.render();
                    }
                    return ;
                }
                var flag=1;

                for(v of haschoose){
                    //var v=haschoose[i];
                    if(v["kh"]===arr[0]) {flag=0;break;}
                }


                if(flag===1)
                    for(i in arr[2]){
                        var v=(arr[2][i]);
                        if(!add(v)) {flag=-1;break;}
                    }
                if(isinit===1) {
                    haschoose.push({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak});
                    //console.log(Oin({"kh":arr[0],"gh":arr[3],"cname":arr[1],"sksj":arr[2]},haschoose));
                    return;
                }

                //若课时冲突 则抛出异常
                if(flag!==1) {
                    if(flag===-1)alert("课时冲突");
                    if(flag===0)alert("选了相同专业课");
                    data.elem.checked = false;
                    form.render();
                }else{
                    //加入选课表

                    //后台传数据
                    $.ajax({
                        url: "/xk/add_course",
                        async: false,
                        type: 'post',
                        dataType: "",
                        data:{
                            "kh":arr[0],
                            "km":arr[1],
                            "sksj":bak,
                            "gh":arr[3]
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            console.log(XMLHttpRequest);
                            console.log(textStatus);
                            console.log(errorThrown);
                        },
                        success: function (response) {
                            if(!response) alert("加课失败");
                            else {
                                haschoose.push({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak});
                                //alert("yes");
                            }
                        }

                    });
                }
            }else {//退课
                // console.log(isEqual({"kh":arr[0],"gh":arr[3],"cname":arr[1],"sksj":arr[2]},haschoose[0]));
                // console.log(haschoose[0]);
                // console.log({"kh":arr[0],"gh":arr[3],"cname":arr[1],"sksj":arr[2]});
                console.log(bak);
                if(Oin({"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak},haschoose)){
                    $.ajax({
                        url: "/xk/del_course",
                        async: false,
                        type: 'post',
                        dataType: "",
                        data:{
                            "kh":arr[0],
                            "km":arr[1],
                            "sksj":bak,
                            "gh":arr[3]
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            console.log(XMLHttpRequest);
                            console.log(textStatus);
                            console.log(errorThrown);
                        },
                        success: function (response) {
                            if(!response) alert("删课失败");
                            else {
                                var tmp=haschoose.filter(function (v) {
                                    return !isEqual(v,{"kh":arr[0],"gh":arr[3],"cname":arr[1],"_sksj":arr[2],"tname":arr[5],"xf":arr[6],"num":arr[7],"sksj":bak})
                                });
                                haschoose=tmp;
                                console.log(haschoose);
                                //alert("yes");
                                //然后前端去除课
                                for(var u of arr[2]) {
                                    res = del(u);
                                    //console.log(u);
                                }
                            }
                        }
                    });
                }else{
                    alert("没有这门课，你怎么选了？");
                }
            }
        }
    });

    form.on('submit(search)', function(data){
        //console.log(data.field.kh);

        searchtable.reload({
            url:"/xk/search_course",
            where:{
                "kh":data.field.kh,
                "cname":data.field.km,
                "tname":data.field.tname,
                "sksj":data.field.sksj,
                "xf":data.field.xf
            },
            //size:"lg",
            cols: [
                [
                    { title: '加入待选', width:"12%",  templet: '#check00'}
                    ,{field: 'kh', title: '课程号', width:"16%"}
                    ,{field: 'km', title: '课程名', width:"22%"}
                    ,{field: 'xm', title: '教师', width:"15%"}
                    ,{field: 'xf', title: '学分', width: "10%"}
                    ,{field: 'sksj', title: '时间', width: "15%"}
                    ,{field: 'num', title: '人数',width: "10%"}
                ]
            ],
            request: {
                pageName: 'page' //页码的参数名称，默认：page
,                limitName: 'size' //每页数据量的参数名，默认：limit

            },
            page: {
                curr: 1 //重新从第 1 页开始
            },
            done : function () {
                //alert("yes");
            }

    });

    });
});


$("#tuixuanke").click(function () {
//            console.log(table.cache["demo1"]);
    var newdata = [];
    for(var v of haschoose){ //存旧数据
        if(!Oin(v,newdata))newdata.push(v);
    }
    for(var v of waitforchoose){
        if(!Oin(v,newdata)) newdata.push(v);
    }
    console.log(newdata);
    table.reload("demo1",{
        data:newdata,
        url:false,
        done:function () {
            isinit=2;
            $('input[name*="_1_"]').next().click();
            isinit=0;
        }
    });
});



