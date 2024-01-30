var vue =new Vue({
    el:"#app",
    data:{
        //定义数组,保存服务器回来的账户数据
        userList:[],
        //定义对象,保存账户数据,单个
        userInfo:{}
    },
    methods:{
        //点击删除的事件,对用户进行提示
        //点击确定,向服务器发送请求进行删除
        deleteUser:function (id) {
            if(confirm("确定要删除此信息吗?")){
                //点击确定,向服务器发送请求进行删除
                axios.post("/deleteUser.action","id="+id).
                then(response=>{
                    if(response.data === "删除成功"){
                        this.queryAll();
                    }
                }).
                catch(error=>{

                })
            }
        },

        //点击修改按钮事件,服务器发请求
        updateUser:function () {
            axios.post("/updateUser.action",this.userInfo).
            then(response=>{
                if(response.data === "修改成功"){
                    this.queryAll();
                }
            }).
            catch(error=>{

            });
        },

        //点击修改按钮,打开模态框,进行主键的查询回显
        openUpdateWindow:function(id){
            //服务器发送请求,提交主键数据
            axios.post("/queryUserById.action","id="+id).
            then(response=>{
                //userInfo对象,赋值响应回来的json
                this.userInfo = response.data;
                //打开修改模态框
                $("#update_modal").modal("show");
            }).
            catch(error=>{

            });
        },

        //点击添加按钮,打开添加账户数据的模态框
        openAddWindow:function () {
            //json对象的数据,置空
            this.userInfo = {};
            $("#add_modal").modal("show");
        },
        //点击添加数据按钮,发送请求,提交json数据
        addUser:function () {
           axios.post("/addUser.action",this.userInfo).
           then(response=>{
               if(response.data === "添加成功"){
                   this.queryAll();
               }
           }).
           catch(error=>{

           });
        },

        /**
         * 定义函数,服务器发送请求
         * 返回查询后的账户数据 json格式
         */
        queryAll:function(){
            axios.post("/queryAll.action").
            then(response=>{
                //服务器响应回来的账户数据 (json数据)赋值到数组中
                this.userList = response.data;
                //console.log(response.data);
            }).
            catch(error=>{

            });
        }
    },
    mounted:function () {
        this.queryAll();
    }
});