function initUpload(){
    layui.config({
        base: '/layui/' //插件路径
    });
    layui.use(['layer','upload'], function(){
        var upload = layui.upload;
        var name = "";
        upload.render({
            elem: '.demoFile'
            ,accept: 'file'
            ,before: function(){
                name = this.id;
            }
            ,done: function(res, index, upload){
                setImg(name,res.image)
            }
        })
    });
}

/**
 * 设置图片显示
 * @param name
 * @param image
 */
function setImg(name,image){
    $("#"+name).val(image);
    $("#demo_"+name).attr("src",image);
    $("#demoMore_"+name).show();
}