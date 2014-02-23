<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<section class="category" id="category">
	<header>
		Category Management
	</header>
	<article>
		<div class="formAdd category_add">
			<h3>Add New Promo</h3><hr><br>
			<form action="addPromo" method="post" id="addPromo">
				<div>
					<label for="promoName">Promo Name:</label>
					<input type="text" id="promoName" name="promo.name" maxlength="35" autofocus required value="<s:property value='promoName'/>">
				</div>
				<div>
					<label for="promoCode">Promo Code:</label>
					<input type="text" id="promoCode" name="promo.promoCode" maxlength="35" value="<s:property value='promoCode'/>">
				</div>
				<div>
					<label for="promoDesc">Promo Description:</label>
					<textarea  name="promo.desc" rows="6" maxlength="250" required><s:property value='promoDesc'/></textarea>
				</div>
				<div>
				 	<label for="image_file">Category Image: </label>
				 	<input type="file" name="promo.image" id="image_file" />
				</div>
				<input class="button" onclick="javascript:addPromo()" value="Save">
			</form>
		</div>
		<s:if test="%{addSuccessful}">
			<div id="addPromoMessage" class="addSuccessful">
				ADDING PROMO SUCCESSFUL
			</div>
		</s:if>
		<s:if test="%{addFailed}">
			<div id="addPromoMessage" class="addFailed">
				ADDING PROMO FAILED
			</div>
		</s:if>
	</article>
</section>

<script>
function addPromoPost(action, data){
	$.ajax({
		url: action,
	    type: "POST",
	    data: data,
	    error: function(){
	        alert('Admin Error');
	    },
	    success: function(data){         
	    	var $container = $("#body_container");
			$container.empty();
			$container.html(data);
	    },
	    complete: function (data){
	    }
	});
}

function addPromo(){
	var form = $('#addPromo').serialize();
	var action = "addPromo";
	addPromoPost(action, form);
}



</script>