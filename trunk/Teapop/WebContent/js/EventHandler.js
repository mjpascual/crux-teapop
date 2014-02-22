

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
	
	initMenuSliderLinks : function(id, pagerId){
		$(id).bxSlider({
			mode: 'fade',
			pagerCustom : pagerId,
			adaptiveHeight: true,
			controls: false,
		});
	},
	
	initSpecialsSliderLinks : function(id){
		$(id).bxSlider({
			hideControlOnEnd: true,
			infiniteLoop: false,
			pager: false
		});
	},
	
	initScrollbar : function(id){
	    $(function() {
	        $(id).perfectScrollbar();
	    });
	},
	
	scrollAfterLoading : function(){
		$("body,html").animate({
			scrollTop: $("#content_wrapper").offset().top
		}, 500, "swing");
	}
	
};