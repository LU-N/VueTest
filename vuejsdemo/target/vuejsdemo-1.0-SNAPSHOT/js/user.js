new Vue({
    el: "#app",
    data: {
        user: {
            id: "",
            username: "",
            password: "",
            email: "",
            age: "",
            sex: ""
        },
        userList: []
    },
    methods: {
        findAll: function () {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/user/findAll.do')
                .then(function (response) {
                    //响应数据给userList赋值
                    _this.userList = response.data;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        findById: function (userid) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.get('/user/findById.do', {params: {id: userid}})
                .then(function (response) {
                    //响应数据给userList赋值
                    _this.user = response.data;
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //post请求
        update: function (user) {
            //在当前方法中定义一个变量，表明是vue对象
            var _this = this;
            axios.post('/user/updateUser.do', _this.user)
                .then(function (response) {
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    //当我们页面加载的时候触发请求，查询所有
    created: function () {
        this.findAll();
    }
});