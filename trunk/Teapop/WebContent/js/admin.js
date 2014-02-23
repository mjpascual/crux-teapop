
var BodySwitcher = {
	
	initBodySwitcher : function(){
		var self = this;
		$(document).on("click", ".bodySwitcher", function() { 
			var action = $(this).attr("id");
			self.ajaxCall(action, null, $.proxy(self.showBody, this), $.proxy(self.initCall, this));
		});
	},

	ajaxCall : function(action, data, callback, callback1){
		$.ajax({
			url: action,
		    type: "POST",
		    data: data,
		    async:false,
            cache:false,
		    error: function(jqXHR, exception) {
	            if (jqXHR.status === 0) {
	                alert('Not connect.\n Verify Network.');
	            } else if (jqXHR.status == 404) {
	                alert('Requested page not found. [404]');
	            } else if (jqXHR.status == 500) {
	                alert('Internal Server Error [500].');
	            } else if (exception === 'parsererror') {
	                alert('Requested JSON parse failed.');
	            } else if (exception === 'timeout') {
	                alert('Time out error.');
	            } else if (exception === 'abort') {
	                alert('Ajax request aborted.');
	            } else {
	                alert('Uncaught Error.\n' + jqXHR.responseText);
	            }
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
		$container.removeChildrenFromDom();
		$container.empty();
		$container.html(data);
	},
	
	initCall: function(data){
		var $container = $("#body_container");
		
		while ($container.firstChild) {
		    myNode.removeChild(myNode.firstChild);
		}
		
		var $table = $container.find(".table");
		if ($table.length > 0){ 
			BodySwitcher.initDataTable($table);
		}
		var $form = $container.find("form#add");
		if ($form.length > 0){ 
			BodySwitcher.initForm($form, "#submitAddBtn");										    //SET THIS ID
		}
		
	},
	
	initDataTable : function($table){
		
		if ($table.length > 0){ 
			$("#"+$table.attr("id")).dataTable( {
				"sPaginationType": "full_numbers"
			} );
		}

		var self = BodySwitcher;
		var action = $table.find("#addSubmit").attr("forward");                                      	//SET THIS ID
		
		$(document).on("click", "#addSubmit", function(e){
			self.ajaxCall(action, null, $.proxy(self.showBody, this), $.proxy(self.initCall, this));
		});
		
		$(document).on("click", "#submitEditBtn", function(e){                                       	//SET THIS ID
			var $form = $(this).closest("form#update");
			var data = $form.serialize();
			var action = $form.attr("action");
			self.ajaxCall(action, data, $.proxy(self.showBody, this), $.proxy(self.initCall, this));
		});
		
		$(document).on("click", "#submitDelBtn", function(e){          
			var $form = $(this).closest("form#delete");
			var data = $form.serialize();
			var action = $form.attr("action");
			self.ajaxCall(action, data, $.proxy(self.showBody, this), $.proxy(self.initCall, this));
		});
	},
	
	initForm: function($form, btn){
		var self = BodySwitcher;
		var $formId = $form.find("formId").val();														//SET THIS CLASS
		var $checkBox = $form.find(".checkbox");                                                		//SET THIS CLASS
		
		if($formId !== null | $formId !== "") {
			var $header = $form.closest(".changeHeader");												//ADD SPAN
			$header.empty().html("Update");
			
		} 
		
		$checkBox.change(function() {
			var state = $(this).is(':checked');
		    if (state) {
		    	$(this).val(true);
		    } else {
		    	$(this).val(false);
			}
		});
		
		var $fileTemp = $form.find(".fileTemp");											    		//SET THIS CLASS
		var $file 	  = $form.find(".file");															//SET THIS CLASS
		
		$(document).on("change",".fileTemp", function(){
			$file.val($fileTemp.val().split('\\').pop());
		});
		
		$(document).on("click", btn, function(e){                                            			//SET THIS ID
			if($form[0].checkValidity()) {
				var disabled = $form.find(':input:disabled').removeAttr('disabled');
				var action = $form.attr("action");
				var data = $form.serialize();
				disabled.attr('disabled','disabled');
				e.preventDefault();
				self.ajaxCall(action, data, $.proxy(self.showBody, this), $.proxy(self.initCall, this));
			} 
		});
		
	}
	
};


var AdminBehavour = {
		
		initialize : function(){
			this.navClick();
		},

		navClick : function(){
			$(document).on("click", ".menu-item", function(){
				$(".menu-item").find("ul").removeClass("open");
				$(this).find("ul").addClass("open");
			});
		} 
		
};

(function( $ ){
	$.fn.removeChildrenFromDom = function (i) {
	    if (!this) return;
	    this.find('input[type="submit"]').unbind(); 
	    this.children()
	       .empty() 
	       .each(function (index, domEle) {
	           try { domEle.innerHTML = ""; } catch (e) {}  
	       });
	    this.empty(); 
	    try { this.get().innerHTML = ""; } catch (e) {} 
	};
})( jQuery );
