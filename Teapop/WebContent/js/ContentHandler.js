/**
 * file contains functions that handles the content of the main site
 */
var config = {
	contentContainer : "content_wrapper",
	loaderId : "loader_wrapper",
	fadeSpeed: 500,
	loadingImage : "images/loading2.gif"
};

var mockData = {
	"products" : {
		categories :[
		            {
		            	name : "category1",
		            	link : "cat1",
		            	image : "images/categories/cat1.png",
		            	desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
		            	items : [
		            	         	{	
			            	         	name : "cat 1 item 1",
					            		desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
					            		price : "P100"
				            		},
				            		
				            		{	
			            	         	name : "cat 1 item 2",
					            		desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
					            		price : "P200"
					            	},
				            	]
		            },
		            {
		            	name : "category 2",
		            	link : "cat2",
		            	image : "images/categories/cat2.png",
		            	desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
		            	items : [
		            	         	{	
			            	         	name : "cat 2 item 1",
					            		desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
					            		price : "P100"
				            		},
				            		
				            		{	
			            	         	name : "cat 2 item 2",
					            		desc : "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore",
					            		price : "P200"
					            	},
				            	]
		            },
		]
	},
	"home" : {},
	"locationanddelivery" : {},
	"specials" : {},
	"contactus" : {}
	
};

var ContentHandler = {

	// used to prevent duplicate links for View Models
	linkFlags : {
		productTemplateLinked : false,
	},
		
	// general functions
	container : null,	
	
	show : function(contentId){
		// lazy instantiation for container
		if (this.container == null){
			ContentHandler.container = "#"+config.contentContainer; 
		}
		
		// called after fading in of loader
		function postloading(){
			ContentHandler.getContent(contentId, function(json, newContent){
				$(ContentHandler.container).hide();
				$(ContentHandler.container).html(newContent);

				// perform initContentif function exists in new content
				if (typeof(initContent) != "undefined"){
					initContent(json);
				}
				
				$(ContentHandler.container).show(config.fadeSpeed);
			});			
		}
		
		ContentHandler.loader.show(postloading);
	},
	
	getContent : function(contentId, callback){
//		$.getJSON("", function(json){
//			ContentHandler.generateContent(contentId, response, callback);
//		});
		
		// replace this with actual JSON from actual using getJSON
		json = mockData[contentId];
		ContentHandler.generateContent(contentId, json, callback);	
	},
	
	generateContent : function(contentId, json, callback){
		$.post("jsp/main/"+ contentId +".jsp", function(data){
			response = data;
			callback(json, data);
		}).fail(function() {
			alert( "content handler error" );
		});
	},

	loader : {
		loaderWrapper : null,
		show : function(callback){
			if (this.loaderWrapper == null){
				this.loaderWrapper = this.createWrapper();
			}
			// show actual element
			$(this.loaderWrapper).show();
			$(ContentHandler.container).html(ContentHandler.loader.loaderWrapper);
			callback();
		},
		hide : function(){
			$(this.loaderWrapper).hide();
		},
		createWrapper : function(){
			var div = document.createElement("div");
			div.id = config.loaderId;
			return div;
		}
	},
};
