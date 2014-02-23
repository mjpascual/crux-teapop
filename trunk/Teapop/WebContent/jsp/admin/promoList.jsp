<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section class="category">
	<header>
		Promo Management
	</header>
	<article>
		<table id="category-table" class="table">
			<thead>
				<tr>
					<th colspan="5"><button class="btn pull-right"><span class="icon-plus"></span>&nbsp;Add New Promo</button></th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Code</th>
					<th>Functions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="status" value="specials.promos">
						<tr>
							<td><s:property value="promoId"/></td>
							<td><s:property value="name"/></td>
							<td><s:property value="desc"/></td>
							<td><s:property value="promoCode"/></td>
							<td>
								<div class="btn-group">
									<a class="btn btn-mini"><span class="icon-pencil"></span></a>
									<a class="btn btn-mini"><span class="icon-trash"></span></a>
								</div>
							</td>
							
						</tr>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>
