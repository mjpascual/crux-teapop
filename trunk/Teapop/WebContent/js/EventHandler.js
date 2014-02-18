

var EventHandler = {
	
	initTopMenu : function(){
		$(".menu_link").click( function(){
			ContentHandler.show($(this).attr("id"));
		});
	},
	
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
	}
};