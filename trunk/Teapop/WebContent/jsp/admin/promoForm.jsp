<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section class="category" id="category">
	<header>
		Promo Management
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
			<form method="post" id="add_edit" action="<s:property value='action'/>" enctype="multipart/form-data">
				<div>
					<label for="promoName">Promo Name:</label>
					<input type="text" value="<s:property value='promo.name'/>" id="promoName" name="promo.name" maxlength="35" autofocus required>
				</div>
				<div>
					<label for="promoCode">Promo Code:</label>
					<input type="text" id="promoCode" name="promo.promoCode" maxlength="35" value="<s:property value='promo.promoCode'/>">
				</div>
				<div>
					<label for="promoDesc">Promo Description:</label>
					<textarea  name="promo.desc" rows="6" maxlength="250" required><s:property value='promo.desc'/></textarea>
				</div>
				<div>
				 	<label for="image_file">Promo Image: </label>
				 	<input type="text" name="promo.image" value="<s:property value='promo.image'/>" class="file" disabled />
				 	<input type="file" name="myFile" class="fileTemp"/>
				</div>
				<s:if test="%{edit}">
					<input type="hidden" value="<s:property value='promo.promoId'/>" name="promo.promoId"/>
					<input type="submit" class="button"  value="Save Edit" id="saveEditBtn">
				</s:if>
				<s:else>
					<input type="submit" class="button" value="Save" id="saveAddBtn">
				</s:else>
			</form>
		</div>
	</article>
</section>