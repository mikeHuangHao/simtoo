$(function(){
    //轮播
	var n=0;
	var time=5000;
	function Lunbo(){
		n++;
		n=n%$(".homepage-banner ul li").length;
		$(".homepage-banner ul li").eq(n).fadeIn(1000).siblings().fadeOut(1000);
		$(".disc a").eq(n).addClass("act").siblings().removeClass("act");
	}
	$(".disc a").click(function(){
		var n=$(this).index();
		$(".homepage-banner ul li").eq(n).fadeIn(1000).siblings().fadeOut(1000);
		$(".disc a").eq(n).addClass("act").siblings().removeClass("act");
	})
	$(".btn .next").click(function(){
		n++;
		if(n==3){n=0};
		$(".homepage-banner ul li").fadeOut();
		$(".homepage-banner ul li").eq(n).fadeIn();
		$(".disc a").eq(n).addClass("act").siblings().removeClass("act");
	})
	$(".btn .pre").click(function(){
		n--;
		if(n==-1){n=2};
		$(".homepage-banner ul li").fadeOut();
		$(".homepage-banner ul li").eq(n).fadeIn();
		$(".disc a").eq(n).addClass("act").siblings().removeClass("act");
	})
	timer=setInterval(Lunbo,time);
	$(".homepage-banner").hover(function(){
		clearInterval(timer);
	},function(){
		timer=setInterval(Lunbo,time);
	});
	//图片切换
	$(window).on("visibilitychange", function() {
//		document.hidden ? r.autoplaying && (n = !0, r.stopAutoplay()) : n && (n = !1, r.startAutoplay())
	}), $(".slide-grid-container .control-btn").click(function() {
		var e = $(".slide-grid-container ul.slide-grid-list"),
			a = e.find(".slide-grid-item"),
			t = a.first(),
			s = a.last();
		$(this).hasClass("control-btn-left") ? e.prepend(s) : e.append(t)
	}), $(".swiper-slide-countdown").length && e();
    //滑过切换背景-字体颜色
    $(".product-list>div").hover(function(){
    	$(this).css("background","url(images/product-list-hbg.png) no-repeat center bottom #fff");
    	$(this).find("p").css("color","#272727")
    },function(){
    	$(this).css("background","url(images/product-list-bg.png) no-repeat center bottom #fff");
    	$(this).find("p").css("color","#747474")
    });
    //点击显示联系我们note内容
    $(".note").click(function(){
    	$(this).addClass("act");
    	$(".contact-list").show();
    });
    //shop-product切换
    $(".product-small>a.product-simg").click(function(){
    	var i=$(this).index();
   		$(".product-big>a").eq(i).addClass("first-bimg").siblings().removeClass("first-bimg")
    });
    //点击选择星级
    $(".five-star a").click(function(){
    	$(this).addClass("act").siblings().removeClass("act");
    });
    //点击description-reviews切换
    $(".show-top a").click(function(){
    	var a=$(this).index();
    	$(this).addClass("act").siblings().removeClass("act");
    	$(".show-bottom>div").eq(a).show().siblings().hide();
    });
    //产品滑过上移
    $(".owl .owl-item").mousemove(function(){
    	$(this).find(".owl-imgs .owl-btn").css({
    		opacity: 1,
    		bottom:"50px"
    	})
    });
    $(".owl .owl-item").mouseleave(function(){
    	$(this).find(".owl-imgs .owl-btn").css({
    		opacity: 0,
    		bottom:"0"
    	})
    });
    //产品图片滑过切换
    $(".owl-img").mousemove(function(){
    	$(this).find(".owlh").css({left:"100%"});
    	$(this).find(".owlp").css({left:"0"});
    });
    $(".owl-img").mouseleave(function(){
    	$(this).find(".owlp").css({left:"-100%"});
    	$(this).find(".owlh").css({left:"0"});
    });
    //点赞
    $(".owl-btn a.second").click(function(){
    	$(this).addClass("heart");
    });
    //点击显示大图
    $(".owl-img img").click(function(){
    	var url = $(this).next("img").attr("src");
    	$(".img-big").show();
    	$(".big-img img").attr('src',url);
    	$(".big-text").slideDown('slow');
    });
    $(".big-text a,.img-big").click(function(){
    	$(".img-big").fadeOut();
    	$(".big-text").fadeOut();
    });
    //点击放大按钮出现图片及详情
    $(".owl-btn a.expand").click(function(){
    	$(".img-big").show();
    	$(".big-list").slideDown('slow');
    });
    $(".list-close a,.img-big").click(function(){
    	$(".big-list").fadeOut();
    	$(".img-big").fadeOut();
    });
    //购物车
    $(".shop-cart a.cart-btn").click(function(){
    	$(this).parents(".shop-cart").addClass("shop-open");
    	event.stopImmediatePropagation();
    });
    $(document).bind("click",function(){
    	$(".shop-cart").removeClass("shop-open");
	});
	$(".cart-text .cart-close").click(function(){
		$(".shop-cart").removeClass("shop-open");
		$(this).parent().parent(".media").remove();
	});
	//checkout——点击显示详情
	$(".customer .showlogin").click(function(){
		$(this).parent(".customer").next(".customer-login").slideToggle();
	});
	//点击城市选择
	$(".select-top").click(function(){
		var select=$(".select-bottom");
		if (select.is(':hidden')){
			select.slideDown();
			$(this).find(".up-down i").removeClass("fa-down").addClass("fa-up");
		}else{
			select.slideUp();
			$(this).find(".up-down i").removeClass("fa-up").addClass("fa-down");
		}
//		$(this).find(".up-down i").removeClass("fa-down").addClass("fa-up");
//		$(".select-bottom").slideToggle();
	})
	//点击区域外隐藏
	$(document).bind("click",function(e){
		var target = $(e.target);
		if(target.closest(".select-all").length == 0){
		//点击id为sibader之外的地方触发
		 $(".select-bottom").slideUp();
		 $(".select-top").find(".up-down i").removeClass("fa-up").addClass("fa-down");
		};
	});
	//点击获取文本
	$(".select-list li").click(function(){
		var text=$(this).html();
		$(".select-top a span.select-text").html(text);
		$(".select-bottom").slideUp();
		$(".select-top").find(".up-down i").removeClass("fa-up").addClass("fa-down");
	});
	//密码
	$( '.account' ).bind('click', function() {
	   $(".account-list").slideToggle();
	});
	//支付点击展开并切换
	$(".payment li input").click(function () {
		$('.payment .payment_list').slideUp();				 
		
		var details = $(this).siblings(".payment_list");
		if (details.is(':hidden')){
			details.slideDown();
		}else{
			details.slideUp(); 		
		}
	});
	
	$(".checkout-pay .payment li").eq(0).find('.payment_list').show();
})
