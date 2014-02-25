<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<section class="menu">
	<header>
		Menu Management
	</header>
	<article>
		<div class="formAdd menu_add">
			<h3>
				<s:if test="%{edit}">
					Edit Menu Item
				</s:if>
				<s:else>
					Add Menu Item
				</s:else>	</h3><hr><br>
			<form method="post" id="add_edit"  action="<s:property value='action'/>">
				<div>
					<label for="menuName">Menu Name:</label>
					<input type="text" value="<s:property value='menuItem.name'/>" id="menuName" name="menuItem.name" maxlength="35" autofocus required>
				</div>
				<div>
					<label for="menuDesc">Menu Description:</label>
					<textarea name="menuItem.desc"  rows="6" maxlength="250" required><s:property value="menuItem.desc"/></textarea>
				</div>
				<div>
					<label for="menuCode">Menu Code:</label>
					<input type="text"  name="menuItem.itemCode"  value="<s:property value='menuItem.itemCode'/>" id="menuCode" name="menuCode" maxlength="10" required>
				</div>
				<div>
					<label for="menuDesc">Category:</label>
					<select id="category" name="category.categoryId">
						<s:iterator value="categories" status="itemStatus">
			               <option value="<s:property value='categoryId'/>"><s:property value="name"/> </option>
		                 </s:iterator>
		             </select>
				</div>
				<div>
					<label for="menuPrice">Small Price:</label>
					<input type="text" value="<s:property value='menuItem.price.small'/>" id="menuPrice" name="menuItem.price.small" maxlength="3" required>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label for="menuPrice" id="sizePrice">Regular Price:</label>
					<input type="text" value="<s:property value='menuItem.price.regular'/>" id="menuPrice" name="menuItem.price.regular" maxlength="3" required>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label for="menuPrice" id="sizePrice">Large Price:</label>
					<input type="text" value="<s:property value='menuItem.price.large'/>" id="menuPrice" name="menuItem.price.large" maxlength="3" required>
				</div>
				<div>
					<label for="menuPrice">Featured:</label>
					<input type="checkbox" class="checkbox" name="menuItem.featured" value="<s:property value='menuItem.featured'/>" <s:if test="%{menuItem.featured}">checked</s:if>>
				</div>
				<div>
					<label for="menuPrice">Hidden:</label>
					<input type="checkbox" class="checkbox" name="menuItem.hidden" value="<s:property value='menuItem.hidden'/>" <s:if test="%{menuItem.hidden}">checked</s:if>>
				</div>
				<div>
				 	<label for="image_file">Image: </label>
				 	<input type="text" class="file" name="image_file" value="<s:property value='image_file'/>" disabled />
				 	<input type="file" class="fileTemp" value="<s:property value='image_file'/>"/>
				</div>
				<s:if test="%{edit}">
					<input type="hidden" name="menuItem.itemId" value="<s:property value='menuItem.itemId'/>"/>
					<input id="saveEditBtn" class="button" type="submit" value="Save"/>
				</s:if>
				<s:else>
					<input id="saveAddBtn" class="button" type="submit" value="Save"/>
				</s:else>
			</form>
		</div>
	</article>
</section>