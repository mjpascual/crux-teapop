<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="category">
	<header>
		Category Management
	</header>
	<article>
		<table id="category-table" class="table">
			<thead>
				<tr>
					<th colspan="7"><button class="btn pull-right"id="addSubmit" forward="displayAddCategory" ><span class="icon-plus"></span>&nbsp;Add Menu Category</button></th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Category Group</th>
					<th>Position</th>
					<th>Show SML</th>
					<th>Functions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="categoryList" status="category">
					<tr>
						<td><s:property value="categoryId" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="desc" /></td>
						<td><s:property value="main" /></td>
						<td><s:property value="disp"/></td>
						<td><s:property value="showSML"/></td>
						<td>
							<div class="btn-group">
								<form id="update" class="smallForm" action="updateCategory">
									<input type="hidden" name="catergoryId" value='<s:property value="categoryId" />' />
									<a class="btn btn-mini" id="submitEditBtn"><span class="icon-pencil"></span></a>
								</form>
								<form id="delete" class="smallForm" action="deleteCategory">
									<input type="hidden" name="catergoryId" value='<s:property value="categoryId" />' />
									<a class="btn btn-mini deleteBtnClass" id="submitDelBtn"><span class="icon-trash"></span></a>
								</form>

							</div>
						</td>
					</tr>
				</s:iterator>
				<s:if test="hasActionErrors()">
					<div class="login_errors">
						<s:actionerror/>
					</div>
				</s:if>
				<s:if test="hasActionMessages()">
					<div class="success_form">
						<s:actionmessage/>
					</div>
				</s:if>
			</tbody>
		</table>
	</article>
</section>