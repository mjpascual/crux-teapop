<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="category printIt">
	<header>
		Print Category Master List
	</header>
	<article>
		<table id="print-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Category Group</th>
					<th>Category Image Path</th>
					<th>Display Position</th>
					<th>Show SML</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="categoryList" status="category">
					<tr>
						<td><s:property value="categoryId" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="desc" /></td>
						<td><s:property value="main" /></td>
						<td><s:property value="image"/></td>
						<td><s:property value="disp"/></td>
						<td><s:property value="showSML"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>