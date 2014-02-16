
var BodySwitcher = {
	
	initBodySwitcher : function(){
		var self = this;
		$(document).on("click", ".bodySwitcher", function() { 
			var action = $(this).attr("id");
			self.ajaxCall(action, null, $.proxy(self.showBody, this));
		});
	},

	ajaxCall : function(action, data, callback){
		$.ajax({
			url: action,
		    type: "POST",
		    data: data,
		    error: function(){
		        alert('Error');
		    },
		    success: function(data){         
		    	callback(data);
		    }
		});
	},
	
	showBody : function(data){
		var $container = $("#body_container");
		$container.empty();
		$container.html(data);
	}
	
	
};
