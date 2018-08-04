function initUpload(){
    layui.config({
        base: '/layui/' //插件路径
    });
    layui.use(['layer','upload'], function(){
        var upload = layui.upload;
        var name = "";
        upload.render({
            elem: '.demoMore'
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
    name.indexOf("File") < 1 ? $("#demo_"+name).attr("src",image) : $("#demo_"+name).attr("href",image);
    $("#demoMore_"+name).show();
}