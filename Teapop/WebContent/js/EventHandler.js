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

	initMenuSlider : function(id, pagerId, callback) {
		var slider = $(id).bxSlider({
			mode : 'fade',
			pagerCustom : pagerId,
			adaptiveHeight : true,
			controls : false,
			onSliderLoad: function(){
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

	initContentToggler : function(elementClass, contentClass) {
		var $selectors = $(elementClass + " a");
		$selectors.each(function(index) {
			var $currentSelector = $(this);
			$currentSelector.click(function(){
				if (!$currentSelector.hasClass("active")){
					var config = sliderConfig[index];
					EventHandler.showContent($selectors, $currentSelector, contentClass, config);
				}
			});
		});
		
		// hide other content
		$(contentClass).hide();
		EventHandler.showContent($selectors, $("#initial_load"), contentClass, sliderConfig[0]);
	},
	
	showContent : function($selectors, $currentSelector, contentClass, config){
		var contentId = $currentSelector.attr("title");
		EventHandler.toggleContent(contentClass, contentId);

		// remove the active class
		$selectors.each(function(){
			$(this).removeClass("active");
		});
		
		// add active class to clicked selector
		$currentSelector.addClass("active");		
		
		// load sliders
		if (config.slider != null){
			config.slider.destroySlider();
			config.slider.reloadSlider();
		} else {
			config.slider = EventHandler.initMenuSlider(config.id, config.pagerId);	
		}
	},

	toggleContent : function(contentClass, contentId) {
		$(contentClass).hide(0, function(){});
		$("#"+contentId).toggle("slide");
	},

	initScrollbar : function(id) {
		$(function() {
			$(id).perfectScrollbar();
		});
	},

	scrollAfterLoading : function() {
//		$("body,html").animate({
//			scrollTop : $("#content_wrapper").offset().top
//		}, 500, "swing");
	}

};