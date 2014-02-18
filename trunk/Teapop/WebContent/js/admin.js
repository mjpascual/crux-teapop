
var BodySwitcher = {
	
	initBodySwitcher : function(){
		var self = this;
		$(document).on("click", ".bodySwitcher", function() { 
			var action = $(this).attr("id");
			self.ajaxCall(action, null, $.proxy(self.showBody, this), $.proxy(self.initDataTable, this));
		});
	},

	ajaxCall : function(action, data, callback, callback1){
		$.ajax({
			url: action,
		    type: "POST",
		    data: data,
		    error: function(){
		        alert('Admin Error');
		    },
		    success: function(data){         
		    	callback(data);
		    },
		    complete: function (data){
		    	callback1(data);
		    }
		});
	},
	
	showBody : function(data){
		var $container = $("#body_container");
		$container.empty();
		$container.html(data);
	},
	
	initDataTable : function(data){
		var $container = $("#body_container");
		var $table = $container.find(".table");
		if ($table.length > 0){ 
			$("#"+$table.attr("id")).dataTable( {
				"sPaginationType": "full_numbers"
			} );
		}
	}
	
};
