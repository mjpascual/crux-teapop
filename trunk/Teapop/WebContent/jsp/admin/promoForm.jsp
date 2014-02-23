<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<section class="category" id="category">
	<header>
		Category Management
	</header>
	<article>
		<div class="formAdd category_add">
			<h3>
				<s:if test="%{edit}">
					Edit New Promo
				</s:if>
				<s:else>
					Add New Promo
				</s:else>				
			</h3><hr><br>
			<form method="post" id="promoForm">
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
				</div>	<s:if test="%{edit}">
					<input class="button" onclick="javascript:editPromo()" value="Save Edit">
				</s:if>
				<s:else>
					<input class="button" onclick="javascript:addPromo()" value="Save">
				</s:else>
				<input type="hidden" value="<s:property value='promoId'/>" name="promo.promoId"/>
			</form>
		</div>
		<s:if test="%{addSuccessful}">
			<div id="addPromoMessage" class="addSuccessful">
			 	SAVE SUCCESSFUL
			</div>
		</s:if>
		<s:if test="%{addFailed}">
			<div id="addPromoMessage" class="addFailed">
				SAVE FAILED
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
	var form = $('#promoForm').serialize();
	addPromoPost("addPromo", form);
}

function editPromo(){
	var form = $('#promoForm').serialize();
	addPromoPost("editPromo", form);
}



</script>