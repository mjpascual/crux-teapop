<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="category printIt">
	<header>
		Print Menu Master List
	</header>
	<article>
		<table id="print-table">
			<thead>
				<tr>
					<th>Menu ID</th>
					<th>Menu Name</th>
					<th>Menu Description</th>
					<th>Menu Category</th>
					<th>Price (S-R-L)</th>
					<th>Featured</th>
					<th>Hidden</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="menu.additionalSection.categories" status="category">
					<s:iterator value="items" status="itemStatus">
						<tr>
							<td><s:property value="itemId" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="desc" /></td>
							<td><s:property value="category" /></td>
							<td><s:property value="price.small"/> - <s:property value="price.regular"/> - <s:property value="price.large"/></td>
							<td><s:property value="featured"/></td>
							<td><s:property value="hidden"/></td>
						</tr>
					</s:iterator>
				</s:iterator>
				<s:iterator value="menu.beveragesSection.categories" status="category">
					<s:iterator value="items" status="itemStatus">
						<tr>
							<td><s:property value="itemId" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="desc" /></td>
							<td><s:property value="category" /></td>
							<td><s:property value="price.small"/> - <s:property value="price.regular"/> - <s:property value="price.large"/></td>
							<td><s:property value="featured"/></td>
							<td><s:property value="hidden"/></td>
						</tr>
					</s:iterator>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>