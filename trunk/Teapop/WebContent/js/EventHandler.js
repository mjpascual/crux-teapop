var EventHandler = {

	initCategoryLinks : function(id) {
		$('#' + id + ' a[href^="#"]').on('click', function(e) {
			e.preventDefault();

			var target = this.hash, $target = $(target);

			$('html, body').stop().animate({
				'scrollTop' : $target.offset().top
			}, 900, 'swing', function() {
				window.location.hash = target;
			});
		});
	},

	initMenuSliderLinks : function(id, pagerId, callback) {
		var slider = $(id).bxSlider({
			mode : 'fade',
			pagerCustom : pagerId,
			adaptiveHeight : true,
			controls : false,
			onSliderLoad: function(){
				if (callback){
					callback();	
				}
				EventHandler.initScrollbar(pagerId);
			}
		});
		
		return slider;
	},

	initSpecialsSliderLinks : function(id) {
		$(id).bxSlider({
			hideControlOnEnd : true,
			infiniteLoop : false,
			pager : false
		});
	},

	initContentToggler : function(elementClass, contentClass, beverageSlider, additionalSlider) {
		var $selectors = $(elementClass + " a");
		$selectors.each(function() {
			var $currentSelector = $(this);
			$currentSelector.click(function(){
				if (!$currentSelector.hasClass("active")){
					var contentId = $currentSelector.attr("title");
					EventHandler.toggleContent(contentClass, contentId);
					
					// remove the active class
					$selectors.each(function(){
						$(this).removeClass("active");
					});
					
					// add active class to clicked selector
					$currentSelector.addClass("active");		
					
					// reload sliders
//					beverageSlider.reloadSlider();
//					additionalSlider.reloadSlider();
				}
			});
		});
		
		// hide other content
		$(contentClass).not($(".initialdisplay")).hide();

	},

	toggleContent : function(contentClass, contentId) {
		$(contentClass).hide(500);
		$("#"+contentId).show(500);
	},

	initScrollbar : function(id) {
		$(function() {
			$(id).perfectScrollbar();
		});
	},

	scrollAfterLoading : function() {
		$("body,html").animate({
			scrollTop : $("#content_wrapper").offset().top
		}, 500, "swing");
	}

};