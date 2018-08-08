/**
 * 单文件上传
 */
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
 * 多文件上传
 */
function initUploadS(){
    layui.config({
        base: '/layui/' //插件路径
    });
    layui.use(['layer','upload'], function(){
        var upload = layui.upload;
        var name = "";
        upload.render({
            elem: '.demoMore'
            ,accept: 'file'
            ,multiple: true
            ,before: function(){
                name = this.id;
            }
            ,done: function(res, index, upload){
                $("#"+name).val($("#"+name).val()+res.image+",");
                $("#demoMore_"+name).show().append('<img class="layui-upload-img" id="demo_imgUrl" src="'+res.image+'"  style="width:200px;height:200px;margin-left: 100px" >');
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

/**
 * 百度富文本
 */
function ueEditUploadImages(){
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage' || action == "uploadvideo") {
            return '/admin/weUpload'; //在这里返回我们实际的上传图片地址
        }else {
            return this._bkGetActionUrl.call(this, action);
        }
    }
}