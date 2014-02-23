<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<section class="category">
	<header>
		Category Management
	</header>
	<article>
		<div class="formAdd category_add">
			<h3><span class="changeHeader">Add</span> Menu Category</h3><hr><br>
			<form id="add" action="addCategory">
				<div class="idContainer">
					<label for="categoryId">Category Id:</label>
					<input type="text" class="formId" name="category.categoryId" value="<s:property value='category.categoryId'/>" disabled />
				</div>
				<div>
					<label for="categoryName">Category Name:</label>
					<input type="text" name="category.name" value="<s:property value='category.name'/>" maxlength="35" autofocus required>
				</div>
				<div>
					<label for="categoryDesc">Category Description:</label>
					<textarea name="category.desc" srows="6" maxlength="250" required><s:property value='category.desc'/></textarea>
				</div>
				<div>
					<label for="categoryGroup">Category Group: </label>
					<select name="category.main" required>
						<option value="">Please select</option>
						<option <s:if test="%{category.main=='Beverage'}">selected</s:if> value="Beverage">Beverages</option>
						<option <s:if test="%{category.main=='Additionals'}">selected</s:if> value="Additionals">Additionals</option>
					</select>
				</div>
				<div>
				 	<label for="image_file">Category Image: </label>
				 	<input type="text" name="category.image" value="<s:property value='category.image'/>" class="file" disabled />
				 	<input type="file" class="fileTemp" value="<s:property value='category.image'/>"/>
				</div>
				<div>
					<label for="Position">Category Display Position: </label>
					<input type="text" class="displayPosition" name="category.disp" value="<s:property value='category.disp'/>" maxlength="35" required>
				</div>
				<div>
					<label for="categoryGroup">Show SML? </label>
					<input type="checkbox" class="checkbox" name="category.showSML" value="<s:property value='category.showSML'/>" <s:if test="%{category.showSML}">checked</s:if>>
				</div>
				<input class="button" id="submitAddBtn" type="submit" value="Save" >
			</form>
			<s:if test="hasActionErrors()">
				<div class="login_errors">
					<s:actionerror/>
				</div>
			</s:if>
		</div>
	</article>
</section>