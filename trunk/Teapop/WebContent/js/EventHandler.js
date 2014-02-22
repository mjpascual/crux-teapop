

var EventHandler = {
	
	initCategoryLinks : function(id){
		$('#'+id+' a[href^="#"]').on('click',function (e) {
		    e.preventDefault();

		    var target = this.hash,
		    $target = $(target);

		    $('html, body').stop().animate({
		        'scrollTop': $target.offset().top
		    }, 900, 'swing', function () {
		        window.location.hash = target;
		    });
		});
	},
	
	initMenuSliderLinks : function(id){
		$(".contentSliderMenu").bxSlider({
			pagerCustom : id,
			controls: false
			
		});
	},
	
	scrollAfterLoading : function(){
		$("body,html").animate({
			scrollTop: $("#content_wrapper").offset().top
		}, 1000, "swing");
	}
};