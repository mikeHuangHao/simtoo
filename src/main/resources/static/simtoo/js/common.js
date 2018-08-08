var i = 0;
function opencat(e){
    $(".nav-menu").show();
    $(".nav-menu ul").eq($(e).index()).show();
}
function closecat(e){
    i = $(e).index();
    $(".nav-menu").hide();
    $(".nav-menu ul").eq($(e).index()).hide();
}
function opencat1(){
    $(".nav-menu").show();
    $(".nav-menu ul").eq(i).show();
}
function closecat2(){
    $(".nav-menu").hide();
    $(".nav-menu ul").eq(i).hide();
}
new Vue({
    el:'#top-common',
    data:{
        topData:[],
        topData2:[],
    },
    mounted:function(){
        this.getDate(this);
    },
    methods:{
        getDate:function(e){
            var params = new URLSearchParams();
            axios.post('/ec/menuList', params)
                .then(function (response) {
                    response.data.data.forEach(function (value) {
                        e.topData.push({
                            menuId:value.menuId,
                            name:value.name,
                            product:value.product,
                        })
                    });
                })
                .catch(function (error) {
                    alert("出错了，请稍后再试");
                });
        }
    }
})